package com.lykeon.utils;

import com.lykeon.MoreToolAndArmor;
import com.lykeon.block.ModBlocks;
import com.lykeon.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups extends ItemGroups {

    public static final ItemGroup MORE_TOOL_AND_ARMOR_GROUP  = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(MoreToolAndArmor.MOD_ID, "more_tool_and_armor"),
            FabricItemGroup.builder()
                    //Icona che vogliamo visualizzare nella pagina della mod
                    .icon(() -> new ItemStack((ModItems.IRON_HAMMER)))

                    //Nome della mod da visualizzare
                    .displayName(Text.translatable("itemgroup.moretoolandarmor.iron_hammer"))

                    .entries(((displayContext, entries) -> {

                        //Inserire gli elementi che appartengono alla mod
                        entries.add(ModItems.IRON_HAMMER);
                        entries.add(ModItems.COPPER_AXE);
                        entries.add(ModItems.COPPER_HOE);
                        entries.add(ModItems.COPPER_PICKAXE);
                        entries.add(ModItems.COPPER_SHOVEL);
                        entries.add(ModItems.COPPER_SWORD);
                        entries.add(ModItems.COPPER_HAMMER);
                        entries.add(ModItems.COPPER_TREE_FALLER);
                        entries.add(ModItems.COPPER_SICKLE);
                        entries.add(ModBlocks.PEDESTAL);
                        entries.add(ModBlocks.MULTY_PEDESTAL);
                        entries.add(ModItems.BACKPACK);

                    }))
                    .build()
            );

    public static void registerItemGroups(){
        MoreToolAndArmor.LOGGER.info("Registering Item Groups for " + MoreToolAndArmor.MOD_ID);
    }
}
