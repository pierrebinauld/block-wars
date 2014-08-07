package com.blueglobule.blockwars.game.entity;

import android.util.Log;

import java.util.LinkedList;

public class Column extends LinkedList<Block> {

    private int ground = 0;

    public Block retrieve(float altitude) {
        if (altitude < ground) {
            return get((int) Math.floor(altitude));
        } else {
            Block block;
            int altitudeRounded = (int) Math.floor(altitude);
            int size = size();
            for (int i = ground; i < altitudeRounded && i < size; i++) {
                block = get(i);
                if (altitude >= block.altitude() && altitude <= block.altitude() + 1) {
                    return block;
                }
            }
        }
        return null;
    }

    public int ground() {
        return ground;
    }

    public void setGround(int ground) {
        this.ground = ground;
    }
}
