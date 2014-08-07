package com.blueglobule.blockwars.controler;


import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;

import com.blueglobule.blockwars.controler.command.ChangeEntityCommand;
import com.blueglobule.blockwars.controler.command.UpdateMeasurementCommand;
import com.blueglobule.blockwars.controler.command.UpdateSurfaceHolderCommand;
import com.blueglobule.blockwars.game.GameEngine;
import com.blueglobule.blockwars.game.component.graphics.FieldGraphicsComponent;
import com.blueglobule.blockwars.game.component.graphics.HudGraphicsComponent;
import com.blueglobule.blockwars.game.component.input.FieldInputComponent;
import com.blueglobule.blockwars.game.component.physics.FieldPhysicsComponent;
import com.blueglobule.blockwars.game.entity.World;

import java.util.concurrent.ConcurrentLinkedQueue;

public class Controller implements SurfaceHolder.Callback, View.OnTouchListener {

    private GameEngine gameEngine;
    ConcurrentLinkedQueue<MotionEvent> inputsQueue = new ConcurrentLinkedQueue<MotionEvent>();

    public Controller() {
        this.gameEngine = new GameEngine();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        gameEngine.addCommand(new UpdateSurfaceHolderCommand(gameEngine, holder));
        gameEngine.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        gameEngine.addCommand(new UpdateSurfaceHolderCommand(gameEngine, holder));
        gameEngine.addCommand(new UpdateMeasurementCommand(width, height));
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        gameEngine.stop();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        inputsQueue.add(event);
        return true;
    }

    public void startGame() {

        FieldPhysicsComponent fieldPhysics = new FieldPhysicsComponent();
        FieldGraphicsComponent fieldGraphics = new FieldGraphicsComponent();
        HudGraphicsComponent hudGraphics = new HudGraphicsComponent();
        FieldInputComponent fieldInputComponent = new FieldInputComponent(inputsQueue);

        World world = new World(hudGraphics, fieldGraphics, fieldPhysics, fieldInputComponent);
        gameEngine.addCommand(new ChangeEntityCommand(gameEngine, world));
    }
}
