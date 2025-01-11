package com.devdyna.fertilizer.core.Utils;

public class IDUtil {
    public static String getModName(String traslationName) {
        String[] parts = traslationName.split("\\.");
        if (parts.length >= 2) {
            return parts[1];
        } else {
            return null;
        }
    }
}
