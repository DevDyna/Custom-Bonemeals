package com.devdyna.fertilizer.core.Utils;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Constants {

        @SuppressWarnings("unchecked")
        public static final DeferredItem<Item>[] AllDeferredItem() {
                Field[] fields = com.devdyna.fertilizer.core.Items.class.getDeclaredFields();
                List<DeferredItem<Item>> list = new ArrayList<>();
                for (Field field : fields) {
                        try {
                                if (java.lang.reflect.Modifier.isPublic(field.getModifiers()) &&
                                                java.lang.reflect.Modifier.isStatic(field.getModifiers()) &&
                                                java.lang.reflect.Modifier.isFinal(field.getModifiers()) &&
                                                field.getType().equals(DeferredItem.class)) {
                                        Object value = field.get(null);
                                        list.add((DeferredItem<Item>) value);
                                }
                        } catch (Exception e) {
                        }
                }

                return (DeferredItem<Item>[]) list.toArray();
        };

}
