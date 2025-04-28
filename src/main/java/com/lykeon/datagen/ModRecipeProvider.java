package com.lykeon.datagen;

import com.lykeon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    HashMap<Item,Item> otherHammers = new HashMap<Item,Item>();
    HashMap<Item,Item> otherSickle = new HashMap<Item,Item>();
    HashMap<Item,Item> otherTreeFaller = new HashMap<Item,Item>();

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        prepareHammer();
        prepareSickle();
        prepareTreeFaller();

        otherHammers.forEach((hammer, material) ->
                createHammerRecipe(hammer, material, exporter)
        );

        otherSickle.forEach((hammer, material) ->
                createSickleRecipe(hammer, material, exporter)
        );

        otherTreeFaller.forEach((hammer, material) ->
                createTreeFallerRecipe(hammer, material, exporter)
        );


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_SWORD)
                .pattern(" R ")
                .pattern(" R ")
                .pattern(" # ")
                .input('R', Items.COPPER_INGOT)
                .input('#',  Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_SHOVEL)
                .pattern(" R ")
                .pattern(" # ")
                .pattern(" # ")
                .input('R', Items.COPPER_INGOT)
                .input('#',  Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_PICKAXE)
                .pattern("RRR")
                .pattern(" # ")
                .pattern(" # ")
                .input('R', Items.COPPER_INGOT)
                .input('#',  Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_AXE)
                .pattern("RR ")
                .pattern("R# ")
                .pattern(" # ")
                .input('R', Items.COPPER_INGOT)
                .input('#',  Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.COPPER_HOE)
                .pattern(" RR")
                .pattern(" # ")
                .pattern(" # ")
                .input('R', Items.COPPER_INGOT)
                .input('#',  Items.STICK)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

    }



    private void createHammerRecipe(Item result, Item material, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, result)
                .pattern("RRR")
                .pattern("R#R")
                .pattern(" # ")
                .input('R', material)
                .input('#',  Items.STICK)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    private void createSickleRecipe(Item result, Item material, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, result)
                .pattern(" R ")
                .pattern("  R")
                .pattern("#R ")
                .input('R', material)
                .input('#',  Items.STICK)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }

    private void createTreeFallerRecipe(Item result, Item material, RecipeExporter exporter){
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, result)
                .pattern("RR ")
                .pattern("R# ")
                .pattern(" # ")
                .input('R', material)
                .input('#',  Items.STICK)
                .criterion(hasItem(material), conditionsFromItem(material))
                .offerTo(exporter);
    }


    private void prepareHammer(){
        otherHammers.put(ModItems.WOOD_HAMMER,  Items.ACACIA_PLANKS);
        otherHammers.put(ModItems.WOOD_HAMMER, Items.BIRCH_PLANKS);
        otherHammers.put(ModItems.WOOD_HAMMER, Items.JUNGLE_PLANKS);
        otherHammers.put(ModItems.WOOD_HAMMER, Items.BAMBOO_PLANKS);
        otherHammers.put(ModItems.WOOD_HAMMER, Items.OAK_PLANKS);
        otherHammers.put(ModItems.WOOD_HAMMER, Items.SPRUCE_PLANKS);
        otherHammers.put(ModItems.WOOD_HAMMER, Items.DARK_OAK_PLANKS);
        otherHammers.put(ModItems.WOOD_HAMMER, Items.CRIMSON_PLANKS);
        otherHammers.put(ModItems.WOOD_HAMMER, Items.WARPED_PLANKS);
        otherHammers.put(ModItems.WOOD_HAMMER, Items.MANGROVE_PLANKS);
        otherHammers.put(ModItems.STONE_HAMMER, Items.COBBLESTONE);
        otherHammers.put(ModItems.IRON_HAMMER, Items.IRON_BLOCK);
        otherHammers.put(ModItems.COPPER_HAMMER, Items.COPPER_BLOCK);
        otherHammers.put(ModItems.GOLD_HAMMER, Items.GOLD_BLOCK);
        otherHammers.put(ModItems.DIAMOND_HAMMER, Items.DIAMOND_BLOCK);
        otherHammers.put(ModItems.NETHERITE_HAMMER, Items.NETHERITE_BLOCK);
    }

    private void prepareTreeFaller(){
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER,  Items.ACACIA_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER, Items.BIRCH_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER, Items.JUNGLE_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER, Items.BAMBOO_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER, Items.OAK_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER, Items.SPRUCE_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER, Items.DARK_OAK_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER, Items.CRIMSON_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER, Items.WARPED_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_TREE_FALLER, Items.MANGROVE_PLANKS);
        otherTreeFaller.put(ModItems.STONE_TREE_FALLER, Items.COBBLESTONE);
        otherTreeFaller.put(ModItems.IRON_TREE_FALLER, Items.IRON_BLOCK);
        otherTreeFaller.put(ModItems.COPPER_TREE_FALLER, Items.COPPER_BLOCK);
        otherTreeFaller.put(ModItems.GOLD_TREE_FALLER, Items.GOLD_BLOCK);
        otherTreeFaller.put(ModItems.DIAMOND_TREE_FALLER, Items.DIAMOND_BLOCK);
        otherTreeFaller.put(ModItems.NETHERITE_TREE_FALLER, Items.NETHERITE_BLOCK);
    }

    private void prepareSickle(){
        otherTreeFaller.put(ModItems.WOOD_SICKLE,  Items.ACACIA_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_SICKLE, Items.BIRCH_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_SICKLE, Items.JUNGLE_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_SICKLE, Items.BAMBOO_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_SICKLE, Items.OAK_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_SICKLE, Items.SPRUCE_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_SICKLE, Items.DARK_OAK_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_SICKLE, Items.CRIMSON_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_SICKLE, Items.WARPED_PLANKS);
        otherTreeFaller.put(ModItems.WOOD_SICKLE, Items.MANGROVE_PLANKS);
        otherTreeFaller.put(ModItems.STONE_SICKLE, Items.COBBLESTONE);
        otherTreeFaller.put(ModItems.IRON_SICKLE, Items.IRON_BLOCK);
        otherTreeFaller.put(ModItems.COPPER_SICKLE, Items.COPPER_BLOCK);
        otherTreeFaller.put(ModItems.GOLD_SICKLE, Items.GOLD_BLOCK);
        otherTreeFaller.put(ModItems.DIAMOND_SICKLE, Items.DIAMOND_BLOCK);
        otherTreeFaller.put(ModItems.NETHERITE_SICKLE, Items.NETHERITE_BLOCK);
    }
}