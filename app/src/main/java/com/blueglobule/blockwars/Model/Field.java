package com.blueglobule.blockwars.Model;

import java.util.LinkedList;

public class Field extends LinkedList<LinkedList<Block>> {

    private int width;
    private int height;

    public Field(int width, int height) {
        this.width = width;
        this.height = height;

        for(int x=0; x<width; x++) {
            LinkedList<Block> column = new LinkedList<Block>();
            column.add(new Block(Block.Type.RED));
            this.add(column);
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
