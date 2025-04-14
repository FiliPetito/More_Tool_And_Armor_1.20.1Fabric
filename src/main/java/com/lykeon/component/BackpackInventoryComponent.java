package com.lykeon.component;

import com.lykeon.block.entity.ImplementedInventory;

import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import org.ladysnake.cca.api.v3.component.Component;
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent;

public class BackpackInventoryComponent implements Component, ImplementedInventory, AutoSyncedComponent {
    public static final int SIZE = 9; // 9 slot come un piccolo zaino
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(SIZE, ItemStack.EMPTY);
    private final ItemStack provider;

    public BackpackInventoryComponent(ItemStack provider) {
        this.provider = provider;
    }

    public DefaultedList<ItemStack> getInventory() {
        return inventory;
    }

    @Override
    public void writeToNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        Inventories.writeNbt(nbtCompound, inventory, wrapperLookup);
    }

    @Override
    public void readFromNbt(NbtCompound nbtCompound, RegistryWrapper.WrapperLookup wrapperLookup) {
        Inventories.readNbt(nbtCompound, inventory, wrapperLookup);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }
}