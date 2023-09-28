package com.study.effective.chapter01.item01;

public class ColorDark {
    private final boolean isDark;
    private final String color;
    private static final ColorDark darkMode = new ColorDark();
    private ColorDark() {
        this.isDark = true;
        this.color = "dark";
    }

    public boolean isDark() {
        return isDark;
    }

    public String getColor() {
        return color;
    }

    public static ColorDark getDarkStatus() {
        return darkMode;
    }
}
