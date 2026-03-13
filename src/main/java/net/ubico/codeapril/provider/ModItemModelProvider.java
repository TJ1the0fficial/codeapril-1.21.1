package net.ubico.codeapril.provider;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.ubico.codeapril.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, "examplemod", existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Block items generally use their corresponding block models as parent.
//        withExistingParent(MyItemsClass.EXAMPLE_BLOCK_ITEM.getId().toString(), modLoc("block/example_block"));
        // Items generally use a simple parent and one texture. The most common parents are item/generated and item/handheld.
        // In this example, the item texture would be located at assets/examplemod/textures/item/example_item.png.
        // If you want a more complex model, you can use getBuilder() and then work from that, like you would with block models.
//        withExistingParent(MyItemsClass.EXAMPLE_ITEM.getId().toString(), mcLoc("item/generated")).texture("layer0", "item/example_item");
        // The above line is so common that there is a shortcut for it. Note that the item registry name and the
        // texture path, relative to textures/item, must match.
//        basicItem(MyItemsClass.EXAMPLE_ITEM.get());

        for (DeferredHolder<Item, ? extends Item> item : ModItems.ITEMS.getEntries()) {
            if (item.get() instanceof BlockItem blockItem) continue;
            basicItem(item.get());
        }
    }
}
