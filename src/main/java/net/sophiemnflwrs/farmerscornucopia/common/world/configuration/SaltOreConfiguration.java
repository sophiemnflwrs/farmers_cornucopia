package net.sophiemnflwrs.farmerscornucopia.common.world.configuration;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCBlocks;

import java.util.List;

public class SaltOreConfiguration {

    public static final ResourceKey<ConfiguredFeature<?, ?>> SALT_ORE_KEY = registerKey("salt_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> saltOres = List.of(
                OreConfiguration.target(stoneReplaceable, FCBlocks.SALT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, FCBlocks.DEEPSLATE_SALT_ORE.get().defaultBlockState()));

        register(context, SALT_ORE_KEY, Feature.ORE, new OreConfiguration(saltOres, 8));
    }

    // register
    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey (String name){
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FarmersCornucopia.MOD_ID, "salt_ore"));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>>void register
            (BootstapContext < ConfiguredFeature < ?, ?>>context,
             ResourceKey < ConfiguredFeature < ?, ?>>key, F feature, FC configuration){
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
