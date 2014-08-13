package com.blueglobule.blockwars.game.component.physics;

import android.util.Log;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;

import java.util.List;
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

    private void operateLaunching(Field field, Block block) {
        if(Block.State.FIRED != block.state()) {
            int x = block.x();
            int y = block.y();

            Block.Type type = block.type();
            int x1 = horizontalLookUpFor(field, type, x, y, -1);
            int x2 = horizontalLookUpFor(field, type, x, y, 1);

            int y1 = y;
            int y2 = y;

            if(x2 - x1 >= 3 - 1) { // Magic number !
                for(int i=x1; i<x2+1; i++) {
                    field.get(i).get(y).setState(Block.State.FIRED);
                }
            }
        }
    }

    private int horizontalLookUpFor(Field field, Block.Type type, int x, int y, int step) {
        int result = x;
        boolean run = true;

        do {
            if(result+step < 0 || result+step >= field.size()) {
                run = false;
            } else {
                Column column = field.get(result+step);
                if(y >= column.size() || Block.State.FIRED == column.get(y).state() || column.get(y).type() != type) {
                    run = false;
                } else {
                    result += step;
                }
            }
        } while(run);

        return result;
    }

}
