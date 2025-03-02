package com.devdyna.fertilizer.builder;

import java.util.List;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

public class VanillaBoneMeal extends BoneMealItem {

    public static final int DEFAULT_WIDTH = GRASS_SPREAD_WIDTH;
    public static final int DEFAULT_HEIGHT = GRASS_SPREAD_HEIGHT;
    public static final SoundEvent DEFAULT_SOUND = SoundEvents.BONE_MEAL_USE;
    public static final SimpleParticleType DEFAULT_PARTICLES = ParticleTypes.HAPPY_VILLAGER;

    private String t = "";

    public VanillaBoneMeal(Properties p, String traslationName) {
        super(p);
        this.t = traslationName;
    }

    public VanillaBoneMeal(Properties p) {
        super(p);
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
