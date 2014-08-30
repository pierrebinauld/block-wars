package com.blueglobule.blockwars.game.component.graphics;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.blueglobule.blockwars.game.component.GraphicsComponent;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.World;

public class HudGraphicsComponent extends GraphicsComponent<Field> {

    @Override
    public void update(Field field, Canvas canvas) {

//        canvas.scale(1,-1,graphicsMeasurement.getWorldWidth()/2,graphicsMeasurement.getWorldHeight()/2);
        Paint paint = theme.getPaint();
        int margin = graphicsMeasurement.getFieldMargin();
        int worldHeight = graphicsMeasurement.getWorldHeight();

        int left = margin - 2;
        int right = graphicsMeasurement.getWorldWidth() - margin + 2;
        int top = worldHeight - margin - graphicsMeasurement.getFieldHeight() - 2;
        int bottom = worldHeight - margin + 2;


        canvas.drawText(field.score()+"", left, margin*2, paint);

        canvas.drawLine(left, bottom, left, top, paint);
        canvas.drawLine(right, bottom, right, top, paint);
        canvas.drawLine(left, bottom, right, bottom, paint);
    }
}
