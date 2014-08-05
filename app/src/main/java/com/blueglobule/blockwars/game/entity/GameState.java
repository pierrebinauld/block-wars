package com.blueglobule.blockwars.game.entity;

import android.graphics.Canvas;

public interface GameState {
    void update();
    void render(Canvas canvas);
}
