package com.nexushack.modules.combat;

import com.nexushack.event.EventTarget;
import com.nexushack.event.events.UpdateEvent;
import com.nexushack.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class KillAura extends Module {

    private double range = 4.2;
    private boolean raytrace = true;

    public KillAura() {
        super("KillAura", Category.COMBAT);
    }

    @Override
    public void onEnable() {
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    @EventTarget
    public void onUpdate(UpdateEvent event) {
        if (!isEnabled() || mc.player == null || mc.world == null) return;

        LivingEntity target = getBestTarget();

        if (target != null) {
            aimAtTarget(target);

            if (mc.player.getAttackCooldownProgress(0.5f) >= 1.0f) {
                mc.interactionManager.attackEntity(mc.player, target);
                mc.player.swingHand(Hand.MAIN_HAND);
            }
        }
    }

    private LivingEntity getBestTarget() {
        LivingEntity bestTarget = null;
        double maxDist = range * range;

        for (Entity entity : mc.world.getEntities()) {
            if (entity instanceof LivingEntity living && entity != mc.player) {
                if (living.isDead() || living.getHealth() <= 0) continue;
                
                if (living instanceof PlayerEntity) {
                    double dist = mc.player.squaredDistanceTo(living);
                    if (dist <= maxDist) {
                        maxDist = dist;
                        bestTarget = living;
                    }
                }
            }
        }
        return bestTarget;
    }

    private void aimAtTarget(LivingEntity target) {
        double diffX = target.getX() - mc.player.getX();
        double diffY = (target.getY() + target.getEyeHeight(target.getPose())) - (mc.player.getY() + mc.player.getEyeHeight(mc.player.getPose()));
        double diffZ = target.getZ() - mc.player.getZ();

        double dist = Math.sqrt(diffX * diffX + diffZ * diffZ);

        float yaw = (float) (Math.atan2(diffZ, diffX) * (180 / Math.PI)) - 90.0f;
        float pitch = (float) -(Math.atan2(diffY, dist) * (180 / Math.PI));

        mc.player.setYaw(yaw);
        mc.player.setPitch(pitch);
    }
}

