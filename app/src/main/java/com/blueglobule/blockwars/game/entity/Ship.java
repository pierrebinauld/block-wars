package com.blueglobule.blockwars.game.entity;

import java.util.ArrayList;

public class Ship extends ArrayList<Column> {

    private boolean isLanded;
    private float acceleration;
    private float speed;

    public Ship() {
        this.isLanded = false;
        this.acceleration = 0;
        this.speed = 0;
    }

    public void impulse(float impulse) {
        acceleration += impulse;
    }

    public void move() {
//        speed += acceleration;
//
//        for (Column column : this) {
//            Lane lane = column.lane();
//            for (int i = column.floor(); i < column.top(); i++) {
//                lane.get(i).addAltitude(speed);
//            }
//        }
    }

    @Override
    public boolean add(Column column) {
        return super.add(column);
    }

    public boolean isLanded() {
        return isLanded;
    }

    public void setLanded(boolean isLanded) {
        this.isLanded = isLanded;
    }

    public float acceleration() {
        return acceleration;
    }

    public void setAcceleration(float acceleration) {
        this.acceleration = acceleration;
    }

    public float speed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
