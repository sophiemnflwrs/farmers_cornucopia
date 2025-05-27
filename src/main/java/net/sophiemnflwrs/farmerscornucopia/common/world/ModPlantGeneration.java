package net.sophiemnflwrs.farmerscornucopia.common.world;


import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;

@SuppressWarnings("removal")
public class ModPlantGeneration {

    // configured features

    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_OLIVE_TREE = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_olive_tree"));

    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_LEMON_SHRUB = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_lemon_shrub"));

    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_BLUEBERRY_BUSH = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_blueberry_bush"));

    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_CASSAVA = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_cassava"));

    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_CHILI_PEPPER = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_chili_pepper"));
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_GARLIC = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_garlic"));
    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_WILD_GINGER = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_ginger"));

    public static ResourceKey<ConfiguredFeature<?, ?>> FEATURE_PATCH_VIOLET = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_violet"));

    // placed features

    public static ResourceKey<PlacedFeature> PATCH_OLIVE_TREE = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_olive_tree"));

    public static ResourceKey<PlacedFeature> PATCH_LEMON_SHRUB = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_lemon_shrub"));

    public static ResourceKey<PlacedFeature> PATCH_BLUEBERRY_BUSH = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_blueberry_bush"));

    public static ResourceKey<PlacedFeature> PATCH_WILD_CASSAVA = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_cassava"));

    public static ResourceKey<PlacedFeature> PATCH_WILD_CHILI_PEPPER = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_chili_pepper"));
    public static ResourceKey<PlacedFeature> PATCH_WILD_GARLIC = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_garlic"));
    public static ResourceKey<PlacedFeature> PATCH_WILD_GINGER = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_wild_ginger"));

    public static ResourceKey<PlacedFeature> PATCH_VIOLET = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "patch_violet"));

    // registration

    public static void load() {
    }
}
