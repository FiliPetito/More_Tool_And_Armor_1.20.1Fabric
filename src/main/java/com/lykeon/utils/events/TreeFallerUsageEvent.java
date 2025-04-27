package com.lykeon.utils.events;

import com.lykeon.item.custom.TreeFellerItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeFallerUsageEvent implements PlayerBlockBreakEvents.Before{

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        if (world.isClient) return true;

        ItemStack mainHandItem = player.getMainHandStack();

        if(player.isCreative()){
            world.breakBlock(pos, false);
            return true;
        }

        if (mainHandItem.getItem() instanceof TreeFellerItem && player instanceof ServerPlayerEntity serverPlayer) {
            if (HARVESTED_BLOCKS.contains(pos) || !state.isIn(BlockTags.LOGS)) {
                return true;
            }

            List<BlockPos> treeBlocks = TreeFellerItem.getBlocksToBeDestroyed(world, pos, serverPlayer);

            for (BlockPos position : treeBlocks) {
                if (pos.equals(position)) continue;

                if (!((TreeFellerItem) mainHandItem.getItem()).isCorrectForDrops(mainHandItem, world.getBlockState(position))) {
                    continue;
                }

                HARVESTED_BLOCKS.add(position);
                serverPlayer.interactionManager.tryBreakBlock(position);
                HARVESTED_BLOCKS.remove(position);
            }
        }

        return true;
    }
}
