package com.shadeer.entity.aquatic;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.navigation.WaterNavigation;
import net.minecraft.entity.ai.navigation.Navigation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.WaterCreatureEntity;
import net.minecraft.world.World;

public class JellyfishEntity extends WaterCreatureEntity {
    private float pulsePhase = 0.0f;

    public JellyfishEntity(EntityType<? extends JellyfishEntity> entityType, World world) {
        super(entityType, world);
        this.navigation = createNavigation(world);
    }

    @Override
    protected Navigation createNavigation(World world) {
        return new WaterNavigation(this, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 0.8));
        this.goalSelector.addGoal(1, new SwimAroundGoal(this, 0.6, 8));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, 5.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(4.0);
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.15);
    }

    @Override
    public void tick() {
        super.tick();

        // Pulsing animation phase
        pulsePhase += 0.1f;
        if (pulsePhase > Math.PI * 2) {
            pulsePhase = 0.0f;
        }
    }

    public float getPulsePhase() {
        return pulsePhase;
    }
}