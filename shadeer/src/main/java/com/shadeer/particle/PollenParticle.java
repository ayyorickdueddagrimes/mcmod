package com.shadeer.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class PollenParticle extends SpriteBillboardParticle {
    public PollenParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.scale = 0.05f + (float)Math.random() * 0.05f;
        this.maxAge = 40 + this.random.nextInt(30);
        this.collidesWithWorld = false;
        this.colorAlpha = 0.6f;

        // Yellow/gold pollen colors
        this.colorRed = 1.0f;
        this.colorGreen = 0.9f + (float)Math.random() * 0.1f;
        this.colorBlue = 0.3f + (float)Math.random() * 0.2f;
    }

    @Override
    public void tick() {
        super.tick();

        // Gentle floating motion
        this.velocityX *= 0.98;
        this.velocityY *= 0.98;
        this.velocityZ *= 0.98;

        // Slowly fade out
        this.colorAlpha = 0.6f * (1.0f - (float)this.age / (float)this.maxAge);
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT;
    }

    public static class Factory implements ParticleFactory<SimpleParticleType> {
        private final SpriteProvider spriteProvider;

        public Factory(SpriteProvider spriteProvider) {
            this.spriteProvider = spriteProvider;
        }

        @Override
        public Particle createParticle(SimpleParticleType type, ClientWorld world, double x, double y, double z, double dx, double dy, double dz) {
            PollenParticle particle = new PollenParticle(world, x, y, z, dx, dy, dz);
            particle.setSprite(this.spriteProvider);
            return particle;
        }
    }
}