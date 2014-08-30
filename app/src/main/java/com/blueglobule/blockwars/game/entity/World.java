package com.blueglobule.blockwars.game.entity;


import android.graphics.Canvas;
import android.graphics.Color;

import com.blueglobule.blockwars.game.component.graphics.FieldGraphicsComponent;
import com.blueglobule.blockwars.game.component.graphics.HudGraphicsComponent;
import com.blueglobule.blockwars.game.component.input.FieldInputComponent;
import com.blueglobule.blockwars.game.component.physics.FieldPhysicsComponent;
import com.blueglobule.blockwars.locator.RuleLocator;

public class World implements GameState {

    private Field field;

    private FieldPhysicsComponent fieldPhysics;

    private FieldGraphicsComponent fieldGraphics;
    private HudGraphicsComponent hudGraphics;

    private FieldInputComponent fieldInputComponent;

    public World(HudGraphicsComponent hudGraphics, FieldGraphicsComponent fieldGraphics, FieldPhysicsComponent fieldPhysics, FieldInputComponent fieldInputComponent) {
        this.hudGraphics = hudGraphics;
        this.fieldGraphics = fieldGraphics;
        this.fieldPhysics = fieldPhysics;
        this.fieldInputComponent = fieldInputComponent;

        this.init();
    }

    public void init() {
        field = new Field();
        fieldPhysics.init(field);
        fieldGraphics.init(field); //WARN: Do nothing ?
    }

    public void update() {
        fieldInputComponent.update(field);
        fieldPhysics.update(field);
    }

    public void render(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        hudGraphics.update(field, canvas);
        fieldGraphics.update(field, canvas);
    }
}
