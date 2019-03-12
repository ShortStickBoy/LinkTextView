package com.sunzn.text.library;

import android.graphics.Color;

public class LinkHelper {

    public static int getColor(String color) {
        return Color.parseColor(color);
    }

    public static int getLength(String value) {
        return value == null ? 0 : value.length();
    }

    public static String getValue(String value) {
        return value == null ? "" : value;
    }

}
