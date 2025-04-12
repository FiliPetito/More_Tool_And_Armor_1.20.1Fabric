package com.lykeon.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TreeFellerItem extends MiningToolItem {

    public TreeFellerItem(ToolMaterial material, Settings settings) {
        super(material, BlockTags.AXE_MINEABLE, settings);
    }

    public static List<BlockPos> getBlocksToBeDestroyed(World world, BlockPos initialBlockPos, ServerPlayerEntity player) {
        Set<BlockPos> visited = new HashSet<>();
        breakTree(world, initialBlockPos, visited, player);
        return new ArrayList<>(visited);
    }

    private static void breakTree(World world, BlockPos pos, Set<BlockPos> visited, ServerPlayerEntity player) {
        if (visited.contains(pos)) return;

        BlockState state = world.getBlockState(pos);
        if (!isLog(state)) return;

        visited.add(pos);

        for (Direction dir : Direction.values()) {
            BlockPos neighbor = pos.offset(dir);
            breakTree(world, neighbor, visited, player);
        }
    }

    private static boolean isLog(BlockState state) {
        return state.isIn(BlockTags.LOGS);
    }
}
