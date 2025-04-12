package com.lykeon.item.custom;

import com.lykeon.utils.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MiningToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.*;

public class SickleItem extends MiningToolItem {

    public SickleItem(ToolMaterial material, Settings settings) {
        super(material, ModTags.Blocks.SICKLE_MINEABLE, settings);
    }

    public void getBlocksToBeDestroyed(World world, BlockPos center, PlayerEntity player) {
        if (world.isClient) return;

        Random random = new Random();

        BlockPos playerDropPos = player.getBlockPos(); // dove far spawnare gli oggetti

        // Scansiona 5x5 attorno al blocco colpito
        for (int x = -2; x <= 2; x++) {
            for (int z = -2; z <= 2; z++) {
                BlockPos targetPos = center.add(x, 0, z);
                BlockState state = world.getBlockState(targetPos);

                if (isGrass(state)) {

                    // Rimuove il blocco
                    world.breakBlock(targetPos, false);

                    // 70% di probabilità di droppare 1 seme
                    if (random.nextFloat() <= 0.6f) {
                        ItemStack seeds = new ItemStack(Items.WHEAT_SEEDS, 1);
                        ItemEntity drop = new ItemEntity(
                                world,
                                playerDropPos.getX() + 0.5,
                                playerDropPos.getY(),
                                playerDropPos.getZ() + 0.5,
                                seeds);
                        world.spawnEntity(drop);
                    }
                }
            }
        }
    }

    private boolean isGrass(BlockState state) {
        return state.isIn(ModTags.Blocks.SICKLE_MINEABLE);
    }
}
