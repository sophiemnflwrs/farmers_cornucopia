package net.sophiemnflwrs.farmerscornucopia.common.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.sophiemnflwrs.farmerscornucopia.common.block.shrub.LemonShrub;

public class FruitingShrubFeature extends Feature<SimpleBlockConfiguration> {
    public FruitingShrubFeature(Codec<SimpleBlockConfiguration> codec) {
        super(codec);
    }

    // places the given feature at the given location. features are placed within a 3x3 region of chunks, centering on the chunk being generated.

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockConfiguration> pContext) {
        WorldGenLevel worldgenlevel = pContext.level();
        BlockPos blockpos = pContext.origin();
        BlockState blockstate = pContext.config().toPlace().getState(pContext.random(), blockpos);
        if (blockstate.canSurvive(worldgenlevel, blockpos) && worldgenlevel.isEmptyBlock(blockpos.above())) {
            if (blockstate.getBlock() instanceof LemonShrub) {
                LemonShrub.placeAt(worldgenlevel, blockstate, blockpos, 2);
                return true;
            }
        }
        return false;
    }
}
