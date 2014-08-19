package com.blueglobule.blockwars.game.entity;

import java.util.ArrayList;

public class Column implements Comparable<Column> {

    private ArrayList<Block> lane;

    private int x;

    private int top;
    private int floor;

    private float altitude;


    public Column(Lane lane) {
        this.lane = lane;
    }

    public Block retrieve(float altitude) {
//        if (altitude < top) {
//            return lane.get((int) Math.floor(altitude));
//        } else { //TODO: Could improve with ship enhancement
//            Block block;
//            int altitudeRounded = (int) Math.floor(altitude);
//            int size = lane.size();
//            for (int i = top; i < altitudeRounded && i < size; i++) {
//                block = lane.get(i);
//                if (altitude >= block.altitude() && altitude <= block.altitude() + 1) {
//                    return block;
//                }
//            }
//        }
//        return null;

        float relativeAltitude = altitude - this.altitude;
        int relativeIndex = (int) Math.floor(relativeAltitude);
        int index = relativeIndex + floor;
        return lane.get(index);
    }

    public void land(Block block) {
        block.land(this);
//        field.addMovedBlock(block);
        top++;
    }

    public int top() {
        return top;
    }

    public int floor() {
        return floor;
    }

    public float altitude() {
        return altitude;
    }

    public float topAltitude() {
        return altitude + (top - floor) * Field.UNIT;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public void setX(int x) {
        this.x = x;
    }


    @Override
    public int compareTo(Column another) {
        return another.floor - floor;
    }
}
