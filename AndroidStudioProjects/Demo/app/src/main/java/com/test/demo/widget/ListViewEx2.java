package com.test.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

import com.test.demo.design.memento.Memento;

/**
 * Created by Li Zhi
 * 2017/4/9.
 */

public class ListViewEx2 extends ListView {

    private HorizontalEx2 mHorizontalEx2;
    private int mLastInterceptX,mLastInterceptY;

    public ListViewEx2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListViewEx2(Context context) {
        this(context, null);
    }

    public ListViewEx2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setHorizontalEx2(HorizontalEx2 horizontalEx2) {
        mHorizontalEx2 = horizontalEx2;
    }

    public HorizontalEx2 getHorizontalEx2() {
        return mHorizontalEx2;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mHorizontalEx2.requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_MOVE:
                int diffX = x - mLastInterceptX;
                int diffY = y - mLastInterceptY;
                if(Math.abs(diffX) > Math.abs(diffY)){
                    mHorizontalEx2.requestDisallowInterceptTouchEvent(false);
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        mLastInterceptY = y;
        mLastInterceptX = x;
        return super.dispatchTouchEvent(ev);
    }
}
