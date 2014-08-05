package com.blueglobule.blockwars.locator;

import com.blueglobule.blockwars.game.theme.Theme;

public class ThemeLocator {

    private static Theme theme;

    public static Theme getTheme() {
        return theme;
    }

    public static void provide(Theme theme) {
        ThemeLocator.theme = theme;
    }
}
