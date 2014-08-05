package com.blueglobule.blockwars.game.entity;

import java.util.LinkedList;

public class Column extends LinkedList<Block> {

    private int ground = 0;

    public int ground() {
        return ground;
    }

    public void setGround(int ground) {
        this.ground = ground;
    }
}
