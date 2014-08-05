package com.blueglobule.blockwars.controler;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameView extends SurfaceView {

    public GameView(Context context) {
        super(context);
    }

    public GameView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void init(Controller controller) {
        SurfaceHolder holder = getHolder();
        holder.addCallback(controller);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

}
