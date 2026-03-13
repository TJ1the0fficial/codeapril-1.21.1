package net.ubico.codeapril.provider;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.ubico.codeapril.CodeApril;
import net.ubico.codeapril.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    // Parameter values are provided by GatherDataEvent.
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, CodeApril.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        ModelFile exampleModel = models().withExistingParent("example_model", this.mcLoc("block/cobblestone"));

        for (DeferredHolder<Block, ? extends Block> block : ModBlocks.BLOCKS.getEntries()) {
            simpleBlockWithItem(block.get(), cubeAll(block.get()));
        }
    }

    @SubscribeEvent // on the mod event bus
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // other providers here
        generator.addProvider(
                event.includeClient(),
                new ModBlockStateProvider(output, existingFileHelper)
        );
    }
}
