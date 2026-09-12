package com.shadeer.config;

import com.shadeer.ShadeerMod;
import net.fabricmc.loader.api.FabricLoader;

import java.io.*;
import java.util.Properties;

public class ModConfig {
    private static final String CONFIG_FILE = "config/shadeer.properties";
    private static Properties properties = new Properties();

    // Default values
    public static boolean enableBirds = true;
    public static boolean enableInsects = true;
    public static boolean enableAquatic = true;
    public static boolean enableParticles = true;
    public static boolean enableWeatherEffects = true;
    public static boolean enableDynamicLighting = true;

    public static int birdSpawnRate = 10;
    public static int insectSpawnRate = 15;
    public static int aquaticSpawnRate = 12;
    public static int particleDensity = 50;

    public static void load() {
        File configFile = new File(FabricLoader.getInstance().getConfigDir().toFile(), "shadeer.properties");

        if (!configFile.exists()) {
            saveDefaults(configFile);
            return;
        }

        try (FileInputStream fis = new FileInputStream(configFile)) {
            properties.load(fis);
            loadValues();
        } catch (IOException e) {
            System.err.println("Failed to load Shadeer config: " + e.getMessage());
            saveDefaults(configFile);
        }
    }

    private static void loadValues() {
        enableBirds = Boolean.parseBoolean(properties.getProperty("enableBirds", "true"));
        enableInsects = Boolean.parseBoolean(properties.getProperty("enableInsects", "true"));
        enableAquatic = Boolean.parseBoolean(properties.getProperty("enableAquatic", "true"));
        enableParticles = Boolean.parseBoolean(properties.getProperty("enableParticles", "true"));
        enableWeatherEffects = Boolean.parseBoolean(properties.getProperty("enableWeatherEffects", "true"));
        enableDynamicLighting = Boolean.parseBoolean(properties.getProperty("enableDynamicLighting", "true"));

        birdSpawnRate = Integer.parseInt(properties.getProperty("birdSpawnRate", "10"));
        insectSpawnRate = Integer.parseInt(properties.getProperty("insectSpawnRate", "15"));
        aquaticSpawnRate = Integer.parseInt(properties.getProperty("aquaticSpawnRate", "12"));
        particleDensity = Integer.parseInt(properties.getProperty("particleDensity", "50"));
    }

    private static void saveDefaults(File configFile) {
        properties.setProperty("enableBirds", "true");
        properties.setProperty("enableInsects", "true");
        properties.setProperty("enableAquatic", "true");
        properties.setProperty("enableParticles", "true");
        properties.setProperty("enableWeatherEffects", "true");
        properties.setProperty("enableDynamicLighting", "true");

        properties.setProperty("birdSpawnRate", "10");
        properties.setProperty("insectSpawnRate", "15");
        properties.setProperty("aquaticSpawnRate", "12");
        properties.setProperty("particleDensity", "50");

        try {
            configFile.getParentFile().mkdirs();
            try (FileOutputStream fos = new FileOutputStream(configFile)) {
                properties.store(fos, "Shadeer Mod Configuration");
            }
        } catch (IOException e) {
            System.err.println("Failed to save Shadeer config: " + e.getMessage());
        }
    }

    public static void save() {
        File configFile = new File(FabricLoader.getInstance().getConfigDir().toFile(), "shadeer.properties");

        properties.setProperty("enableBirds", String.valueOf(enableBirds));
        properties.setProperty("enableInsects", String.valueOf(enableInsects));
        properties.setProperty("enableAquatic", String.valueOf(enableAquatic));
        properties.setProperty("enableParticles", String.valueOf(enableParticles));
        properties.setProperty("enableWeatherEffects", String.valueOf(enableWeatherEffects));
        properties.setProperty("enableDynamicLighting", String.valueOf(enableDynamicLighting));

        properties.setProperty("birdSpawnRate", String.valueOf(birdSpawnRate));
        properties.setProperty("insectSpawnRate", String.valueOf(insectSpawnRate));
        properties.setProperty("aquaticSpawnRate", String.valueOf(aquaticSpawnRate));
        properties.setProperty("particleDensity", String.valueOf(particleDensity));

        try (FileOutputStream fos = new FileOutputStream(configFile)) {
            properties.store(fos, "Shadeer Mod Configuration");
        } catch (IOException e) {
            System.err.println("Failed to save Shadeer config: " + e.getMessage());
        }
    }
}