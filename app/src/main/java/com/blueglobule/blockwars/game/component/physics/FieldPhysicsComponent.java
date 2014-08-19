package com.blueglobule.blockwars.game.component.physics;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.Lane;
import com.blueglobule.blockwars.game.entity.factory.BlockFactory;

public class FieldPhysicsComponent extends PhysicsComponent<Field> {

    private BlockGeneratorComponent blockGeneratorComponent;
    private ShipLauncherComponent shipLauncherComponent;

    public FieldPhysicsComponent() {

        this.blockGeneratorComponent = new BlockGeneratorComponent(new BlockFactory(rule));
        this.shipLauncherComponent = new ShipLauncherComponent();
    }

    @Override
    public void init(Field field) {
        field.init(rule);
        blockGeneratorComponent.init(field);
    }

    @Override
    public void update(Field field) {
        blockGeneratorComponent.update(field);


        // Gravity
        for (Lane lane : field) {
            Column topColumn = lane.getColumns().last();
            int top = topColumn.top();
            for (int i = top; i < lane.size(); i++) {
                Block block = lane.get(i);
                block.move();
                if (block.altitude() <= top) {
                    topColumn.land(block);
                    top = topColumn.top();
                }
            }
        }

        shipLauncherComponent.update(field);
    }
}
