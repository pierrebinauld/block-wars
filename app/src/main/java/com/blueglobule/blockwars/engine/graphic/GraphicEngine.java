package com.blueglobule.blockwars.engine.graphic;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.blueglobule.blockwars.engine.Engine;

public class GraphicEngine extends Engine implements Runnable {

    long sleepTime;

    SurfaceHolder surfaceHolder;

    Drawer drawer;

    public GraphicEngine(SurfaceHolder surfaceHolder, Drawer drawer, int fps) {
        this.sleepTime = (long) (1.0 / fps * 1000);
        this.surfaceHolder = surfaceHolder;
        this.drawer = drawer;
    }

    @Override
    public void doRun() {

        Canvas canvas = null;
        try {
            canvas = surfaceHolder.lockCanvas();
            if (null != canvas) {
                synchronized (surfaceHolder) {
                    drawer.doDraw(canvas);
                }
            }
        } finally {
            if (null != canvas) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

        //Controlling the number of frames per second.
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
        }
    }
}
