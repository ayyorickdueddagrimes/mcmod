package com.shadeer.registry;

import com.shadeer.ShadeerMod;
import com.shadeer.entity.bird.SongbirdEntity;
import com.shadeer.entity.bird.HawkEntity;
import com.shadeer.entity.bird.WaterBirdEntity;
import com.shadeer.entity.insect.ButterflyEntity;
import com.shadeer.entity.insect.DragonflyEntity;
import com.shadeer.entity.insect.FireflyEntity;
import com.shadeer.entity.aquatic.TropicalFishEntity;
import com.shadeer.entity.aquatic.DeepOceanFishEntity;
import com.shadeer.entity.aquatic.JellyfishEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntityTypes {
    // Bird Entities
    public static EntityType<SongbirdEntity> SONGBIRD;
    public static EntityType<HawkEntity> HAWK;
    public static EntityType<WaterBirdEntity> WATER_BIRD;

    // Insect Entities
    public static EntityType<ButterflyEntity> BUTTERFLY;
    public static EntityType<DragonflyEntity> DRAGONFLY;
    public static EntityType<FireflyEntity> FIREFLY;

    // Aquatic Entities
    public static EntityType<TropicalFishEntity> TROPICAL_FISH;
    public static EntityType<DeepOceanFishEntity> DEEP_OCEAN_FISH;
    public static EntityType<JellyfishEntity> JELLYFISH;

    public static void register() {
        // Register bird entities
        SONGBIRD = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(ShadeerMod.MOD_ID, "songbird"),
                FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, SongbirdEntity::new)
                        .dimensions(EntityDimensions.fixed(0.3f, 0.3f))
                        .build()
        );

        HAWK = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(ShadeerMod.MOD_ID, "hawk"),
                FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, HawkEntity::new)
                        .dimensions(EntityDimensions.fixed(0.6f, 0.6f))
                        .build()
        );

        WATER_BIRD = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(ShadeerMod.MOD_ID, "water_bird"),
                FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, WaterBirdEntity::new)
                        .dimensions(EntityDimensions.fixed(0.5f, 0.5f))
                        .build()
        );

        // Register insect entities
        BUTTERFLY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(ShadeerMod.MOD_ID, "butterfly"),
                FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, ButterflyEntity::new)
                        .dimensions(EntityDimensions.fixed(0.2f, 0.2f))
                        .build()
        );

        DRAGONFLY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(ShadeerMod.MOD_ID, "dragonfly"),
                FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, DragonflyEntity::new)
                        .dimensions(EntityDimensions.fixed(0.3f, 0.15f))
                        .build()
        );

        FIREFLY = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(ShadeerMod.MOD_ID, "firefly"),
                FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, FireflyEntity::new)
                        .dimensions(EntityDimensions.fixed(0.15f, 0.15f))
                        .build()
        );

        // Register aquatic entities
        TROPICAL_FISH = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(ShadeerMod.MOD_ID, "tropical_fish"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_AMBIENT, TropicalFishEntity::new)
                        .dimensions(EntityDimensions.fixed(0.3f, 0.3f))
                        .build()
        );

        DEEP_OCEAN_FISH = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(ShadeerMod.MOD_ID, "deep_ocean_fish"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_AMBIENT, DeepOceanFishEntity::new)
                        .dimensions(EntityDimensions.fixed(0.4f, 0.4f))
                        .build()
        );

        JELLYFISH = Registry.register(
                Registries.ENTITY_TYPE,
                new Identifier(ShadeerMod.MOD_ID, "jellyfish"),
                FabricEntityTypeBuilder.create(SpawnGroup.WATER_AMBIENT, JellyfishEntity::new)
                        .dimensions(EntityDimensions.fixed(0.5f, 0.6f))
                        .build()
        );

        System.out.println("Shadeer entity types registered!");
    }
}