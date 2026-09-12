package com.shadeer.vfx.lighting;

import com.shadeer.entity.insect.FireflyEntity;
import net.minecraft.entity.Entity;

public class DynamicLightHandler {
    /**
     * Get the light level for an entity based on its type and state
     */
    public static int getLightLevel(Entity entity) {
        if (entity instanceof FireflyEntity firefly) {
            if (firefly.isGlowing()) {
                return firefly.getGlowIntensity();
            }
        }

        // Add more dynamic light sources here
        // For example: bioluminescent fish, glowing plants, etc.

        return 0;
    }

    /**
     * Check if an entity should emit light
     */
    public static boolean shouldEmitLight(Entity entity) {
        return getLightLevel(entity) > 0;
    }

    /**
     * Register dynamic light handlers for entity types
     */
    public static void registerLightHandlers() {
        // This would integrate with dynamic lighting mods like LambDynamicLights
        // For now, we'll implement a basic system
        System.out.println("Shadeer dynamic light handlers registered!");
    }
}