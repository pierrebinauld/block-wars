package com.blueglobule.blockwars.game;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

import com.blueglobule.blockwars.game.entity.GameState;
import com.blueglobule.blockwars.game.entity.NullGameState;
import com.blueglobule.blockwars.tool.Timer;

public class GameEngine extends Engine {

    private final static int MAX_FPS = 50;
    private final static int MAX_FRAME_SKIPS = 5;
    private final static int FRAME_PERIOD = 1000 / MAX_FPS;

    private Timer timer;

    private SurfaceHolder surfaceHolder;
    private Canvas canvas;

    private GameState gameState;

    private long elapsedTime;        // the time it took for the cycle to execute
    private int sleepTime;        // ms to sleep (<0 if we're behind)
    private int framesSkipped;    // number of frames being skipped

    public GameEngine() {
        this.surfaceHolder = null;
        this.gameState = new NullGameState();

        this.timer = new Timer();
    }

    @Override
    public void doRun() {

        canvas = null;
        // try locking the canvas for exclusive pixel editing
        // in the surface
        try {
            canvas = this.surfaceHolder.lockCanvas();
            if(null != canvas) {
//                canvas.translate(Locators.random.get().random(0,20),Locators.random.get().random(0,5));
                synchronized (surfaceHolder) {
                    timer.start();
                    framesSkipped = 0;    // resetting the frames skipped

                    gameState.update();
                    gameState.render(canvas);

                    elapsedTime = timer.elapsedMilliSeconds();
                    sleepTime = (int) (FRAME_PERIOD - elapsedTime);

                    if (sleepTime > 0) {
                        try {
                            Thread.sleep(sleepTime);
                        } catch (InterruptedException e) {
                        }
                    }

                    while (sleepTime < 0 && framesSkipped < MAX_FRAME_SKIPS) {
                        // we need to catch up
                        // update without rendering
                        gameState.update();
                        // add frame period to check if in next frame
                        sleepTime += FRAME_PERIOD;
                        framesSkipped++;
                    }
                }
            }
        } finally {
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public void setSurfaceHolder(SurfaceHolder holder) {
        this.surfaceHolder = holder;
    }
}
