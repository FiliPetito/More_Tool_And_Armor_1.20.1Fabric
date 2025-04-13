package com.lykeon.block.entity.custom;

import com.lykeon.block.entity.ImplementedInventory;
import com.lykeon.block.entity.ModBlockEntities;
import com.lykeon.item.ModItems;
import com.lykeon.screen.custom.MultyPedestalScreenHandler;
import com.lykeon.screen.custom.PedestalScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class MultyPedestalBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(8, ItemStack.EMPTY);
    private float rotation = 0;

    public MultyPedestalBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MULTY_PEDESTAL_BE, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    //public float getRenderingRotation() {
    //    rotation += 0.5f;
    //    if(rotation >= 360) {
    //        rotation = 0;
    //    }
    //    return rotation;
    //}

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, inventory, registryLookup);
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
        return this.pos;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.more_tool_and_armor.multy_pedestal_text");
    }

    //Creazione dell'interfaccia
    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new MultyPedestalScreenHandler(syncId, playerInventory, this.pos);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    //Controllo degli elementi inseribili
    @Override
    public boolean isValid(int slot, ItemStack stack) {
        Item item = stack.getItem();
        return switch (slot) {
            case 0 -> item == ModItems.COPPER_SWORD;
            case 1 -> item == ModItems.COPPER_AXE;
            case 2 -> item == ModItems.COPPER_SHOVEL;
            case 3 -> item == ModItems.COPPER_PICKAXE;
            case 4 -> item == ModItems.COPPER_HOE;
            case 5 -> item == ModItems.COPPER_HAMMER;
            case 6 -> item == ModItems.COPPER_TREE_FALLER;
            case 7 -> item == ModItems.COPPER_SICKLE;
            default -> false;
        };
    }

    // impedisce l'inserimento tramite hopper o automation
    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return false;
    }

    // impedisce l'estrazzione tramite hopper o automation
    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return false;
    }

}
