package com.devdyna.fertilizer.core.Utils;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class TipBuilder extends Item {

    private String t = "";

    public TipBuilder(Properties p, String tkey) {
        super(p);
        this.t = tkey;
    }

    @SuppressWarnings("null")
    @Override
    public void appendHoverText(ItemStack st, TooltipContext ct, List<Component> tip,
    TooltipFlag tf) {
        if (!t.isEmpty())
            if (Screen.hasControlDown()) {
                tip.add(Component.translatable("item." + t + ".0"));
                tip.add(Component.translatable("item." + t + ".1"));
                tip.add(Component.translatable("item." + t + ".2"));
            } else {
                tip.add(Component.translatable("item." + t + ".off"));
            }
        super.appendHoverText(st, ct, tip, tf);
    }
}
