package net.ubico.codeapril.provider;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.block.Blocks;
import net.ubico.codeapril.block.ModBlocks;
import net.ubico.codeapril.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {

    // Get the parameters from GatherDataEvent.
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_APRIL_BLOCK_ASITEM)
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RAW_APRIL)
                .unlockedBy("has_raw_april", has(ModItems.RAW_APRIL))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_APRIL, 9)
                .requires(ModBlocks.RAW_APRIL_BLOCK_ASITEM)
                .unlockedBy("has_raw_april_block", has(ModBlocks.RAW_APRIL_BLOCK_ASITEM))
                .save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.APRIl_BLOCK_ASITEM)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.APRIL)
                .unlockedBy("has_april_block", has(ModBlocks.APRIL_BLOCK))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.APRIL, 9)
                .requires(ModBlocks.APRIl_BLOCK_ASITEM)
                .unlockedBy("has__april_block", has(ModBlocks.APRIl_BLOCK_ASITEM))
                .save(output);

        SimpleCookingRecipeBuilder.smelting(
                        // Our input ingredient.
                        Ingredient.of(ModItems.RAW_APRIL),
                        // Our recipe category.
                        RecipeCategory.MISC,
                        // Our result item. May also be an ItemStack.
                        ModItems.APRIL,
                        // Our experience reward
                        0.5f,
                        // Our cooking time.
                        150
                )
                // The recipe advancement, like with the crafting recipes above.
                .unlockedBy("has_raw_april", has(ModItems.RAW_APRIL))
                // This overload of #save allows us to specify a name.
                .save(output, "raw_april_smelting");

        SimpleCookingRecipeBuilder.smelting(
                        // Our input ingredient.
                        Ingredient.of(ModBlocks.RAW_APRIL_BLOCK_ASITEM),
                        // Our recipe category.
                        RecipeCategory.MISC,
                        // Our result item. May also be an ItemStack.
                        ModBlocks.APRIl_BLOCK_ASITEM,
                        // Our experience reward
                        1.5f,
                        // Our cooking time.
                        200
                )
                // The recipe advancement, like with the crafting recipes above.
                .unlockedBy("has_raw_april_block", has(ModItems.RAW_APRIL))
                // This overload of #save allows us to specify a name.
                .save(output, "raw_april_block_smelting");
    }
}
