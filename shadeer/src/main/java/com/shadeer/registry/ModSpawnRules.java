package com.shadeer.registry;

import com.shadeer.ShadeerMod;
import com.shadeer.config.ModConfig;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;

public class ModSpawnRules {
    public static void register() {
        // Register spawn rules for birds
        registerBirdSpawns();
        registerInsectSpawns();
        registerAquaticSpawns();

        System.out.println("Shadeer spawn rules registered!");
    }

    private static void registerBirdSpawns() {
        if (!ModConfig.enableBirds) return;

        // Songbirds spawn in forests and plains
        SpawnRestriction.register(
                ModEntityTypes.SONGBIRD,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                PassiveEntity::canSpawnInDark
        );

        // Hawks spawn in mountains and high areas
        SpawnRestriction.register(
                ModEntityTypes.HAWK,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                PassiveEntity::canSpawnInDark
        );

        // Water birds spawn near water
        SpawnRestriction.register(
                ModEntityTypes.WATER_BIRD,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                PassiveEntity::canSpawnInDark
        );
    }

    private static void registerInsectSpawns() {
        if (!ModConfig.enableInsects) return;

        // Butterflies spawn in flower-rich areas
        SpawnRestriction.register(
                ModEntityTypes.BUTTERFLY,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                PassiveEntity::canSpawnInDark
        );

        // Dragonflies spawn near water
        SpawnRestriction.register(
                ModEntityTypes.DRAGONFLY,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                PassiveEntity::canSpawnInDark
        );

        // Fireflies spawn at night in forests
        SpawnRestriction.register(
                ModEntityTypes.FIREFLY,
                SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                PassiveEntity::canSpawnInDark
        );
    }

    private static void registerAquaticSpawns() {
        if (!ModConfig.enableAquatic) return;

        // Tropical fish spawn in warm oceans
        SpawnRestriction.register(
                ModEntityTypes.TROPICAL_FISH,
                SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                PassiveEntity::canSpawnInDark
        );

        // Deep ocean fish spawn in deep oceans
        SpawnRestriction.register(
                ModEntityTypes.DEEP_OCEAN_FISH,
                SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                PassiveEntity::canSpawnInDark
        );

        // Jellyfish spawn in oceans
        SpawnRestriction.register(
                ModEntityTypes.JELLYFISH,
                SpawnRestriction.Location.IN_WATER,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
                PassiveEntity::canSpawnInDark
        );
    }
}