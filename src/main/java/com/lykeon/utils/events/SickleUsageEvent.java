package com.lykeon.utils.events;

import com.lykeon.item.custom.SickleItem;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class SickleUsageEvent  implements PlayerBlockBreakEvents.Before {

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity) {
        if (world.isClient) return true;

        if(player.isCreative()){
            world.breakBlock(pos, false);
            return true;
        }

        ItemStack mainHandItem = player.getMainHandStack();

        if (mainHandItem.getItem() instanceof SickleItem sickle) {
            if (player instanceof ServerPlayerEntity) {
                sickle.getBlocksToBeDestroyed(world, pos, player);
                return false; // blocchiamo la normale distruzione, lo gestiamo noi
            }
        }

        return true;
    }
}
