//package com.blueglobule.blockwars.engine.graphic;
//
//
//import android.graphics.Canvas;
//import android.graphics.Color;
//import android.graphics.Paint;
//import android.graphics.Rect;
//
//import Block;
//import World;
//
//import java.util.LinkedList;
//
//public class SurfaceDrawer {
//
//    private World game;
//
//    private BlockDrawer blockDrawer;
//
//    private int width;
//    private int height;
//    private int blockSize;
//    private int fieldMargin;
//    private int blockMargin;
//
//    public SurfaceDrawer(World game, BlockDrawer blockDrawer, int width, int height, int blockSize, int fieldMargin, int blockMargin) {
//        this.game = game;
//        this.blockDrawer = blockDrawer;
//
//        this.width = width;
//        this.height = height;
//        this.blockSize = blockSize;
//        this.fieldMargin = fieldMargin;
//        this.blockMargin = blockMargin;
//    }
//
//
//    public void draw(Canvas canvas) {
//
//        drawScene(canvas);
//        drawScore(canvas);
//
//        int i = 0;
//        for(LinkedList<Block> column : game.getField()) {
//            int x = i * blockSize + i * blockMargin + fieldMargin;
//            for(Block block : column) {
//                Rect bounds = new Rect(
//                        x,
//                        block.altitude(),
//                        x + blockSize,
//                        block.altitude() + blockSize);
//                blockDrawer.draw(canvas, block.type(), bounds);
//            }
//            i++;
//        }
//    }
//
//    private void drawScene(Canvas canvas) {
//        canvas.drawColor(Color.BLACK);
//
//        Paint whitePaint = new Paint();
//        whitePaint.setColor(Color.WHITE);
//
//        canvas.drawLine(
//                fieldMargin,
//                height-fieldMargin,
//                fieldMargin,
//                height - 8 * blockSize - 9*blockMargin - fieldMargin,
//                whitePaint);
//        canvas.drawLine(
//                width - fieldMargin,
//                height-fieldMargin,
//                width - fieldMargin,
//                height - 8 * blockSize - 9*blockMargin - fieldMargin,
//                whitePaint);
//        canvas.drawLine(
//                fieldMargin,
//                height-fieldMargin,
//                width - fieldMargin,
//                height-fieldMargin,
//                whitePaint);
//    }
//
//    private void drawScore(Canvas canvas) {
//    }
//}
