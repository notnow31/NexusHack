package com.nexushack.modules.combat;

import com.nexushack.event.EventTarget;
import com.nexushack.event.events.UpdateEvent;
import com.nexushack.module.Module;

public class Velocity extends Module {

    public Velocity() {
        super("Velocity", Category.COMBAT);
    }

    @EventTarget
    public void onUpdate(UpdateEvent event) {
        if (!isEnabled() || mc.player == null) return;

        // Geri itme (knockback) değerlerini sıfırlama veya azaltma mantığı
        if (mc.player.hurtTime > 0) {
            // Sunucudan gelen savrulma paketlerini burada bloke edeceğiz
            mc.player.setVelocity(mc.player.getVelocity().getX() * 0.0, mc.player.getVelocity().getY(), mc.player.getVelocity().getZ() * 0.0);
        }
    }
}

