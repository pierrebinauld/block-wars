package com.blueglobule.blockwars.game.entity;

import com.blueglobule.blockwars.game.entity.factory.BlockFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Field extends ArrayList<Column> {

    public static float UNIT = 1f;

    private int columnSize;

    private Column selectedColumn;
    private Block selectedBlock;

    private Queue<Block> movedBlocks = new LinkedList<Block>();

    public Field() {
    }

    public void init(Rule rule) {
        this.columnSize = rule.columnSize;

        for (int x = 0; x < rule.columnCount; x++) {
            Column column = new Column();
            this.add(column);
        }
    }

    @Override
    public boolean add(Column column) {
        column.setX(size());
        column.setField(this);
        return super.add(column);
    }

    public int height() {
        return columnSize;
    }

    public Block selectedBlock() {
        return selectedBlock;
    }

    public Column selectedColumn() {
        return selectedColumn;
    }

    public void select(Column column, Block block) {
        selectedBlock = block;
        selectedColumn = column;
        selectedBlock.setSelected(true);
    }

    public void select(int columnIndex, float altitude) {
        Column column = get(columnIndex);
        Block block = column.retrieve(altitude);

        if(null != block) {
            selectedBlock = block;
            selectedColumn = column;
            selectedBlock.setSelected(true);
        }
    }

    public void unselect() {
        if(hasSelection()) {
            selectedBlock.setSelected(false);
            selectedColumn = null;
            selectedBlock = null;
        }
    }


    public void slide(Block block, int step) {
        int nextPosition = block.y() + step;
        Column column = get(block.x());

        int size = column.size();
        if (nextPosition < 0 || nextPosition >= size) {
            return;
        }

        Block otherBlock = column.get(nextPosition);
        float nextAltitude = otherBlock.altitude();
        otherBlock.setAltitude(block.altitude());
        otherBlock.setY(block.y());
        this.addMovedBlock(otherBlock);

        block.setAltitude(nextAltitude);
        block.setY(nextPosition);
        this.addMovedBlock(block);


        Collections.swap(column, block.y(), otherBlock.y());
    }

    public boolean hasSelection() {
        return null != selectedBlock;
    }

    public Queue<Block> getMovedBlocks() {
        return movedBlocks;
    }

    public void addMovedBlock(Block block) {
        movedBlocks.add(block);
    }
}
