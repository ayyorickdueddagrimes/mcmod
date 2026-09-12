package com.shadeer.entity.insect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.navigation.FlyingNavigation;
import net.minecraft.entity.ai.navigation.Navigation;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracked;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedDataHandler;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;

public class FireflyEntity extends AnimalEntity {
    private static final TrackedDataHandler<Boolean> IS_GLOWING = DataTracker.registerData(FireflyEntity.class, TrackedDataHandler.BOOLEAN);
    private static final TrackedDataHandler<Integer> GLOW_INTENSITY = DataTracker.registerData(FireflyEntity.class, TrackedDataHandler.INTEGER);

    public FireflyEntity(EntityType<? extends FireflyEntity> entityType, World world) {
        super(entityType, world);
        this.navigation = createNavigation(world);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(IS_GLOWING, false);
        this.dataTracker.startTracking(GLOW_INTENSITY, 0);
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
        this.goalSelector.addGoal(0, new PanicGoal(this, 0.8));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, 3.0F));
        this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(3, new WanderAroundFarGoal(this, 0.6));
    }

    @Override
    protected void initAttributes() {
        super.initAttributes();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(3.0);
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(0.1);
    }

    @Override
    public void tick() {
        super.tick();

        // Fireflies only glow at night
        boolean isNight = this.world.isNight();
        if (isNight && !this.dataTracker.get(IS_GLOWING)) {
            this.dataTracker.set(IS_GLOWING, true);
            this.dataTracker.set(GLOW_INTENSITY, 15); // Maximum glow
        } else if (!isNight && this.dataTracker.get(IS_GLOWING)) {
            this.dataTracker.set(IS_GLOWING, false);
            this.dataTracker.set(GLOW_INTENSITY, 0);
        }

        // Pulse the glow effect
        if (this.dataTracker.get(IS_GLOWING)) {
            this.dataTracker.set(GLOW_INTENSITY, 10 + (int)(Math.sin(this.age * 0.1) * 5));
        }
    }

    public int getGlowIntensity() {
        return this.dataTracker.get(GLOW_INTENSITY);
    }

    public boolean isGlowing() {
        return this.dataTracker.get(IS_GLOWING);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putBoolean("IsGlowing", this.dataTracker.get(IS_GLOWING));
        nbt.putInt("GlowIntensity", this.dataTracker.get(GLOW_INTENSITY));
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        this.dataTracker.set(IS_GLOWING, nbt.getBoolean("IsGlowing"));
        this.dataTracker.set(GLOW_INTENSITY, nbt.getInt("GlowIntensity"));
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