package net.sophiemnflwrs.farmerscornucopia.datagen.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.crafting.StrictNBTIngredient;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.registry.ModRecipeSerializers;

import java.util.function.Consumer;

public class CraftingRecipe {
    public static void register(Consumer<FinishedRecipe> consumer) {
        craftBlocks(consumer);
        craftMaterials(consumer);
        craftFoodstuffs(consumer);
        craftDrinks(consumer);
        craftMeals(consumer);
        craftFoodBlocks(consumer);
        SpecialRecipeBuilder.special(ModRecipeSerializers.FOOD_SERVING.get()).save(consumer, "food_serving");
    }

    private static void craftBlocks(Consumer<FinishedRecipe> consumer) {

        // crop crates
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FCItems.GARLIC_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', FCItems.GARLIC.get())
                .unlockedBy("has_garlic", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GARLIC.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FCItems.GINGER_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', FCItems.GINGER.get())
                .unlockedBy("has_ginger", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GINGER.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FCItems.OLIVE_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', FCItems.OLIVE.get())
                .unlockedBy("has_olive", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.OLIVE.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FCItems.LEMON_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', FCItems.LEMON.get())
                .unlockedBy("has_lemon", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.LEMON.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FCItems.BLUEBERRY_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', FCItems.BLUEBERRY.get())
                .unlockedBy("has_blueberry", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.BLUEBERRY.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, FCItems.CHILI_PEPPER_CRATE.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', FCItems.CHILI_PEPPER.get())
                .unlockedBy("has_chili_pepper", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.CHILI_PEPPER.get()))
                .save(consumer);

    }

    private static void craftMaterials(Consumer<FinishedRecipe> consumer) {

        // crops from crates
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.GARLIC.get(), 9)
                .requires(FCItems.GARLIC_CRATE.get())
                .unlockedBy("has_garlic_crate", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GARLIC_CRATE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "garlic_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.GINGER.get(), 9)
                .requires(FCItems.GINGER_CRATE.get())
                .unlockedBy("has_ginger_crate", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GINGER_CRATE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "ginger_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.OLIVE.get(), 9)
                .requires(FCItems.OLIVE_CRATE.get())
                .unlockedBy("has_olive_crate", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.OLIVE_CRATE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "olive_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.LEMON.get(), 9)
                .requires(FCItems.LEMON_CRATE.get())
                .unlockedBy("has_lemon_crate", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.LEMON_CRATE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "lemon_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.BLUEBERRY.get(), 9)
                .requires(FCItems.BLUEBERRY_CRATE.get())
                .unlockedBy("has_blueberry_crate", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.BLUEBERRY_CRATE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "blueberry_from_crate"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.CHILI_PEPPER.get(), 9)
                .requires(FCItems.CHILI_PEPPER_CRATE.get())
                .unlockedBy("has_chili_pepper_crate", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.CHILI_PEPPER_CRATE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "chili_pepper_from_crate"));

    }

    private static void craftFoodstuffs(Consumer<FinishedRecipe> consumer) {

        // gen foodstuffs
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.CREAM.get(), 2)
                .requires(Items.MILK_BUCKET)
                .requires(Items.GLASS_BOTTLE)
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_milk_bucket", InventoryChangeTrigger.TriggerInstance.hasItems(Items.MILK_BUCKET))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "cream_from_bucket"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.CREAM.get(), 1)
                .requires(ModItems.MILK_BOTTLE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_milk_bottle", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.MILK_BOTTLE.get()))
                .save(consumer, new ResourceLocation(FarmersCornucopia.MOD_ID, "cream_from_bottle"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.BUTTER.get(), 1)
                .requires(FCItems.CREAM.get())
                .requires(FCItems.CREAM.get())
                .requires(FCItems.CREAM.get())
                .requires(FCItems.CREAM.get())
                .requires(FCItems.SALT.get())
                .unlockedBy("has_cream", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.CREAM.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.OLIVE_OIL.get(), 1)
                .requires(FCItems.OLIVE.get())
                .requires(FCItems.OLIVE.get())
                .requires(FCItems.OLIVE.get())
                .requires(FCItems.OLIVE.get())
                .requires(Items.GLASS_BOTTLE)
                .unlockedBy("has_olive", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.OLIVE.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.AIOLI.get(), 1)
                .requires(Items.EGG)
                .requires(FCItems.OLIVE_OIL.get())
                .requires(FCItems.GARLIC.get())
                .requires(FCItems.LEMON.get())
                .requires(FCItems.SALT.get())
                .unlockedBy("has_olive_oil", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.OLIVE_OIL.get()))
                .save(consumer);

        // preserves
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FCItems.VIOLET_JELLY.get(), 1)
                .pattern(" g ")
                .pattern("swl")
                .pattern("vvv")
                .define('v', FCItems.VIOLET.get())
                .define('s', Items.SUGAR)
                .define('w', Items.WATER_BUCKET)
                .define('l', FCItems.LEMON.get())
                .define('g', Items.GLASS_BOTTLE)
                .unlockedBy("has_violet", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.VIOLET.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FCItems.BLUEBERRY_JAM.get(), 1)
                .pattern(" g ")
                .pattern("swl")
                .pattern("bbb")
                .define('b', FCItems.BLUEBERRY.get())
                .define('s', Items.SUGAR)
                .define('w', Items.WATER_BUCKET)
                .define('l', FCItems.LEMON.get())
                .define('g', Items.GLASS_BOTTLE)
                .unlockedBy("has_blueberry", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.BLUEBERRY_JAM.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FCItems.LEMON_MARMALADE.get(), 1)
                .pattern(" g ")
                .pattern("swl")
                .pattern("lll")
                .define('l', FCItems.LEMON.get())
                .define('s', Items.SUGAR)
                .define('w', Items.WATER_BUCKET)
                .define('g', Items.GLASS_BOTTLE)
                .unlockedBy("has_lemon", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.LEMON.get()))
                .save(consumer);

    }

    private static void craftDrinks(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.LEMONADE.get(), 3)
                .requires(StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)))
                .requires(StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)))
                .requires(StrictNBTIngredient.of(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER)))
                .requires(Items.SUGAR)
                .requires(FCItems.LEMON.get())
                .unlockedBy("has_lemon", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.LEMON.get()))
                .save(consumer);

    }

    private static void craftMeals(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, FCItems.GARLIC_BREAD.get(), 2)
                .requires(Items.BREAD)
                .requires(FCItems.GARLIC.get())
                .requires(FCItems.BUTTER.get())
                .unlockedBy("has_garlic", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.GARLIC.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, FCItems.BLUEBERRY_MUFFIN.get(), 1)
                .pattern("b1b")
                .pattern("esw")
                .define('e', Items.EGG)
                .define('s',Items.SUGAR)
                .define('w', Items.WHEAT)
                .define('b', FCItems.BLUEBERRY.get())
                .define('1', FCItems.BUTTER.get())
                .unlockedBy("has_blueberry", InventoryChangeTrigger.TriggerInstance.hasItems(FCItems.BLUEBERRY.get()))
                .save(consumer);

    }

    private static void craftFoodBlocks(Consumer<FinishedRecipe> consumer) {

    }
}
