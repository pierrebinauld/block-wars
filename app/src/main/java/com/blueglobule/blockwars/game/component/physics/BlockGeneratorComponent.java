package com.blueglobule.blockwars.game.component.physics;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.factory.BlockFactory;
import com.blueglobule.blockwars.locator.Locators;
import com.blueglobule.blockwars.service.RandomService;
import com.blueglobule.blockwars.tool.Timer;

import java.util.List;

public class BlockGeneratorComponent extends PhysicsComponent<Field> {

    private RandomService randomService = Locators.random.get();
    private List<Block.Type> probabilityTypes = rule.getProbabilityTypes();

    private Timer timer = new Timer();

    private BlockFactory blockFactory;

    public BlockGeneratorComponent(BlockFactory blockFactory) {
        this.blockFactory = blockFactory;
        this.timer.start(rule.getBlockGenerationPeriod());
    }

    @Override
    public void init(Field field) {
        for (int x = 0; x < field.size(); x++) {
            Column column = field.get(x);
            for (int y = 0; y < rule.getInitialLayerBlockCount(); y++) {
                int typeIndex = randomService.random(0, probabilityTypes.size());

                Block block = blockFactory.build(probabilityTypes.get(typeIndex));
                column.add(block);
                column.land(block);
            }
        }
    }

    @Override
    public void update(Field field) {
        if (timer.isFinished()) {
            int columnIndex = randomService.random(0, field.size());
            int blockIndex = randomService.random(0, probabilityTypes.size());

            Block block = blockFactory.build(probabilityTypes.get(blockIndex));

            field.get(columnIndex).add(block);

            timer.restart();
        }
    }
}
