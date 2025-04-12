package com.lykeon.datagen;

import com.lykeon.MoreToolAndArmor;
import com.lykeon.utils.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture){
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        MoreToolAndArmor.LOGGER.info("ModBlockProvider" + MoreToolAndArmor.MOD_ID);

        getOrCreateTagBuilder(ModTags.Blocks.SICKLE_MINEABLE)
               .add(Blocks.SHORT_GRASS)
               .add(Blocks.TALL_GRASS)
               .add(Blocks.FERN)
               .add(Blocks.LARGE_FERN);


        //getOrCreateTagBuilder(ModTags.Blocks.NEEDS_COPPER_TOOL)
        //        .addTag(BlockTags.NEEDS_IRON_TOOL);
    }
}
