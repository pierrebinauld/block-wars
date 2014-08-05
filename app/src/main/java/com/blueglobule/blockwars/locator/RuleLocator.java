package com.blueglobule.blockwars.locator;

import com.blueglobule.blockwars.game.entity.Rule;

public class RuleLocator {

    private static Rule rule;

    public static Rule getRule() {
        return rule;
    }

    public static void provide(Rule rule) {
        RuleLocator.rule = rule;
    }
}
