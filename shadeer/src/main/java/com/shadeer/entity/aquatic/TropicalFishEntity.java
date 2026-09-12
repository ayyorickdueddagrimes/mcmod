package com.shadeer.entity.aquatic;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.navigation.WaterNavigation;
import net.minecraft.entity.ai.navigation.Navigation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.WaterCreatureEntity;
import net.minecraft.world.World;

public class TropicalFishEntity extends WaterCreatureEntity {
    public TropicalFishEntity(EntityType<? extends TropicalFishEntity> entityType, World world) {
        super(entityType, world);
        this.navigation = createNavigation(world);
    }

    @Override
    protected Navigation createNavigation(World world) {
        return new WaterNavigation(this, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.2));
        this.goalSelector.addGoal(1, new SwimAroundGoal(this, 1.0, 10));
        this.goalSelector.addGoal(2, new LookAtPlayerGoal(this, 6.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(3.0);
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.3);
    }
}