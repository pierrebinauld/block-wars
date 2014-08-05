package com.blueglobule.blockwars.game.entity;


import java.util.HashMap;
import java.util.Map;

public class Rule {

    long blockGenerationPeriod;

    int columnCount;
    int columnSize;
    float gravity;

    Map<Block.Type, Integer> availableBlocks;

    public Rule() {
        this.availableBlocks = new HashMap<Block.Type, Integer>();
    }

    public Rule addAvailableBlock(Block.Type block, Integer probability) {
        availableBlocks.put(block, probability);
        return this;
    }

    public Map<Block.Type, Integer> getAvailableBlocks() {
        return availableBlocks;
    }

    public long getBlockGenerationPeriod() {
        return blockGenerationPeriod;
    }

    public float getGravity() {
        return gravity;
    }

    public Rule setGravity(float gravity) {
        this.gravity = gravity;
        return this;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public int getColumnSize() {
        return columnSize;
    }

    public Rule setBlockGenerationPeriod(long blockGenerationPeriod) {
        this.blockGenerationPeriod = blockGenerationPeriod;
        return this;
    }

    public Rule setColumnCount(int columnCount) {
        this.columnCount = columnCount;
        return this;
    }

    public Rule setColumnSize(int columnSize) {
        this.columnSize = columnSize;
        return this;
    }
}
