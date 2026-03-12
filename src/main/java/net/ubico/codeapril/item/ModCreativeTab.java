package net.ubico.codeapril.item;


import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ubico.codeapril.CodeApril;
import net.ubico.codeapril.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB,CodeApril.MOD_ID);

    public static Supplier<CreativeModeTab> CODE_APRIL_CREATIVE_TAB = CREATIVE_MODE_TABS.register(
            "code_april_creative_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup." + CodeApril.MOD_ID + ".code_april_creative_tab"))
                    .icon(() -> new ItemStack(ModItems.APRIL.get()))
                    .displayItems((params, output) -> {
                        output.accept(ModItems.APRIL.get());
                        output.accept(ModItems.RAW_APRIL.get());
                        output.accept(ModBlocks.APRIL_ORE.get());
                        output.accept(ModBlocks.RAW_APRIL_BLOCK.get());
                    })
                    .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
