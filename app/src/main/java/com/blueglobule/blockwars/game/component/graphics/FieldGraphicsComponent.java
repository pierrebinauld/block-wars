package com.blueglobule.blockwars.game.component.graphics;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.blueglobule.blockwars.game.component.GraphicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;

public class FieldGraphicsComponent extends GraphicsComponent<Field> {

    public FieldGraphicsComponent(GraphicsMeasurement graphicsMeasurement) {
        super(graphicsMeasurement);
    }

    @Override
    public void update(Field field, Canvas canvas) {
        int margin = graphicsMeasurement.getFieldMargin();
        int blockSize = graphicsMeasurement.getBlockSize();
        int x = margin;
        for (Column column : field) {
            for (Block block : column) {
                int y = (int) (block.altitude() * blockSize + margin);

                Drawable d = block.getDrawable();
                d.setBounds(x,y,x+blockSize,y+blockSize);
                d.draw(canvas);
            }
            x += blockSize;
        }
    }

    public void init(Field field) {

    }
}
