package com.blueglobule.blockwars.game.entity;

import android.graphics.drawable.Drawable;

public class Block {

    private int x;
    private int y;
    private Column column;

    private State state;
    private Type type;
    private Drawable drawable;

    private float altitude;

    private boolean isSelected;
    private float selectedAltitude;

    public Block(Type type) {
        this.x = 0;
        this.y = 0;

        this.drawable = null;
        this.type = type;
        this.state = State.IDLE;

        this.altitude = 0;

        this.isSelected = false;
        this.selectedAltitude = 0;
    }

    public Block clone() {
        Block clone = new Block(type);

        clone.setX(x);
        clone.setY(y);
        clone.setColumn(column);

        clone.setState(state);
        clone.setDrawable(drawable);

        clone.setAltitude(altitude);

        clone.setSelected(isSelected);
        clone.setSelectedAltitude(selectedAltitude);

        return clone;
    }

    public void land(Column column) {
        this.column = column;
        this.y = this.column.size();
        this.column.add(this);
        this.altitude = column.topAltitude();
    }

    public boolean belongsToColumn() {
        return null != column;
    }

    public Drawable drawable() {
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

    public float altitude() {
        return altitude;
    }

    public void addAltitude(float altitude) {
        this.altitude += altitude;
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

    public void setColumn(Column column) {
        this.column = column;
    }

    public Column column() {
        return column;
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
