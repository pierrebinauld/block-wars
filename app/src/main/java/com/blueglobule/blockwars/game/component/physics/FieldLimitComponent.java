package com.blueglobule.blockwars.game.component.physics;


import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.Lane;

public class FieldLimitComponent extends PhysicsComponent<Field> {

    @Override
    public void init(Field field) {

    }

    @Override
    public void update(Field field) {
        for (Lane lane : field) {
            for (int i = lane.size() - 1; i >= 0; i--) {
                Column column = lane.get(i);
                if(column.movement() != Column.Movement.FALLING) {
                    if (column.topAltitude() <= rule.getLaneSize() + 1) { //TODO: Magic Number !
                        break;
                    } else {
                        for (int j = column.size() - 1; j >= 0; j--) {
                            Block block = column.get(j);
                            if (block.altitude() <= rule.getLaneSize() + 1) { //TODO: Magic Number !
                                break;
                            } else {
                                column.remove(j);
                                field.addToScore(100); //TODO: Magic Number !
                            }
                        }
                    }
                }
            }
        }
    }
}
