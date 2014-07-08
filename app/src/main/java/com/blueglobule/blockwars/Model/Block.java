package com.blueglobule.blockwars.Model;

import com.blueglobule.blockwars.R;

public class Block {

    public enum Type {
        RED(R.drawable.red_block),
        GREEN(R.drawable.green_block),
        BLUE(R.drawable.blue_block),
        ORANGE(R.drawable.orange_block);

        private int id;

        private Type(int id) {
            this.id = id;
        }

        public int id() {
            return id;
        }
    }

    public static final int SIZE = 100;

    private int altitude;
    private Type type;

    public Block(Type type) {
        this.altitude = 0;
        this.type = type;
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
}
