package com.blueglobule.blockwars.controler;


import android.view.SurfaceHolder;

import com.blueglobule.blockwars.controler.command.ChangeEntityCommand;
import com.blueglobule.blockwars.controler.command.UpdateMeasurementCommand;
import com.blueglobule.blockwars.controler.command.UpdateSurfaceHolderCommand;
import com.blueglobule.blockwars.game.component.graphics.FieldGraphicsComponent;
import com.blueglobule.blockwars.game.component.graphics.GraphicsMeasurement;
import com.blueglobule.blockwars.game.GameEngine;
import com.blueglobule.blockwars.game.component.graphics.HudGraphicsComponent;
import com.blueglobule.blockwars.game.component.physics.FieldPhysicsComponent;
import com.blueglobule.blockwars.game.entity.Block;
import com.blueglobule.blockwars.game.entity.Rule;
import com.blueglobule.blockwars.game.entity.World;
import com.blueglobule.blockwars.game.entity.factory.BlockFactory;
import com.blueglobule.blockwars.game.theme.Theme;
import com.blueglobule.blockwars.locator.RuleLocator;
import com.blueglobule.blockwars.locator.ThemeLocator;

public class Controller implements SurfaceHolder.Callback {

    private GameEngine gameEngine;

    private GraphicsMeasurement measurement = new GraphicsMeasurement();

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
        gameEngine.addCommand(new UpdateMeasurementCommand(measurement, width, height));
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        gameEngine.stop();
    }

    public void startGame() {

        FieldPhysicsComponent fieldPhysics = new FieldPhysicsComponent();
        FieldGraphicsComponent fieldGraphics = new FieldGraphicsComponent(measurement);
        HudGraphicsComponent hudGraphics = new HudGraphicsComponent(measurement);

        World world = new World(hudGraphics, fieldGraphics, fieldPhysics);
        gameEngine.addCommand(new ChangeEntityCommand(gameEngine, world));
    }
}
