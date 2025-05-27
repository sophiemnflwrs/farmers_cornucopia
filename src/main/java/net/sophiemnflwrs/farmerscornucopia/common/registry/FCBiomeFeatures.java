package net.sophiemnflwrs.farmerscornucopia.common.registry;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.world.configuration.WildCropConfiguration;
import net.sophiemnflwrs.farmerscornucopia.common.world.feature.FlowerFeature;
import net.sophiemnflwrs.farmerscornucopia.common.world.feature.FruitingBushFeature;
import net.sophiemnflwrs.farmerscornucopia.common.world.feature.FruitingShrubFeature;
import net.sophiemnflwrs.farmerscornucopia.common.world.feature.WildCropFeature;

public class FCBiomeFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, FarmersCornucopia.MOD_ID);

    public static final RegistryObject<Feature<TreeConfiguration>> FRUITING_TREES = FEATURES.register("fruiting_trees",
            () -> new TreeFeature(TreeConfiguration.CODEC));

    public static final RegistryObject<Feature<SimpleBlockConfiguration>> FRUITING_SHRUBS = FEATURES.register("fruiting_shrubs",
            () -> new FruitingShrubFeature(SimpleBlockConfiguration.CODEC));

    public static final RegistryObject<Feature<SimpleBlockConfiguration>> FRUITING_BUSH = FEATURES.register("fruiting_bush",
            () -> new FruitingBushFeature(SimpleBlockConfiguration.CODEC));

    public static final RegistryObject<Feature<WildCropConfiguration>> WILD_CROP = FEATURES.register("wild_crop",
            () -> new WildCropFeature(WildCropConfiguration.CODEC));

    public static final RegistryObject<Feature<RandomPatchConfiguration>> FLOWERS = FEATURES.register("flowers",
            () -> new FlowerFeature(RandomPatchConfiguration.CODEC));

}
