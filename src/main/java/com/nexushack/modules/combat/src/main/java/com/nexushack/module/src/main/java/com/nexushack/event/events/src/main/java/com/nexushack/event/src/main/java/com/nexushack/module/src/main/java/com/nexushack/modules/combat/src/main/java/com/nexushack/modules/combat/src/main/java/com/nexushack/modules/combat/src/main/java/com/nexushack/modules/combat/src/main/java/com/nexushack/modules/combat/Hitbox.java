package com.nexushack.modules.combat;

import com.nexushack.event.EventTarget;
import com.nexushack.event.events.UpdateEvent;
import com.nexushack.module.Module;

public class Hitbox extends Module {

    // Düşman kutu boyutunu ayarlamak için değer (İstediğin gibi artırabilirsin)
    public float size = 0.5f; 

    public Hitbox() {
        super("Hitbox", Category.COMBAT);
    }

    @EventTarget
    public void onUpdate(UpdateEvent event) {
        if (!isEnabled() || mc.world == null) return;

        // Etraftaki oyuncuların veya varlıkların hedef alma kutularını (AABB) genişletme mantığı
    }
}

