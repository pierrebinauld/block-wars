package com.blueglobule.blockwars.game.component.physics;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.Lane;
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
        for (Lane lane : field) {
            Column column = lane.get(lane.size()-1);
            for (int y = 0; y < rule.getInitialLayerBlockCount(); y++) {
                int typeIndex = randomService.random(0, probabilityTypes.size());

                Block block = blockFactory.build(probabilityTypes.get(typeIndex));
                column.add(block);
            }
            lane.land(column);
        }
    }

    @Override
    public void update(Field field) {
        if (timer.isFinished()) {
            int laneIndex = randomService.random(0, field.size());
            int blockIndex = randomService.random(0, probabilityTypes.size());

            Lane lane = field.get(laneIndex);

            Block block = blockFactory.build(probabilityTypes.get(blockIndex));

            Column column = lane.spawn(block);
            column.setMovement(Column.Movement.FALLING);

            timer.restart();
        }
    }
}
