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

    private BlockFactory blockFactory;

    private Timer blockGeneratorTimer = new Timer();

    public FieldPhysicsComponent() {
        Rule rule = RuleLocator.getRule();
        this.blockFactory = new BlockFactory(rule);
        this.blockGeneratorTimer.start(rule.getBlockGenerationPeriod());
    }

    public Field init() {
        Rule rule = RuleLocator.getRule();
        Field field = new Field(rule);
        RandomService randomService = Locators.random.get();

        Map<Block.Type, Integer> blocks = rule.getAvailableBlocks();
        int count = blocks.size();

        for (Column column : field) {
            for (int i = 0; i < 3; i++) {
                int rand = randomService.random(0, count);
                Object[] blockTypes = blocks.keySet().toArray();
                Block block = blockFactory.build((Block.Type) blockTypes[rand]);
                block.setAltitude(i);
                column.add(block);
            }
            column.setGround(3);
        }

        return field;
    }

    @Override
    public void update(Field field) {
        if (blockGeneratorTimer.isFinished()) {
            blockGeneratorTimer.restart();
            Block block = blockFactory.build(Block.Type.ALPHA);
            field.get(Locators.random.get().random(0, field.size())).add(block);
        }

        applyGravity(field);
    }

    private void applyGravity(Field field) {

        for (Column column : field) {
            int ground = column.ground();
            for (int i = ground; i < column.size(); i++) {
                Block block = column.get(i);
                block.move();
                if(block.altitude() <= ground) {
                    block.land(ground);
                    ground++;
                    column.setGround(ground);
                }
            }


//                if(block.altitude() != ground) {
//                    block.move();
//                    if (block.altitude() < ground) {
//                        block.setAltitude(ground);
//                    }
//                }
//                if(block.altitude() == ground) {
//                    ground++;
//                }

        }
    }
}
