package net.sophiemnflwrs.farmerscornucopia.common.tag;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;

public class FCTags {


    public static final TagKey<Block> WILD_CROPS = modBlockTag("wild_crops");
    public static final TagKey<Item> WILD_CROPS_ITEM = modItemTag("wild_crops");

    public static final TagKey<Block> FRUITING_SHRUB = modBlockTag("fruiting_shrub");

    public static final TagKey<Block> FRUITING_BUSH = modBlockTag("fruiting_bush");

    public static final TagKey<Block> FRUITING_LEAVES = modBlockTag("fruiting_leaves");
    public static final TagKey<Item> FRUITING_LEAVES_ITEM = modItemTag("fruiting_leaves");

    public static final TagKey<EntityType<?>> CORROSION_IMMUNE = modEntityTag("corrosion_immune");


    // register
    private static TagKey<Item> modItemTag(String path) {
        return ItemTags.create(new ResourceLocation(FarmersCornucopia.MOD_ID, path));
    }
    private static TagKey<Block> modBlockTag(String path) {
        return BlockTags.create(new ResourceLocation(FarmersCornucopia.MOD_ID, path));
    }
    private static TagKey<EntityType<?>> modEntityTag(String path) {
        return TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(FarmersCornucopia.MOD_ID, path));
    }
}
