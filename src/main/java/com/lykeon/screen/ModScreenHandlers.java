package com.lykeon.screen;

import com.lykeon.MoreToolAndArmor;
import com.lykeon.screen.custom.MultyPedestalScreenHandler;
import com.lykeon.screen.custom.PedestalScreenHandler;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
    public static final ScreenHandlerType<PedestalScreenHandler> PEDESTAL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MoreToolAndArmor.MOD_ID, "pedestal_screen_handler"),
                    new ExtendedScreenHandlerType<>(PedestalScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<MultyPedestalScreenHandler> MULTY_PEDESTAL_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MoreToolAndArmor.MOD_ID, "multy_pedestal_screen_handler"),
                    new ExtendedScreenHandlerType<>(MultyPedestalScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
        MoreToolAndArmor.LOGGER.info("Registering Screen Handlers for " + MoreToolAndArmor.MOD_ID);
    }
}