package com.blueglobule.blockwars.game.entity;

import java.util.Collections;
import java.util.LinkedList;

public class Column extends LinkedList<Block> {

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

//    public int retrieveIndex(float altitude) {
//        if (altitude < top) {
//            return (int) Math.floor(altitude);
//        } else { //TODO: Could improve with ship enhancement
//            Block block;
//            int altitudeRounded = (int) Math.floor(altitude);
//            int size = size();
//            for (int i = top; i < altitudeRounded && i < size; i++) {
//                block = get(i);
//                if (altitude >= block.altitude() && altitude <= block.altitude() + 1) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }

//    public Selection retrieve(float altitude) {
//        if (altitude < top) {
//            int index = (int) Math.top(altitude);
//            return new Selection(this, index, get(index));
//            return (int) Math.top(altitude);
//        } else { //TODO: Could improve with ship enhancement
//            Block block;
//            int altitudeRounded = (int) Math.top(altitude);
//            int size = size();
//            for (int i = top; i < altitudeRounded && i < size; i++) {
//                block = get(i);
//                if (altitude >= block.altitude() && altitude <= block.altitude() + 1) {
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }

    public int top() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void land(Block block) {
        block.land(top);
        top++;
    }

    public void pushUp(int index) {
        int size = size();
        if (size == index || size < 2) {
            return;
        }
        Collections.swap(this, index, index + 1);

        Block block;
        block = get(index);
        block.setAltitude(block.altitude() - 1);

        block = get(index + 1);
        block.setAltitude(block.altitude() + 1);
    }

    public void pushDown(int index) {
        if (0 == index || size() < 2) {
            return;
        }
        Collections.swap(this, index, index - 1);

        Block block;
        block = get(index);
        block.setAltitude(block.altitude() + 1);

        block = get(index - 1);
        block.setAltitude(block.altitude() - 1);
    }
}
