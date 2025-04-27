package com.lykeon.item;

import com.lykeon.MoreToolAndArmor;
import com.lykeon.item.custom.HammerItem;
import com.lykeon.item.custom.SickleItem;
import com.lykeon.item.custom.TreeFellerItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    // Utensili
    public static final Item COPPER_SWORD = registerItem("copper_sword",
            new SwordItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.COPPER, 3, -2.4F))));
    public static final Item COPPER_PICKAXE = registerItem("copper_pickaxe",
            new PickaxeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 1.0F, -2.8F))));
    public static final Item COPPER_AXE = registerItem("copper_axe",
            new AxeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 6.0F, -3.1F))));
    public static final Item COPPER_SHOVEL = registerItem("copper_shovel",
            new ShovelItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.COPPER, 1.5F, -3.0F))));
    public static final Item COPPER_HOE = registerItem("copper_hoe",
            new HoeItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.COPPER, -2.0F, -1.0F))));


    //SICKLE
    public static final Item WOOD_SICKLE = registerItem("wood_sickle",
            new SickleItem(ToolMaterials.WOOD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.WOOD, -2.0F, -1.0F))));

    public static final Item STONE_SICKLE = registerItem("stone_sickle",
            new SickleItem(ToolMaterials.STONE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.STONE, -2.0F, -1.0F))));

    public static final Item IRON_SICKLE = registerItem("iron_sickle",
            new SickleItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, -2.0F, -1.0F))));

    public static final Item COPPER_SICKLE = registerItem("copper_sickle",
            new SickleItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER, -2.0F, -1.0F))));

    public static final Item GOLD_SICKLE = registerItem("gold_sickle",
            new SickleItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.GOLD, -2.0F, -1.0F))));

    public static final Item DIAMOND_SICKLE = registerItem("diamond_sickle",
            new SickleItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, -2.0F, -1.0F))));

    public static final Item NETHERITE_SICKLE = registerItem("netherite_sickle",
            new SickleItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, -2.0F, -1.0F))));


    //TREE FALLER
    public static final Item WOOD_TREE_FALLER = registerItem("wood_tree_faller",
            new TreeFellerItem(ToolMaterials.WOOD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.WOOD, 7.0F, -3.8F))));

    public static final Item STONE_TREE_FALLER = registerItem("stone_tree_faller",
            new TreeFellerItem(ToolMaterials.STONE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.STONE, 7.0F, -3.8F))));

    public static final Item IRON_TREE_FALLER = registerItem("iron_tree_faller",
            new TreeFellerItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 7.0F, -3.8F))));

    public static final Item COPPER_TREE_FALLER = registerItem("copper_tree_faller",
            new TreeFellerItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 7.0F, -3.8F))));

    public static final Item GOLD_TREE_FALLER = registerItem("gold_tree_faller",
            new TreeFellerItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.GOLD, 7.0F, -3.8F))));

    public static final Item DIAMOND_TREE_FALLER = registerItem("diamond_tree_faller",
            new TreeFellerItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 7.0F, -3.8F))));

    public static final Item NETHERITE_TREE_FALLER = registerItem("netherite_tree_faller",
            new TreeFellerItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 7.0F, -3.8F))));


    //HAMMER
    public static final Item WOOD_HAMMER = registerItem("wood_hammer",
            new HammerItem(ToolMaterials.WOOD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.WOOD, 7.0F, -3.8F))));

    public static final Item STONE_HAMMER = registerItem("stone_hammer",
            new HammerItem(ToolMaterials.STONE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.STONE, 7.0F, -3.8F))));

    public static final Item IRON_HAMMER = registerItem("iron_hammer",
            new HammerItem(ToolMaterials.IRON, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.IRON, 7.0F, -3.8F))));

    public static final Item COPPER_HAMMER = registerItem("copper_hammer",
            new HammerItem(ModToolMaterials.COPPER, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.COPPER, 7.0F, -3.8F))));

    public static final Item GOLD_HAMMER = registerItem("gold_hammer",
            new HammerItem(ToolMaterials.GOLD, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.GOLD, 7.0F, -3.8F))));

    public static final Item DIAMOND_HAMMER = registerItem("diamond_hammer",
            new HammerItem(ToolMaterials.DIAMOND, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.DIAMOND, 7.0F, -3.8F))));

    public static final Item NETHERITE_HAMMER = registerItem("netherite_hammer",
            new HammerItem(ToolMaterials.NETHERITE, new Item.Settings()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ToolMaterials.NETHERITE, 7.0F, -3.8F))));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(MoreToolAndArmor.MOD_ID, name), item);
    }

    public static void registerModItems(){
        MoreToolAndArmor.LOGGER.info("Registering Simple Badge for " + MoreToolAndArmor.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries ->
        {

            //entries.add(IRON_HAMMER);

        });
    }

}
