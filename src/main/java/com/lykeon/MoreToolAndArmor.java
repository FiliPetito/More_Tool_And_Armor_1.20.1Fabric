package com.lykeon;

import com.lykeon.block.ModBlocks;
import com.lykeon.block.entity.ModBlockEntities;
import com.lykeon.component.ModDataComponentTypes;
import com.lykeon.screen.ModScreenHandlers;
import com.lykeon.utils.events.HammerUsageEvent;
import com.lykeon.utils.ModItemGroups;
import com.lykeon.item.ModItems;
import com.lykeon.utils.events.SickleUsageEvent;
import com.lykeon.utils.events.TreeFallerUsageEvent;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreToolAndArmor implements ModInitializer {
	public static final String MOD_ID = "moretoolandarmor";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Initialization of the mod" + MOD_ID);

		//Initialization Mod Items
		ModItems.registerModItems();

		//Initialization Mod Groups
		ModItemGroups.registerItemGroups();

		ModBlocks.registerModBlocks();
		ModBlockEntities.registerBlockEntities();

		ModScreenHandlers.registerScreenHandlers();

		ModDataComponentTypes.registerDataComponentTypes();

		PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register(new TreeFallerUsageEvent());
		PlayerBlockBreakEvents.BEFORE.register(new SickleUsageEvent());

	}
}