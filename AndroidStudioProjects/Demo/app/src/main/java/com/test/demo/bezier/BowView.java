package com.test.demo.bezier;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

@SuppressLint("ClickableViewAccessibility")
public class BowView extends View {
	
	private static final int STATUS_DRAGING = 1;
	private static final int STATUS_RELEASING = 2;
	private static final int STATUS_INIT = 0;
	
	private static final int DUARATION = 30;
	private static final int DUARATION2 = 500;
	
	private static final int INIT_X = 500;
	private static final int INIT_Y = 300;
	private static final int RADIUS = 400;
	private static final int BOW_C_HEIGHT = 300;
	private static final int BOW_STRING_HEIGHT_MAX = 200;
	private static final int DECORATE_RADIUS = 25;
	
	private static final int ARROW_LENGTH = 500;
	private static final int ARROW_MAX_DISTANCE = 3000;
	
	private static final int DECORATE_X_OFFSET = 60;
	private static final int DECORATE_Y_OFFSET = 70;
	
	private PointF mBowLeftPoint = new PointF();
	private PointF mBowRightPoint = new PointF();
	private PointF mBowControlPoint = new PointF();
	private PointF mBowStringCenterPoint = new PointF();
	private PointF mBowStringReleasePoint = new PointF();
	private PointF mArrawPoint = new PointF();
	
	private Path mPath = new Path();
	private Paint mBowPaint = new Paint();
	private Paint mBowStringPaint = new Paint();
	private Paint mDecoratePaint = new Paint();
	private Paint mArrowPaint = new Paint();
	private Paint mPointPaint = new Paint();
	
	private int mStatus = STATUS_INIT;
	
	private boolean isFlying = false;
	
	private ValueAnimator mBowStringAnimator;
	private ValueAnimator mArrowAnimator;

	public BowView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public BowView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public BowView(Context context) {
		this(context, null);
	}
	
