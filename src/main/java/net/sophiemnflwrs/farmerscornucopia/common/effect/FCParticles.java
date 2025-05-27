package net.sophiemnflwrs.farmerscornucopia.common.effect;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;

public class FCParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, FarmersCornucopia.MOD_ID);

    public static final RegistryObject<SimpleParticleType> ACID = PARTICLES.register("acid", () -> new SimpleParticleType(true));

    public static void create(IEventBus bus) {
        PARTICLES.register(bus);
    }
}
