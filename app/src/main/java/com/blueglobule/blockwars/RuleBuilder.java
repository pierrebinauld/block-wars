package com.blueglobule.blockwars;

import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Rule;

public class RuleBuilder {

    public Rule build() {
        return new Rule()
                .addAvailableBlock(Block.Type.ALPHA, 4)
                .addAvailableBlock(Block.Type.BETA, 1)
                .addAvailableBlock(Block.Type.GAMMA, 1)
                .addAvailableBlock(Block.Type.DELTA, 1)
                .setBlockGenerationPeriod(2000)
                .setInitialLayerBlockCount(3)
                .setLaneCount(9)
                .setLaneSize(13)
                .setGravity(-0.005f)
                .setFiredBlockCount(3)
                .setTimeToResetShip(4000);
    }
}
