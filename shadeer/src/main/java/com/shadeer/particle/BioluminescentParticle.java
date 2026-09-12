package com.shadeer.particle;

import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.SimpleParticleType;

public class BioluminescentParticle extends SpriteBillboardParticle {
    private final float initialScale;

    public BioluminescentParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.initialScale = this.scale = 0.15f + (float)Math.random() * 0.1f;
        this.maxAge = 80 + this.random.nextInt(60);
        this.collidesWithWorld = false;
        this.colorAlpha = 0.8f;
    }

    @Override
    public void tick() {
        super.tick();

        // Gentle pulsing effect
        float ageProgress = (float)this.age / (float)this.maxAge;
        this.scale = this.initialScale * (1.0f - ageProgress * 0.3f);

        // Blue-green bioluminescent color
        float pulse = (float)Math.sin(this.age * 0.15) * 0.3f + 0.7f;
        this.colorRed = 0.1f;
        this.colorGreen = 0.5f + pulse * 0.3f;
        this.colorBlue = 0.8f + pulse * 0.2f;
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
            BioluminescentParticle particle = new BioluminescentParticle(world, x, y, z, dx, dy, dz);
            particle.setSprite(this.spriteProvider);
            return particle;
        }
    }
}