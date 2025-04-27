package com.lykeon.component;


import com.lykeon.MoreToolAndArmor;
import com.lykeon.item.ModItems;
import net.minecraft.component.ComponentType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.ladysnake.cca.api.v3.component.ComponentKey;
import org.ladysnake.cca.api.v3.component.ComponentRegistry;
import org.ladysnake.cca.api.v3.item.ItemComponentInitializer;
import org.ladysnake.cca.api.v3.item.ItemComponentMigrationRegistry;

public class BackpackComponents implements ItemComponentInitializer {
    public static final ComponentKey<BackpackInventoryComponent> BACKPACK_INV =
            ComponentRegistry.getOrCreate(Identifier.of(MoreToolAndArmor.MOD_ID, "backpack_inv"), BackpackInventoryComponent.class);

    @Override
    public void registerItemComponentMigrations(ItemComponentMigrationRegistry itemComponentMigrationRegistry) {
        itemComponentMigrationRegistry.registerMigration(Identifier.of(MoreToolAndArmor.MOD_ID, "backpack_inv"), (ComponentType<BackpackInventoryComponent>) BACKPACK_INV);
    }
}