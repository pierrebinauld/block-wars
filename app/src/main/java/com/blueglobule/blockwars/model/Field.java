package com.blueglobule.blockwars.model;

import java.util.LinkedList;

public class Field extends LinkedList<LinkedList<Block>> {

    private int width;
    private int height;
    private int threshold;

    public Field(int width, int height, int threshold) {
        this.width = width;
        this.height = height;
        this.threshold = threshold;

        if(threshold > height) {
            threshold = height;
        }

        for(int x=0; x<width; x++) {
            LinkedList<Block> column = new LinkedList<Block>();
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
