package com.blueglobule.blockwars.game.theme;

import android.graphics.Paint;
import android.graphics.drawable.Drawable;

import com.blueglobule.blockwars.game.entity.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Theme {


    private Map<Block.Type, Drawable> drawableBlocks = new HashMap<Block.Type, Drawable>();
    private Drawable firedDrawableBlock;
    private Paint paint;
    private float fieldMarginPercent;

    public Theme() {
    }

    public Drawable getDrawableBlock(Block.Type type) {
        return drawableBlocks.get(type);
    }

    public Set<Block.Type> getDrawableBlockTypeSet() {
        return drawableBlocks.keySet();
    }

    public Paint getPaint() {
        return paint;
    }

    public float getFieldMarginPercent() {
        return fieldMarginPercent;
    }

    public Drawable getFiredDrawableBlock() {
        return firedDrawableBlock;
    }

    public Theme putDrawableBlockId(Block.Type type, Drawable drawable) {
        drawableBlocks.put(type, drawable);
        return this;
    }

    public Theme setPaint(Paint paint) {
        this.paint = paint;
        return this;
    }

    public Theme setFieldMarginPercent(float fieldMarginPercent) {
        this.fieldMarginPercent = fieldMarginPercent;
        return this;
    }

    public Theme setFiredDrawableBlock(Drawable firedDrawableBlock) {
        this.firedDrawableBlock = firedDrawableBlock;
        return this;
    }
}
