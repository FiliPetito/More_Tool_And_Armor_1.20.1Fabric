package com.lykeon;

import com.lykeon.datagen.ModBlockProvider;
import com.lykeon.datagen.ModItemTagProvider;
import com.lykeon.datagen.ModModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MoreToolAndArmorDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		MoreToolAndArmor.LOGGER.info("Init MoreToolAndArmorDataGenerator" + MoreToolAndArmor.MOD_ID);

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(ModBlockProvider::new);
		pack.addProvider(ModItemTagProvider::new);
		//pack.addProvider(ModLootTableProvider::new);
		pack.addProvider(ModModelProvider::new);
		//pack.addProvider(ModRecipeProvider::new);
	}
}
