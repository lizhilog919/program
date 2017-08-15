package com.test.demo.common.util;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;

/**
 * Created by Li Zhi
 * 2017/4/16.
 */

public class DensityUtil {

    public static int dip2px(Context context, float dip){
        float density = context.getResources().getDisplayMetrics().density;
        return (int) (density * dip + 0.5f);
    }

    public static float px2dip(Context context, int px){
        float density = context.getResources().getDisplayMetrics().density;
        return px/density + 0.5f;
    }

    public static int sp2px(Context context, float sp){
        float density = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (density * sp + 0.5f);
    }

    public static float px2sp(Context context, int px){
        float density = context.getResources().getDisplayMetrics().scaledDensity;
        return px/density + 0.5f;
    }

    public static Point getScreenMetrics(Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int w_screen = dm.widthPixels;
        int h_screen = dm.heightPixels;
        return new Point(w_screen, h_screen);
    }

    public static float getScreenRate(Context context){
        Point point = getScreenMetrics(context);
        float H = point.y;
        float W = point.x;
        return H/W;
    }
}
