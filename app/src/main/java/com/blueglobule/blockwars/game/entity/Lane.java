package com.blueglobule.blockwars.game.entity;

import java.util.LinkedList;
import java.util.Queue;

/**
 * A field lane which contain several column. Column belongs to a ship except the first one.
 */
public class Lane extends Runway<Column> {

    private int x;
    private Field field;

//    private Queue<Column> removes = new LinkedList<Column>();

    public Lane() {
        this.add(new Column(this, 0));
    }

    public Block retrieve(float altitude) {
        for (Column column : this) {
            if(column.floorAltitude() > altitude) {
                return null;
            } else if(column.topAltitude() >= altitude) {
                return column.retrieve(altitude);
            }
        }

        return null;
    }

//    public void addToRemoves(Column column) {
//        removes.add(column);
//    }
//
//    public void processRemoves() {
//        for(Column column : removes) {
//            this.remove(column);
//        }
//    }

    public Column spawn(Block block) {
        Column column = new Column(this, get(size()-1).top());
        column.add(block);
        this.add(column);
        return column;
    }

    public Column buildColumn(Block block) {
        Column column = block.column();
        if(column.floor() == block.y()) {
            return column;
        } else {
            Column result = new Column(this, block.y());
            result.setMovement(column.movement());

            int index = block.y();
            while(column.size() > index) {
                result.add(column.get(index));
                column.remove(index);
            }

            int y = column.y()+1;
            this.add(y, result);
            result.setY(y);
            return result;
        }
    }

    @Override
    public Column land(Column column) {
        column.setAltitude(0f);
        column.setMovement(Column.Movement.LANDED);

        return column;
    }

    @Override
    public float landingAltitude() {
        return 0f;
    }

    public float topAltitude() {
        return get(size()-1).topAltitude();
    }

    @Override
    public boolean add(Column column) {
        column.setY(size());
        return super.add(column);
    }

    @Override
    public void add(int location, Column column) {
        column.setY(location);
        super.add(location, column);
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


}
