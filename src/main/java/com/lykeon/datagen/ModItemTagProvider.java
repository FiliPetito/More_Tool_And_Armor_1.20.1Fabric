package com.lykeon.datagen;

import com.lykeon.MoreToolAndArmor;
import com.lykeon.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;


import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture){
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        MoreToolAndArmor.LOGGER.info("ModItemTagProvider" + MoreToolAndArmor.MOD_ID);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.COPPER_SWORD);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.COPPER_HOE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.COPPER_PICKAXE);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.COPPER_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.COPPER_SHOVEL);


        //HAMMER
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.WOOD_HAMMER);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.STONE_HAMMER);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.IRON_HAMMER);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.COPPER_HAMMER);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.GOLD_HAMMER);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.DIAMOND_HAMMER);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.NETHERITE_HAMMER);

        //SICKLE
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.WOOD_SICKLE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.STONE_SICKLE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.IRON_SICKLE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.COPPER_SICKLE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.GOLD_SICKLE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.DIAMOND_SICKLE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.NETHERITE_SICKLE);

        //TREE FALLER
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.WOOD_TREE_FALLER);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.STONE_TREE_FALLER);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.IRON_TREE_FALLER);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.COPPER_TREE_FALLER);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.GOLD_TREE_FALLER);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.DIAMOND_TREE_FALLER);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.NETHERITE_TREE_FALLER);
    }
}
