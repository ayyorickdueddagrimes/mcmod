package com.shadeer.client;

import com.shadeer.particle.BioluminescentParticle;
import com.shadeer.particle.FireflyParticle;
import com.shadeer.particle.ModParticles;
import com.shadeer.particle.PollenParticle;
import com.shadeer.client.renderer.ModRenderers;
import com.shadeer.util.PerformanceManager;
import com.shadeer.vfx.lighting.DynamicLightHandler;
import com.shadeer.vfx.weather.WeatherEffects;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvent;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;

public class ShadeerClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        // Register particle factories
        registerParticles();

        // Register entity renderers
        ModRenderers.register();

        // Register weather effects
        WeatherEffects.register();

        // Register dynamic lighting
        DynamicLightHandler.registerLightHandlers();

        // Register performance update
        ClientTickEvent.END_CLIENT_TICK.register(client -> {
            PerformanceManager.updatePerformance();
        });

        System.out.println("Shadeer client initialized!");
    }

    private void registerParticles() {
        ParticleFactoryRegistry.getInstance().register(ModParticles.FIREFLY_GLOW, FireflyParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.BIOLUMINESCENT, BioluminescentParticle.Factory::new);
        ParticleFactoryRegistry.getInstance().register(ModParticles.POLLEN, PollenParticle.Factory::new);
    }
}