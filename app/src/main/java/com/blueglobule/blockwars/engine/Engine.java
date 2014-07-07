package com.blueglobule.blockwars.engine;

public abstract class Engine implements Runnable {

    private boolean keepRunning = false;

    public boolean isRunning() {
        return keepRunning;
    }

    public void start() {
        keepRunning = true;
        new Thread(this).start();
    }

    public void stop() {
        keepRunning = false;
    }

    @Override
    public void run() {
        while(keepRunning) {
            doRun();
        }
    }

    public abstract void doRun();
}
