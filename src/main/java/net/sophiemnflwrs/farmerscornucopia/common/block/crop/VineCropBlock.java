package net.sophiemnflwrs.farmerscornucopia.common.block.crop;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.registries.ForgeRegistries;
import net.sophiemnflwrs.farmerscornucopia.common.Configuration;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;
import vectorwing.farmersdelight.common.registry.ModBlocks;
import vectorwing.farmersdelight.common.registry.ModSounds;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;
import vectorwing.farmersdelight.common.tag.ModTags;

import javax.annotation.Nullable;

// credit to vectorwing for this code!

@SuppressWarnings("removal")
public class VineCropBlock extends CropBlock {

    public static final IntegerProperty VINE_AGE = BlockStateProperties.AGE_3;
    public static final BooleanProperty ROPELOGGED = BooleanProperty.create("ropelogged");
    private static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);

    public VineCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        int age = state.getValue(getAgeProperty());
        boolean isMature = age == getMaxAge();
        boolean isRopelogged = state.getValue(VineCropBlock.ROPELOGGED);
        if (!isMature && player.getItemInHand(hand).is(Items.BONE_MEAL)) {
            return InteractionResult.PASS;
        } else if (isMature && isRopelogged) {
            int quantity = 1 + level.random.nextInt(2);
            popResource(level, pos, new ItemStack(FCItems.VANILLA_POD.get(), quantity));
            level.playSound(null, pos, ModSounds.ITEM_TOMATO_PICK_FROM_BUSH.get(), SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(getAgeProperty(), 0), 2);
            return InteractionResult.SUCCESS;
        } else {
            return super.use(state, level, pos, player, hand, hit);
        }
    }

    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        boolean isRopelogged = state.getValue(VineCropBlock.ROPELOGGED);
        if (!level.isAreaLoaded(pos, 1)) return;
        if (level.getRawBrightness(pos, 0) >= 9) {
            int age = this.getAge(state);
            if (age < this.getMaxAge() && isRopelogged) {
                float speed = getGrowthSpeed(this, level, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt((int) (25.0F / speed) + 1) == 0)) {
                    level.setBlock(pos, state.setValue(getAgeProperty(), age + 1), 2);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
                }
            }
            attemptRopeClimb(level, pos, random);
        }
    }

    public void attemptRopeClimb(ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextFloat() < 0.3F) {
            BlockPos posAbove = pos.above();
            BlockState stateAbove = level.getBlockState(posAbove);
            boolean canClimb = Configuration.ENABLE_VINE_CROP_CLIMBING_TAGGED_ROPES.get() ? stateAbove.is(ModTags.ROPES) : stateAbove.is(ModBlocks.ROPE.get());
            if (canClimb) {
                int vineHeight;
                for (vineHeight = 1; level.getBlockState(pos.below(vineHeight)).is(this); ++vineHeight) {
                }
                if (vineHeight < 3) {
                    level.setBlockAndUpdate(posAbove, defaultBlockState().setValue(ROPELOGGED, true));
                }
            }
        }

    }

    @Override
    public BlockState getStateForAge(int age) {
        return this.defaultBlockState().setValue(this.getAgeProperty(), age);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return VINE_AGE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public int getMaxAge() {
        return 3;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return FCItems.VANILLA_POD.get();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(VINE_AGE, ROPELOGGED);
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return super.getBonemealAgeIncrease(level) / 2;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        int newAge = this.getAge(state) + this.getBonemealAgeIncrease(level);
        int maxAge = this.getMaxAge();
        if (newAge > maxAge) {
            newAge = maxAge;
        }

        level.setBlockAndUpdate(pos, state.setValue(getAgeProperty(), newAge));
        attemptRopeClimb(level, pos, random);
    }

    @Override
    public boolean isLadder(BlockState state, LevelReader level, BlockPos pos, LivingEntity entity) {
        return state.getValue(ROPELOGGED) && state.is(BlockTags.CLIMBABLE);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        BlockPos belowPos = pos.below();
        BlockState belowState = level.getBlockState(belowPos);

        if (state.getValue(VineCropBlock.ROPELOGGED)) {
            return belowState.is(FCBlocks.VANILLA_CROP.get()) && hasGoodCropConditions(level, pos);
        }

        return super.canSurvive(state, level, pos);
    }

    public boolean hasGoodCropConditions(LevelReader level, BlockPos pos) {
        return level.getRawBrightness(pos, 0) >= 8 || level.canSeeSky(pos);
    }

    @Override
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
        boolean isRopelogged = state.getValue(VineCropBlock.ROPELOGGED);
        super.playerDestroy(level, player, pos, state, blockEntity, stack);
        if (isRopelogged) {
            destroyAndPlaceRope(level, pos);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos currentPos, BlockPos facingPos) {
        if (!state.canSurvive(level, currentPos)) {
            level.scheduleTick(currentPos, this, 1);
        }
        return state;
    }

    public static void destroyAndPlaceRope(Level level, BlockPos pos) {
        Block configuredRopeBlock = ForgeRegistries.BLOCKS.getValue(new ResourceLocation(Configuration.DEFAULT_VINE_CROP_ROPE.get()));
        Block finalRopeBlock = configuredRopeBlock != null ? configuredRopeBlock : ModBlocks.ROPE.get();
        level.setBlockAndUpdate(pos, finalRopeBlock.defaultBlockState());
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
            if (state.getValue(VineCropBlock.ROPELOGGED)) {
                destroyAndPlaceRope(level, pos);
            }
        }
    }
}
