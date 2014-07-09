package com.blueglobule.blockwars.model;

public class Game {

    private Field field;

    public Game(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
