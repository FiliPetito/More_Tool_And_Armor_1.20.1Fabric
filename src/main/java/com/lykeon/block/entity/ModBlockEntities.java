package com.lykeon.block.entity;

import com.lykeon.MoreToolAndArmor;
import com.lykeon.block.ModBlocks;
import com.lykeon.block.entity.custom.MultyPedestalBlockEntity;
import com.lykeon.block.entity.custom.PedestalBlockEntity;
import com.lykeon.component.BackpackInventoryComponent;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoreToolAndArmor.MOD_ID, "pedestal_be"),
                    BlockEntityType.Builder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));

    public static final BlockEntityType<MultyPedestalBlockEntity> MULTY_PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoreToolAndArmor.MOD_ID, "multy_pedestal_be"),
                    BlockEntityType.Builder.create(MultyPedestalBlockEntity::new, ModBlocks.MULTY_PEDESTAL).build(null));


    public static void registerBlockEntities() {
        MoreToolAndArmor.LOGGER.info("Registering Block Entities for " + MoreToolAndArmor.MOD_ID);
    }
}