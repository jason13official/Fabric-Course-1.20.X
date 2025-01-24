package net.kaupenjoe.mccourse.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingRecipeCodecs;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import java.util.List;

public class GemEmpoweringRecipe implements Recipe<SimpleContainer> {
    private final ItemStack output;
    private final List<Ingredient> recipeItems;
    private final int craftTime;
    private final int energyAmount;

    public GemEmpoweringRecipe(List<Ingredient> recipeItems, ItemStack output, int craftTime, int energyAmount) {
        this.output = output;
        this.recipeItems = recipeItems;
        this.craftTime = craftTime;
        this.energyAmount = energyAmount;
    }

    @Override
    public boolean matches(SimpleContainer inventory, Level world) {
        if(world.isClientSide()) {
            return false;
        }

        return recipeItems.get(0).test(inventory.getItem(0));
    }

    @Override
    public ItemStack assemble(SimpleContainer inventory, RegistryAccess registryManager) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryManager) {
        return output;
    }

    public int getCraftTime() {
        return craftTime;
    }

    public int getEnergyAmount() {
        return energyAmount;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList list = NonNullList.createWithCapacity(this.recipeItems.size());
        list.addAll(recipeItems);
        return list;
    }

    public static class Type implements RecipeType<GemEmpoweringRecipe> {
        private Type() { }
        public static final Type INSTANCE = new Type();
        public static final String ID = "gem_empowering";
    }

    public static class Serializer implements RecipeSerializer<GemEmpoweringRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "gem_empowering";
        // this is the name given in the json file

        public static final Codec<GemEmpoweringRecipe> CODEC = RecordCodecBuilder.create(in -> in.group(
                validateAmount(Ingredient.CODEC_NONEMPTY, 9).fieldOf("ingredients").forGetter(GemEmpoweringRecipe::getIngredients),
                CraftingRecipeCodecs.ITEMSTACK_OBJECT_CODEC.fieldOf("output").forGetter(r -> r.output),
                ExtraCodecs.POSITIVE_INT.fieldOf("craftTime").forGetter(r -> r.craftTime),
                ExtraCodecs.POSITIVE_INT.fieldOf("energyAmount").forGetter(r -> r.energyAmount)
        ).apply(in, GemEmpoweringRecipe::new));

        private static Codec<List<Ingredient>> validateAmount(Codec<Ingredient> delegate, int max) {
            return ExtraCodecs.validate(ExtraCodecs.validate(
                    delegate.listOf(), list -> list.size() > max ? DataResult.error(() -> "Recipe has too many ingredients!") : DataResult.success(list)
            ), list -> list.isEmpty() ? DataResult.error(() -> "Recipe has no ingredients!") : DataResult.success(list));
        }

        @Override
        public Codec<GemEmpoweringRecipe> codec() {
            return CODEC;
        }

        @Override
        public GemEmpoweringRecipe fromNetwork(FriendlyByteBuf buf) {
            NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);

            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buf));
            }

            int craftTime = buf.readInt();
            int energyAmount = buf.readInt();
            ItemStack output = buf.readItem();
            return new GemEmpoweringRecipe(inputs, output, craftTime, energyAmount);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buf, GemEmpoweringRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buf);
            }
            buf.writeInt(recipe.craftTime);
            buf.writeInt(recipe.energyAmount);
            buf.writeItem(recipe.getResultItem(null));
        }
    }
}
