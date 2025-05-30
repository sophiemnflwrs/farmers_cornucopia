package net.sophiemnflwrs.farmerscornucopia.datagen;

import com.google.common.collect.Sets;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.sophiemnflwrs.farmerscornucopia.FarmersCornucopia;
import net.sophiemnflwrs.farmerscornucopia.common.registry.FCItems;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@SuppressWarnings("removal")
public class ItemModelsProvider extends ItemModelProvider {

    // helper methods
    public static final String GENERATED = "item/generated";
    public static final String HANDHELD = "item/handheld";
    public static final ResourceLocation MUG = new ResourceLocation(FarmersCornucopia.MOD_ID, "item/mug");

    public ItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FarmersCornucopia.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels(){
        Set<Item> items = ForgeRegistries.ITEMS.getValues().stream().filter(i -> FarmersCornucopia.MOD_ID.equals(ForgeRegistries.ITEMS.getKey(i).getNamespace()))
                .collect(Collectors.toSet());

        // specific cases
        blockBasedModel(FCItems.FRUITING_OLIVE_LEAVES.get(), "_stage1");
        items.remove(FCItems.FRUITING_OLIVE_LEAVES.get());

        blockBasedModel(FCItems.WILD_CASSAVA.get(), "_upper");
        items.remove(FCItems.WILD_CASSAVA.get());

        // items w/ special sprites
        Set<Item> spriteBlockItems = Sets.newHashSet(
                FCItems.BLUEBERRY_SEEDS.get(),
                FCItems.CHILI_PEPPER_SEEDS.get(),
                FCItems.GARLIC_CLOVE.get(),
                FCItems.GINGER_SEEDS.get(),
                FCItems.LEMON_SEEDS.get(),
                FCItems.CASSAVA.get(),
                FCItems.VANILLA_POD.get()

        );
        takeAll(items, spriteBlockItems.toArray(new Item[0])).forEach(item -> withExistingParent(itemName(item), GENERATED).texture("layer0", resourceItem(itemName(item))));

        // blocks w/ flat block textures for their items
        Set<Item> flatBlockItems = Sets.newHashSet(
                FCItems.WILD_GARLIC.get(),
                FCItems.WILD_GINGER.get(),
                FCItems.WILD_CHILI_PEPPER.get(),

                FCItems.GINGER_LILY.get(),
                FCItems.VIOLET.get(),

                FCItems.OLIVE_SAPLING.get()
        );
        takeAll(items, flatBlockItems.toArray(new Item[0])).forEach(item -> itemGeneratedModel(item, resourceBlock(itemName(item))));

        // items that should be held like a mug
        Set<Item> mugItems = Sets.newHashSet(
                FCItems.LEMONADE.get()
        );
        takeAll(items, mugItems.toArray(new Item[0])).forEach(item -> itemMugModel(item, resourceItem(itemName(item))));

        // blocks whose items look alike
        takeAll(items, i -> i instanceof BlockItem).forEach(item -> blockBasedModel(item, ""));

        // all other items; generated here
        items.forEach(item -> itemGeneratedModel(item, resourceItem(itemName(item))));
    }

    // main helper methods
    public void blockBasedModel(Item item, String suffix) {
        withExistingParent(itemName(item), BlockStatesProvider.resourceBlock(itemName(item) + suffix));
    }
    public void itemHandheldModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), HANDHELD).texture("layer0", texture);
    }
    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }
    public void itemMugModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), MUG).texture("layer0", texture);
    }

    private String itemName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }
    public ResourceLocation resourceBlock(String path) {
        return new ResourceLocation(FarmersCornucopia.MOD_ID, "block/" + path);
    }
    public ResourceLocation resourceItem(String path) {
        return new ResourceLocation(FarmersCornucopia.MOD_ID, "item/" + path);
    }

    // main helper methods 2
    @SafeVarargs
    @SuppressWarnings("varargs")
    public static <T> Collection<T> takeAll(Set<? extends T> src, T... items) {
        List<T> ret = Arrays.asList(items);
        for (T item : items) {
            if (!src.contains(item)) {
                FarmersCornucopia.LOGGER.warn("Item {} not found in set", item);
            }
        }
        if (!src.removeAll(ret)) {
            FarmersCornucopia.LOGGER.warn("takeAll array didn't yield anything ({})", Arrays.toString(items));
        }
        return ret;
    }
    public static <T> Collection<T> takeAll(Set<T> src, Predicate<T> pred) {
        List<T> ret = new ArrayList<>();

        Iterator<T> iter = src.iterator();
        while (iter.hasNext()) {
            T item = iter.next();
            if (pred.test(item)) {
                iter.remove();
                ret.add(item);
            }
        }

        if (ret.isEmpty()) {
            FarmersCornucopia.LOGGER.warn("takeAll predicate yielded nothing", new Throwable());
        }
        return ret;
    }
}
