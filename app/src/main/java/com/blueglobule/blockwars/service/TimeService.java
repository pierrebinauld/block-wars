package com.blueglobule.blockwars.service;

public class TimeService {
    long startTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public long elapsedNanoSeconds() {
        return System.nanoTime() - startTime;
    }

    public long elapsedMilliSeconds() {
        return (long) ((System.nanoTime() - startTime) / 1e6);
    }

    public long elapsedSeconds() {
        return (long) ((System.nanoTime() - startTime) / 1e9);
    }
}
