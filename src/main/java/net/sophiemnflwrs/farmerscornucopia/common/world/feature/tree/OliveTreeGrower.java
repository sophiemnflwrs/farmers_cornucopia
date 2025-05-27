package net.sophiemnflwrs.farmerscornucopia.common.world.feature.tree;

import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.sophiemnflwrs.farmerscornucopia.common.world.ModPlantGeneration;

import javax.annotation.Nullable;

public class OliveTreeGrower extends AbstractTreeGrower {
    public OliveTreeGrower() {
    }

    @Nullable
    public ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource randomSource, boolean hasFlowers) {
        return ModPlantGeneration.FEATURE_PATCH_OLIVE_TREE;
    }


}
