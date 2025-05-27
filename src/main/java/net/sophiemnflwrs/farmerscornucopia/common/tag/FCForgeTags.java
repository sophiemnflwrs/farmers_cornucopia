package net.sophiemnflwrs.farmerscornucopia.common.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class FCForgeTags {

    // registry
    private static TagKey<Block> forgeBlockTag(String path) {
        return BlockTags.create(new ResourceLocation("forge", path));
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return ItemTags.create(new ResourceLocation("forge", path));
    }

    // seeds
    public static final TagKey<Item> SEEDS = forgeItemTag("seeds");
    public static final TagKey<Item> SEEDS_BLUEBERRY = forgeItemTag("seeds/blueberry");
    public static final TagKey<Item> SEEDS_CASSAVA = forgeItemTag("seeds/cassava");
    public static final TagKey<Item> SEEDS_CHILI_PEPPER = forgeItemTag("seeds/chili_pepper");
    public static final TagKey<Item> SEEDS_GARLIC = forgeItemTag("seeds/garlic");
    public static final TagKey<Item> SEEDS_GINGER = forgeItemTag("seeds/ginger");
    public static final TagKey<Item> SEEDS_LEMON = forgeItemTag("seeds/lemon");

    // crops
    public static final TagKey<Item> CROPS = forgeItemTag("crops");
    public static final TagKey<Item> CROPS_BLUEBERRY = forgeItemTag("crops/blueberry");
    public static final TagKey<Item> CROPS_CASSAVA = forgeItemTag("crops/cassava");
    public static final TagKey<Item> CROPS_CHILI_PEPPER = forgeItemTag("crops/chili_pepper");
    public static final TagKey<Item> CROPS_GARLIC = forgeItemTag("crops/garlic");
    public static final TagKey<Item> CROPS_GINGER = forgeItemTag("crops/ginger");
    public static final TagKey<Item> CROPS_LEMON = forgeItemTag("crops/lemon");
    public static final TagKey<Item> CROPS_OLIVE = forgeItemTag("crops/olive");

    // flowers
    public static final TagKey<Item> FLOWERS = forgeItemTag("flowers");
    public static final TagKey<Item> FLOWERS_GINGER_LILY = forgeItemTag("flowers/ginger_lily");
    public static final TagKey<Item> FLOWERS_VIOLET = forgeItemTag("flowers/violet");

    // foodstuffs
    public static final TagKey<Item> FOODSTUFFS = forgeItemTag("foodstuffs");
    public static final TagKey<Item> FOODSTUFFS_SALT = forgeItemTag("foodstuffs/salt");
    public static final TagKey<Item> FOODSTUFFS_OLIVE_OIL = forgeItemTag("foodstuffs/olive_oil");
    public static final TagKey<Item> FOODSTUFFS_CREAM = forgeItemTag("foodstuffs/cream");
    public static final TagKey<Item> FOODSTUFFS_BUTTER = forgeItemTag("foodstuffs/butter");
    public static final TagKey<Item> FOODSTUFFS_AIOLI = forgeItemTag("foodstuffs/aioli");

    // preserves
    public static final TagKey<Item> PRESERVES = forgeItemTag("preserves");
    public static final TagKey<Item> PRESERVES_VIOLET_JELLY = forgeItemTag("preserves/violet_jelly");
    public static final TagKey<Item> PRESERVES_BLUEBERRY_JAM = forgeItemTag("preserves/blueberry_jam");
    public static final TagKey<Item> PRESERVES_LEMON_MARMALADE = forgeItemTag("preserves/lemon_marmalade");

    // crop type
    public static final TagKey<Item> VEGETABLES = forgeItemTag("vegetables");
    public static final TagKey<Item> VEGETABLES_CASSAVA = forgeItemTag("vegetables/cassava");
    public static final TagKey<Item> VEGETABLES_CHILI_PEPPER = forgeItemTag("vegetables/chili_pepper");
    public static final TagKey<Item> VEGETABLES_GARLIC = forgeItemTag("vegetables/garlic");
    public static final TagKey<Item> VEGETABLES_GINGER = forgeItemTag("vegetables/ginger");

    public static final TagKey<Item> FRUITS = forgeItemTag("fruits");
    public static final TagKey<Item> FRUITS_LEMON = forgeItemTag("fruits/lemon");
    public static final TagKey<Item> FRUITS_BLUEBERRY = forgeItemTag("fruits/blueberry");
    public static final TagKey<Item> FRUITS_OLIVE = forgeItemTag("fruits/olive");

    // ingredient categorization
    public static final TagKey<Item> BREAD = forgeItemTag("bread");
    public static final TagKey<Item> BREAD_WHEAT = forgeItemTag("bread/wheat");

    public static final TagKey<Item> DAIRY = forgeItemTag("dairy");
    public static final TagKey<Item> DAIRY_MILK_BUCKET = forgeItemTag("dairy/milk");
    public static final TagKey<Item> DAIRY_MILK_BOTTLE = forgeItemTag("dairy/milk_bottle");
    public static final TagKey<Item> DAIRY_CREAM = forgeItemTag("dairy/cream");
    public static final TagKey<Item> DAIRY_BUTTER = forgeItemTag("dairy/butter");

}
