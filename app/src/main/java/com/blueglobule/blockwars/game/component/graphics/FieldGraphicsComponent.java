package com.blueglobule.blockwars.game.component.graphics;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.blueglobule.blockwars.game.component.GraphicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Column;
import com.blueglobule.blockwars.game.entity.Field;
import com.blueglobule.blockwars.game.entity.Lane;

public class FieldGraphicsComponent extends GraphicsComponent<Field> {

    public FieldGraphicsComponent() {
    }

    @Override
    public void update(Field field, Canvas canvas) {
        int margin = graphicsMeasurement.getFieldMargin();
        int blockSize = graphicsMeasurement.getBlockSize();
        int worldHeight = graphicsMeasurement.getWorldHeight();
        int x = margin;
        int y;
        for (Lane lane : field) {
            for (Column column : lane) {
//                if (column.isLanded()) {
//                    theme.getPaint().setColor(Color.GREEN);
//                    theme.getPaint().setStrokeWidth(4);
//                }
//                canvas.drawRect(
//                        x,
//                        worldHeight - (margin + column.floorAltitude() * blockSize),
//                        x + blockSize,
//                        worldHeight - (margin + column.topAltitude() * blockSize),
//                        theme.getPaint());
//                theme.getPaint().setColor(Color.WHITE);

                for (Block block : column) {
                    //TODO: Use graphics measurement to retrieve this.
                    if (block.isSelected()) {
                        y = worldHeight - (int) ((block.selectedAltitude() + 1) * blockSize + margin);
                    } else {
                        y = worldHeight - (int) ((block.altitude() + 1) * blockSize + margin);
                    }

                    Drawable drawable;
                    if (block.state() == Block.State.FIRED) {
                        drawable = theme.getFiredBlockDrawable();
                    } else {
                        drawable = block.drawable();
                    }
                    drawable.setBounds(x, y, x + blockSize, y + blockSize);
                    drawable.draw(canvas);
                }
            }

            x += blockSize;
        }
    }

    public void init(Field field) {

    }
}
