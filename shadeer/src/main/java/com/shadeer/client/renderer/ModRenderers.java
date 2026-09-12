package com.shadeer.client.renderer;

import com.shadeer.entity.bird.HawkEntity;
import com.shadeer.entity.bird.SongbirdEntity;
import com.shadeer.entity.bird.WaterBirdEntity;
import com.shadeer.entity.insect.ButterflyEntity;
import com.shadeer.entity.insect.DragonflyEntity;
import com.shadeer.entity.insect.FireflyEntity;
import com.shadeer.entity.aquatic.DeepOceanFishEntity;
import com.shadeer.entity.aquatic.JellyfishEntity;
import com.shadeer.entity.aquatic.TropicalFishEntity;
import com.shadeer.registry.ModEntityTypes;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.FlyingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.QuadrupedEntityModel;
import net.minecraft.util.Identifier;

public class ModRenderers {
    public static void register() {
        // Register bird renderers with appropriate models
        EntityRendererRegistry.register(ModEntityTypes.SONGBIRD, SongbirdRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.HAWK, HawkRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.WATER_BIRD, WaterBirdRenderer::new);

        // Register insect renderers with appropriate models
        EntityRendererRegistry.register(ModEntityTypes.BUTTERFLY, ButterflyRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.DRAGONFLY, DragonflyRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.FIREFLY, FireflyRenderer::new);

        // Register aquatic renderers with appropriate models
        EntityRendererRegistry.register(ModEntityTypes.TROPICAL_FISH, TropicalFishRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.DEEP_OCEAN_FISH, DeepOceanFishRenderer::new);
        EntityRendererRegistry.register(ModEntityTypes.JELLYFISH, JellyfishRenderer::new);

        System.out.println("Shadeer entity renderers registered!");
    }

    // Bird renderers - using FlyingEntityRenderer for flying birds
    private static class SongbirdRenderer extends FlyingEntityRenderer<SongbirdEntity> {
        private static final Identifier TEXTURE = new Identifier("shadeer:textures/entity/songbird.png");

        public SongbirdRenderer(EntityRendererFactory.Context context) {
            super(context, 0.3f);
        }

        @Override
        public Identifier getTexture(SongbirdEntity entity) {
            return TEXTURE;
        }
    }

    private static class HawkRenderer extends FlyingEntityRenderer<HawkEntity> {
        private static final Identifier TEXTURE = new Identifier("shadeer:textures/entity/hawk.png");

        public HawkRenderer(EntityRendererFactory.Context context) {
            super(context, 0.6f);
        }

        @Override
        public Identifier getTexture(HawkEntity entity) {
            return TEXTURE;
        }
    }

    private static class WaterBirdRenderer extends FlyingEntityRenderer<WaterBirdEntity> {
        private static final Identifier TEXTURE = new Identifier("shadeer:textures/entity/water_bird.png");

        public WaterBirdRenderer(EntityRendererFactory.Context context) {
            super(context, 0.5f);
        }

        @Override
        public Identifier getTexture(WaterBirdEntity entity) {
            return TEXTURE;
        }
    }

    // Insect renderers - using small generic models (placeholder)
    private static class ButterflyRenderer extends MobEntityRenderer<ButterflyEntity, EntityModel<ButterflyEntity>> {
        private static final Identifier TEXTURE = new Identifier("shadeer:textures/entity/butterfly.png");

        public ButterflyRenderer(EntityRendererFactory.Context context) {
            super(context, new ButterflyModel(context.getModelPart(new Identifier("shadeer", "butterfly"))), 0.2f);
        }

        @Override
        public Identifier getTexture(ButterflyEntity entity) {
            return TEXTURE;
        }
    }

    private static class DragonflyRenderer extends MobEntityRenderer<DragonflyEntity, EntityModel<DragonflyEntity>> {
        private static final Identifier TEXTURE = new Identifier("shadeer:textures/entity/dragonfly.png");

        public DragonflyRenderer(EntityRendererFactory.Context context) {
            super(context, new DragonflyModel(context.getModelPart(new Identifier("shadeer", "dragonfly"))), 0.3f);
        }

        @Override
        public Identifier getTexture(DragonflyEntity entity) {
            return TEXTURE;
        }
    }

    private static class FireflyRenderer extends MobEntityRenderer<FireflyEntity, EntityModel<FireflyEntity>> {
        private static final Identifier TEXTURE = new Identifier("shadeer:textures/entity/firefly.png");

        public FireflyRenderer(EntityRendererFactory.Context context) {
            super(context, new FireflyModel(context.getModelPart(new Identifier("shadeer", "firefly"))), 0.15f);
        }

        @Override
        public Identifier getTexture(FireflyEntity entity) {
            return TEXTURE;
        }
    }

    // Aquatic renderers - using generic models (placeholder)
    private static class TropicalFishRenderer extends MobEntityRenderer<TropicalFishEntity, EntityModel<TropicalFishEntity>> {
        private static final Identifier TEXTURE = new Identifier("shadeer:textures/entity/tropical_fish.png");

        public TropicalFishRenderer(EntityRendererFactory.Context context) {
            super(context, new TropicalFishModel(context.getModelPart(new Identifier("shadeer", "tropical_fish"))), 0.3f);
        }

        @Override
        public Identifier getTexture(TropicalFishEntity entity) {
            return TEXTURE;
        }
    }

    private static class DeepOceanFishRenderer extends MobEntityRenderer<DeepOceanFishEntity, EntityModel<DeepOceanFishEntity>> {
        private static final Identifier TEXTURE = new Identifier("shadeer:textures/entity/deep_ocean_fish.png");

        public DeepOceanFishRenderer(EntityRendererFactory.Context context) {
            super(context, new DeepOceanFishModel(context.getModelPart(new Identifier("shadeer", "deep_ocean_fish"))), 0.4f);
        }

        @Override
        public Identifier getTexture(DeepOceanFishEntity entity) {
            return TEXTURE;
        }
    }

    private static class JellyfishRenderer extends MobEntityRenderer<JellyfishEntity, EntityModel<JellyfishEntity>> {
        private static final Identifier TEXTURE = new Identifier("shadeer:textures/entity/jellyfish.png");

        public JellyfishRenderer(EntityRendererFactory.Context context) {
            super(context, new JellyfishModel(context.getModelPart(new Identifier("shadeer", "jellyfish"))), 0.5f);
        }

        @Override
        public Identifier getTexture(JellyfishEntity entity) {
            return TEXTURE;
        }
    }
}