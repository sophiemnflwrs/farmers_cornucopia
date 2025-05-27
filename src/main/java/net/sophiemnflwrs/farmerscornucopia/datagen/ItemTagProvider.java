package net.sophiemnflwrs.farmerscornucopia.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;
import net.sophiemnflwrs.farmerscornucopia.common.tag.FCForgeTags;
import net.sophiemnflwrs.farmerscornucopia.common.tag.FCTags;
import vectorwing.farmersdelight.common.registry.ModItems;

import javax.annotation.Nullable;
import java.util.concurrent.CompletableFuture;

public class ItemTagProvider extends ItemTagsProvider {

    public ItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, FarmersCornucopia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        copy(FCTags.WILD_CROPS, FCTags.WILD_CROPS_ITEM);
        copy(BlockTags.SMALL_FLOWERS, ItemTags.SMALL_FLOWERS);

        copy(FCTags.FRUITING_LEAVES, FCTags.FRUITING_LEAVES_ITEM);
        copy(BlockTags.LEAVES, ItemTags.LEAVES);

        this.registerForgeTags();
    }

    @SuppressWarnings("unchecked")
    private void registerForgeTags() {

        tag(FCForgeTags.SEEDS).addTags(
                FCForgeTags.SEEDS_BLUEBERRY,
                FCForgeTags.SEEDS_CASSAVA,
                FCForgeTags.SEEDS_CHILI_PEPPER,
                FCForgeTags.SEEDS_GARLIC,
                FCForgeTags.SEEDS_GINGER,
                FCForgeTags.SEEDS_LEMON);
        tag(FCForgeTags.SEEDS_BLUEBERRY).add(FCItems.BLUEBERRY_SEEDS.get());
        tag(FCForgeTags.SEEDS_CASSAVA).add(FCItems.CASSAVA.get());
        tag(FCForgeTags.SEEDS_CHILI_PEPPER).add(FCItems.CHILI_PEPPER_SEEDS.get());
        tag(FCForgeTags.SEEDS_LEMON).add(FCItems.LEMON_SEEDS.get());
        tag(FCForgeTags.SEEDS_GARLIC).add(FCItems.GARLIC_CLOVE.get());
        tag(FCForgeTags.SEEDS_GINGER).add(FCItems.GINGER_SEEDS.get());

        tag(FCForgeTags.CROPS).addTags(
                FCForgeTags.CROPS_BLUEBERRY,
                FCForgeTags.CROPS_CASSAVA,
                FCForgeTags.CROPS_CHILI_PEPPER,
                FCForgeTags.CROPS_GARLIC,
                FCForgeTags.CROPS_GINGER,
                FCForgeTags.CROPS_LEMON,
                FCForgeTags.CROPS_OLIVE);
        tag(FCForgeTags.CROPS_BLUEBERRY).add(FCItems.BLUEBERRY.get());
        tag(FCForgeTags.CROPS_CASSAVA).add(FCItems.CASSAVA.get());
        tag(FCForgeTags.CROPS_CHILI_PEPPER).add(FCItems.CHILI_PEPPER.get());
        tag(FCForgeTags.CROPS_GARLIC).add(FCItems.GARLIC.get());
        tag(FCForgeTags.CROPS_GINGER).add(FCItems.GINGER.get());
        tag(FCForgeTags.CROPS_LEMON).add(FCItems.LEMON.get());
        tag(FCForgeTags.CROPS_OLIVE).add(FCItems.OLIVE.get());

        tag(FCForgeTags.FLOWERS).addTags(
                FCForgeTags.FLOWERS_GINGER_LILY,
                FCForgeTags.FLOWERS_VIOLET);
        tag(FCForgeTags.FLOWERS_GINGER_LILY).add(FCItems.GINGER_LILY.get());
        tag(FCForgeTags.FLOWERS_VIOLET).add(FCItems.VIOLET.get());

        tag(FCForgeTags.FOODSTUFFS).addTags(
                FCForgeTags.FOODSTUFFS_SALT,
                FCForgeTags.FOODSTUFFS_OLIVE_OIL,
                FCForgeTags.FOODSTUFFS_CREAM,
                FCForgeTags.FOODSTUFFS_BUTTER,
                FCForgeTags.FOODSTUFFS_AIOLI);
        tag(FCForgeTags.FOODSTUFFS_SALT).add(FCItems.SALT.get());
        tag(FCForgeTags.FOODSTUFFS_OLIVE_OIL).add(FCItems.OLIVE_OIL.get());
        tag(FCForgeTags.FOODSTUFFS_CREAM).add(FCItems.CREAM.get());
        tag(FCForgeTags.FOODSTUFFS_BUTTER).add(FCItems.BUTTER.get());
        tag(FCForgeTags.FOODSTUFFS_AIOLI).add(FCItems.AIOLI.get());

        tag(FCForgeTags.PRESERVES).addTags(
                FCForgeTags.PRESERVES_BLUEBERRY_JAM,
                FCForgeTags.PRESERVES_LEMON_MARMALADE,
                FCForgeTags.PRESERVES_VIOLET_JELLY);
        tag(FCForgeTags.PRESERVES_BLUEBERRY_JAM).add(FCItems.BLUEBERRY_JAM.get());
        tag(FCForgeTags.PRESERVES_LEMON_MARMALADE).add(FCItems.LEMON_MARMALADE.get());
        tag(FCForgeTags.PRESERVES_VIOLET_JELLY).add(FCItems.VIOLET_JELLY.get());

        tag(FCForgeTags.VEGETABLES).addTags(
                FCForgeTags.VEGETABLES_CASSAVA,
                FCForgeTags.VEGETABLES_CHILI_PEPPER,
                FCForgeTags.VEGETABLES_GARLIC,
                FCForgeTags.VEGETABLES_GINGER);
        tag(FCForgeTags.VEGETABLES_CASSAVA).add(FCItems.CASSAVA.get());
        tag(FCForgeTags.VEGETABLES_CHILI_PEPPER).add(FCItems.CHILI_PEPPER.get());
        tag(FCForgeTags.VEGETABLES_GARLIC).add(FCItems.GARLIC.get());
        tag(FCForgeTags.VEGETABLES_GINGER).add(FCItems.GINGER.get());

        tag(FCForgeTags.FRUITS).addTags(
                FCForgeTags.FRUITS_BLUEBERRY,
                FCForgeTags.FRUITS_LEMON,
                FCForgeTags.FRUITS_OLIVE);
        tag(FCForgeTags.FRUITS_BLUEBERRY).add(FCItems.BLUEBERRY.get());
        tag(FCForgeTags.FRUITS_LEMON).add(FCItems.LEMON.get());
        tag(FCForgeTags.FRUITS_OLIVE).add(FCItems.OLIVE.get());

        tag(FCForgeTags.BREAD).addTag(
                FCForgeTags.BREAD_WHEAT);
        tag(FCForgeTags.BREAD_WHEAT).add(Items.BREAD);

        tag(FCForgeTags.DAIRY).addTags(
                FCForgeTags.DAIRY_MILK_BUCKET,
                FCForgeTags.DAIRY_MILK_BOTTLE,
                FCForgeTags.DAIRY_CREAM,
                FCForgeTags.DAIRY_BUTTER);
        tag(FCForgeTags.DAIRY_MILK_BUCKET).add(Items.MILK_BUCKET);
        tag(FCForgeTags.DAIRY_MILK_BOTTLE).add(ModItems.MILK_BOTTLE.get());
        tag(FCForgeTags.DAIRY_CREAM).add(FCItems.CREAM.get());
        tag(FCForgeTags.DAIRY_BUTTER).add(FCItems.BUTTER.get());

    }
}

