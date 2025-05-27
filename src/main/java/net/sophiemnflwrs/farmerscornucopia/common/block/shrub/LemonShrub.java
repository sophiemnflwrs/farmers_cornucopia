package net.sophiemnflwrs.farmerscornucopia.common.block.shrub;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class LemonShrub extends CropBlock implements FruitingShrub {
    public static final int MAX_AGE = 4;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    public static final BooleanProperty STUNTED = BooleanProperty.create("stunted");
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    private static final VoxelShape SHAPE_LOWER = Shapes.or(
            Block.box(0.0D, 11.0D, 0.0D, 16.0D, 24.0D, 16.0D),
            Block.box(6.0D, 0.0D, 6.0D, 10.0D, 11.0D, 10.0D));
    private static final VoxelShape SHAPE_UPPER = Shapes.or(
            Block.box(0.0D, -5.0D, 0.0D, 16.0D, 8.0D, 16.0D),
            Block.box(6.0D, -16.0D, 6.0D, 10.0D, -5.0D, 10.0D));

    public LemonShrub(Properties pProperties) {
        super(pProperties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(AGE, 0)
                .setValue(STUNTED, false)
                .setValue(HALF, DoubleBlockHalf.LOWER)
        );
    }

    @Override
    public @NotNull IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    public int getMaxAge() {
        return MAX_AGE;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return state.getValue(HALF) == DoubleBlockHalf.UPPER ? SHAPE_UPPER : SHAPE_LOWER;
    }

    // update the provided state given the provided neighbor direction and neighbor state, returning a new state.
    @Override
    public @NotNull BlockState updateShape(BlockState state, Direction facing, @NotNull BlockState facingState, @NotNull LevelAccessor world, @NotNull BlockPos pos, @NotNull BlockPos facingPos) {
        DoubleBlockHalf doubleblockhalf = state.getValue(HALF);
        if (facing.getAxis() == Direction.Axis.Y && doubleblockhalf == DoubleBlockHalf.LOWER == (facing == Direction.UP)) {
            return facingState.is(this) && facingState.getValue(HALF) != doubleblockhalf ? state.setValue(AGE, facingState.getValue(AGE)).setValue(STUNTED, facingState.getValue(STUNTED)) : Blocks.AIR.defaultBlockState();
        } else {
            return doubleblockhalf == DoubleBlockHalf.LOWER && facing == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, facing, facingState, world, pos, facingPos);
        }
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos) {
        return pState.is(BlockTags.DIRT);
    }

    @Override
    public boolean canSurvive(BlockState state, @NotNull LevelReader level, BlockPos pos) {
        BlockPos blockpos = pos.below();
        return state.getValue(HALF) == DoubleBlockHalf.LOWER ? this.mayPlaceOn(level.getBlockState(blockpos), level, blockpos) : state.is(this);
    }

    @Override
    protected @NotNull ItemLike getBaseSeedId() {
        return FCItems.LEMON_SEEDS.get();
    }

    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return new ItemStack(this.getBaseSeedId());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE, STUNTED, HALF);
    }

    // return whether this block needs random ticking.
    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(AGE) < this.getMaxAge() && state.getValue(HALF) == DoubleBlockHalf.LOWER && !state.getValue(STUNTED);
    }

    @Override
    public Item getFruit() {
        return FCItems.LEMON.get();
    }

    @SuppressWarnings("deprecation")
    @Override
    public @NotNull InteractionResult use(BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Player pPlayer, @NotNull InteractionHand pHand, @NotNull BlockHitResult pHit) {
        if (pState.getValue(AGE) == this.getMaxAge()) {
            dropResources(pLevel, pPos);
            pLevel.playSound(null, pPos, SoundEvents.SWEET_BERRY_BUSH_PICK_BERRIES, SoundSource.BLOCKS, 1.0F, 0.8F + pLevel.random.nextFloat() * 0.4F);
            pLevel.setBlockAndUpdate(pPos, pState.setValue(AGE, 0)); // revert to pre-flowering state
            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        } else if (pPlayer.getItemInHand(pHand).getItem() instanceof AxeItem && !pState.getValue(STUNTED)) {
            pLevel.setBlockAndUpdate(pPos, pState.setValue(STUNTED, true));
            pLevel.playSound(pPlayer, pPos, SoundEvents.AXE_STRIP, SoundSource.BLOCKS, 1.0F, 1.0F);
            pPlayer.getItemInHand(pHand).hurtAndBreak(1, pPlayer, (b) -> b.broadcastBreakEvent(b.getUsedItemHand()));
            return InteractionResult.sidedSuccess(pLevel.isClientSide());
        } else if (pPlayer.getItemInHand(pHand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else {
            return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
        }
    }

    @Override
    public boolean isValidBonemealTarget(@NotNull LevelReader level, @NotNull BlockPos pPos, BlockState pState, boolean pIsClient) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, BlockState pState) {
        pLevel.setBlockAndUpdate(pPos, pState.setValue(AGE, Math.min(this.getMaxAge(), pState.getValue(AGE) + 1)));
    }

    @Override
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        BlockPos blockpos = pContext.getClickedPos();
        return blockpos.getY() < 255 && pContext.getLevel().getBlockState(blockpos.above()).canBeReplaced(pContext) ?
                this.defaultBlockState().setValue(AGE, 0).setValue(STUNTED, false).setValue(HALF, DoubleBlockHalf.LOWER) :
                null;
    }

    // called by BlockItem after this block has been placed.
    @Override
    public void setPlacedBy(Level pLevel, BlockPos pPos, BlockState pState, LivingEntity pPlacer, @NotNull ItemStack pStack) {
        pLevel.setBlock(pPos.above(), pState.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    public static void placeAt(LevelAccessor pLevel, BlockState pState, BlockPos pPos, int pFlags) {
        pLevel.setBlock(pPos, pState.setValue(AGE, MAX_AGE).setValue(HALF, DoubleBlockHalf.LOWER), pFlags);
        pLevel.setBlock(pPos.above(), pState.setValue(AGE, MAX_AGE).setValue(HALF, DoubleBlockHalf.UPPER), pFlags);
    }

    @Override
    public void playerWillDestroy(Level pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, @NotNull Player pPlayer) {
        if (!pLevel.isClientSide()) {
            if (pPlayer.isCreative()) {
                preventCreativeDropFromBottomPart(HALF, pLevel, pPos, pState, pPlayer);
            } else if (pState.getValue(AGE) == this.getMaxAge()) {
                dropResources(pLevel, pPos);
            }
        }
        super.playerWillDestroy(pLevel, pPos, pState, pPlayer);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 30;
    }
}
