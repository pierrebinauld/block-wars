package com.blueglobule.blockwars.game.entity;

import com.blueglobule.blockwars.game.entity.factory.BlockFactory;

import java.util.ArrayList;

public class Field extends ArrayList<Column> {

    private int columnSize;

//    private boolean hasSelectedBlock = false;
//    private Block selectedBlock;
//    private int selectedBlockIndex;
//    private int selectedColumnIndex;

    private Selection selection;

    public Field(Rule rule) {
    }

    public void init(Rule rule) {
        this.columnSize = rule.columnSize;

        for (int x = 0; x < rule.columnCount; x++) {
            Column column = new Column();
            this.add(column);
        }
    }

    public int height() {
        return columnSize;
    }

//    public Block selectedBlock() {
//        return selectedBlock;
//    }
//
//    public int selectedBlockIndex() {
//        return selectedBlockIndex;
//    }
//
//    public int selectedColumnIndex() {
//        return selectedColumnIndex;
//    }

//    public void selectBlock(int selectedColumnIndex, int selectedBlockIndex) {
//        this.hasSelectedBlock = true;
//        this.selectedColumnIndex = selectedColumnIndex;
//        this.selectedBlockIndex = selectedBlockIndex;
//    }

//    public void selectBlock(Block block) {
//        selectedBlock = block;
//        selectedBlock.setSelected(true);
//        hasSelectedBlock = true;
//    }
//
//    public void unselectBlock() {
//        selectedBlock.setSelected(false);
//        selectedBlock = null;
//        hasSelectedBlock = false;
//    }

//    public boolean hasSelectedBlock() {
//        return hasSelectedBlock;
//    }

    public void select(Column column, int blockIndex) {
        if(column.size() > blockIndex) {
            Block block = column.get(blockIndex);
            block.setSelected(true);
            selection = new Selection(column, blockIndex, block);
        }
    }

    public void unselect() {
        if(hasSelection()) {
            selection.block().setSelected(false);
            selection = null;
        }
    }

    public boolean hasSelection() {
        return null != selection;
    }

    public Selection selection() {
        return selection;
    }
}
