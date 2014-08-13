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

    // May i have to put this in field ?
    public void pushUp(int index) {
        int size = size();
        if (size == index || size < 2) {
            return;
        }
        Collections.swap(this, index, index + 1);

        Block block;
        block = get(index);
        block.setAltitude(block.altitude() - 1);
        block.setY(index);
        field.addMovedBlock(block);

        block = get(index + 1);
        block.setAltitude(block.altitude() + 1);
        block.setY(index + 1);
        field.addMovedBlock(block);
    }

    // May i have to put this in field ?
    public void pushDown(int index) {
        if (0 == index || size() < 2) {
            return;
        }
        Collections.swap(this, index, index - 1);

        Block block;
        block = get(index);
        block.setAltitude(block.altitude() + 1);
        block.setY(index);
        field.addMovedBlock(block);

        block = get(index - 1);
        block.setAltitude(block.altitude() - 1);
        block.setY(index - 1);
        field.addMovedBlock(block);

    }

    public int top() {
        return top;
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
