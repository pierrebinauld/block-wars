package com.blueglobule.blockwars.game.component.graphics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.blueglobule.blockwars.game.component.GraphicsComponent;
import com.blueglobule.blockwars.game.entity.World;

public class HudGraphicsComponent extends GraphicsComponent<World> {

    public HudGraphicsComponent(GraphicsMeasurement graphicsMeasurement) {
        super(graphicsMeasurement);
    }

    @Override
    public void update(World world, Canvas canvas) {
        Paint paint = GraphicsComponent.getTheme().getPaint();
        int margin = graphicsMeasurement.getFieldMargin();

        int left = margin - 2;
        int right = graphicsMeasurement.getWorldWidth() - margin + 2;
        int top = margin + graphicsMeasurement.getFieldHeight() + 2;
        int bottom = margin - 2;


        canvas.drawLine(left, bottom, left, top, paint);
        canvas.drawLine(right, bottom, right, top, paint);
        canvas.drawLine(left, bottom, right, bottom, paint);
    }
}
