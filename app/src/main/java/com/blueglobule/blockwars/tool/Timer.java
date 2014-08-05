package com.blueglobule.blockwars.tool;

public class Timer {

    private long startTime = 0;
    private long target = 0;

    public void start() {
        this.start(0);
    }

    public void start(long target) {
        this.target = target;
        this.restart();
    }

    public void restart() {
        this.startTime = System.currentTimeMillis();
    }

    public long elapsedMilliSeconds() {
        return (long) ((System.currentTimeMillis() - startTime));
    }

    public long elapsedSeconds() {
        return (long) ((System.currentTimeMillis() - startTime) / 1e3);
    }

    public boolean isFinished() {
        if (target - elapsedMilliSeconds() > 0) {
            return false;
        } else {
            return true;
        }
    }

    public void setTarget(long target) {
        this.target = target;
    }
    public long getTarget() {
        return target;
    }
}
