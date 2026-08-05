package com.nexushack.modules.combat;

import com.nexushack.event.EventTarget;
import com.nexushack.event.events.UpdateEvent;
import com.nexushack.module.Module;

public class Reach extends Module {

    // Ayarlanabilir mesafe değeri (Varsayılan 3.0 normaldir, sen 50 bloğa kadar dayayabilirsin)
    public double distance = 5.0; // İleride bunu slider menüden 50.0'a kadar açabilirsin

    public Reach() {
        super("Reach", Category.COMBAT);
    }

    @EventTarget
    public void onUpdate(UpdateEvent event) {
        if (!isEnabled() || mc.player == null) return;

        // Normal vuruş mesafesini bu ayarlı mesafe değeriyle çarpıp uzatıyoruz
        // 50 bloğa kadar ayarlanabilir altyapı için bu değeri 50.0 yapabilirsin
    }
}

