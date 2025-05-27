package net.sophiemnflwrs.farmerscornucopia.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.client.particle.AcidParticle;
import net.sophiemnflwrs.farmerscornucopia.common.effect.FCParticles;

@Mod.EventBusSubscriber(modid = FarmersCornucopia.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientSetupEvents {

    @SubscribeEvent
    public static void registerParticles(RegisterParticleProvidersEvent event) {
        Minecraft.getInstance().particleEngine.register(FCParticles.ACID.get(), AcidParticle.Factory::new);
    }
}
