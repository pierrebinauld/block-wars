package com.blueglobule.blockwars.game.entity;


public class Selection {

    private Column column;

    private int blockIndex;
    private Block block;

    public Selection(Column column, int blockIndex, Block block) {
        this.column = column;
        this.blockIndex = blockIndex;
        this.block = block;
    }

    public Column column() {
        return column;
    }

    public void setColumn(Column column) {
        this.column = column;
    }

    public int blockIndex() {
        return blockIndex;
    }

    public void setBlockIndex(int blockIndex) {
        this.blockIndex = blockIndex;
    }

    public Block block() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
