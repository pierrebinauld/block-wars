package com.blueglobule.blockwars.game.entity;

import java.util.LinkedList;

public class Column extends LinkedList<Block> {

    private Lane lane;

    private int y;
    private int floor;

    private Movement movement;
    private boolean movementHasChanged;

    private boolean isLanded;
    private float impulsion;
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

    public Column merge(Column column) {
        float altitude = this.topAltitude();
        for (Block block : column) {
            this.add(block);
            block.setAltitude(altitude);
            altitude += Field.UNIT;
        }
        this.lane.remove(column);

        return this;
    }

    public void move() {
        speed += acceleration;

        if (speed < minSpeedLimit) {
            speed = minSpeedLimit;
        }

        speed += impulsion;

        if (impulsion != 0) {
            impulsion = 0;
        }


        for (Block block : this) {
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

    public void impulse(float impulsion) {
        this.impulsion += impulsion;
    }

    public float impulsion() {
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
        for (Block block : this) {
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
        this.y++;
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
        LANDING,
        FALLING,
        LAUNCHING,
        FLYING
    }
}
