package net.kaupenjoe.mccourse.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.kaupenjoe.mccourse.entity.animations.ModAnimations;
import net.kaupenjoe.mccourse.entity.custom.PorcupineEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.util.Mth;

public class PorcupineModel<T extends PorcupineEntity> extends HierarchicalModel<T> {
    private final ModelPart porcupine;
    private final ModelPart head;

    public PorcupineModel(ModelPart root) {
        this.porcupine = root.getChild("porcupine");
        this.head = porcupine.getChild("body").getChild("torso").getChild("head");
    }

    public static LayerDefinition getTexturedModelData() {
        MeshDefinition modelData = new MeshDefinition();
        PartDefinition modelPartData = modelData.getRoot();
        PartDefinition porcupine = modelPartData.addOrReplaceChild("porcupine", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

        PartDefinition body = porcupine.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, -4.0F, 0.0F));

        PartDefinition torso = body.addOrReplaceChild("torso", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -4.0F, 6.0F, 5.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition tail = torso.addOrReplaceChild("tail", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -1.251F, 4.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition cube_r1 = tail.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(11, 25).addBox(-6.0F, -0.499F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, 0.0F, 0.9599F, 0.0F));

        PartDefinition cube_r2 = tail.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(11, 25).addBox(-6.0F, 0.001F, -1.0F, 7.0F, 0.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.25F, 0.0F, 0.0F, 0.6109F, 0.0F));

        PartDefinition head = torso.addOrReplaceChild("head", CubeListBuilder.create(), PartPose.offset(0.0F, -1.0F, -4.0F));

        PartDefinition skull = head.addOrReplaceChild("skull", CubeListBuilder.create().texOffs(0, 13).addBox(-2.0F, -2.0F, -4.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(1.1F, -0.75F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(12, 13).addBox(1.425F, -0.975F, -3.025F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F))
                .texOffs(0, 14).mirror().addBox(-2.1F, -0.75F, -3.25F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
                .texOffs(12, 13).mirror().addBox(-2.425F, -0.975F, -3.025F, 1.0F, 1.0F, 1.0F, new CubeDeformation(-0.3F)).mirror(false)
                .texOffs(16, 18).addBox(-1.0F, -0.25F, -5.0F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition hair = skull.addOrReplaceChild("hair", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -1.0F, -4.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition cube_r3 = hair.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition cube_r4 = hair.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 16).addBox(0.0F, -4.0F, 0.0F, 0.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

        PartDefinition left_eyelid = skull.addOrReplaceChild("left_eyelid", CubeListBuilder.create().texOffs(24, 0).addBox(0.1F, -1.75F, -7.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)), PartPose.offset(-0.4F, 0.5F, 3.5F));

        PartDefinition right_eyelid = skull.addOrReplaceChild("right_eyelid", CubeListBuilder.create().texOffs(24, 0).mirror().addBox(-2.1F, -1.75F, -7.25F, 2.0F, 2.0F, 2.0F, new CubeDeformation(-0.4F)).mirror(false), PartPose.offset(0.4F, 0.5F, 3.5F));

        PartDefinition spikes = torso.addOrReplaceChild("spikes", CubeListBuilder.create(), PartPose.offset(0.0F, -3.0F, -3.5F));

        PartDefinition spike = spikes.addOrReplaceChild("spike", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.0436F));

        PartDefinition spike2 = spikes.addOrReplaceChild("spike2", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0873F));

        PartDefinition spike5 = spikes.addOrReplaceChild("spike5", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

        PartDefinition spike3 = spikes.addOrReplaceChild("spike3", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition spike4 = spikes.addOrReplaceChild("spike4", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.4363F));

        PartDefinition spikes2 = torso.addOrReplaceChild("spikes2", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -3.0F, -2.5F, 0.3054F, 0.0F, 0.0F));

        PartDefinition spike6 = spikes2.addOrReplaceChild("spike6", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -1.0F));

        PartDefinition spike7 = spikes2.addOrReplaceChild("spike7", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.2618F));

        PartDefinition spike8 = spikes2.addOrReplaceChild("spike8", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition spike9 = spikes2.addOrReplaceChild("spike9", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, -1.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition spike10 = spikes2.addOrReplaceChild("spike10", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.6545F));

        PartDefinition spikes3 = torso.addOrReplaceChild("spikes3", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -3.0F, -2.5F, -0.1745F, 0.0F, 0.0F));

