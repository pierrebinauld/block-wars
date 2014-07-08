package com.blueglobule.blockwars.engine.graphic;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.blueglobule.blockwars.Model.Block;
import com.blueglobule.blockwars.Model.Game;
import com.blueglobule.blockwars.R;

import java.util.HashMap;
import java.util.Map;

public class DrawerBuilder {

    Context context;
    Game game;

    int width;
    int height;

    public Map<Block.Type, Drawable> blocks;

    public DrawerBuilder(Context context, Game game) {
        this.context = context;
        this.game = game;

        this.initResources();
    }

    public SurfaceDrawer buildSurfaceDrawer(int width, int height) {

        float fieldMarginFraction = context.getResources().getFraction(R.fraction.game_field_margin, 1, 1);
        float blockMarginFraction = context.getResources().getFraction(R.fraction.game_block_margin, 1, 1);

        int blockCount = game.getField().size();
        int fieldMargin = Math.round(width * fieldMarginFraction);
        int blockMargin = Math.round(width * blockMarginFraction);
        int blockSize = (width - 2*fieldMargin - (blockCount+1)*blockMargin)/blockCount;

        Log.d("blockSize", blockSize + "");

        SurfaceDrawer surfaceDrawer = new SurfaceDrawer(game, buildBlockDrawer(),  width, height, blockSize, fieldMargin, blockMargin);

        return surfaceDrawer;
    }

    private void initResources() {
        blocks = new HashMap<Block.Type, Drawable>();

        blocks.put(Block.Type.BLUE, context.getResources().getDrawable(Block.Type.BLUE.id()));
        blocks.put(Block.Type.GREEN, context.getResources().getDrawable(Block.Type.GREEN.id()));
        blocks.put(Block.Type.ORANGE, context.getResources().getDrawable(Block.Type.ORANGE.id()));
        blocks.put(Block.Type.RED, context.getResources().getDrawable(Block.Type.RED.id()));
    }

    public BlockDrawer buildBlockDrawer() {

        BlockDrawer blockDrawer = new BlockDrawer();
        blockDrawer.setDrawableBlocks(blocks);

        return blockDrawer;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
