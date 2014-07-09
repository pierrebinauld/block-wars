package com.blueglobule.blockwars.engine.physic.builders;

import android.util.Log;

import com.blueglobule.blockwars.model.Block;
import com.blueglobule.blockwars.model.Field;
import com.blueglobule.blockwars.model.Game;

import java.util.List;

public class GameBuilder {

    private RuleBuilder ruleBuilder;
    private BlockBuilder blockBuilder;


    public GameBuilder() {
        ruleBuilder = new RuleBuilder();
        blockBuilder = new BlockBuilder(ruleBuilder.buildRule());
    }

    public Game buildGame() {

        int width = 8;
        int height = 8;
        int threshold = 6;

        Field field = new Field(width, height ,threshold);
        for(int x=0; x<width; x++) {
            List<Block> column = field.get(x);
            Block block = blockBuilder.buildRandomBlock();
            block.setAltitude(0);
            column.add(block);
        }

        Game game = new Game(field);

        return game;
    }
}
