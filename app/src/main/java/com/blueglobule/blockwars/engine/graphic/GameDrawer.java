package com.blueglobule.blockwars.engine.graphic;


import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class GameDrawer implements Drawer {

    int y = 20;
    int x = 20;
    Paint paint = new Paint();

    @Override
    public void doDraw(Canvas canvas) {
        canvas.drawColor(Color.GREEN);
        paint.setARGB(255,255,0,0);

        if(y<= 500) {
            y += 20;
        }
//        if(y > 500) {
//            y = 20;
//            x += 30;
//        }

        canvas.drawCircle(x,y,10, paint);
    }
}