        PartDefinition spike11 = spikes3.addOrReplaceChild("spike11", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.1309F));

        PartDefinition spike12 = spikes3.addOrReplaceChild("spike12", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition spike13 = spikes3.addOrReplaceChild("spike13", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2618F));

        PartDefinition spike14 = spikes3.addOrReplaceChild("spike14", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0436F));

        PartDefinition spike15 = spikes3.addOrReplaceChild("spike15", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -7.0F, 0.0F, 0.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1745F));

        PartDefinition spikes4 = torso.addOrReplaceChild("spikes4", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, -2.0F, -0.5672F, 0.0F, 0.0F));

        PartDefinition spike16 = spikes4.addOrReplaceChild("spike16", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition spike17 = spikes4.addOrReplaceChild("spike17", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1745F));

        PartDefinition spike18 = spikes4.addOrReplaceChild("spike18", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2182F));

        PartDefinition spike19 = spikes4.addOrReplaceChild("spike19", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.0873F));

        PartDefinition spike20 = spikes4.addOrReplaceChild("spike20", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1309F));

        PartDefinition spikes5 = torso.addOrReplaceChild("spikes5", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

        PartDefinition spike21 = spikes5.addOrReplaceChild("spike21", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition spike22 = spikes5.addOrReplaceChild("spike22", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4363F));

        PartDefinition spike23 = spikes5.addOrReplaceChild("spike23", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.7854F));

        PartDefinition spike24 = spikes5.addOrReplaceChild("spike24", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

        PartDefinition spike25 = spikes5.addOrReplaceChild("spike25", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -6.0F, 0.0F, 0.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5672F));

        PartDefinition spikes6 = torso.addOrReplaceChild("spikes6", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -3.0F, -0.5F, -0.6545F, 0.0F, 0.0F));

        PartDefinition spike26 = spikes6.addOrReplaceChild("spike26", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition spike27 = spikes6.addOrReplaceChild("spike27", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

        PartDefinition spike28 = spikes6.addOrReplaceChild("spike28", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.48F));

        PartDefinition spike29 = spikes6.addOrReplaceChild("spike29", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2182F));

        PartDefinition spike30 = spikes6.addOrReplaceChild("spike30", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -5.0F, 0.0F, 0.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.48F));

        PartDefinition spikes7 = torso.addOrReplaceChild("spikes7", CubeListBuilder.create(), PartPose.offsetAndRotation(0.5F, -3.0F, 1.5F, -0.9599F, 0.0F, 0.0F));

        PartDefinition spike31 = spikes7.addOrReplaceChild("spike31", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.5F));

        PartDefinition spike32 = spikes7.addOrReplaceChild("spike32", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1309F));

        PartDefinition spike33 = spikes7.addOrReplaceChild("spike33", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3491F));

        PartDefinition spike34 = spikes7.addOrReplaceChild("spike34", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1309F));

        PartDefinition spike35 = spikes7.addOrReplaceChild("spike35", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition spikes8 = torso.addOrReplaceChild("spikes8", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -3.0F, 3.0F, -1.0472F, 0.0F, 0.0F));

        PartDefinition spike36 = spikes8.addOrReplaceChild("spike36", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.1309F));

        PartDefinition spike37 = spikes8.addOrReplaceChild("spike37", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 0.0F, 0.0F));

        PartDefinition spike38 = spikes8.addOrReplaceChild("spike38", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3927F));

        PartDefinition spike39 = spikes8.addOrReplaceChild("spike39", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 0.0F, 0.0F));

        PartDefinition spike40 = spikes8.addOrReplaceChild("spike40", CubeListBuilder.create().texOffs(20, 0).addBox(0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.3054F));

        PartDefinition left_front_leg = body.addOrReplaceChild("left_front_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, -2.5F));

        PartDefinition right_front_leg = body.addOrReplaceChild("right_front_leg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, -2.5F));

        PartDefinition right_back_leg = body.addOrReplaceChild("right_back_leg", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-3.0F, 0.0F, 2.5F));

        PartDefinition left_back_leg = body.addOrReplaceChild("left_back_leg", CubeListBuilder.create().texOffs(0, 0).addBox(-1.0F, -1.0F, -1.0F, 2.0F, 5.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 0.0F, 2.5F));
        return LayerDefinition.create(modelData, 32, 32);
    }

    @Override
    public void setupAnim(PorcupineEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);
        this.setHeadAngles(entity, netHeadYaw, headPitch, ageInTicks);

        this.animateWalk(ModAnimations.PORCUPINE_WALK, limbSwing, limbSwingAmount, 2f, 2.5f);
        this.animate(entity.idleAnimationState, ModAnimations.PORCUPINE_IDLE, ageInTicks, 1f);
        this.animate(entity.attackAnimationState, ModAnimations.PORCUPINE_ATTACK, ageInTicks, 1f);
        this.animate(entity.sitAnimationState, ModAnimations.PORCUPINE_SIT, ageInTicks, 1f);
    }

    private void setHeadAngles(PorcupineEntity entity, float headYaw, float headPitch, float animationProgress) {
        headYaw = Mth.clamp(headYaw, -30.0F, 30.0F);
        headPitch = Mth.clamp(headPitch, -25.0F, 45.0F);

        this.head.yRot = headYaw * 0.017453292F;
        this.head.xRot = headPitch * 0.017453292F;
    }

    @Override
    public void renderToBuffer(PoseStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        porcupine.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
    }

    @Override
    public ModelPart root() {
        return porcupine;
    }
}
