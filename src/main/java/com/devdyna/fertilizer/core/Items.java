package com.devdyna.fertilizer.core;

import com.devdyna.fertilizer.Main;
import com.devdyna.fertilizer.builder.SpecialBoneMeal;
import com.devdyna.fertilizer.builder.VanillaBoneMeal;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class Items {

    public static void register(IEventBus bus) {
        // BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Main.MODID);

    public static final DeferredItem<Item> FERTILIZER = ITEMS.register("fertilizer",
            () -> new VanillaBoneMeal(new Item.Properties()));

    public static final DeferredItem<Item> FLOREAL_FERTILIZER = ITEMS.register("floreal",
            () -> new SpecialBoneMeal(new Item.Properties(), "floreal", new int[] { 3, 3, 3 }, 7,
                    SoundEvents.BARREL_OPEN, ParticleTypes.ENCHANT, BlockTags.ANVIL, null, null));

}
