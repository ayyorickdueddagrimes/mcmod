package com.shadeer.util;

import com.shadeer.config.ModConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;

public class PerformanceManager {
    private static long lastFrameTime = 0;
    private static float currentFPS = 60.0f;
    private static final int FPS_UPDATE_INTERVAL = 20; // Update FPS every 20 frames
    private static int frameCount = 0;

    /**
     * Update performance metrics
     */
    public static void updatePerformance() {
        long currentTime = System.currentTimeMillis();
        frameCount++;

        if (frameCount >= FPS_UPDATE_INTERVAL) {
            float deltaTime = (currentTime - lastFrameTime) / 1000.0f;
            if (deltaTime > 0) {
                currentFPS = frameCount / deltaTime;
            }
            frameCount = 0;
            lastFrameTime = currentTime;
        }
    }

    /**
     * Get current FPS
     */
    public static float getCurrentFPS() {
        return currentFPS;
    }

    /**
     * Check if performance is low (below 30 FPS)
     */
    public static boolean isLowPerformance() {
        return currentFPS < 30.0f;
    }

    /**
     * Check if particles should be spawned based on performance
     */
    public static boolean shouldSpawnParticles() {
        if (!ModConfig.enableParticles) return false;

        // Reduce particle spawning when performance is low
        if (isLowPerformance()) {
            return frameCount % 3 == 0; // Only spawn every 3rd particle
        }

        return true;
    }

    /**
     * Check if entity rendering should be reduced
     */
    public static boolean shouldReduceEntityRendering() {
        return isLowPerformance();
    }

    /**
     * Get appropriate render distance based on performance
     */
    public static int getRenderDistance(int baseDistance) {
        if (isLowPerformance()) {
            return Math.max(baseDistance / 2, 16); // At least 16 blocks
        }
        return baseDistance;
    }

    /**
     * Clean up distant entities to improve performance
     */
    public static void cleanupDistantEntities() {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.world == null || client.player == null) return;

        // This is a placeholder for entity cleanup logic
        // In a full implementation, this would remove entities that are too far
        // from the player and not important
    }
}