	private void init(){
		mBowPaint.setStrokeWidth(20);
		mBowPaint.setColor(Color.DKGRAY);
		mBowPaint.setStyle(Style.STROKE);
		mBowPaint.setAntiAlias(true);
		
		mBowStringPaint.setStrokeWidth(4);
		mBowStringPaint.setStyle(Style.STROKE);
		mBowStringPaint.setColor(Color.RED);
		mBowPaint.setAntiAlias(true);
		
		mDecoratePaint.setStyle(Style.FILL);
		mDecoratePaint.setColor(Color.BLACK);
		mDecoratePaint.setAntiAlias(true);
		
		mArrowPaint = new Paint();
		mArrowPaint.setStyle(Style.STROKE);
		mArrowPaint.setColor(Color.BLACK);
		mArrowPaint.setStrokeWidth(8);
		mArrowPaint.setAntiAlias(true);

		mPointPaint.setColor(Color.BLUE);
		mPointPaint.setStyle(Paint.Style.FILL);
		mPointPaint.setStrokeWidth(10);
		
		mBowLeftPoint.set(INIT_X - RADIUS, INIT_Y);
		mBowRightPoint.set(INIT_X + RADIUS,  INIT_Y);
		mBowControlPoint.set(INIT_X, INIT_Y + BOW_C_HEIGHT);
		mBowStringCenterPoint.set(INIT_X, INIT_Y);
		
		mBowStringAnimator = ValueAnimator.ofFloat(0, DUARATION);
		mBowStringAnimator.setDuration(DUARATION);
		mBowStringAnimator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float value = (float) animation.getAnimatedValue();
				mBowStringCenterPoint.set(INIT_X, mBowStringReleasePoint.y + value);
				computeDraging(mBowStringCenterPoint);
				invalidate();
			}
		});
		mBowStringAnimator.addListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator animation) {
				
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				mStatus = STATUS_INIT;
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				
			}
		});
		mArrowAnimator = ValueAnimator.ofFloat(0, ARROW_MAX_DISTANCE);
		mArrowAnimator.setDuration(DUARATION2);
		mArrowAnimator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float value = (float) animation.getAnimatedValue();
				mArrawPoint.set(INIT_X, mBowStringReleasePoint.y + value);
				invalidate();
			}
		});
		mArrowAnimator.addListener(new AnimatorListener() {
			
			@Override
			public void onAnimationStart(Animator animation) {
				isFlying = true;
			}
			
			@Override
			public void onAnimationRepeat(Animator animation) {
				
			}
			
			@Override
			public void onAnimationEnd(Animator animation) {
				isFlying = false;
			}
			
			@Override
			public void onAnimationCancel(Animator animation) {
				
			}
		});
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			PointF point = new PointF(event.getX(), event.getY());
			PointF originPoint = new PointF(INIT_X, INIT_Y);
			float distance = GraphUtil.distance4PointF(point, originPoint);
			if(distance < 200 && mStatus == STATUS_INIT){
				mStatus = STATUS_DRAGING;
			}
			break;
		case MotionEvent.ACTION_MOVE:
			if(event.getY() < INIT_Y && event.getY() > INIT_Y - BOW_STRING_HEIGHT_MAX){
				if(mStatus == STATUS_DRAGING){
					mBowStringCenterPoint.set(INIT_X, event.getY());
					mArrawPoint.set(mBowStringCenterPoint);
					computeDraging(mBowStringCenterPoint);
					invalidate();
				}
			}
			break;
		case MotionEvent.ACTION_UP:
			if(mBowControlPoint.y != INIT_Y && mStatus == STATUS_DRAGING){
				mStatus = STATUS_RELEASING;
				mBowStringReleasePoint.set(mBowStringCenterPoint.x, mBowStringCenterPoint.y);
				startBowStringAnimation();
				startArrowAnimation();
			}
			break;
		}
		return true;
	}
	
	private void computeDraging(PointF point){
		float ratio = (INIT_Y - point.y) / BOW_STRING_HEIGHT_MAX;
		mBowLeftPoint.set(INIT_X - RADIUS + DECORATE_X_OFFSET * ratio, INIT_Y - DECORATE_Y_OFFSET * ratio);
		mBowRightPoint.set(INIT_X + RADIUS - DECORATE_X_OFFSET * ratio, INIT_Y - DECORATE_Y_OFFSET * ratio);
	}
	
	private void startBowStringAnimation(){
		mBowStringAnimator.setFloatValues(0, INIT_Y - mBowStringReleasePoint.y);
		mBowStringAnimator.setInterpolator(new DecelerateInterpolator());
		mBowStringAnimator.start();
	}
	
	private void startArrowAnimation(){
		float ratio = (INIT_Y - mBowStringReleasePoint.y) / BOW_STRING_HEIGHT_MAX;
		float distance = ARROW_MAX_DISTANCE * ratio * ratio;
		mArrowAnimator.setFloatValues(0, distance);
		mArrowAnimator.setInterpolator(new DecelerateInterpolator());
		mArrowAnimator.start();
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		mPath.reset();
		mPath.moveTo(mBowLeftPoint.x, mBowLeftPoint.y);
		mPath.quadTo(mBowControlPoint.x, mBowControlPoint.y, mBowRightPoint.x, mBowRightPoint.y);
		canvas.drawPath(mPath, mBowPaint);
		canvas.drawLine(mBowStringCenterPoint.x, mBowStringCenterPoint.y, mBowLeftPoint.x, mBowLeftPoint.y, mBowStringPaint);
		canvas.drawLine(mBowStringCenterPoint.x, mBowStringCenterPoint.y, mBowRightPoint.x, mBowRightPoint.y, mBowStringPaint);
		canvas.drawCircle(mBowLeftPoint.x, mBowLeftPoint.y, DECORATE_RADIUS, mDecoratePaint);
		canvas.drawCircle(mBowRightPoint.x, mBowRightPoint.y, DECORATE_RADIUS, mDecoratePaint);
		if(mStatus == STATUS_DRAGING || isFlying){
			canvas.drawLine(mArrawPoint.x, mArrawPoint.y, mArrawPoint.x, mArrawPoint.y + ARROW_LENGTH, mArrowPaint);
			canvas.drawLine(mArrawPoint.x, mArrawPoint.y + ARROW_LENGTH -3, mArrawPoint.x - 20, mArrawPoint.y + ARROW_LENGTH - 40, mArrowPaint);
			canvas.drawLine(mArrawPoint.x, mArrawPoint.y + ARROW_LENGTH -3, mArrawPoint.x + 20, mArrawPoint.y + ARROW_LENGTH - 40, mArrowPaint);
		}

		canvas.drawPoint(mBowLeftPoint.x, mBowLeftPoint.y,mPointPaint);
		canvas.drawPoint(mBowRightPoint.x,mBowRightPoint.y,mPointPaint);
		canvas.drawPoint(mBowControlPoint.x,mBowControlPoint.y,mPointPaint);
		canvas.drawPoint(mArrawPoint.x, mArrawPoint.y,mPointPaint);
	}
	
	@Override
	protected void onDetachedFromWindow() {
		if(mBowStringAnimator != null){
			mBowStringAnimator.cancel();
		}
		if(mArrowAnimator != null){
			mArrowAnimator.cancel();
		}
		super.onDetachedFromWindow();
	}
}
