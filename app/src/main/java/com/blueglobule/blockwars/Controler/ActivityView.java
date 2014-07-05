package com.blueglobule.blockwars.Controler;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.blueglobule.blockwars.engine.graphic.GameDrawer;

public class ActivityView extends SurfaceView implements SurfaceHolder.Callback {

    public static final int FPS = 50;
    public static final long SLEEP_TIME = (long) (1.0 / FPS * 1000);

    private SurfaceHolder holder;
    DrawingThread drawingThread;
    GameDrawer gameDrawer = new GameDrawer();

    public ActivityView(Context context) {
        super(context);
        init();
    }

    public ActivityView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ActivityView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        holder = getHolder();
        holder.addCallback(this);

        drawingThread = new DrawingThread();
    }

    @Override
    public boolean onTouchEvent (MotionEvent event) {
//        Log.d("onTouchEvent", "OK !");
        return false;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        drawingThread.keepDrawing = true;
        drawingThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        drawingThread.keepDrawing = false;

        boolean joined = false;
        while (!joined) {
            try {
                drawingThread.join();
                joined = true;
            } catch (InterruptedException e) {
            }
        }
    }

    protected void doDraw(Canvas canvas) {
        gameDrawer.doDraw(canvas);
    }

    private class DrawingThread extends Thread {
        boolean keepDrawing = true;

        @Override
        public void run() {
            while (keepDrawing) {
                Canvas canvas = null;
                try {
                    canvas = holder.lockCanvas();
                    if (null != canvas) {
                        synchronized (holder) {
                            doDraw(canvas);
                        }
                    }
                } finally {
                    if (null != canvas) {
                        holder.unlockCanvasAndPost(canvas);
                    }
                }

                //Controlling the number of frames per second.
                try {
                    Thread.sleep(SLEEP_TIME);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
