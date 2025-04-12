package com.lykeon;

import com.lykeon.block.entity.ModBlockEntities;
import com.lykeon.block.entity.renderer.PedestalBlockEntityRenderer;
import com.lykeon.screen.ModScreenHandlers;
import com.lykeon.screen.custom.PedestalScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class MoreToolAndArmorClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.PEDESTAL_SCREEN_HANDLER, PedestalScreen::new);
    }
}
