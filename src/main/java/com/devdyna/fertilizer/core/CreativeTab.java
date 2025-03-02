package com.devdyna.fertilizer.core;

import com.devdyna.fertilizer.Main;
import com.devdyna.fertilizer.core.Utils.Constants;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTab {

    public static void register(IEventBus bus) {
        CREATIVE_MODE_TABS.register(bus);
    }

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, Main.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> TAB = CREATIVE_MODE_TABS
            .register(Main.MODID+"_tab", () -> CreativeModeTab.builder()
                    .title(Component.translatable(Main.MODID+".tab"))
                    .withTabsBefore(CreativeModeTabs.COMBAT)
                    .icon(() -> Items.FERTILIZER.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {

                        for (Item i : Constants.AllItems) {
                            output.accept(i);
                        }

                    }).build());
}
