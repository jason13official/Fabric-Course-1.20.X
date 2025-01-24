package net.kaupenjoe.mccourse.entity;

import com.terraformersmc.terraform.boat.api.TerraformBoatType;
import com.terraformersmc.terraform.boat.api.TerraformBoatTypeRegistry;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.block.ModBlocks;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

public class ModBoats {
    public static final ResourceLocation DRIFTWOOD_BOAT_ID = new ResourceLocation(MCCourseMod.MOD_ID, "driftwood_boat");
    public static final ResourceLocation DRIFTWOOD_CHEST_BOAT_ID = new ResourceLocation(MCCourseMod.MOD_ID, "driftwood_chest_boat");

    public static final ResourceKey<TerraformBoatType> DRIFTWOOD_BOAT_KEY = TerraformBoatTypeRegistry.createKey(DRIFTWOOD_BOAT_ID);

    public static void registerBoats() {
        TerraformBoatType driftwoodBoat = new TerraformBoatType.Builder()
                .item(ModItems.DRIFTWOOD_BOAT)
                .chestItem(ModItems.DRIFTWOOD_CHEST_BOAT)
                .planks(ModBlocks.DRIFTWOOD_PLANKS.asItem())
                .build();

        Registry.register(TerraformBoatTypeRegistry.INSTANCE, DRIFTWOOD_BOAT_KEY, driftwoodBoat);
    }
}
