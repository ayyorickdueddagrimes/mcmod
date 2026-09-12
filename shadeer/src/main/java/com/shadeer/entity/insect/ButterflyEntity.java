package com.shadeer.entity.insect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.navigation.FlyingNavigation;
import net.minecraft.entity.ai.navigation.Navigation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.World;

public class ButterflyEntity extends AnimalEntity {
    public ButterflyEntity(EntityType<? extends ButterflyEntity> entityType, World world) {
        super(entityType, world);
        this.navigation = createNavigation(world);
    }

    @Override
    protected Navigation createNavigation(World world) {
        FlyingNavigation navigation = new FlyingNavigation(this, world);
        navigation.setCanPathOverWater(false);
        navigation.setCanEnterOpenDoors(false);
        return navigation;
    }

    @Override
    protected void initGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.0));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, 4.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new WanderAroundFarGoal(this, 0.8));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(4.0);
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.15);
    }

    @Override
    public boolean canBreed() {
        return false;
    }

    @Override
    public PassiveEntity createChild(PassiveEntity passiveEntity) {
        return null;
    }
}