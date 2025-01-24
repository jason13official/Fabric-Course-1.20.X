package net.kaupenjoe.mccourse.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import java.util.function.Consumer;

public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementHolder> consumer) {
        AdvancementHolder rootAdvancement = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.PINK_GARNET),
                        Component.literal("MC Course"), Component.literal("The Power lies in the Pink Garnet!"),
                        new ResourceLocation(MCCourseMod.MOD_ID, "textures/block/pink_garnet_ore.png"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_pink_garnet", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.PINK_GARNET))
                .save(consumer, MCCourseMod.MOD_ID + ":mccourse");

        AdvancementHolder metalDetector = Advancement.Builder.advancement()
                .display(new DisplayInfo(new ItemStack(ModItems.METAL_DETECTOR),
                        Component.literal("Metal Detector"), Component.literal("Batteries not included! (Actually doesn't need batteries)"),
                        new ResourceLocation(MCCourseMod.MOD_ID, "block/pink_garnet_ore"), FrameType.TASK,
                        true, true, false))
                .addCriterion("has_used_metal_detector", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.METAL_DETECTOR))
                .parent(rootAdvancement)
                .save(consumer, MCCourseMod.MOD_ID + ":metal_detector");
    }
}
