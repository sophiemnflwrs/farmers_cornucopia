package net.sophiemnflwrs.farmerscornucopia.common.block.tree;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;
import net.minecraftforge.common.ToolActions;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;

import javax.annotation.Nullable;

public class FCLogBlock extends RotatedPillarBlock {
    public FCLogBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction action, boolean simulate) {
        if (action == ToolActions.AXE_STRIP)
            if (state.is(FCBlocks.OLIVE_LOG.get())) {
                return FCBlocks.STRIPPED_OLIVE_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        return super.getToolModifiedState(state, context, action, simulate);
    }
}
