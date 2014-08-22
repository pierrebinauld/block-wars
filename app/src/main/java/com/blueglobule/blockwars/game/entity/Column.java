package com.blueglobule.blockwars.game.entity;

import android.util.Log;

public class Column extends Runway<Block> {

    private Lane lane;

    private int y;
    private int floor;

    private Movement movement;
    private boolean movementHasChanged;

    private boolean isLanded;
    private int impulsion;
    private float acceleration;
    private float speed;
    private float minSpeedLimit;


    public Column(Lane lane, int floor) {
        this.lane = lane;
        this.floor = floor;
        this.movementHasChanged = false;
    }

    public Block retrieve(float altitude) {

        float relativeAltitude = altitude - this.floorAltitude();
        int index = (int) Math.floor(relativeAltitude);
        return get(index);
    }

    @Override
    public boolean add(Block block) {
        block.setY(this.size());
        block.setColumn(this);
        return super.add(block);
    }

    @Override
    public Column land(Column column) {
        float altitude = this.topAltitude();
        for(Block block : column) {
            this.add(block);
            block.setAltitude(altitude);
            altitude += Field.UNIT;
        }
        this.lane.remove(column);

        return this;
    }

    @Override
    public float landingAltitude() {
        return topAltitude();
    }

    public void move() {
        speed += acceleration;
        if(speed < minSpeedLimit) {
            speed = minSpeedLimit;
        }

        for(Block block : this) {
            block.addAltitude(speed);
////        field.addMovedBlock(block);
        }
    }

    public Lane lane() {
        return lane;
    }

    public int floor() {
        return floor;
    }

    public int top() {
        return floor + size();
    }

    public float floorAltitude() {
        if (0 == size()) {
            return floor;
        } else {
            return get(0).altitude();
        }
    }

    public float topAltitude() {
        if (0 == size()) {
            return floor;
        } else {
            return get(size() - 1).altitude() + Field.UNIT;
        }
    }

    public boolean isLanded() {
        return isLanded;
    }

    public void setLanded(boolean isLanded) {
        this.isLanded = isLanded;
    }


    public void impulse() {
        this.impulsion++;
    }

    public int impulsion() {
        return impulsion;
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

    public void setAltitude(float altitude) {
        for(Block block : this) {
            block.setAltitude(altitude);
            altitude += Field.UNIT;
        }
    }

    public int y() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void incrementY() {
        this.y ++;
    }

    public Movement movement() {
        return movement;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
        this.movementHasChanged = true;
    }

    public void movementChangementPerformed() {
        movementHasChanged = false;
    }

    public boolean movementHasChanged() {
        return movementHasChanged;
    }

    public void setMinSpeedLimit(float minSpeedLimit) {
        this.minSpeedLimit = minSpeedLimit;
    }

    public float minSpeedLimit() {
        return minSpeedLimit;
    }

    public enum Movement {
        LANDED,
        FALLING,
        LAUNCHING,
        FLYING
    }
}
