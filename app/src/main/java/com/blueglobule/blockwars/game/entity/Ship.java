package com.blueglobule.blockwars.game.entity;

import java.util.ArrayList;

public class Ship extends ArrayList<Column> {

    private int width;
    private int height;
    private int threshold;

    public Ship(int width, int height, int threshold) {
        this.width = width;
        this.height = height;
        this.threshold = threshold;

        if (threshold > height) {
            threshold = height;
        }

        for (int x = 0; x < width; x++) {

            Column column = new Column();
            this.add(column);
        }
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }

    public int threshold() {
        return threshold;
    }
}
