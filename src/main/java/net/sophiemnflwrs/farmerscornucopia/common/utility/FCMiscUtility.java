package net.sophiemnflwrs.farmerscornucopia.common.utility;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

// credit to brnbrd for this code!

@SuppressWarnings("removal")
public class FCMiscUtility {

    public static ResourceLocation cr(String path) {
        return new ResourceLocation(FarmersCornucopia.MOD_ID, path);
    }

    public static ResourceLocation rl(String modid, String path) {
        return new ResourceLocation(modid, path);
    }

    @Nullable
    public static Item item(String modid, String path) {
        return item(rl(modid, path));
    }

    @Nullable
    public static Item item(ResourceLocation rl) {
        return ForgeRegistries.ITEMS.getValue(rl);
    }

    public static ItemStack gs(Supplier<Item> r) {
        return r.get().getDefaultInstance();
    }

    public static String name(Item item) {
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item)).getPath();
    }

    public static String name(Block block) {
        return Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block)).getPath();
    }

    public static String name(RegistryObject<?> reg) {
        return reg.getId().getPath();
    }
}
