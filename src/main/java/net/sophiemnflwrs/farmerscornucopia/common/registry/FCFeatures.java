package net.sophiemnflwrs.farmerscornucopia.common.registry;

import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;

@Mod.EventBusSubscriber(modid = FarmersCornucopia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class FCFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, FarmersCornucopia.MOD_ID);



}
