package com.lykeon.block.custom;

import com.lykeon.block.entity.custom.MultyPedestalBlockEntity;
import com.lykeon.block.entity.custom.PedestalBlockEntity;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MultyPedestalBlock extends BlockWithEntity implements BlockEntityProvider {

    private static final VoxelShape SHAPE =
            Block.createCuboidShape(2, 0, 2, 14, 13, 14);
    public static final MapCodec<MultyPedestalBlock> CODEC = MultyPedestalBlock.createCodec(MultyPedestalBlock::new);

    public MultyPedestalBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MultyPedestalBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if(state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if(blockEntity instanceof MultyPedestalBlockEntity) {
                ItemScatterer.spawn(world, pos, ((MultyPedestalBlockEntity) blockEntity));
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    //@Override
    //protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos,
    //                                         PlayerEntity player, Hand hand, BlockHitResult hit) {
    //    if(world.getBlockEntity(pos) instanceof MultyPedestalBlockEntity multyPedestalBlockEntity) {
    //        if(!world.isClient()){
    //            player.openHandledScreen(multyPedestalBlockEntity);
    //        }
    //    }
    //    return ItemActionResult.SUCCESS;
    //}


    //Interazione con il blocco al click destro
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        //Controllo se è l'istanza del MultyPedestalBlockEntity
        if(world.getBlockEntity(pos) instanceof MultyPedestalBlockEntity multyPedestalBlockEntity) {
            if(!world.isClient()){
                //Apertura del'inventario
                player.openHandledScreen(multyPedestalBlockEntity);
            }
        }
        return ActionResult.SUCCESS;
    }
}
