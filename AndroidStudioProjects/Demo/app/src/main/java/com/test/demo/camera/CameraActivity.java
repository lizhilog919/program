package com.test.demo.camera;

import android.graphics.Color;
import android.hardware.Camera;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.test.demo.BaseActivity;
import com.test.demo.R;
import com.test.demo.common.util.DensityUtil;

public class CameraActivity extends BaseActivity {

    CameraSurfaceView mCameraSurfaceView;
    private Button mBtnReverse;
    private Button mBtnTake;
    private Button mBtnPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handleStatusBar();
        setContentView(R.layout.activity_camera);
        initView();
    }

    private void handleStatusBar(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
    }

    protected void initView(){
        mCameraSurfaceView = (CameraSurfaceView) findViewById(R.id.cameraView);
        mCameraSurfaceView.setOnTouchListener(mCameraTouchListener);
        mBtnReverse = (Button) findViewById(R.id.reverse);
        mBtnReverse.setOnClickListener(mReserveClickListener);
        mBtnTake = (Button) findViewById(R.id.take);
        mBtnTake.setOnClickListener(mTakeClickListener);
        mBtnPhoto = (Button) findViewById(R.id.check);
        mBtnPhoto.setOnClickListener(mPhotoClickListener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private View.OnTouchListener mCameraTouchListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            int x = (int) event.getX();
            int y = (int) event.getY();
            if(mCameraSurfaceView != null){
                mCameraSurfaceView.focus(x,y);
            }
            return true;
        }
    };
    private View.OnClickListener mReserveClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mCameraSurfaceView.reverseCamera();
        }
    };
    private View.OnClickListener mTakeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(mActivity, "take picture", Toast.LENGTH_SHORT).show();
            mCameraSurfaceView.takePicture();
        }
    };
    private View.OnClickListener mPhotoClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

}
