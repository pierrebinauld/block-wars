package com.blueglobule.blockwars.game.component;

import android.graphics.Canvas;

import com.blueglobule.blockwars.game.component.graphics.GraphicsMeasurement;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.locator.ThemeLocator;


public abstract class GraphicsComponent<Entity> extends ThemeLocator {

    protected GraphicsMeasurement graphicsMeasurement;

    public GraphicsComponent(GraphicsMeasurement graphicsMeasurement) {
        this.graphicsMeasurement = graphicsMeasurement;
    }

    public abstract void update(Entity entity, Canvas canvas);
}
