package net.sophiemnflwrs.farmerscornucopia.common.block.crop;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IPlantable;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;
import org.jetbrains.annotations.NotNull;

public class TallCropBlock extends DoublePlantBlock implements BonemealableBlock {
    public static final IntegerProperty AGE;
    private static final VoxelShape FULL_UPPER_SHAPE;
    private static final VoxelShape FULL_LOWER_SHAPE;
    private static final VoxelShape[] UPPER_SHAPE_BY_AGE;
    private static final VoxelShape[] LOWER_SHAPE_BY_AGE;
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    static {
        AGE = BlockStateProperties.AGE_4;
        FULL_UPPER_SHAPE = Block.box(3.0, 0.0, 3.0, 13.0, 15.0, 13.0);
        FULL_LOWER_SHAPE = Block.box(3.0, -1.0, 3.0, 13.0, 16.0, 13.0);
        UPPER_SHAPE_BY_AGE = new VoxelShape[]{
                Block.box(3.0, 0.0, 3.0, 13.0, 11.0, 13.0),
                Block.box(3.0, 0.0, 3.0, 13.0, 15.0, 13.0),
                FULL_UPPER_SHAPE};
        LOWER_SHAPE_BY_AGE = new VoxelShape[]{
                Block.box(3.0, -1.0, 3.0, 13.0, 14.0, 13.0),
                Block.box(3.0, -1.0, 3.0, 13.0, 16.0, 13.0),
                FULL_LOWER_SHAPE,
                FULL_LOWER_SHAPE,
                FULL_LOWER_SHAPE};
    }

    record PosAndState(BlockPos pos, BlockState state) {
        PosAndState(BlockPos pos, BlockState state) {
            this.pos = pos;
            this.state = state;
        }
        public BlockPos pos() {
            return this.pos;
        }
        public BlockState state() {
            return this.state;
        }
    }

    public TallCropBlock(Properties properties) {
        super(properties);
    }

