package net.sophiemnflwrs.farmerscornucopia.common;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.sophiemnflwrs.farmerscornucopia.common.effect.FCEffects;
import net.sophiemnflwrs.farmerscornucopia.common.effect.FCParticles;
import net.sophiemnflwrs.farmerscornucopia.common.tag.FCTags;

import java.util.Objects;

public class ForgeEvents {
    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void onCorrodeWeapon(LivingDamageEvent e) {
        if (e.getEntity().hasEffect(FCEffects.CORROSION.get()) && e.getSource().getEntity() instanceof Player p) {
            InteractionHand hand = p.getUsedItemHand();
            ItemStack stack = p.getItemInHand(hand);
            if (stack.isDamageableItem()) {
                int damage = Objects.requireNonNull(e.getEntity().getEffect(FCEffects.CORROSION.get())).getAmplifier();
                stack.hurtAndBreak(damage, p, en -> en.broadcastBreakEvent(hand));
            }
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void onCorrodeProjectile(ProjectileImpactEvent e) {
        if (e.getRayTraceResult().getType() == HitResult.Type.ENTITY &&
                ((EntityHitResult) e.getRayTraceResult()).getEntity() instanceof LivingEntity victim &&
                victim.hasEffect(FCEffects.CORROSION.get())) {
            Projectile proj = e.getProjectile();
            if (proj.getType().is(FCTags.CORROSION_IMMUNE)) {
                return;
            }
            e.setCanceled(true);
            if (!proj.level().isClientSide() && proj.level() instanceof ServerLevel server) {
                for (int i = 0; i < 3; i++) {
                    server.sendParticles(FCParticles.ACID.get(), proj.getRandomX(0.3D), proj.getRandomY(), proj.getRandomZ(0.3D), 1, 0.0D, 0.0D, 0.0D, 0.0D);
                }
                victim.playSound(SoundEvents.REDSTONE_TORCH_BURNOUT, 0.4F, 1.1F);
                if (proj instanceof ThrownTrident trident) {
                    trident.tridentItem.hurt(5 * Objects.requireNonNull(victim.getEffect(FCEffects.CORROSION.get())).getAmplifier(), trident.level().getRandom(), null);
                } else {
                    proj.discard();
                    proj.gameEvent(GameEvent.ENTITY_DIE);
                }
            }
        }
    }
}
