package com.shadeer.client.renderer;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

public class DragonflyModel extends SinglePartEntityModel<DragonflyEntity> {
    private final ModelPart root;

    public DragonflyModel(ModelPart root) {
        this.root = root;
    }

    @Override
    public ModelPart getPart() {
        return root;
    }

    @Override
    public void setAngles(DragonflyEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        // Simple placeholder animation
    }
}