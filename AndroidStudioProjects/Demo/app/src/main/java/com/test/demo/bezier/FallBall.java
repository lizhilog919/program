package com.test.demo.bezier;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class FallBall extends View {
	
	public static final String TAG = "FallBall";
	
	private static final float RATIO = 0.5522f;
	private static final int RADIUS = 200;
	private static final int INIT_CENTER_X = 600;
	private static final int INIT_CENTER_Y = 200;
	private static final int HEIGHT = 1000;
	
	private static final int DURATION = 2000;
	private static final int DURATION2 = 300;
	private float mAcceSpeed;
	
	private int mCurrentCenterX = INIT_CENTER_X;
	private int mCurrentCenterY = INIT_CENTER_Y;
	private Point mCenterPoint = new Point(mCurrentCenterX, mCurrentCenterY);
	private Point mLastPoint = new Point();
	
	private Point mLeftStartPoint = new Point();
	private Point mTopStartPoint = new Point();
	private Point mRightStartPoint = new Point();
	private Point mBottomStartPoint = new Point();
	
	private Point mLeftControlPoint_1 = new Point();
	private Point mTopControlPoint_1 = new Point();
	private Point mRightControlPoint_1 = new Point();
	private Point mBottomControlPoint_1 = new Point();
	
	private Point mLeftControlPoint_2 = new Point();
	private Point mTopControlPoint_2 = new Point();
	private Point mRightControlPoint_2 = new Point();
	private Point mBottomControlPoint_2 = new Point();
	
	private Paint mPaint = new Paint();
	private Paint mFloorPaint = new Paint();

	private Paint mPointPaint = new Paint();
	
	private Path mPath = new Path();
	
	private ValueAnimator mValueAnimator;
	private ValueAnimator mValueAnimator2;
	private ValueAnimator mValueAnimator3;
	private ValueAnimator mValueAnimator4;
	private AnimatorSet mAnimatorSet;

	public FallBall(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public FallBall(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public FallBall(Context context) {
		this(context, null);
	}
	
	private void init(){
		mPaint.setAntiAlias(true);
		mPaint.setColor(Color.RED);
		mFloorPaint.setAntiAlias(true);
		mFloorPaint.setColor(Color.GRAY);
		mFloorPaint.setStrokeWidth(340);
		mPointPaint.setColor(Color.BLUE);
		mPointPaint.setStyle(Paint.Style.FILL);
		mPointPaint.setStrokeWidth(10);
		mAcceSpeed = HEIGHT *2.0f / (DURATION * DURATION);
		mAnimatorSet = new AnimatorSet();
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		mValueAnimator = ValueAnimator.ofInt(0,DURATION);
		mValueAnimator.setDuration(DURATION);
		mValueAnimator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int value = (int) animation.getAnimatedValue();
				Log.v(TAG, "time :" +  value);
				mCenterPoint.y = (int) (INIT_CENTER_Y + 0.5f * mAcceSpeed * value * value);
				computePoint(mCenterPoint);
				invalidate();
			}
		});
		mValueAnimator.addListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator animation) {
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				mLastPoint.y = mLeftStartPoint.y;
				mLastPoint.x = mLeftStartPoint.x;
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				
			}
		});
		mValueAnimator2 = ValueAnimator.ofInt(0, DURATION2);
		mValueAnimator2.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int value = (int)animation.getAnimatedValue();
				int h = RADIUS * 2 + HEIGHT - mLastPoint.y;
				float acceSpeed = (2.0f * h) / (DURATION2 * DURATION2);
				mCenterPoint.y = (int) (RADIUS * 2 + HEIGHT - RADIUS + acceSpeed * DURATION2 * value - 0.5f * acceSpeed * value * value);
				computePoint(mCenterPoint);
				float acceSpeed2 = (float) ((RADIUS / Math.sqrt(2)) * RATIO * 2.0f / (DURATION2 * DURATION2));
				float s = (acceSpeed2 * DURATION2 * value - 0.5f * acceSpeed2 * value * value);
				mBottomControlPoint_1.x = (int) (mBottomStartPoint.x - RADIUS / Math.sqrt(2) * RATIO  + s);
				mBottomControlPoint_1.y = (int) (mBottomStartPoint.y + RADIUS / Math.sqrt(2) * RATIO - s);
				mBottomControlPoint_2.x = (int) (mLeftStartPoint.x + RADIUS / Math.sqrt(2) * RATIO  - s);
				mBottomControlPoint_2.y = (int) (mLeftStartPoint.y + RADIUS / Math.sqrt(2) * RATIO  - s);
					
				invalidate();
			}
		});
		mValueAnimator2.setDuration(DURATION2);
		mValueAnimator3 = ValueAnimator.ofInt(DURATION2);
		mValueAnimator3.setDuration(DURATION2);
		mValueAnimator3.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int value = (int)animation.getAnimatedValue();
				int h = RADIUS * 2 + HEIGHT - mLastPoint.y;
				float acceSpeed = (2.0f * h) / (DURATION2 * DURATION2);
				mCenterPoint.y = (int) (RADIUS * 2 + HEIGHT - RADIUS + h - 0.5f * acceSpeed * value * value);
				computePoint(mCenterPoint);
				float acceSpeed2 = (float) ((RADIUS / Math.sqrt(2)) * RATIO * 2.0f / (DURATION2 * DURATION2));
				float s = 0.5f * acceSpeed2 * value * value;
				mBottomControlPoint_1.x = (int) (mBottomStartPoint.x - s);
				mBottomControlPoint_1.y = (int) (mBottomStartPoint.y + s);
				mBottomControlPoint_2.x = (int) (mLeftStartPoint.x + s);
				mBottomControlPoint_2.y = (int) (mLeftStartPoint.y + s);	
				invalidate();
			}
		});
		mValueAnimator4 = ValueAnimator.ofInt(DURATION);
		mValueAnimator4.setDuration(DURATION);
		mValueAnimator4.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				int value = (int) animation.getAnimatedValue();
				Log.v(TAG, "time :" +  value);
				mCenterPoint.y = (int) ( INIT_CENTER_Y + HEIGHT - (mAcceSpeed * DURATION * value - 0.5f * mAcceSpeed * value * value));
				computePoint(mCenterPoint);
				invalidate();
			}
		});
		mAnimatorSet.playSequentially(new Animator[]{mValueAnimator, mValueAnimator2, mValueAnimator3, mValueAnimator4});
		mAnimatorSet.start();
		mAnimatorSet.addListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				mAnimatorSet.start();
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				
			}
		});
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		mPath.reset();
		mPath.moveTo(mLeftStartPoint.x, mLeftStartPoint.y);
		mPath.cubicTo(mLeftControlPoint_1.x, mLeftControlPoint_1.y, mLeftControlPoint_2.x, mLeftControlPoint_2.y, mTopStartPoint.x, mTopStartPoint.y);
		mPath.cubicTo(mTopControlPoint_1.x, mTopControlPoint_1.y, mTopControlPoint_2.x, mTopControlPoint_2.y, mRightStartPoint.x, mRightStartPoint.y);
		mPath.cubicTo(mRightControlPoint_1.x, mRightControlPoint_1.y, mRightControlPoint_2.x, mRightControlPoint_2.y, mBottomStartPoint.x, mBottomStartPoint.y);
		mPath.cubicTo(mBottomControlPoint_1.x, mBottomControlPoint_1.y, mBottomControlPoint_2.x, mBottomControlPoint_2.y, mLeftStartPoint.x, mLeftStartPoint.y);
		canvas.drawPath(mPath, mPaint);
		
		canvas.drawLine(0, RADIUS * 2 + HEIGHT + 170, 1080, RADIUS * 2 + HEIGHT + 170, mFloorPaint);

		canvas.drawPoint(mLeftStartPoint.x, mLeftStartPoint.y, mPointPaint);
		canvas.drawPoint(mBottomStartPoint.x, mBottomStartPoint.y, mPointPaint);
		canvas.drawPoint(mBottomControlPoint_1.x, mBottomControlPoint_1.y, mPointPaint);
		canvas.drawPoint(mBottomControlPoint_2.x,mBottomControlPoint_2.y,mPointPaint);
		super.onDraw(canvas);
	}
	
	
	private void computePoint(Point centerPoint){
		mLeftStartPoint.x = (int) (centerPoint.x - RADIUS/ Math.sqrt(2));
		mLeftStartPoint.y = (int) (centerPoint.y + RADIUS/ Math.sqrt(2));
		mTopStartPoint.x = (int) (centerPoint.x - RADIUS/ Math.sqrt(2));
		mTopStartPoint.y = (int) (centerPoint.y - RADIUS/ Math.sqrt(2));
		mRightStartPoint.x = (int) (centerPoint.x + RADIUS/ Math.sqrt(2));
		mRightStartPoint.y = (int) (centerPoint.y - RADIUS/ Math.sqrt(2));
		mBottomStartPoint.x = (int) (centerPoint.x + RADIUS/ Math.sqrt(2));
		mBottomStartPoint.y = (int) (centerPoint.y + RADIUS/ Math.sqrt(2));
		
		mLeftControlPoint_1.x = (int) (mLeftStartPoint.x - RADIUS / Math.sqrt(2) * RATIO);
		mLeftControlPoint_1.y = (int) (mLeftStartPoint.y - RADIUS / Math.sqrt(2) * RATIO);
		mTopControlPoint_1.x = (int) (mTopStartPoint.x + RADIUS / Math.sqrt(2) * RATIO);
		mTopControlPoint_1.y = (int) (mTopStartPoint.y - RADIUS / Math.sqrt(2) * RATIO);
		mRightControlPoint_1.x = (int) (mRightStartPoint.x + RADIUS / Math.sqrt(2) * RATIO);
		mRightControlPoint_1.y = (int) (mRightStartPoint.y + RADIUS / Math.sqrt(2) * RATIO);
		mBottomControlPoint_1.x = (int) (mBottomStartPoint.x - RADIUS / Math.sqrt(2) * RATIO);
		mBottomControlPoint_1.y = (int) (mBottomStartPoint.y + RADIUS / Math.sqrt(2) * RATIO);
		
		mLeftControlPoint_2.x = (int) (mTopStartPoint.x - RADIUS / Math.sqrt(2) * RATIO);
		mLeftControlPoint_2.y = (int) (mTopStartPoint.y + RADIUS / Math.sqrt(2) * RATIO);
		mTopControlPoint_2.x = (int) (mRightStartPoint.x - RADIUS / Math.sqrt(2) * RATIO);
		mTopControlPoint_2.y = (int) (mRightStartPoint.y - RADIUS / Math.sqrt(2) * RATIO);
		mRightControlPoint_2.x = (int) (mBottomStartPoint.x + RADIUS / Math.sqrt(2) * RATIO);
		mRightControlPoint_2.y = (int) (mBottomStartPoint.y - RADIUS / Math.sqrt(2) * RATIO);
		mBottomControlPoint_2.x = (int) (mLeftStartPoint.x + RADIUS / Math.sqrt(2) * RATIO);
		mBottomControlPoint_2.y = (int) (mLeftStartPoint.y + RADIUS / Math.sqrt(2) * RATIO);
	}
}
