package com.blueglobule.blockwars.Controler;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.blueglobule.blockwars.engine.graphic.GameDrawer;
import com.blueglobule.blockwars.engine.graphic.GraphicEngine;

public class ActivityView extends SurfaceView implements SurfaceHolder.Callback {

    public static final int FPS = 50;

    private SurfaceHolder holder;
    GraphicEngine graphicEngine;
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

        graphicEngine = new GraphicEngine(holder, gameDrawer, FPS);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
//        Log.d("onTouchEvent", "OK !");
        return false;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        graphicEngine.resumeDrawing();
        new Thread(graphicEngine).start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        graphicEngine.stopDrawing();
//        drawingThread.keepDrawing = false;
//
//        boolean joined = false;
//        while (!joined) {
//            try {
//                drawingThread.join();
//                joined = true;
//            } catch (InterruptedException e) {
//            }
//        }
    }

}
