package net.sophiemnflwrs.farmerscornucopia.common.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;

public class FCCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FarmersCornucopia.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TAB_FARMERS_CORNUCOPIA = CREATIVE_TABS.register(FarmersCornucopia.MOD_ID,
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.farmerscornucopiatab"))
                    .icon(() -> new ItemStack(FCItems.GARLIC.get()))
                    .displayItems((parameters, output) -> FCItems.CREATIVE_TAB_ITEMS.forEach((item) -> output.accept(item.get())))
                    .build());
}
