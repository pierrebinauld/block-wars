package com.blueglobule.blockwars.game.entity.factory;

import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Rule;
import com.blueglobule.blockwars.locator.ThemeLocator;

public class BlockFactory extends ThemeLocator {

    private Block prototype;

    public BlockFactory(Block prototype) {
        this.prototype = prototype;
    }

    public BlockFactory(Rule rule) {

        prototype = new Block(null);
        prototype.setState(Block.State.IDLE);

        prototype.setAcceleration(rule.getGravity());
        prototype.setSpeed(0);
        prototype.setAltitude(rule.getColumnSize() + 1);
    }

    public Block build(Block.Type type) {
        Block block = prototype.clone();
        return transform(block, type);
    }

    public Block transform(Block block, Block.Type type) {
        block.setType(type);
        block.setDrawable(ThemeLocator.getTheme().getDrawableBlock(type));
        return block;
    }

    public void setPrototype(Block prototype) {
        this.prototype = prototype;
    }
}
