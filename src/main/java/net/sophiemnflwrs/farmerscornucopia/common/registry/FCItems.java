package net.sophiemnflwrs.farmerscornucopia.common.registry;

import com.google.common.collect.Sets;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.FoodValues;
import net.sophiemnflwrs.farmerscornucopia.common.item.DrinkableItem;
import net.sophiemnflwrs.farmerscornucopia.common.item.drinks.CreamItem;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

public class FCItems {

    // creative tab sorter
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, FarmersCornucopia.MOD_ID);
    public static LinkedHashSet<RegistryObject<Item>> CREATIVE_TAB_ITEMS = Sets.newLinkedHashSet();

    public static RegistryObject<Item> registerWithTab(final String name, final Supplier<Item> supplier) {
        RegistryObject<Item> block = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(block);
        return block;
    }

    // helper methods
    public static Item.Properties basicItem() {
        return new Item.Properties();
    }
    public static Item.Properties foodItem(FoodProperties food) {
        return new Item.Properties().food(food);
    }
    public static Item.Properties drinkItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16);
    }

    // crop crates
    public static final RegistryObject<Item> BLUEBERRY_CRATE = registerWithTab("blueberry_crate",
            () -> new BlockItem(FCBlocks.BLUEBERRY_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> CHILI_PEPPER_CRATE = registerWithTab("chili_pepper_crate",
            () -> new BlockItem(FCBlocks.CHILI_PEPPER_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> GARLIC_CRATE = registerWithTab("garlic_crate",
            () -> new BlockItem(FCBlocks.GARLIC_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> GINGER_CRATE = registerWithTab("ginger_crate",
            () -> new BlockItem(FCBlocks.GINGER_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> LEMON_CRATE = registerWithTab("lemon_crate",
            () -> new BlockItem(FCBlocks.LEMON_CRATE.get(), basicItem()));
    public static final RegistryObject<Item> OLIVE_CRATE = registerWithTab("olive_crate",
            () -> new BlockItem(FCBlocks.OLIVE_CRATE.get(), basicItem()));

    // salt blocks
    public static final RegistryObject<Item> SALT_BLOCK = registerWithTab("salt_block",
            () -> new BlockItem(FCBlocks.SALT_BLOCK.get(), basicItem()));
    public static final RegistryObject<Item> SALT_ORE = registerWithTab("salt_ore",
            () -> new BlockItem(FCBlocks.SALT_ORE.get(), basicItem()));
    public static final RegistryObject<Item> DEEPSLATE_SALT_ORE = registerWithTab("deepslate_salt_ore",
            () -> new BlockItem(FCBlocks.DEEPSLATE_SALT_ORE.get(), basicItem()));

    // trees
    public static final RegistryObject<Item> OLIVE_LOG = registerWithTab("olive_log",
            () -> new BlockItem(FCBlocks.OLIVE_LOG.get(), basicItem()));
    public static final RegistryObject<Item> STRIPPED_OLIVE_LOG = registerWithTab("stripped_olive_log",
            () -> new BlockItem(FCBlocks.STRIPPED_OLIVE_LOG.get(), basicItem()));
    public static final RegistryObject<Item> OLIVE_LEAVES = registerWithTab("olive_leaves",
            () -> new BlockItem(FCBlocks.OLIVE_LEAVES.get(), basicItem()));
    public static final RegistryObject<Item> FRUITING_OLIVE_LEAVES = registerWithTab("fruiting_olive_leaves",
            () -> new BlockItem(FCBlocks.FRUITING_OLIVE_LEAVES.get(), basicItem()));
    public static final RegistryObject<Item> OLIVE_PLANKS = registerWithTab("olive_planks",
            () -> new BlockItem(FCBlocks.OLIVE_PLANKS.get(), basicItem()));
    public static final RegistryObject<Item> OLIVE_SAPLING = registerWithTab("olive_sapling",
            () -> new BlockItem(FCBlocks.OLIVE_SAPLING.get(), basicItem()));

    // wild crops
    public static final RegistryObject<Item> WILD_CHILI_PEPPER = registerWithTab("wild_chili_pepper",
            () -> new BlockItem(FCBlocks.WILD_CHILI_PEPPER.get(), basicItem()));
    public static final RegistryObject<Item> WILD_GARLIC = registerWithTab("wild_garlic",
            () -> new BlockItem(FCBlocks.WILD_GARLIC.get(), basicItem()));
    public static final RegistryObject<Item> WILD_GINGER = registerWithTab("wild_ginger",
            () -> new BlockItem(FCBlocks.WILD_GINGER.get(), basicItem()));

    public static final RegistryObject<Item> WILD_CASSAVA = registerWithTab("wild_cassava",
            () -> new DoubleHighBlockItem(FCBlocks.WILD_CASSAVA.get(), basicItem()));

    // flowers
    public static final RegistryObject<Item> GINGER_LILY = registerWithTab("ginger_lily",
            () -> new BlockItem(FCBlocks.GINGER_LILY.get(), basicItem()));
    public static final RegistryObject<Item> VIOLET = registerWithTab("violet",
            () -> new BlockItem(FCBlocks.VIOLET.get(), basicItem()));

    // foodstuffs
    public static final RegistryObject<Item> SALT = registerWithTab("salt",
            () -> new Item(foodItem(FoodValues.SALT)));
    public static final RegistryObject<Item> CREAM = registerWithTab("cream",
            () -> new CreamItem(drinkItem(FoodValues.CREAM)));
    public static final RegistryObject<Item> BUTTER = registerWithTab("butter",
            () -> new Item(foodItem(FoodValues.BUTTER)));
    public static final RegistryObject<Item> OLIVE_OIL = registerWithTab("olive_oil",
            () -> new DrinkableItem(drinkItem(FoodValues.OLIVE_OIL)));
    public static final RegistryObject<Item> AIOLI = registerWithTab("aioli",
            () -> new Item(drinkItem(FoodValues.AIOLI)));

    // preserves
    public static final RegistryObject<Item> BLUEBERRY_JAM = registerWithTab("blueberry_jam",
            () -> new Item(foodItem(FoodValues.BLUEBERRY_JAM)));
    public static final RegistryObject<Item> LEMON_MARMALADE = registerWithTab("lemon_marmalade",
            () -> new Item(foodItem(FoodValues.LEMON_MARMALADE)));
    public static final RegistryObject<Item> VIOLET_JELLY = registerWithTab("violet_jelly",
            () -> new Item(foodItem(FoodValues.VIOLET_JELLY)));

    // crops
    public static final RegistryObject<Item> CHILI_PEPPER = registerWithTab("chili_pepper",
            () -> new Item(foodItem(FoodValues.CHILI_PEPPER)));
    public static final RegistryObject<Item> GARLIC = registerWithTab("garlic",
            () -> new Item(foodItem(FoodValues.GARLIC)));
    public static final RegistryObject<Item> GINGER = registerWithTab("ginger",
            () -> new Item(foodItem(FoodValues.GINGER)));

    public static final RegistryObject<Item> CASSAVA = registerWithTab("cassava",
            () -> new ItemNameBlockItem(FCBlocks.CASSAVA_CROP.get(), foodItem(FoodValues.CASSAVA)));

    public static final RegistryObject<Item> BLUEBERRY = registerWithTab("blueberry",
            () -> new Item(foodItem(FoodValues.BLUEBERRY)));

    public static final RegistryObject<Item> LEMON = registerWithTab("lemon",
            () -> new Item(foodItem(FoodValues.LEMON)));

    public static final RegistryObject<Item> OLIVE = registerWithTab("olive",
            () -> new Item(foodItem(FoodValues.OLIVE)));

    // seeds
    public static final RegistryObject<Item> BLUEBERRY_SEEDS = registerWithTab("blueberry_seeds",
            () -> new ItemNameBlockItem(FCBlocks.BLUEBERRY_BUSH.get(), basicItem()));
    public static final RegistryObject<Item> CHILI_PEPPER_SEEDS = registerWithTab("chili_pepper_seeds",
            () -> new ItemNameBlockItem(FCBlocks.BUDDING_CHILI_PEPPER_CROP.get(), basicItem()));
    public static final RegistryObject<Item> LEMON_SEEDS = registerWithTab("lemon_seeds",
            () -> new ItemNameBlockItem(FCBlocks.LEMON_SEEDLING.get(), basicItem()));
    public static final RegistryObject<Item> GARLIC_CLOVE = registerWithTab("garlic_clove",
            () -> new ItemNameBlockItem(FCBlocks.GARLIC_CROP.get(), foodItem(FoodValues.GARLIC_CLOVE)));
    public static final RegistryObject<Item> GINGER_SEEDS = registerWithTab("ginger_seeds",
            () -> new ItemNameBlockItem(FCBlocks.GINGER_CROP.get(), basicItem()));
    public static final RegistryObject<Item> VANILLA_POD = registerWithTab("vanilla_pod",
            () -> new ItemNameBlockItem(FCBlocks.VANILLA_CROP.get(), basicItem()));

    // drinks
    public static final RegistryObject<Item> LEMONADE = registerWithTab("lemonade",
            () -> new DrinkableItem(drinkItem(FoodValues.LEMONADE)));

    // meals + food items
    public static final RegistryObject<Item> GARLIC_BREAD = registerWithTab("garlic_bread",
            () -> new Item(foodItem(FoodValues.GARLIC_BREAD)));
    public static final RegistryObject<Item> BLUEBERRY_MUFFIN = registerWithTab("blueberry_muffin",
            () -> new Item(foodItem(FoodValues.BLUEBERRY_MUFFIN)));
    public static final RegistryObject<Item> MASHED_POTATOES = registerWithTab("mashed_potatoes",
            () -> new Item(foodItem(FoodValues.MASHED_POTATOES)));
    public static final RegistryObject<Item> PATATAS_BRAVAS = registerWithTab("patatas_bravas",
            () -> new Item(foodItem(FoodValues.PATATAS_BRAVAS)));
    public static final RegistryObject<Item> GARLIC_SALMON_PASTA = registerWithTab("garlic_salmon_pasta",
            () -> new Item(foodItem(FoodValues.GARLIC_SALMON_PASTA)));

    // register
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
