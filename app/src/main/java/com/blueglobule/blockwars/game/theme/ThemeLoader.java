package com.blueglobule.blockwars.game.theme;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.blueglobule.blockwars.R;
import com.blueglobule.blockwars.game.entity.Block;

public class ThemeLoader {

    private Context context;

    public ThemeLoader(Context context) {
        this.context = context;
    }

    public Theme load(int id) {

        // The attributes you want retrieved
        int[] attrs = {
                R.attr.AlphaBlock,
                R.attr.BetaBlock,
                R.attr.GammaBlock,
                R.attr.DeltaBlock,
                R.attr.FiredBlock,
                R.attr.FieldMargin,
                R.attr.FieldColor
        };

        TypedArray ta = context.getTheme().obtainStyledAttributes(id, attrs);

        Drawable alphaBlock = ta.getDrawable(0);
        Drawable betaBlock = ta.getDrawable(1);
        Drawable gammaBlock = ta.getDrawable(2);
        Drawable deltaBlock = ta.getDrawable(3);
        Drawable firedBlock = ta.getDrawable(4);

        float fieldMarginPercent = ta.getFraction(5, 1, 1, 1);

        int fieldColor = ta.getColor(6, Color.WHITE);

        ta.recycle();

        Paint paint = new Paint();
        paint.setColor(fieldColor);

        Theme theme = new Theme()
                .putDrawableBlockId(Block.Type.ALPHA, alphaBlock)
                .putDrawableBlockId(Block.Type.BETA,  betaBlock)
                .putDrawableBlockId(Block.Type.GAMMA, gammaBlock)
                .putDrawableBlockId(Block.Type.DELTA, deltaBlock)
                .setFiredDrawableBlock(firedBlock)
                .setPaint(paint)
                .setFieldMarginPercent(fieldMarginPercent);

        return theme;
    }
}
