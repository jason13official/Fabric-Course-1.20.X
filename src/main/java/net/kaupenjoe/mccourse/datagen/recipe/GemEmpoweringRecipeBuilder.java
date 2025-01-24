package net.kaupenjoe.mccourse.datagen.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.kaupenjoe.mccourse.MCCourseMod;
import net.kaupenjoe.mccourse.recipe.GemEmpoweringRecipe;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.Criterion;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class GemEmpoweringRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Ingredient ingredient;
    private final int count;
    private final int craftTime;
    private final int energyAmount;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    public GemEmpoweringRecipeBuilder(ItemLike ingredient, ItemLike result, int count, int craftTime, int energyAmount) {
        this.ingredient = Ingredient.of(ingredient);
        this.result = result.asItem();
        this.count = count;
        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> conditions) {
        this.advancement.addCriterion(name, conditions);
        return this;
    }

    @Override
    public RecipeBuilder group(@Nullable String group) {
        return this;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(RecipeOutput exporter, ResourceLocation recipeId) {
        // this.advancement.parent(new Identifier("recipes/root"))
        //         .criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId))
        //         .rewards(AdvancementRewards.Builder.recipe(recipeId));

        exporter.accept(new JsonBuilder(recipeId, this.result, this.count, this.ingredient,
                this.advancement, new ResourceLocation(recipeId.getNamespace(), "recipes/"
                + recipeId.getPath()), this.craftTime, this.energyAmount));
    }

    public static class JsonBuilder implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final Ingredient ingredient;
        private final int count;
        private final int craftTime;
        private final int energyAmount;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public JsonBuilder(ResourceLocation id, Item result, int count, Ingredient ingredient,
                           Advancement.Builder advancement, ResourceLocation advancementId, int craftTime, int energyAmount) {
            this.id = id;
            this.result = result;
            this.ingredient = ingredient;
            this.count = count;
            this.advancement = advancement;
            this.advancementId = advancementId;
            this.craftTime = craftTime;
            this.energyAmount = energyAmount;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray jsonarray = new JsonArray();
            jsonarray.add(ingredient.toJson(true));

            json.add("ingredients", jsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", BuiltInRegistries.ITEM.getKey(this.result).toString());
            if (this.count > 1) {
                jsonobject.addProperty("count", this.count);
            }

            json.addProperty("craftTime", this.craftTime);
            json.addProperty("energyAmount", this.energyAmount);
            json.add("output", jsonobject);
        }

        @Override
        public ResourceLocation id() {
            return new ResourceLocation(MCCourseMod.MOD_ID,
                    BuiltInRegistries.ITEM.getKey(this.result).getPath() + "_from_gem_empowering");
        }

        @Override
        public RecipeSerializer<?> type() {
            return GemEmpoweringRecipe.Serializer.INSTANCE;
        }

        @Nullable
        @Override
        public AdvancementHolder advancement() {
            return new AdvancementHolder(id(), advancement.build(id()).value());
        }
    }
}
