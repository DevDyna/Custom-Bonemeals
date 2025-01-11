package com.devdyna.fertilizer;

import com.devdyna.fertilizer.core.CreativeTab;
import com.devdyna.fertilizer.core.Items;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Main.MODID)
public class Main {

    public static final String MODID = "fertilizer";

    public Main(IEventBus modEventBus, ModContainer modContainer) {
        Items.register(modEventBus);
        CreativeTab.register(modEventBus);
    }

}
