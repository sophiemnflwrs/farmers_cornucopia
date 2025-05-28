package net.sophiemnflwrs.farmerscornucopia.common;


import net.minecraft.world.level.block.ComposterBlock;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;

public class CommonSetup {

    public static void init(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            registerCompostables();
        });
    }

    public static void registerCompostables() {
        // 30% chance
        ComposterBlock.COMPOSTABLES.put(FCItems.CHILI_PEPPER_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(FCItems.GINGER_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(FCItems.LEMON_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(FCItems.BLUEBERRY_SEEDS.get(), 0.3F);
        ComposterBlock.COMPOSTABLES.put(FCItems.OLIVE_LEAVES.get(), 0.3F);

        // 50% chance
        ComposterBlock.COMPOSTABLES.put(FCItems.GARLIC_CLOVE.get(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(FCItems.OLIVE_SAPLING.get(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(FCItems.VIOLET.get(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(FCItems.GINGER_LILY.get(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(FCItems.FRUITING_OLIVE_LEAVES.get(), 0.5F);

        // 65% chance
        ComposterBlock.COMPOSTABLES.put(FCItems.GARLIC.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FCItems.GINGER.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FCItems.CHILI_PEPPER.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FCItems.LEMON.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FCItems.BLUEBERRY.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FCItems.OLIVE.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FCItems.GARLIC_BREAD.get(), 0.65F);
        ComposterBlock.COMPOSTABLES.put(FCItems.CASSAVA.get(), 0.65F);

        // 85% chance
        ComposterBlock.COMPOSTABLES.put(FCItems.BLUEBERRY_MUFFIN.get(), 0.85F);
        ComposterBlock.COMPOSTABLES.put(FCItems.MASHED_POTATOES.get(), 0.85F);
        ComposterBlock.COMPOSTABLES.put(FCItems.LEMON_MARMALADE.get(), 0.85F);
        ComposterBlock.COMPOSTABLES.put(FCItems.BLUEBERRY_JAM.get(), 0.85F);
        ComposterBlock.COMPOSTABLES.put(FCItems.VIOLET_JELLY.get(), 0.85F);

        // 100% chance
        ComposterBlock.COMPOSTABLES.put(FCItems.PATATAS_BRAVAS.get(), 1.0F);
    }
    // init potted plants
    // ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(FCBlocks.VIOLET.getId(), FCBlocks.POTTED_VIOLET);
}

