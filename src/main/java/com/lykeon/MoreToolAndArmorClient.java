package com.lykeon;

import com.lykeon.block.entity.ModBlockEntities;
import com.lykeon.block.entity.renderer.MultyPedestalBlockEntityRenderer;
import com.lykeon.block.entity.renderer.PedestalBlockEntityRenderer;
import com.lykeon.screen.ModScreenHandlers;
import com.lykeon.screen.custom.MultyPedestalScreen;
import com.lykeon.screen.custom.PedestalScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class MoreToolAndArmorClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MULTY_PEDESTAL_BE, MultyPedestalBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.PEDESTAL_SCREEN_HANDLER, PedestalScreen::new);
        HandledScreens.register(ModScreenHandlers.MULTY_PEDESTAL_SCREEN_HANDLER, MultyPedestalScreen::new);
    }
}
