package com.blueglobule.blockwars.engine.graphic;


import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.RectShape;

public abstract class Drawer {

    protected Rect boundaryRect;

    protected Drawer(Rect boundaryRect) {
        this.boundaryRect = boundaryRect;
    }

    public abstract void doDraw(Canvas canvas);
}
