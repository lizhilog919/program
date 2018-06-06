package com.test.demo.opengl;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;

@SuppressLint("NewApi")
@TargetApi(Build.VERSION_CODES.CUPCAKE)
public class MySurfaceView extends GLSurfaceView {

    private MyRender mRenderer;

    public MySurfaceView(Context context) {
        this(context, null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        setEGLContextClientVersion(2);
        //创建渲染器实例
        mRenderer = new MyRender();
        // 设置渲染器
        setRenderer(mRenderer);
        //设置渲染模式
        setRenderMode(GLSurfaceView.RENDERMODE_WHEN_DIRTY);
    }
}
