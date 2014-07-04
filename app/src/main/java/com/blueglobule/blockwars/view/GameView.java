package com.blueglobule.blockwars.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.blueglobule.blockwars.R;

/**
 * Created by pierre on 03/07/14.
 */
public class GameView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder holder;
    DrawingThread drawingThread;

    public GameView(Context context) {
        super(context);
        init();
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        holder = getHolder();
        holder.addCallback(this);

        drawingThread = new DrawingThread();
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

    @Override
    protected void onDraw(Canvas canvas) {

        Paint paint = new Paint();
        paint.setARGB(255,255,0,0);
        canvas.drawCircle(10,10,10,paint);
    }

    private class DrawingThread extends Thread {
        // Utilisé pour arrêter le dessin quand il le faut
        boolean keepDrawing = true;

        @Override
        public void run() {

            while (keepDrawing) {
                Canvas canvas = null;
                try {
                    canvas = holder.lockCanvas();
                    synchronized (holder) {
                        onDraw(canvas);
                    }
                } finally {
                    if (canvas != null) {
                        holder.unlockCanvasAndPost(canvas);
                    }
                }
                // ~50 fps
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
