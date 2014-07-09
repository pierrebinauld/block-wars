package com.blueglobule.blockwars.Controler;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.blueglobule.blockwars.engine.physic.builders.GameBuilder;
import com.blueglobule.blockwars.model.Field;
import com.blueglobule.blockwars.model.Game;
import com.blueglobule.blockwars.engine.graphic.DrawerBuilder;
import com.blueglobule.blockwars.engine.graphic.GraphicEngine;
import com.blueglobule.blockwars.engine.physic.PhysicEngine;

public class ActivityView extends SurfaceView implements SurfaceHolder.Callback {

    public static final int FPS = 50;

    private SurfaceHolder holder;

    DrawerBuilder builder;

    GraphicEngine graphicEngine;
    PhysicEngine physicEngine;

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

        GameBuilder gameBuilder = new GameBuilder();

        Game game = gameBuilder.buildGame();

        builder = new DrawerBuilder(this.getContext(), game);


        graphicEngine = new GraphicEngine(holder, FPS);
        physicEngine = new PhysicEngine(game);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        builder.setWidth(width);
        builder.setHeight(height);
        graphicEngine.setDrawer(builder.buildSurfaceDrawer(width, height));

        if(!graphicEngine.isRunning()) {
            graphicEngine.start();
        }

        if(!physicEngine.isRunning()) {
            physicEngine.start();
        }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        Log.d("ActivityView", "surfaceDestroyed");

        graphicEngine.stop();
        physicEngine.stop();
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
