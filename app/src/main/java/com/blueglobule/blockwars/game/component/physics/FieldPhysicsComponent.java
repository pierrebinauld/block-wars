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

    public FieldPhysicsComponent() {
        ;
        this.blockGeneratorComponent = new BlockGeneratorComponent(new BlockFactory(rule));
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
            int ground = column.ground();
            for (int i = ground; i < column.size(); i++) {
                Block block = column.get(i);
                block.move();
                if (block.altitude() <= ground) {
                    column.land(block);
                    ground = column.ground();
                }
            }
        }

        if (field.hasSelectedBlock()) {
            Block block = field.selectedBlock();
            float selectedAltitude = block.selectedAltitude();

            if (selectedAltitude < 0f) {
                block.setSelectedAltitude(0f);
            }
//            else if (selectedAltitude > column.ground() - 1) {
//                block.setSelectedAltitude(column.ground() - 1);
//            }
// else if (selectedAltitude < block.altitude() - 0.5) {
//                column.pushDown(i);
//            } else if (selectedAltitude > block.altitude() + 0.5) {
//                column.pushUp(i);
//            }
        }
    }
}
