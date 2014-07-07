package com.blueglobule.blockwars.Model;

public class Game {

    private Field field;

    public Game(int width, int height) {
        this.field = new Field(width, height);
    }

    public Field getField() {
        return field;
    }
}
