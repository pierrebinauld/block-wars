package com.blueglobule.blockwars.game.entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Rule {

    long blockGenerationPeriod;
    int initialLayerBlockCount;

    int columnCount;
    int columnSize;
    float gravity;

    private int firedBlockCount;
    List<Block.Type> probabilityTypes = new ArrayList<Block.Type>();
//    Map<Block.Type, Integer> availableBlocks = new HashMap<Block.Type, Integer>();

    public Rule addAvailableBlock(Block.Type block, Integer probability) {
//        availableBlocks.put(block, probability);
        for (int i=0;i<probability;i++) {
            probabilityTypes.add(block);
        }
        return this;
    }

    public List<Block.Type> getProbabilityTypes() {
        return probabilityTypes;
    }

//    public Map<Block.Type, Integer> getAvailableBlocks() {
//        return availableBlocks;
//    }

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

    public int getInitialLayerBlockCount() {
        return initialLayerBlockCount;
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

    public Rule setInitialLayerBlockCount(int initialLayerBlockCount) {
        this.initialLayerBlockCount = initialLayerBlockCount;
        return this;
    }

    public int getFiredBlockCount() {
        return firedBlockCount;
    }

    public Rule setFiredBlockCount(int firedBlockCount) {
        this.firedBlockCount = firedBlockCount;
        return this;
    }
}
