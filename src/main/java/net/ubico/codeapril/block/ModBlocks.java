package net.ubico.codeapril.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.ubico.codeapril.CodeApril;
import static net.ubico.codeapril.item.ModItems.ITEMS;

public class ModBlocks {
    public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(CodeApril.MOD_ID);

    public static DeferredBlock<Block> APRIL_ORE = BLOCKS.register(
            "april_ore",
            () -> new Block((BlockBehaviour.Properties.of()
                    .destroyTime(4f)
                    .requiresCorrectToolForDrops()
            ))
    );
    public static DeferredItem<BlockItem> APRIl_ORE_ASITEM = ITEMS.registerSimpleBlockItem(
            "april_ore",
            APRIL_ORE
    );

    public static DeferredBlock<Block> RAW_APRIL_BLOCK = BLOCKS.register(
            "raw_april_block",
            () -> new Block((BlockBehaviour.Properties.of()
                    .destroyTime(4f)
                    .requiresCorrectToolForDrops()
            ))
    );
    public static DeferredItem<BlockItem> RAW_APRIL_BLOCK_ASITEM = ITEMS.registerSimpleBlockItem(
            "raw_april_block",
            RAW_APRIL_BLOCK
    );

    public static DeferredBlock<Block> APRIL_BLOCK = BLOCKS.register(
            "april_block",
            () -> new Block((BlockBehaviour.Properties.of()
                    .destroyTime(4f)
                    .requiresCorrectToolForDrops()
            ))
    );
    public static DeferredItem<BlockItem> APRIl_BLOCK_ASITEM = ITEMS.registerSimpleBlockItem(
            "april_block",
            APRIL_BLOCK
    );

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
