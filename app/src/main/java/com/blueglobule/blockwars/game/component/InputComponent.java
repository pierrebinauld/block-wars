package com.blueglobule.blockwars.game.component;

import com.blueglobule.blockwars.game.entity.GraphicsMeasurement;
import com.blueglobule.blockwars.locator.GraphicsMeasurementLocator;

public abstract class InputComponent<Entity> {

    protected GraphicsMeasurement graphicsMeasurement = GraphicsMeasurementLocator.getGraphicsMeasurement();

    public abstract void update(Entity entity);
}
