package com.lykeon.datagen;

import com.lykeon.MoreToolAndArmor;
import com.lykeon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

        MoreToolAndArmor.LOGGER.info("ModModelProvider" + MoreToolAndArmor.MOD_ID);

        itemModelGenerator.register(ModItems.COPPER_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HOE, Models.HANDHELD);

        //HAMMER
        itemModelGenerator.register(ModItems.WOOD_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_HAMMER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_HAMMER, Models.HANDHELD);

        //SICKLE
        itemModelGenerator.register(ModItems.WOOD_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_SICKLE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_SICKLE, Models.HANDHELD);

        //TREE FALLER
        itemModelGenerator.register(ModItems.WOOD_TREE_FALLER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.STONE_TREE_FALLER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.IRON_TREE_FALLER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.COPPER_TREE_FALLER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GOLD_TREE_FALLER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.DIAMOND_TREE_FALLER, Models.HANDHELD);
        itemModelGenerator.register(ModItems.NETHERITE_TREE_FALLER, Models.HANDHELD);

    }


}
