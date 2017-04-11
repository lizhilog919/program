package com.test.demo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;

/**
 * Created by Li Zhi
 * 2017/4/9.
 */

public class HorizontalEx2 extends ViewGroup {

    private Scroller mScroller;
    private VelocityTracker mTracker;
    int childCount;
    int childIndex;
    int mLastX, mLastY;
    boolean isFirstTouch = true;


    public HorizontalEx2(Context context) {
        this(context, null);
    }

    public HorizontalEx2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalEx2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mScroller = new Scroller(getContext());
        mTracker = VelocityTracker.obtain();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        int width_mode = MeasureSpec.getMode(widthMeasureSpec);
        int height_mode = MeasureSpec.getMode(heightMeasureSpec);
        childCount = getChildCount();
        measureChildren(widthMeasureSpec,heightMeasureSpec);
        if(childCount == 0){
            width = 0;
            height = 0;
        }else if(width_mode == MeasureSpec.AT_MOST && height_mode == MeasureSpec.AT_MOST){
            width = childCount * getChildAt(0).getMeasuredWidth();
            height = getChildAt(0).getMeasuredHeight();
        }else if(width_mode == MeasureSpec.AT_MOST){
            width = childCount * getChildAt(0).getMeasuredWidth();
        }else{
            height = getChildAt(0).getMeasuredHeight();
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int left = 0;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            child.layout(l + left, t, r+ left, b);
            left += child.getMeasuredWidth();
        }
    }

    @Override
    public boolean onInterceptHoverEvent(MotionEvent event) {
        if(MotionEvent.ACTION_DOWN == event.getAction()){
            if(!mScroller.isFinished()){
                mScroller.abortAnimation();
                return true;
            }
            return false;
        }else {
            return true;
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x= (int) event.getX();
        int y = (int) event.getY();
        mTracker.addMovement(event);
        ViewConfiguration configuration = ViewConfiguration.get(getContext());
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if(!mScroller.isFinished()){
                    mScroller.abortAnimation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if(isFirstTouch){
                    mLastX = x;
                    mLastY = y;
                    isFirstTouch = false;
                }
                int diffX = x - mLastX;
                scrollBy(- diffX, 0);
                break;
            case MotionEvent.ACTION_UP:
                int scrollX = getScrollX();
                int childWidth = getChildAt(0).getWidth();
                mTracker.computeCurrentVelocity(1000, configuration.getScaledMaximumFlingVelocity());
                float velocityX  = mTracker.getXVelocity();
                if(Math.abs(velocityX) > configuration.getScaledMinimumFlingVelocity()){
                    childIndex = velocityX < 0?childIndex + 1:childIndex -1;
                }else{
                    childIndex = (scrollX + childWidth/2)/childWidth;
                }
                childIndex = Math.min(getChildCount() -1, Math.max(childIndex, 0));
                smoothScrollBy(childIndex * childWidth -scrollX, 0);
                mTracker.clear();
                isFirstTouch = true;
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }

    @Override
    public void computeScroll() {
        if(mScroller.computeScrollOffset()){
            scrollTo(mScroller.getCurrX(),mScroller.getCurrY());
            invalidate();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mTracker.recycle();
    }

    void smoothScrollBy(int dx, int dy){
        mScroller.startScroll(getScrollX(), getScrollY(),dx, dy, 500);
        invalidate();
    }
}
