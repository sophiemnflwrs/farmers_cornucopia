package net.sophiemnflwrs.farmerscornucopia;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.sophiemnflwrs.farmerscornucopia.client.ClientSetup;
import net.sophiemnflwrs.farmerscornucopia.common.CommonSetup;
import net.sophiemnflwrs.farmerscornucopia.common.Configuration;
import net.sophiemnflwrs.farmerscornucopia.common.effect.FCEffects;
import net.sophiemnflwrs.farmerscornucopia.common.effect.FCParticles;
import net.sophiemnflwrs.farmerscornucopia.common.registry.*;
import net.sophiemnflwrs.farmerscornucopia.datagen.DataGenerators;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FarmersCornucopia.MOD_ID)
public class FarmersCornucopia {

    public static final String MOD_ID = "farmerscornucopia";
    public static final Logger LOGGER = LogManager.getLogger();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public FarmersCornucopia() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(CommonSetup::init);
        if (FMLEnvironment.dist.isClient()) {
            modEventBus.addListener(ClientSetup::init);
        }

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Configuration.COMMON_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Configuration.CLIENT_CONFIG);

        MinecraftForge.EVENT_BUS.register(DataGenerators.class);

        FCCreativeTab.CREATIVE_TABS.register(modEventBus);
        FCBlocks.BLOCKS.register(modEventBus);
        FCItems.ITEMS.register(modEventBus);
        FCPlacementModifiers.PLACEMENT_MODIFIERS.register(modEventBus);
        FCBiomeFeatures.FEATURES.register(modEventBus);
        FCBiomeModifiers.BIOME_MODIFIER_SERIALIZERS.register(modEventBus);
        FCEffects.EFFECTS.register(modEventBus);
        FCParticles.PARTICLES.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {

    };
}
