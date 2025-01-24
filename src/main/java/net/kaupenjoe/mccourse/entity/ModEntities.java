package net.kaupenjoe.mccourse.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.entity.custom.DiceProjectileEntity;
import net.kaupenjoe.mccourse.entity.custom.MagicProjectileEntity;
import net.kaupenjoe.mccourse.entity.custom.PorcupineEntity;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    public static final EntityType<PorcupineEntity> PORCUPINE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation(MCCourseMod.MOD_ID, "porcupine"),
            FabricEntityTypeBuilder.create(MobCategory.CREATURE, PorcupineEntity::new)
                    .dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build());


    public static final EntityType<DiceProjectileEntity> THROWN_DICE_PROJECTILE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation(MCCourseMod.MOD_ID, "dice_projectile"),
            FabricEntityTypeBuilder.<DiceProjectileEntity>create(MobCategory.MISC, DiceProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f, 0.25f)).build());

    public static final EntityType<MagicProjectileEntity> MAGIC_PROJECTILE = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            new ResourceLocation(MCCourseMod.MOD_ID, "magic_projectile"),
            FabricEntityTypeBuilder.<MagicProjectileEntity>create(MobCategory.MISC, MagicProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());



    public static void registerModEntities() {
        MCCourseMod.LOGGER.info("Registering Mod Entities for " + MCCourseMod.MOD_ID);
    }
}
