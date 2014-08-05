//package com.blueglobule.blockwars.engine.graphic;
//
//import android.graphics.Canvas;
//import android.util.Log;
//import android.view.SurfaceHolder;
//
//import com.blueglobule.blockwars.model.Engine;
//
//public class GraphicEngine extends Engine implements Runnable {
//
//    long sleepTime;
//
//    SurfaceHolder surfaceHolder;
//
//    SurfaceDrawer drawer;
//
//    public GraphicEngine(SurfaceHolder surfaceHolder, int fps) {
//        this.setFps(fps);
//        this.surfaceHolder = surfaceHolder;
//    }
//
//    public void setDrawer(SurfaceDrawer drawer) {
//        synchronized (surfaceHolder) {
//            this.drawer = drawer;
//        }
//    }
//
//    public void setFps(int fps) {
//        this.sleepTime = (long) (1.0 / fps * 1000);
//    }
//
//    @Override
//    public void doRun() {
//
//        Canvas canvas = null;
//        try {
//            canvas = surfaceHolder.lockCanvas();
//            if (null != canvas) {
//                synchronized (surfaceHolder) {
//                    drawer.draw(canvas);
//                }
//            }
//        } finally {
//            if (null != canvas) {
//                surfaceHolder.unlockCanvasAndPost(canvas);
//            }
//        }
//
//        //Controlling the number of frames per second.
//        try {
//            Thread.sleep(sleepTime);
//        } catch (InterruptedException e) {
//        }
//    }
//}
