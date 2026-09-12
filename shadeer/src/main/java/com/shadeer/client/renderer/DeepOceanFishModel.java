package com.shadeer.client.renderer;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class DeepOceanFishModel extends SinglePartEntityModel<DeepOceanFishEntity> {
    private final ModelPart root;

    public DeepOceanFishModel(ModelPart root) {
        this.root = root;
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(DeepOceanFishEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Simple placeholder animation
    }
}