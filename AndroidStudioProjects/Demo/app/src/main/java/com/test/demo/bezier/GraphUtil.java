package com.test.demo.bezier;

import android.graphics.PointF;

/**
 * Created by Li Zhi
 * 2017/8/13.
 */

public class GraphUtil {

    public static float distance4PointF(PointF start, PointF end){
        return (float) Math.sqrt((end.x - start.x) * (end.x - start.x) + (end.y - start.y) * (end.y - start.y));
    }
}
