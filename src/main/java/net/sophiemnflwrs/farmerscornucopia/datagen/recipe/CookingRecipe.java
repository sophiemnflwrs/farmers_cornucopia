package net.sophiemnflwrs.farmerscornucopia.datagen.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;
import net.sophiemnflwrs.farmerscornucopia.common.tag.FCForgeTags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.function.Consumer;

public class CookingRecipe {
    public static final int FAST_COOKING = 100;      // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;      // 20 seconds

    public static final float SMALL_EXP = 0.35F;
    public static final float MEDIUM_EXP = 1.0F;
    public static final float LARGE_EXP = 2.0F;

    public static void register(Consumer<FinishedRecipe> consumer) {
        cookMeals(consumer);
        cookMiscellaneous(consumer);
    }

    private static void cookMeals(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(FCItems.GARLIC_SALMON_PASTA.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(FCForgeTags.CROPS_GARLIC)
                .addIngredient(FCForgeTags.DAIRY_CREAM)
                .addIngredient(ForgeTags.RAW_FISHES_SALMON)
                .addIngredient(ForgeTags.PASTA)
                .unlockedByAnyIngredient(ModItems.RAW_PASTA.get(), Items.SALMON, FCItems.CREAM.get(), FCItems.GARLIC.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(FCItems.PATATAS_BRAVAS.get(), 1, NORMAL_COOKING, SMALL_EXP, Items.BOWL)
                .addIngredient(Items.POTATO)
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .addIngredient(FCForgeTags.CROPS_CHILI_PEPPER)
                .addIngredient(FCForgeTags.FOODSTUFFS_AIOLI)
                .unlockedByAnyIngredient(Items.POTATO, ModItems.TOMATO.get(), FCItems.CHILI_PEPPER.get(), FCItems.AIOLI.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);
        CookingPotRecipeBuilder.cookingPotRecipe(FCItems.MASHED_POTATOES.get(), 1, NORMAL_COOKING, SMALL_EXP, Items.BOWL)
                .addIngredient(Items.POTATO)
                .addIngredient(FCForgeTags.CROPS_GARLIC)
                .addIngredient(FCForgeTags.DAIRY_CREAM)
                .addIngredient(FCForgeTags.DAIRY_BUTTER)
                .addIngredient(FCForgeTags.FOODSTUFFS_SALT)
                .unlockedByAnyIngredient(Items.POTATO, FCItems.GARLIC.get(), FCItems.CREAM.get(), FCItems.BUTTER.get(), FCItems.SALT.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);
    }

    private static void cookMiscellaneous(Consumer<FinishedRecipe> consumer) {

    }


}
