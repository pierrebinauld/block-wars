package com.blueglobule.blockwars.game.entity;


import android.graphics.Canvas;
import android.graphics.Color;

import com.blueglobule.blockwars.game.component.graphics.FieldGraphicsComponent;
import com.blueglobule.blockwars.game.component.graphics.HudGraphicsComponent;
import com.blueglobule.blockwars.game.component.physics.FieldPhysicsComponent;
import com.blueglobule.blockwars.locator.RuleLocator;

public class World implements GameState {

    private Field field;

    private FieldPhysicsComponent fieldPhysics;
    private FieldGraphicsComponent fieldGraphics;
    private HudGraphicsComponent hudGraphics;

    public World(HudGraphicsComponent hudGraphics, FieldGraphicsComponent fieldGraphics, FieldPhysicsComponent fieldPhysics) {
        this.hudGraphics = hudGraphics;
        this.fieldGraphics = fieldGraphics;
        this.fieldPhysics = fieldPhysics;

        this.init();
    }

    public void init() {
        field = new Field(RuleLocator.getRule());
        fieldPhysics.init(field);
        fieldGraphics.init(field); //WARN: Do nothing ?
    }

    public void update() {
        fieldPhysics.update(field);
    }

    public void render(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        hudGraphics.update(this, canvas);
        fieldGraphics.update(field, canvas);
    }
}