    private boolean isMaxAge(BlockState state) {
        return (Integer)state.getValue(AGE) >= 4;
    }

    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(HALF) == DoubleBlockHalf.LOWER && !this.isMaxAge(state);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState();
    }

    private boolean isLower(BlockState state) {
        return state.is(this) && state.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    private boolean isUpper(BlockState state) {
        return state.is(this) && state.getValue(HALF) == DoubleBlockHalf.UPPER;
    }

    protected static float getGrowthSpeed(Block block, BlockGetter getter, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.below();
        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = getter.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(getter, blockpos.offset(i, 0, j), Direction.UP, (IPlantable)block)) {
                    f1 = 1.0F;
                    if (blockstate.isFertile(getter, pos.offset(i, 0, j))) {
                        f1 = 3.0F;
                    }
                }
                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }
                f += f1;
            }
        }
        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = getter.getBlockState(blockpos3).is(block) || getter.getBlockState(blockpos4).is(block);
        boolean flag1 = getter.getBlockState(blockpos1).is(block) || getter.getBlockState(blockpos2).is(block);
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = getter.getBlockState(blockpos3.north()).is(block) || getter.getBlockState(blockpos4.north()).is(block) || getter.getBlockState(blockpos4.south()).is(block) || getter.getBlockState(blockpos3.south()).is(block);
            if (flag2) {
                f /= 2.0F;
            }
        }
        return f;
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state1, LevelAccessor accessor, BlockPos pos, BlockPos pos1) {
        return !state.canSurvive(accessor, pos) ? Blocks.AIR.defaultBlockState() : state;
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        if (!isLower(state)) {
            return super.canSurvive(state, reader, pos);
        } else {
            BlockPos below = pos.below();
            boolean isSoil = this.mayPlaceOn(reader.getBlockState(below), reader, below);
            if (state.getBlock() == this) {
                isSoil = reader.getBlockState(below).canSustainPlant(reader, below, Direction.UP, this);
            }

            return isSoil && sufficientLight(reader, pos) && ((Integer)state.getValue(AGE) < 2 || isUpper(reader.getBlockState(pos.above())));
        }
    }

    protected boolean mayPlaceOn(BlockState state, BlockGetter getter, BlockPos pos) {
        return state.is(Blocks.FARMLAND);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(AGE);
        super.createBlockStateDefinition(builder);
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return state.getValue(HALF) == DoubleBlockHalf.UPPER ? UPPER_SHAPE_BY_AGE[Math.min(Math.abs(4 - ((Integer)state.getValue(AGE) + 1)), UPPER_SHAPE_BY_AGE.length - 1)] : LOWER_SHAPE_BY_AGE[state.getValue(AGE)];
    }

    public boolean canBeReplaced(BlockState state, BlockPlaceContext context) {
        return false;
    }

    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
    }

    public void randomTick(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource source) {
        float f = getGrowthSpeed(this, level, pos);
        boolean flag = source.nextInt((int)(25.0F / f) + 1) == 0;
        if (flag) {
            this.grow(level, blockState, pos, 1);
        }

    }

    private void grow(ServerLevel level, BlockState state, BlockPos pos, int j) {
        int i = Math.min((Integer)state.getValue(AGE) + j, 4);
        if (this.canGrow(level, pos, state, i)) {
            level.setBlock(pos, (BlockState)state.setValue(AGE, i), 2);
            if (i >= 3) {
                BlockPos blockpos = pos.above();
                level.setBlock(blockpos, copyWaterloggedFrom(level, pos, (BlockState)((BlockState)this.defaultBlockState().setValue(AGE, i)).setValue(HALF, DoubleBlockHalf.UPPER)), 3);
            }
        }
    }

    private static boolean canGrowInto(LevelReader reader, BlockPos pos) {
        BlockState blockstate = reader.getBlockState(pos);
        return blockstate.isAir() || blockstate.is(Blocks.PITCHER_CROP);
    }

    private static boolean sufficientLight(LevelReader reader, BlockPos pos) {
        return reader.getRawBrightness(pos, 0) >= 8 || reader.canSeeSky(pos);
    }

    private boolean canGrow(LevelReader reader, BlockPos pos, BlockState state, int i) {
        return !this.isMaxAge(state) && sufficientLight(reader, pos) && (i < 2 || canGrowInto(reader, pos.above()));
    }

    @Nullable
    private TallCropBlock.PosAndState getLowerHalf(LevelReader reader, BlockPos pos, BlockState state) {
        if (isLower(state)) {
            return new PosAndState(pos, state);
        } else {
            BlockPos blockpos = pos.below();
            BlockState blockstate = reader.getBlockState(blockpos);
            return isLower(blockstate) ? new PosAndState(blockpos, blockstate) : null;
        }
    }

    public boolean isValidBonemealTarget(LevelReader reader, BlockPos pos, BlockState state, boolean b) {
        TallCropBlock.PosAndState tallcropblock$posandstate = this.getLowerHalf(reader, pos, state);
        return tallcropblock$posandstate == null ? false : this.canGrow(reader, tallcropblock$posandstate.pos, tallcropblock$posandstate.state, (Integer)tallcropblock$posandstate.state.getValue(AGE) + 1);
    }

    public boolean isBonemealSuccess(Level level, RandomSource source, BlockPos pos, BlockState state) {
        return true;
    }

    public void performBonemeal(ServerLevel level, RandomSource source, BlockPos pos, BlockState state) {
        TallCropBlock.PosAndState tallcropblock$posandstate = this.getLowerHalf(level, pos, state);
        if (tallcropblock$posandstate != null) {
            this.grow(level, tallcropblock$posandstate.state, tallcropblock$posandstate.pos, 1);
        }
    }

    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return (FCBlocks.CASSAVA_CROP.get()).defaultBlockState();
    }

    public ItemStack getCloneItemStack(BlockGetter getter, BlockPos pos, BlockState state) {
        return new ItemStack(this.getBaseSeedId());
    }

    protected ItemLike getBaseSeedId () {
        return FCItems.CASSAVA.get();
    }

}
