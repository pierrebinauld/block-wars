package com.blueglobule.blockwars.engine.graphic;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GraphicEngine implements Runnable {

    boolean keepDrawing = true;

    long sleepTime;

    SurfaceHolder surfaceHolder;

    Drawer drawer;

    public GraphicEngine(SurfaceHolder surfaceHolder, Drawer drawer, int fps) {
        this.sleepTime = (long) (1.0 / fps * 1000);
        this.surfaceHolder = surfaceHolder;
        this.drawer = drawer;
    }

    public boolean isDrawing() {
        return keepDrawing;
    }

    public void setKeepDrawing(boolean keepDrawing) {
        this.keepDrawing = keepDrawing;
    }

    public void stopDrawing() {
        this.keepDrawing = false;
    }

    public void resumeDrawing() {
        this.keepDrawing = true;
    }

    @Override
    public void run() {
        while (keepDrawing) {
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
}
