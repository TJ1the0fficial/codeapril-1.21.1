package net.ubico.codeapril.provider;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import net.ubico.codeapril.CodeApril;
import net.ubico.codeapril.block.ModBlocks;
import net.ubico.codeapril.item.ModCreativeTab;
import net.ubico.codeapril.item.ModItems;

public class en_us_ModLanguageProvider extends LanguageProvider {
    public en_us_ModLanguageProvider(PackOutput output) {
        super(
                // Provided by the GatherDataEvent.
                output,
                // Your mod id.
                CodeApril.MOD_ID,
                // The locale to use. You may use multiple language providers for different locales.
                "en_us"
        );
    }

    @Override
    protected void addTranslations() {
        // Adds a translation with the given key and the given value.
//        add("translation.key.1", "Translation 1");

        // Items
        addItem(ModItems.APRIL,"April");
        addItem(ModItems.RAW_APRIL,"Raw April");
        // Blocks
        addBlock(ModBlocks.APRIL_ORE,"April Ore");
        addBlock(ModBlocks.RAW_APRIL_BLOCK,"Raw April Block");
        addBlock(ModBlocks.APRIL_BLOCK,"Block of April");
        // Creative Tab
        add("creativetab."+CodeApril.MOD_ID+".code_april_creative_tab","Code:April");
    }
}
