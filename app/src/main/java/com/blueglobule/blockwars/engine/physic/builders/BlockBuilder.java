package com.blueglobule.blockwars.engine.physic.builders;

import com.blueglobule.blockwars.model.Block;
import com.blueglobule.blockwars.model.Field;
import com.blueglobule.blockwars.model.Rule;

import java.util.Map;

public class BlockBuilder {

    private Rule rule;

    public BlockBuilder(Rule rule) {
        this.rule = rule;
    }

    public Block buildRandomBlock() {

        Map<Block.Type, Integer> availableBlocks = rule.getAvailableBlocks();
        int availableBlockCount = availableBlocks.size();

        int rand = (int) Math.floor(Math.random() * availableBlockCount);

        Object[] blockTypes = availableBlocks.keySet().toArray();

        Block block = new Block((Block.Type) blockTypes[rand]);

        return block;
    }

    public Block buildRandomBlock(Field field, int x, int y) {
        return null;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }
}
