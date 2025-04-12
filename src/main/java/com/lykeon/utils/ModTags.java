package com.lykeon.utils;

import com.lykeon.MoreToolAndArmor;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {

    public static class Blocks{
        public static final TagKey<Block> NEEDS_COPPER_TOOL = createTag("copper_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPPER_TOOL = createTag("incorrect_for_copper_tool");

        public static final TagKey<Block> SICKLE_MINEABLE  = createTag("sickle_mineable");


        private static TagKey<Block> createTag(String name){
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoreToolAndArmor.MOD_ID, name));
        }
    }

}
