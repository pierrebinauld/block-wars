package com.blueglobule.blockwars.engine.graphic;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.blueglobule.blockwars.game.entity.Block;

import java.util.Map;

public class BlockDrawer {

    private Map<Block.Type, Drawable> drawableBlocks;

    public BlockDrawer() {
    }

    public void draw(Canvas canvas, Block.Type block, Rect bounds) {
        Drawable d = drawableBlocks.get(block);
        d.setBounds(bounds);
        d.draw(canvas);
    }

    public void setDrawableBlocks(Map<Block.Type,Drawable> drawableBlocks) {
        this.drawableBlocks = drawableBlocks;
    }
}
