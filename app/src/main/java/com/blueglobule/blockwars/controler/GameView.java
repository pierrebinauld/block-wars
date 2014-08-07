package com.blueglobule.blockwars.controler;

import android.content.Context;
import android.provider.ContactsContract;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Switch;

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
        SurfaceHolder holder = this.getHolder();
        holder.addCallback(controller);
        this.setOnTouchListener(controller);
    }

}
