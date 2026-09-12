package com.shadeer.entity.aquatic;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.navigation.WaterNavigation;
import net.minecraft.entity.ai.navigation.Navigation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.WaterCreatureEntity;
import net.minecraft.world.World;

public class DeepOceanFishEntity extends WaterCreatureEntity {
    private boolean isBioluminescent = true;

    public DeepOceanFishEntity(EntityType<? extends DeepOceanFishEntity> entityType, World world) {
        super(entityType, world);
        this.navigation = createNavigation(world);
    }

    @Override
    protected Navigation createNavigation(World world) {
        return new WaterNavigation(this, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.0));
        this.goalSelector.addGoal(1, new SwimAroundGoal(this, 0.8, 15));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, 8.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(5.0);
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.25);
    }

    @Override
    public void tick() {
        super.tick();

        // Bioluminescent effect in deep water
        if (this.getY() < 45 && isBioluminescent) {
            // The entity will glow in deep water
        }
    }

    public boolean isBioluminescent() {
        return isBioluminescent;
    }
}