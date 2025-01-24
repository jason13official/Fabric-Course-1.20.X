package net.kaupenjoe.mccourse.recipe;

import net.kaupenjoe.mccourse.MCCourseMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(MCCourseMod.MOD_ID, GemEmpoweringRecipe.Serializer.ID),
                GemEmpoweringRecipe.Serializer.INSTANCE);
        Registry.register(BuiltInRegistries.RECIPE_TYPE, new ResourceLocation(MCCourseMod.MOD_ID, GemEmpoweringRecipe.Type.ID),
                GemEmpoweringRecipe.Type.INSTANCE);

        Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, new ResourceLocation(MCCourseMod.MOD_ID, "kaupen_furnace"),
                KaupenFurnaceRecipe.Serializer.INSTANCE);
        Registry.register(BuiltInRegistries.RECIPE_TYPE, new ResourceLocation(MCCourseMod.MOD_ID, "kaupen_furnace"),
                KaupenFurnaceRecipe.Type.INSTANCE);

    }
}
