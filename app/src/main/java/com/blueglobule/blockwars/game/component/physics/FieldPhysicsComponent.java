package com.blueglobule.blockwars.game.component.physics;

import android.util.Log;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.Rule;
import com.blueglobule.blockwars.game.entity.factory.BlockFactory;
import com.blueglobule.blockwars.locator.Locators;
import com.blueglobule.blockwars.locator.RuleLocator;
import com.blueglobule.blockwars.service.RandomService;
import com.blueglobule.blockwars.tool.Timer;

import java.util.Map;

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
        for (Column column : field) {
            int top = column.top();
            for (int i = top; i < column.size(); i++) {
                Block block = column.get(i);
                block.move();
                if (block.altitude() <= top) {
                    column.land(block);
                    top = column.top();
                }
            }
        }

        shipLauncherComponent.update(field);
    }
}
