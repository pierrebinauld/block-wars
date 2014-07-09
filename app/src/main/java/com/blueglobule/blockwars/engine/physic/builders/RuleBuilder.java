package com.blueglobule.blockwars.engine.physic.builders;

import com.blueglobule.blockwars.model.Block;
import com.blueglobule.blockwars.model.Rule;

public class RuleBuilder {

    public Rule buildRule() {
        Rule rule = new Rule(1);

        rule.addAvailableBlock(Block.Type.BLUE, 1);
        rule.addAvailableBlock(Block.Type.GREEN, 1);
        rule.addAvailableBlock(Block.Type.ORANGE, 1);
        rule.addAvailableBlock(Block.Type.RED, 1);
        rule.addAvailableBlock(Block.Type.FIRED, 1);

        return rule;
    }
}
