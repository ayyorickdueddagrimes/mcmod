package com.shadeer.particle;

import com.shadeer.ShadeerMod;
import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModParticles {
    public static final SimpleParticleType FIREFLY_GLOW = FabricParticleTypes.simple();
    public static final SimpleParticleType BIOLUMINESCENT = FabricParticleTypes.simple();
    public static final SimpleParticleType POLLEN = FabricParticleTypes.simple();
    public static final SimpleParticleType MAGIC_SPARKLE = FabricParticleTypes.simple();
    public static final SimpleParticleType ENHANCED_RAIN = FabricParticleTypes.simple();
    public static final SimpleParticleType ENHANCED_SNOW = FabricParticleTypes.simple();

    public static void register() {
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShadeerMod.MOD_ID, "firefly_glow"), FIREFLY_GLOW);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShadeerMod.MOD_ID, "bioluminescent"), BIOLUMINESCENT);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShadeerMod.MOD_ID, "pollen"), POLLEN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShadeerMod.MOD_ID, "magic_sparkle"), MAGIC_SPARKLE);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShadeerMod.MOD_ID, "enhanced_rain"), ENHANCED_RAIN);
        Registry.register(Registries.PARTICLE_TYPE, new Identifier(ShadeerMod.MOD_ID, "enhanced_snow"), ENHANCED_SNOW);

        System.out.println("Shadeer particles registered!");
    }
}