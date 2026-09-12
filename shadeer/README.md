# Shadeer - Minecraft Life & VFX Mod

A comprehensive Fabric mod for Minecraft 1.21.x that adds vibrant wildlife and incredible visual effects to make the world feel more alive.

## Features

### Wildlife
- **Birds**: Songbirds, Hawks, and Water Birds with flying behaviors
- **Insects**: Butterflies, Dragonflies, and Fireflies with unique behaviors
- **Aquatic Life**: Tropical Fish, Deep Ocean Fish, and Jellyfish

### Visual Effects
- **Custom Particles**: Firefly glow, bioluminescent effects, pollen particles
- **Weather Enhancement**: Enhanced rain and snow effects
- **Dynamic Lighting**: Glowing creatures emit light (fireflies, bioluminescent fish)

### Configuration
- Configurable spawn rates for each creature type
- Performance settings for particle density and rendering
- Toggle features on/off based on preferences

## Installation

1. Install Fabric Loader for Minecraft 1.21.x
2. Download Fabric API
3. Place the Shadeer mod JAR file in your `.minecraft/mods` folder
4. Launch Minecraft with the Fabric profile

## Configuration

The mod creates a configuration file at `config/shadeer.properties` with the following options:

```properties
# Enable/disable creature types
enableBirds=true
enableInsects=true
enableAquatic=true

# Enable/disable visual effects
enableParticles=true
enableWeatherEffects=true
enableDynamicLighting=true

# Spawn rates (higher = more frequent spawns)
birdSpawnRate=10
insectSpawnRate=15
aquaticSpawnRate=12

# Particle density (0-100)
particleDensity=50
```

## Building

To build the mod from source:

```bash
./gradlew build
```

The built JAR file will be in `build/libs/`.

## Development

This mod is built with:
- Minecraft 1.21.1
- Fabric Loader 0.16.9
- Fabric API 0.102.0+1.21.1
- Java 21

## License

MIT License

## Credits

Created with Fabric and Fabric API