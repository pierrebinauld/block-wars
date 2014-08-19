package com.blueglobule.blockwars.game.entity;


import java.util.ArrayList;
import java.util.List;

public class Rule {

    private long blockGenerationPeriod;
    private int initialLayerBlockCount;

    private int laneCount;
    private int laneSize;
    private float gravity;

    private int firedBlockCount;
    private List<Block.Type> probabilityTypes = new ArrayList<Block.Type>();

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

    public int getLaneCount() {
        return laneCount;
    }

    public int getLaneSize() {
        return laneSize;
    }

    public int getInitialLayerBlockCount() {
        return initialLayerBlockCount;
    }

    public Rule setBlockGenerationPeriod(long blockGenerationPeriod) {
        this.blockGenerationPeriod = blockGenerationPeriod;
        return this;
    }

    public Rule setLaneCount(int laneCount) {
        this.laneCount = laneCount;
        return this;
    }

    public Rule setLaneSize(int laneSize) {
        this.laneSize = laneSize;
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
