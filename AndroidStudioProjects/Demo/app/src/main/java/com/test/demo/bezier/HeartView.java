package com.test.demo.bezier;


import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;

public class HeartView extends View {
	
	private static final float RATIO = 0.5522f;
	private static final int INIT_X = 400;
	private static final int INIT_Y = 400;
	private static final int RADIUS = 200;
	private static final int DURATION = 500;
	
	private PointF mCenterPoint = new PointF();
	
	private PointF mLeftPoint = new PointF();
	private PointF mTopPoint = new PointF();
	private PointF mRightPoint = new PointF();
	private PointF mBottomPoint = new PointF();
	
	private PointF mLC1Point = new PointF();
	private PointF mLC2Point = new PointF();
	private PointF mTC1Point = new PointF();
	private PointF mTC2Point = new PointF();
	private PointF mRC1Point = new PointF();
	private PointF mRC2Point = new PointF();
	private PointF mBC1Point = new PointF();
	private PointF mBC2Point = new PointF();
	
	private Path mPath = new Path();
	private Paint mPaint = new Paint();
	private Paint mPointPaint = new Paint();
	
	private ValueAnimator mAnimator;

	public HeartView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	public HeartView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public HeartView(Context context) {
		this(context, null);
	}

	private void init(){
		mPaint.setStyle(Style.FILL_AND_STROKE);
		mPaint.setStrokeWidth(5);
		mPaint.setColor(Color.RED);
		mPointPaint.setColor(Color.BLUE);
		mPointPaint.setStyle(Style.FILL);
		mPointPaint.setStrokeWidth(10);
		mCenterPoint.set(INIT_X, INIT_Y);
		mAnimator = ValueAnimator.ofInt(0, DURATION);
		computePoint();
		mAnimator.addUpdateListener(new AnimatorUpdateListener() {
			
			@Override
			public void onAnimationUpdate(ValueAnimator animation) {
				float ratio = ((int)animation.getAnimatedValue()) / (DURATION * 1.0f);
				computePoint();
				mLeftPoint.set(mCenterPoint.x - RADIUS, mCenterPoint.y - RADIUS * RATIO * 0.2f * ratio);
				mRightPoint.set(mCenterPoint.x + RADIUS, mCenterPoint.y - RADIUS * RATIO * 0.2f * ratio);
				mTopPoint.set(mCenterPoint.x, mCenterPoint.y - RADIUS + RADIUS * 0.50f * ratio);
				mBC1Point.set(mBottomPoint.x  - RADIUS * RATIO , mBottomPoint.y - (RADIUS * RATIO * 0.80f * ratio));
				mBC2Point.set(mLeftPoint.x, mLeftPoint.y + RADIUS * RATIO + RATIO * RADIUS * 0.00f * ratio);
				mRC1Point.set(mRightPoint.x,  mRightPoint.y + RADIUS * RATIO + RATIO * RADIUS * 0.00f * ratio);
				mRC2Point.set(mBottomPoint.x + RADIUS * RATIO, mBottomPoint.y - (RADIUS * RATIO * 0.80f * ratio));
				invalidate();
			}
		});
		mAnimator.setDuration(DURATION);
		mAnimator.setStartDelay(1000);
		mAnimator.start();
	}
	
	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
	}
	
	private void computePoint(){
		mLeftPoint.set(mCenterPoint.x - RADIUS, mCenterPoint.y);
		mTopPoint.set(mCenterPoint.x, mCenterPoint.y - RADIUS);
		mRightPoint.set(mCenterPoint.x + RADIUS, mCenterPoint.y);
		mBottomPoint.set(mCenterPoint.x, mCenterPoint.y + RADIUS);
		
		mLC1Point.set(mLeftPoint.x, mLeftPoint.y - RADIUS * RATIO);
		mLC2Point.set(mTopPoint.x - RADIUS * RATIO, mTopPoint.y);
		mTC1Point.set(mTopPoint.x + RADIUS * RATIO, mTopPoint.y);
		mTC2Point.set(mRightPoint.x, mRightPoint.y - RADIUS * RATIO);
		mRC1Point.set(mRightPoint.x,  mRightPoint.y + RADIUS * RATIO);
		mRC2Point.set(mBottomPoint.x + RADIUS * RATIO, mBottomPoint.y);
		mBC1Point.set(mBottomPoint.x - RADIUS * RATIO, mBottomPoint.y);
		mBC2Point.set(mLeftPoint.x, mLeftPoint.y + RADIUS * RATIO);
	}
	
	@Override
	protected void onDraw(Canvas canvas) {

		mPath.reset();
		mPath.moveTo(mLeftPoint.x, mLeftPoint.y);
		mPath.cubicTo(mLC1Point.x, mLC1Point.y, mLC2Point.x, mLC2Point.y, mTopPoint.x, mTopPoint.y);
		mPath.cubicTo(mTC1Point.x, mTC1Point.y, mTC2Point.x, mTC2Point.y, mRightPoint.x, mRightPoint.y);
		mPath.cubicTo(mRC1Point.x, mRC1Point.y, mRC2Point.x, mRC2Point.y, mBottomPoint.x, mBottomPoint.y);
		mPath.cubicTo(mBC1Point.x, mBC1Point.y, mBC2Point.x, mBC2Point.y, mLeftPoint.x, mLeftPoint.y);
		canvas.drawPath(mPath, mPaint);
		canvas.drawPoint(mLeftPoint.x, mLeftPoint.y,mPointPaint);
		canvas.drawPoint(mTopPoint.x,mTopPoint.y, mPointPaint);
		canvas.drawPoint(mLC1Point.x,mLC1Point.y,mPointPaint);
		canvas.drawPoint(mLC2Point.x,mLC2Point.y,mPointPaint);

		canvas.drawPoint(mBC2Point.x,mBC2Point.y,mPointPaint);
		canvas.drawPoint(mBC1Point.x,mBC1Point.y,mPointPaint);
		canvas.drawPoint(mBottomPoint.x,mBottomPoint.y,mPointPaint);
		super.onDraw(canvas);
	}
}
