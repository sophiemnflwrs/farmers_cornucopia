package net.sophiemnflwrs.farmerscornucopia.common.registry;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.block.TallWildCropBlock;
import net.sophiemnflwrs.farmerscornucopia.common.block.bush.BlueberryBush;
import net.sophiemnflwrs.farmerscornucopia.common.block.crop.specific.*;
import net.sophiemnflwrs.farmerscornucopia.common.block.shrub.LemonSeedling;
import net.sophiemnflwrs.farmerscornucopia.common.block.shrub.LemonShrub;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FCLeavesBlock;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FCLogBlock;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FCPlanksBlock;
import net.sophiemnflwrs.farmerscornucopia.common.block.tree.FruitingLeavesBlock;
import net.sophiemnflwrs.farmerscornucopia.common.world.feature.tree.OliveTreeGrower;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class FCBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FarmersCornucopia.MOD_ID);

    // crop crates
    public static final RegistryObject<Block> BLUEBERRY_CRATE = BLOCKS.register("blueberry_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHILI_PEPPER_CRATE = BLOCKS.register("chili_pepper_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GARLIC_CRATE = BLOCKS.register("garlic_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GINGER_CRATE = BLOCKS.register("ginger_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> LEMON_CRATE = BLOCKS.register("lemon_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> OLIVE_CRATE = BLOCKS.register("olive_crate",
            () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));

    // salt
    public static final RegistryObject<Block> SALT_BLOCK = BLOCKS.register("salt_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SALT_ORE = BLOCKS.register("salt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).sound(SoundType.STONE).requiresCorrectToolForDrops(), UniformInt.of(3,6)));
    public static final RegistryObject<Block> DEEPSLATE_SALT_ORE = BLOCKS.register("deepslate_salt_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f).sound(SoundType.STONE).requiresCorrectToolForDrops(), UniformInt.of(3,6)));

    // trees
    public static final RegistryObject<Block> OLIVE_LOG = BLOCKS.register("olive_log",
            () -> new FCLogBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_OLIVE_LOG = BLOCKS.register("stripped_olive_log",
            () -> new FCLogBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)));
    public static final RegistryObject<Block> OLIVE_LEAVES = BLOCKS.register("olive_leaves",
            () -> new FCLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> FRUITING_OLIVE_LEAVES = BLOCKS.register("fruiting_olive_leaves",
            () -> new FruitingLeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> OLIVE_PLANKS = BLOCKS.register("olive_planks",
            () -> new FCPlanksBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> OLIVE_SAPLING = BLOCKS.register("olive_sapling",
            () -> new SaplingBlock(new OliveTreeGrower(),  BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

    // shrubs
    public static final RegistryObject<Block> LEMON_SEEDLING = BLOCKS.register("lemon_seedling",
            () -> new LemonSeedling(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> LEMON_SHRUB = BLOCKS.register("lemon_shrub",
            () -> new LemonShrub(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.GRASS).noOcclusion()));

    // bush
    public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
            () -> new BlueberryBush(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.GRASS).noOcclusion()));

    // tall wild crops
    public static final RegistryObject<Block> WILD_CASSAVA = BLOCKS.register("wild_cassava",
            () -> new TallWildCropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().sound(SoundType.GRASS).noOcclusion()));

    // wild crops
    public static final RegistryObject<Block> WILD_CHILI_PEPPER = BLOCKS.register("wild_chili_pepper",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 10, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> POTTED_WILD_CHILI_PEPPER = BLOCKS.register("potted_wild_chili_pepper",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock)Blocks.FLOWER_POT), FCBlocks.WILD_CHILI_PEPPER, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<Block> WILD_GARLIC = BLOCKS.register("wild_garlic",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> POTTED_WILD_GARLIC = BLOCKS.register("potted_wild_garlic",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock)Blocks.FLOWER_POT), FCBlocks.WILD_GARLIC, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<Block> WILD_GINGER = BLOCKS.register("wild_ginger",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 10, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> POTTED_WILD_GINGER = BLOCKS.register("potted_wild_ginger",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock)Blocks.FLOWER_POT), FCBlocks.WILD_GINGER, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));

    // flowers
    public static final RegistryObject<Block> GINGER_LILY = BLOCKS.register("ginger_lily",
            () -> new FlowerBlock(MobEffects.MOVEMENT_SPEED, 2, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_GINGER_LILY = BLOCKS.register("potted_ginger_lily",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock)Blocks.FLOWER_POT), FCBlocks.GINGER_LILY, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));
    public static final RegistryObject<Block> VIOLET = BLOCKS.register("violet",
            () -> new FlowerBlock(MobEffects.REGENERATION, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> POTTED_VIOLET = BLOCKS.register("potted_violet",
            () -> new FlowerPotBlock(() -> ((FlowerPotBlock)Blocks.FLOWER_POT), FCBlocks.VIOLET, BlockBehaviour.Properties.copy(Blocks.FLOWER_POT)));

    // crops
    public static final RegistryObject<Block> BUDDING_CHILI_PEPPER_CROP = BLOCKS.register("budding_chili_pepper",
            () -> new BuddingChiliPepperCrop(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> CHILI_PEPPER_CROP = BLOCKS.register("chili_pepper_crop",
            () -> new ChiliPepperCrop(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCrop(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> GINGER_CROP = BLOCKS.register("ginger_crop",
            () -> new GingerCrop(Block.Properties.copy(Blocks.WHEAT)));

    // tall crops
    public static final RegistryObject<Block> CASSAVA_CROP = BLOCKS.register("cassava_crop",
            () -> new CassavaCrop(Block.Properties.copy(Blocks.WHEAT)));

    // vine crops
    public static final RegistryObject<Block> BUDDING_VANILLA_CROP = BLOCKS.register("budding_vanilla",
            () -> new BuddingVanillaCrop(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> VANILLA_CROP = BLOCKS.register("vanilla_crop",
            () -> new VanillaCrop(Block.Properties.copy(Blocks.WHEAT)));

    // register
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
