package net.kaupenjoe.mccourse.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.entity.custom.PorcupineEntity;
import net.kaupenjoe.mccourse.entity.layer.ModModelLayers;
import net.kaupenjoe.mccourse.entity.variant.PorcupineVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import java.util.Map;

public class PorcupineRenderer extends MobRenderer<PorcupineEntity, PorcupineModel<PorcupineEntity>> {
    private static final Map<PorcupineVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(PorcupineVariant.class), map -> {
                map.put(PorcupineVariant.DEFAULT,
                        new ResourceLocation(MCCourseMod.MOD_ID, "textures/entity/porcupine.png"));
                map.put(PorcupineVariant.GREY,
                        new ResourceLocation(MCCourseMod.MOD_ID, "textures/entity/porcupine_grey.png"));
            });

    public PorcupineRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new PorcupineModel<>(ctx.bakeLayer(ModModelLayers.PORCUPINE)), 0.6f);
    }

    @Override
    public ResourceLocation getTexture(PorcupineEntity entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(PorcupineEntity livingEntity, float f, float g, PoseStack matrixStack,
                       MultiBufferSource vertexConsumerProvider, int i) {
        if(livingEntity.isBaby()) {
            matrixStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
