package com.blueglobule.blockwars.game.entity;

import android.graphics.drawable.Drawable;

public class Block {

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

    private State state;
    private Type type;
    private Drawable drawable;

    private float acceleration;
    private float speed;
    private float altitude;

    public Block(Type type) {
        this.drawable = null;
        this.type = type;
        this.state = State.IDLE;

        this.acceleration = 0;
        this.speed = 0;
        this.altitude = 0;
    }

    public Block clone() {
        Block clone = new Block(type);

        clone.setState(state);
        clone.setDrawable(drawable);

        clone.setAcceleration(acceleration);
        clone.setSpeed(speed);
        clone.setAltitude(altitude);

        return clone;
    }

    public void move() {
        speed += acceleration;
        altitude += speed;
    }

    public void land(float altitude) {
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

    public float altitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
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
