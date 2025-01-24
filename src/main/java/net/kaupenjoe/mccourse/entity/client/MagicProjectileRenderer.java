package net.kaupenjoe.mccourse.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.entity.custom.MagicProjectileEntity;
import net.kaupenjoe.mccourse.entity.layer.ModModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class MagicProjectileRenderer extends EntityRenderer<MagicProjectileEntity> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(MCCourseMod.MOD_ID, "textures/entity/magic_projectile.png");
    protected MagicProjectileModel model;

    public MagicProjectileRenderer(EntityRendererProvider.Context ctx) {
        super(ctx);
        model = new MagicProjectileModel(ctx.bakeLayer(ModModelLayers.MAGIC_PROJECTILE));
    }

    @Override
    public void render(MagicProjectileEntity entity, float yaw, float tickDelta, PoseStack matrices,
                       MultiBufferSource vertexConsumers, int light) {
        matrices.pushPose();
        matrices.mulPose(Axis.YP.rotationDegrees(Mth.lerp(tickDelta, entity.yRotO, entity.getYRot()) - 90.0F));
        matrices.mulPose(Axis.ZP.rotationDegrees(Mth.lerp(tickDelta, entity.xRotO, entity.getXRot()) + 90.0F));
        VertexConsumer vertexconsumer = ItemRenderer.getFoilBufferDirect(vertexConsumers, this.model.renderType(TEXTURE), false, false);
        this.model.renderToBuffer(matrices, vertexconsumer, light, OverlayTexture.NO_OVERLAY, 1.0F, 0.0F, 0.0F, 1.0F);

        matrices.popPose();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }

    @Override
    public ResourceLocation getTextureLocation(MagicProjectileEntity entity) {
        return TEXTURE;
    }
}
