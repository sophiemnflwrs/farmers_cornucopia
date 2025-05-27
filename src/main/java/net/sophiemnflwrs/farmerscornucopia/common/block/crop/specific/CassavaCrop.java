package net.sophiemnflwrs.farmerscornucopia.common.block.crop.specific;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.state.BlockState;
import net.sophiemnflwrs.farmerscornucopia.common.block.crop.TallCropBlock;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;

public class CassavaCrop extends TallCropBlock {
    public CassavaCrop(Properties properties) {
        super(properties);
    }

    public BlockState getPlant(BlockGetter world, BlockPos pos) {
        return (FCBlocks.CASSAVA_CROP.get()).defaultBlockState();
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return FCItems.CASSAVA.get();
    }

}
