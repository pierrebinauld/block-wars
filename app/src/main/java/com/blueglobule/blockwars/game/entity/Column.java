package com.blueglobule.blockwars.game.entity;

import java.util.Collections;
import java.util.LinkedList;

public class Column extends LinkedList<Block> {

    private Field field;
    private int x;

    private int top;
    private int floor;

    public Block retrieve(float altitude) {
        if (altitude < top) {
            return get((int) Math.floor(altitude));
        } else { //TODO: Could improve with ship enhancement
            Block block;
            int altitudeRounded = (int) Math.floor(altitude);
            int size = size();
            for (int i = top; i < altitudeRounded && i < size; i++) {
                block = get(i);
                if (altitude >= block.altitude() && altitude <= block.altitude() + 1) {
                    return block;
                }
            }
        }
        return null;
    }

    @Override
    public boolean add(Block block) {
        block.setX(x);
        block.setY(size());
        return super.add(block);
    }

    public void land(Block block) {
        block.land(top);
//        field.addMovedBlock(block);
        top++;
    }

    public int top() {
        return top;
    }

    public int floor() {
        return floor;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
