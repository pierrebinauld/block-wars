package com.blueglobule.blockwars.game.entity;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * A field lane which contain several column. Column belongs to a ship except the first one.
 */
public class Lane extends ArrayList<Block> {

    private int x;
    private Field field;

    private TreeSet<Column> columns = new TreeSet<Column>();

    public Lane() {
        columns.add(new Column(this));
    }

    public Block retrieve(float altitude) {
        for (Column column : columns) {
            if(column.floor() > altitude) {
                return null;
            } else if(column.top() >= altitude) {
                return column.retrieve(altitude);
            }
        }

        return null;
    }

    @Override
    public boolean add(Block block) {
        block.setX(x);
        block.setY(size());
        return super.add(block);
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public TreeSet<Column> getColumns() {
        return columns;
    }
}
