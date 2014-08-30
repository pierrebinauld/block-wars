package com.blueglobule.blockwars.game.component.physics;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.factory.BlockFactory;

public class FieldPhysicsComponent extends PhysicsComponent<Field> {

    private BlockGeneratorComponent blockGeneratorComponent;
    private MovementComponent movementComponent;
    private ShipLauncherComponent shipLauncherComponent;
    private FieldLimitComponent fieldLimitComponent;

    public FieldPhysicsComponent() {

        this.blockGeneratorComponent = new BlockGeneratorComponent(new BlockFactory(rule));
        this.movementComponent = new MovementComponent();
        this.shipLauncherComponent = new ShipLauncherComponent();
        this.fieldLimitComponent = new FieldLimitComponent();
    }

    @Override
    public void init(Field field) {
        field.init(rule);
        blockGeneratorComponent.init(field);
        movementComponent.init(field);
        shipLauncherComponent.init(field);
        fieldLimitComponent.init(field);
    }

    @Override
    public void update(Field field) {
        blockGeneratorComponent.update(field);
        movementComponent.update(field);
        shipLauncherComponent.update(field);
        fieldLimitComponent.update(field);


    }
}
