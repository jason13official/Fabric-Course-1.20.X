package net.kaupenjoe.mccourse.entity.animations;

import net.minecraft.client.animation.AnimationChannel;
import net.minecraft.client.animation.AnimationDefinition;
import net.minecraft.client.animation.Keyframe;
import net.minecraft.client.animation.KeyframeAnimations;

public class ModAnimations {
    public static final AnimationDefinition PORCUPINE_IDLE = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("torso",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.posVec(0f, 0.35f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.875f, KeyframeAnimations.posVec(0f, 0.4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0.4f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0.35f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("torso",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("skull",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, KeyframeAnimations.posVec(0f, 0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0.2f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.9583433f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("skull",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5f, KeyframeAnimations.degreeVec(2f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(2f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(-2f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.degreeVec(-2f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.7083434f, KeyframeAnimations.posVec(0f, 0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9167666f, KeyframeAnimations.posVec(0f, 0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.7916767f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.7916767f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2916767f, KeyframeAnimations.posVec(0f, 0.1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.9167667f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
    public static final AnimationDefinition PORCUPINE_WALK = AnimationDefinition.Builder.withLength(2.5f).looping()
            .addAnimation("torso",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, KeyframeAnimations.posVec(0f, 0f, -0.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.9583434f, KeyframeAnimations.posVec(0f, 0f, -0.05f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, 0f, 0.05f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.125f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0834333f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.625f, KeyframeAnimations.degreeVec(-11f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0834335f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0.20834334f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.5416766f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0834333f, KeyframeAnimations.degreeVec(-11f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.2916767f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(1f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.3433333f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875f, KeyframeAnimations.degreeVec(-11f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.2916765f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.5f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.3433333f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.875f, KeyframeAnimations.degreeVec(-11f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5834333f, KeyframeAnimations.degreeVec(-7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2.0834335f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition PORCUPINE_ATTACK = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("torso",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.6766666f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.posVec(0f, 0.5f, -1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0.5f, -1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5416767f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("torso",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5416767f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6766667f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("skull",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5416767f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("skull",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4167667f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5416767f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.6766667f, KeyframeAnimations.degreeVec(15f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.875f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("hair",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1.25f, 1.25f, 1.25f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.scaleVec(1.25f, 1.25f, 1.25f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("spikes",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("spikes2",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1.25f, 1.25f, 1.25f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.scaleVec(1.25f, 1.25f, 1.25f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("spikes3",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("spikes4",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("spikes5",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("spikes6",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("spikes7",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("spikes8",
                    new AnimationChannel(AnimationChannel.Targets.SCALE,
                            new Keyframe(1f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.0416767f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.scaleVec(1.15f, 1.15f, 1.15f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.scaleVec(1f, 1f, 1f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -0.25f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(7.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.25f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.5f, KeyframeAnimations.degreeVec(10f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.75f, KeyframeAnimations.degreeVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();

    public static final AnimationDefinition PORCUPINE_SIT = AnimationDefinition.Builder.withLength(2f).looping()
            .addAnimation("porcupine",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("torso",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -0.3f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(0.4583433f, KeyframeAnimations.posVec(0f, 0.3f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.125f, KeyframeAnimations.posVec(0f, 0.5f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.7916767f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, -0.3f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("torso",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(-15f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("skull",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(17.5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0.25f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_front_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1f, KeyframeAnimations.posVec(0f, 0.25f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -0.75f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(2f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("right_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.POSITION,
                            new Keyframe(0f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.25f, KeyframeAnimations.posVec(0f, -0.75f, 0f),
                                    AnimationChannel.Interpolations.LINEAR),
                            new Keyframe(1.9583433f, KeyframeAnimations.posVec(0f, -1f, 0f),
                                    AnimationChannel.Interpolations.LINEAR)))
            .addAnimation("left_back_leg",
                    new AnimationChannel(AnimationChannel.Targets.ROTATION,
                            new Keyframe(0f, KeyframeAnimations.degreeVec(5f, 0f, 0f),
                                    AnimationChannel.Interpolations.LINEAR))).build();
}
