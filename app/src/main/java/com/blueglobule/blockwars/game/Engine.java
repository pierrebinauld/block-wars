package com.blueglobule.blockwars.game;

import com.blueglobule.blockwars.controler.command.Command;

import java.util.concurrent.ConcurrentLinkedQueue;

public abstract class Engine implements Runnable {

    private boolean keepRunning = false;
    private Thread thread;

    private ConcurrentLinkedQueue<Command> queue = new ConcurrentLinkedQueue<Command>();

    public boolean isRunning() {
        return keepRunning;
    }

    public void start() {
        if(null == thread) {
            keepRunning = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    public void stop() {
        if(null != thread) {
            keepRunning = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
            }
            thread = null;
        }
    }

    @Override
    public void run() {
        while(keepRunning) {
            while(!queue.isEmpty()) {
                queue.poll().execute();
            }
            doRun();
        }
    }

    public void addCommand(Command cmd) {
        queue.add(cmd);
    }

    public abstract void doRun();
}
