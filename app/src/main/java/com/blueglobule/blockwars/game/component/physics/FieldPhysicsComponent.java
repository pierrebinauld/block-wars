package com.blueglobule.blockwars.game.component.physics;

import android.util.Log;

import com.blueglobule.blockwars.game.component.PhysicsComponent;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.Lane;
import com.blueglobule.blockwars.game.entity.Runway;
import com.blueglobule.blockwars.game.entity.Ship;
import com.blueglobule.blockwars.game.entity.factory.BlockFactory;

public class FieldPhysicsComponent extends PhysicsComponent<Field> {

    private BlockGeneratorComponent blockGeneratorComponent;
    private GravityComponent gravityComponent;
    private ShipLauncherComponent shipLauncherComponent;

    public FieldPhysicsComponent() {

        this.blockGeneratorComponent = new BlockGeneratorComponent(new BlockFactory(rule));
        this.gravityComponent = new GravityComponent();
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

        gravityComponent.update(field);

        shipLauncherComponent.update(field);

    }
}
