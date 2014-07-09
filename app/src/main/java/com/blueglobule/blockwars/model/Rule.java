package com.blueglobule.blockwars.model;


import java.util.HashMap;
import java.util.Map;

public class Rule {

    private float gravity;
    private Map<Block.Type, Integer> availableBlocks;

    public Rule(float gravity) {
        this.gravity = gravity;
        this.availableBlocks = new HashMap<Block.Type, Integer>();
    }

    public void addAvailableBlock(Block.Type block, Integer probability) {
        availableBlocks.put(block, probability);
    }

    public Map<Block.Type, Integer> getAvailableBlocks() {
        return availableBlocks;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }
}
