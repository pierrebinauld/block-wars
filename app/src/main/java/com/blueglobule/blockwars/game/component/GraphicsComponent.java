package com.blueglobule.blockwars.game.component;

import android.graphics.Canvas;

import com.blueglobule.blockwars.game.entity.GraphicsMeasurement;
import com.blueglobule.blockwars.game.theme.Theme;
import com.blueglobule.blockwars.locator.GraphicsMeasurementLocator;
import com.blueglobule.blockwars.locator.ThemeLocator;


public abstract class GraphicsComponent<Entity> {

    protected Theme theme = ThemeLocator.getTheme();
    protected GraphicsMeasurement graphicsMeasurement = GraphicsMeasurementLocator.getGraphicsMeasurement();

    public abstract void update(Entity entity, Canvas canvas);
}
