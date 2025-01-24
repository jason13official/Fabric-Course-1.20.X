package net.kaupenjoe.mccourse.util;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class ModModelPredicateProvider {
    public static void registerModModels() {
        ItemProperties.register(ModItems.DATA_TABLET, new ResourceLocation(MCCourseMod.MOD_ID, "on"),
                (stack, world, entity, seed) -> stack.hasTag() ? 1f : 0f);

        registerBow(ModItems.PINK_GARNET_BOW);

        ItemProperties.register(ModItems.PINK_GARNET_SHIELD, new ResourceLocation("blocking"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0f : 0.0f);
    }

    private static void registerBow(Item bow) {
        ItemProperties.register(bow, new ResourceLocation("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (entity.getUseItem() != stack) {
                return 0.0f;
            }
            return (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0f;
        });
        ItemProperties.register(bow, new ResourceLocation("pulling"),
                (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getUseItem() == stack ? 1.0f : 0.0f);

    }
}
