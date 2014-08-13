package com.blueglobule.blockwars.game.entity;

import android.graphics.drawable.Drawable;

public class Block {

    private int x;
    private int y;

    private State state;
    private Type type;
    private Drawable drawable;

    private boolean isLanded;
    private float acceleration;
    private float speed;
    private float altitude;

    private boolean isSelected;
    private float selectedAltitude;

    public Block(Type type) {
        this.x = 0;
        this.y = 0;

        this.drawable = null;
        this.type = type;
        this.state = State.IDLE;

        this.isLanded = false;
        this.acceleration = 0;
        this.speed = 0;
        this.altitude = 0;

        this.isSelected = false;
        this.selectedAltitude = 0;
    }

    public Block clone() {
        Block clone = new Block(type);

        clone.setX(x);
        clone.setY(y);

        clone.setState(state);
        clone.setDrawable(drawable);

        clone.setLanded(isLanded);
        clone.setAcceleration(acceleration);
        clone.setSpeed(speed);
        clone.setAltitude(altitude);

        clone.setSelected(isSelected);
        clone.setSelectedAltitude(selectedAltitude);

        return clone;
    }

    public void move() {
        speed += acceleration;
        altitude += speed;
    }

    public void land(float altitude) {
        this.isLanded = true;
        this.acceleration = 0;
        this.speed = 0;
        this.altitude = altitude;
    }

    public Drawable getDrawable() {
        return drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
    }

    public Type type() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public State state() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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

    public float altitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Float selectedAltitude() {
        return selectedAltitude;
    }

    public void setSelectedAltitude(float selectedAltitude) {
        this.selectedAltitude = selectedAltitude;
    }

    public float displayAltitude() {
        return isSelected?selectedAltitude:altitude;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int x() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int y() {
        return y;
    }

    public enum Type {
        ALPHA,
        BETA,
        GAMMA,
        DELTA/*,
        EPSILON,
        DZETA,
        ...*/;
    }

    public enum State {
        IDLE,
        FIRED
    }
}
