package com.blueglobule.blockwars.game.entity;

import com.blueglobule.blockwars.locator.RuleLocator;
import com.blueglobule.blockwars.locator.ThemeLocator;

public class GraphicsMeasurement {

    private int worldWidth;
    private int worldHeight;
    private int fieldWidth;
    private int fieldHeight;
    private int blockSize;
    private int fieldMargin;

    public GraphicsMeasurement() {
    }

    public void update(int width, int height) {

        // use theme service
//        float fieldMarginFraction = context.getResources().getFraction(R.fraction.game_field_margin, 1, 1);
        float fieldMarginFraction = ThemeLocator.getTheme().getFieldMarginPercent();

        int columnCount = RuleLocator.getRule().getLaneCount();
        int columnSize = RuleLocator.getRule().getLaneSize();

        this.worldWidth = width;
        this.worldHeight = height;

        this.fieldMargin = Math.round(this.worldWidth * fieldMarginFraction);
        this.fieldWidth = this.worldWidth - 2 * fieldMargin;
        this.blockSize = this.fieldWidth / columnCount;
        this.fieldHeight = this.blockSize * columnSize;

        // Adjustment of margin
        this.fieldWidth = this.blockSize * columnCount;
        this.fieldMargin = (this.worldWidth - this.fieldWidth) / 2;
    }

    public boolean isInField(float x, float y) {
        if (x < fieldMargin || x > fieldMargin + fieldWidth) {
            return false;
        }
        if (y < fieldMargin || y > fieldMargin + fieldHeight) {
            return false;
        }
        return true;
    }

    public int translateToLaneIndex(float x) {
        int laneIndex = (int) ((x - fieldMargin) / blockSize);
        return laneIndex;
    }

    public float translateToAltitude(float y) {
        float altitude =  (((worldHeight -y) - fieldMargin) / blockSize);
        return altitude;
    }

    public int getWorldWidth() {
        return worldWidth;
    }

    public int getWorldHeight() {
        return worldHeight;
    }

    public int getFieldWidth() {
        return fieldWidth;
    }

    public int getFieldHeight() {
        return fieldHeight;
    }

    public int getBlockSize() {
        return blockSize;
    }

    public int getFieldMargin() {
        return fieldMargin;
    }
}
