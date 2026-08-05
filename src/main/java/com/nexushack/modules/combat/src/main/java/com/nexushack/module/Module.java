package com.nexushack.module;

import net.minecraft.client.MinecraftClient;

public class Module {
    protected static MinecraftClient mc = MinecraftClient.getInstance();

    private final String name;
    private final Category category;
    private boolean enabled;

    public Module(String name, Category category) {
        this.name = name;
        this.category = category;
        this.enabled = false;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void toggle() {
        setEnabled(!enabled);
    }

    public void onEnable() {}
    public void onDisable() {}

    public enum Category {
        COMBAT,
        MOVEMENT,
        PLAYER,
        RENDER,
        EXPLOIT
    }
}

