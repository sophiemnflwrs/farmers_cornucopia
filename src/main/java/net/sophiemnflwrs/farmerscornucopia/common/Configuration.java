package net.sophiemnflwrs.farmerscornucopia.common;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class Configuration {

    public static ForgeConfigSpec COMMON_CONFIG;
    public static ForgeConfigSpec CLIENT_CONFIG;

    public static final String CATEGORY_WORLD = "world";

    public static ForgeConfigSpec.BooleanValue GENERATE_OLIVE_TREE;
    public static ForgeConfigSpec.IntValue CHANCE_OLIVE_TREE;

    public static ForgeConfigSpec.BooleanValue GENERATE_LEMON_SHRUB;
    public static ForgeConfigSpec.IntValue CHANCE_LEMON_SHRUB;

    public static ForgeConfigSpec.BooleanValue GENERATE_BLUEBERRY_BUSH;
    public static ForgeConfigSpec.IntValue CHANCE_BLUEBERRY_BUSH;

    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_CASSAVA;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_CASSAVA;

    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_CHILI_PEPPER;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_CHILI_PEPPER;
    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GARLIC;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_GARLIC;
    public static ForgeConfigSpec.BooleanValue GENERATE_WILD_GINGER;
    public static ForgeConfigSpec.IntValue CHANCE_WILD_GINGER;

    public static ForgeConfigSpec.BooleanValue GENERATE_VIOLET;
    public static ForgeConfigSpec.IntValue CHANCE_VIOLET;

    public static final String CATEGORY_CLIENT = "client";
    public static ForgeConfigSpec.BooleanValue FOOD_EFFECT_TOOLTIP;


    static {

        // common
        ForgeConfigSpec.Builder COMMON_BUILDER = new ForgeConfigSpec.Builder();

        COMMON_BUILDER.comment("World generation").push(CATEGORY_WORLD);

        // shrubs
        COMMON_BUILDER.comment("Lemon Shrub generation").push("lemon_shrub");
        CHANCE_LEMON_SHRUB = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 50, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();

        // bushes
        COMMON_BUILDER.comment("Blueberry Bush generation").push("blueberry_bush");
        CHANCE_BLUEBERRY_BUSH = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 50, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();

        // tall wild crops
        COMMON_BUILDER.comment("Wild Cassava generation").push("wild_cassava");
        CHANCE_WILD_CASSAVA = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 60, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();

        // wild crops
        COMMON_BUILDER.comment("Wild Chili Pepper generation").push("wild_chili_pepper");
        CHANCE_WILD_CHILI_PEPPER = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 60, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Wild Garlic generation").push("wild_garlic");
        CHANCE_WILD_GARLIC = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 60, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();
        COMMON_BUILDER.comment("Wild Ginger generation").push("wild_ginger");
        CHANCE_WILD_GINGER = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 60, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();

        // flowers
        COMMON_BUILDER.comment("Violet generation").push("violet");
        CHANCE_VIOLET = COMMON_BUILDER.comment("Chance of generating clusters. Smaller value = more frequent.")
                .defineInRange("chance", 60, 0, Integer.MAX_VALUE);
        COMMON_BUILDER.pop();

        COMMON_CONFIG = COMMON_BUILDER.build();

        //client
        ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();

        CLIENT_BUILDER.comment("Client settings").push(CATEGORY_CLIENT);
        FOOD_EFFECT_TOOLTIP = CLIENT_BUILDER.comment("Should meal and drink tooltips display which effects they provide?")
                .define("foodEffectTooltip", true);
        CLIENT_BUILDER.pop();

        CLIENT_CONFIG = CLIENT_BUILDER.build();
    }
}
