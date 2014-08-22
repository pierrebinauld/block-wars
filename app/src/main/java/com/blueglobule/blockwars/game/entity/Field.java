package com.blueglobule.blockwars.game.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Field extends ArrayList<Lane> {

    public static float UNIT = 1f;

    private int laneSize;

    private Block selectedBlock;

    private Queue<Block> movedBlocks = new LinkedList<Block>();

    private Set<Ship> ships = new HashSet<Ship>();

    public Field() {
    }

    public void init(Rule rule) {
        this.laneSize = rule.getLaneSize();

        for (int x = 0; x < rule.getLaneCount(); x++) {
            this.add(new Lane());
        }
    }

    @Override
    public boolean add(Lane lane) {
        lane.setX(size());
        lane.setField(this);
        return super.add(lane);
    }

    public boolean add(Ship ship) {
        return ships.add(ship);
    }

    public int height() {
        return laneSize;
    }

    public Block selectedBlock() {
        return selectedBlock;
    }

    public void select(int laneIndex, float altitude) {
        Lane lane = get(laneIndex);
        Block block = lane.retrieve(altitude);

        if(null != block) {
            selectedBlock = block;
            selectedBlock.setSelected(true);
        }
    }

    public void unselect() {
        if(hasSelection()) {
            selectedBlock.setSelected(false);
            selectedBlock = null;
        }
    }


    public void slide(Block block, int step) {
        int nextPosition = block.y() + step;
        Column column = block.column();

        int size = column.size();
        if (nextPosition < 0 || nextPosition >= size) {
            return;
        }

        Block otherBlock = column.get(nextPosition);
        float nextAltitude = otherBlock.altitude();
        otherBlock.setAltitude(block.altitude());
        otherBlock.setY(block.y());

        block.setAltitude(nextAltitude);
        block.setY(nextPosition);

        Collections.swap(column, block.y(), otherBlock.y());

        if(block.y() < otherBlock.y()) {
            this.addMovedBlock(block);
            this.addMovedBlock(otherBlock);
        } else {
            this.addMovedBlock(otherBlock);
            this.addMovedBlock(block);
        }
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

    public Set<Ship> getShips() {
        return ships;
    }
}
