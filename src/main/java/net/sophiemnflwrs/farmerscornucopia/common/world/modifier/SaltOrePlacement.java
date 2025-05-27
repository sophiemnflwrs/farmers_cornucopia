package net.sophiemnflwrs.farmerscornucopia.common.world.modifier;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class SaltOrePlacement {

    public static List<PlacementModifier> orePlacement(PlacementModifier pos, PlacementModifier type) {
        return List.of(pos, InSquarePlacement.spread(), type, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int count, PlacementModifier pHeightRange) {
        return orePlacement(CountPlacement.of(count), pHeightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int chance, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(chance), heightRange);
    }

}
