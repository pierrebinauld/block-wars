package com.blueglobule.blockwars.controler.command;

import android.view.SurfaceHolder;

import com.blueglobule.blockwars.game.GameEngine;


public class UpdateSurfaceHolderCommand extends EngineCommand {

    private SurfaceHolder holder;

    public UpdateSurfaceHolderCommand(GameEngine gameEngine, SurfaceHolder holder) {
        super(gameEngine);
        this.holder = holder;
    }

    @Override
    public void execute() {
        gameEngine.setSurfaceHolder(holder);
    }
}
