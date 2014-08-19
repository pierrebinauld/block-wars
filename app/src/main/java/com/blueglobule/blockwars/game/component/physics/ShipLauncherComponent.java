package com.blueglobule.blockwars.game.component.physics;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.Lane;

import java.util.Queue;

public class ShipLauncherComponent extends PhysicsComponent<Field> {

    @Override
    public void init(Field field) {

    }

    @Override
    public void update(Field field) {
        Queue<Block> movedBlocks = field.getMovedBlocks();

        while(!movedBlocks.isEmpty()) {
            Block block = movedBlocks.poll();
            operateLaunching(field, block);
        }
    }

    /**
     * Search similar type block around a block in a field.
     * If there are enough similar block then create a Ship and fire !
     * @param field
     * @param block
     */
    private void operateLaunching(Field field, Block block) {
        if(Block.State.FIRED != block.state()) {

            int x1 = horizontalLookUpFor(field, block, -1);
            int x2 = horizontalLookUpFor(field, block, 1);

            int y1 = verticalLookUpFor(field, block, -1);
            int y2 = verticalLookUpFor(field, block, 1);

            if(x2 - x1 + 1 >= rule.getFiredBlockCount()) {
                if(block.isSelected()) {
                    field.unselect();
                }
                for(int i=x1; i<x2+1; i++) {
                    field.get(i).get(block.y()).setState(Block.State.FIRED);
                }
            }

            if(y2 - y1 + 1 >= rule.getFiredBlockCount()) {
                if(block.isSelected()) {
                    field.unselect();
                }
                Lane lane = field.get(block.x());
                for(int i=y1; i<y2+1; i++) {
                    lane.get(i).setState(Block.State.FIRED);
                }
            }
        }
    }

    private int horizontalLookUpFor(Field field, Block block, int step) {
        int result = block.x();

        boolean run = true;
        Block.Type type = block.type();
        int y = block.y();
        int nextStep = result + step;

        while(run) {
            if(nextStep < 0 || nextStep >= field.size()) {
                run = false;
            } else {
                Lane lane = field.get(nextStep);
                if (y >= lane.size() || Block.State.FIRED == lane.get(y).state() || lane.get(y).type() != type) {
                    run = false;
                } else {
                    result = nextStep;
                    nextStep += step;
                }
            }
        }

        return result;
    }

    private int verticalLookUpFor(Field field, Block block, int step) {
        int result = block.y();

        boolean run = true;
        Block.Type type = block.type();
        int nextStep = result + step;
        Lane lane = field.get(block.x());

        while(run) {
            if(nextStep < 0 || nextStep >= lane.size()) {
                run = false;
            } else {
                Block testedBlock = lane.get(nextStep);
                if (Block.State.FIRED == testedBlock.state() || testedBlock.type() != type) {
                    run = false;
                } else {
                    result = nextStep;
                    nextStep += step;
                }
            }
        }

        return result;
    }

}
