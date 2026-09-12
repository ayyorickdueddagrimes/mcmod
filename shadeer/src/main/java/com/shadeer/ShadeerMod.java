package com.shadeer;

import com.shadeer.config.ModConfig;
import com.shadeer.particle.ModParticles;
import com.shadeer.registry.ModEntityTypes;
import com.shadeer.registry.ModSpawnRules;
import net.fabricmc.api.ModInitializer;

public class ShadeerMod implements ModInitializer {
    public static final String MOD_ID = "shadeer";

    @Override
    public void onInitialize() {
        // Load configuration
        ModConfig.load();

        // Initialize registries
        ModEntityTypes.register();
        ModSpawnRules.register();
        ModParticles.register();

        System.out.println("Shadeer mod initialized!");
    }
}