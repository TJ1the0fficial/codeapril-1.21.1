package net.ubico.codeapril.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ubico.codeapril.CodeApril;

public class ModItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(CodeApril.MOD_ID);

    public static DeferredItem<Item> APRIL = ITEMS.register(
            "april",
            () -> new Item(new Item.Properties())
    );

    public static DeferredItem<Item> RAW_APRIL = ITEMS.register(
            "raw_april",
            () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
