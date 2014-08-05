package com.blueglobule.blockwars.game.entity;

import java.util.ArrayList;

public class Field extends ArrayList<Column> {

    private int columnSize;

    public Field(Rule rule) {
        this.columnSize = rule.columnSize;

        for(int x=0; x<rule.columnCount; x++) {
            Column column = new Column();
            this.add(column);
        }
    }

    public int height() {
        return columnSize;
    }
}
