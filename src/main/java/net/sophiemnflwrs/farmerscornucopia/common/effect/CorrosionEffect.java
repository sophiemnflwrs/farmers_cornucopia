package net.sophiemnflwrs.farmerscornucopia.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

// credit to brnbrd for this code!

public class CorrosionEffect extends MobEffect {

    // this effect causers the player to emit corrosive acid particles that destroy incoming projectiles.
    // however, any weapon used will take extra durability damage.

    protected CorrosionEffect() {
        super(MobEffectCategory.BENEFICIAL, 0x4EFF35);
    }

    @Override
    public void applyEffectTick(LivingEntity entity, int amp) {
        entity.level().addParticle(FCParticles.ACID.get(), entity.getRandomX(0.75D), entity.getRandomY() + 0.4D, entity.getRandomZ(0.75D), 0.0D, -0.02D, 0.0D);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        return false;
    }

}
