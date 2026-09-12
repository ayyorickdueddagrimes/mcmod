package com.shadeer.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class FireflyParticle extends SpriteBillboardParticle {
    private final float initialScale;

    public FireflyParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.initialScale = this.scale = 0.1f + (float)Math.random() * 0.1f;
        this.maxAge = 60 + this.random.nextInt(40);
        this.collidesWithWorld = false;
        this.colorAlpha = 1.0f;
    }

    @Override
    public void tick() {
        super.tick();

        // Pulsing effect
        float ageProgress = (float)this.age / (float)this.maxAge;
        this.scale = this.initialScale * (1.0f - ageProgress * 0.5f);

        // Color pulsing between yellow and green
        float pulse = (float)Math.sin(this.age * 0.2) * 0.5f + 0.5f;
        this.colorRed = 1.0f;
        this.colorGreen = 0.8f + pulse * 0.2f;
        this.colorBlue = 0.2f + pulse * 0.3f;
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
            FireflyParticle particle = new FireflyParticle(world, x, y, z, dx, dy, dz);
            particle.setSprite(this.spriteProvider);
            return particle;
        }
    }
}