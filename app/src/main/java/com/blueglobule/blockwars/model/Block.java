package com.blueglobule.blockwars.model;

import com.blueglobule.blockwars.R;

public class Block {

    public enum Type {
        RED(R.drawable.red_block),
        GREEN(R.drawable.green_block),
        BLUE(R.drawable.blue_block),
        ORANGE(R.drawable.orange_block),
        FIRED(R.drawable.fired_block);

        private int id;

        private Type(int id) {
            this.id = id;
        }

        public int id() {
            return id;
        }
    }

    public enum State {
        IDLE,
        FIRED
    }

    private int altitude;
    private Type type;
    private State state;

    public Block(Type type) {
        this.altitude = 0;
        this.type = type;
        this.state = State.IDLE;
    }

    public int altitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
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
}
