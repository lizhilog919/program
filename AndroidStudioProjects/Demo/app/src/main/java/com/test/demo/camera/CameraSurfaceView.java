package com.test.demo.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Environment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Toast;

import com.test.demo.common.util.DensityUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Li Zhi
 * 2017/4/16.
 */

public final class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Camera.AutoFocusCallback {

    SurfaceHolder mSurfaceHolder;
    Camera mCamera;
    int mCameraNum;
    private int mOrientation;
    boolean mCameraFlag;
    float mPreRate = -1.f;

    public CameraSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CameraSurfaceView(Context context) {
        this(context, null);
    }

    public CameraSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        mSurfaceHolder = getHolder();
        mSurfaceHolder.addCallback(this);
        mSurfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
        mCameraNum = Camera.getNumberOfCameras(); //获取摄像头数量，一般为1或者2
        mPreRate = DensityUtil.getScreenRate(getContext());  //获取屏幕比例
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        openCamera();
    }

    private void openCamera(){
        if (mCamera != null) {  //不为空的时候先销毁
            mCamera.stopPreview();
            mCamera.release();
            mCamera = null;
        }
        if(mCameraNum >= 1){
            mCamera = Camera.open(0);  //默认打开后置摄像头
            mCameraFlag = true;
        }
        startOrientationChangeListener();  //设置屏幕旋转监听
        try {
            mCamera.setPreviewDisplay(mSurfaceHolder);  //设置相机预览surface
            updateCameraOrientation();  //初次矫正方向
            initSize();  //设置屏幕预览尺寸
            initParams();
            mCamera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initParams(){
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_MACRO); // 设置对焦模式
        parameters.setFocusMode(Camera.Parameters.FLASH_MODE_ON);
        //mCamera.setParameters(parameters);
    }

    public void reverseCamera(){
        if(mCameraNum > 1) {
            if (mCamera != null) {  //不为空的时候先销毁
                mCamera.stopPreview();
                mCamera.release();
                mCamera = null;
            }
            mCamera = Camera.open(mCameraFlag ? 1 : 0);
            mCameraFlag = !mCameraFlag;
            try {
                mCamera.setPreviewDisplay(mSurfaceHolder);  //设置相机预览surface
                updateCameraOrientation();  //初次矫正方向
                initSize();  //设置屏幕预览尺寸
                mCamera.startPreview();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void initSize(){
        Camera.Parameters parameters = mCamera.getParameters();
        List<Camera.Size> sizeList = parameters.getSupportedPictureSizes();
        Camera.Size size = getPreSize(sizeList, mPreRate, 800);
        parameters.setPreviewSize(size.width, size.height);
        mCamera.setParameters(parameters);
    }

    private Camera.Size getPreSize(List<Camera.Size> sizes, float rate, int minWidth){
        Collections.sort(sizes, new CameraSizeComparator());
        int i=0;
        for (Camera.Size size : sizes) {
            if(size.width >= minWidth && equalRate(size, rate)){
                break;
            }
            i++;
        }
        if(i == sizes.size()){
            i = 0;
        }
        return sizes.get(i);
    }

    public boolean equalRate(Camera.Size s, float rate){
        float r = (float)(s.width)/(float)(s.height);
        if(Math.abs(r - rate) <= 0.03)
        {
            return true;
        }
        else{
            return false;
        }
    }

    public void takePicture(){
        if(mCamera == null){
            mCamera = Camera.open();
        }
        mCamera.takePicture(mShutterCallback, raw, jpeg);
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        mCamera.startPreview();
        updateCameraOrientation();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mCamera.stopPreview();
        mCamera.release();
        mCamera = null;
    }

    private void updateCameraOrientation(){
        if(mCamera!= null){
            Camera.Parameters parameters = mCamera.getParameters();
            int rotation = 90 + mOrientation == 360?0:90+mOrientation;
            parameters.setRotation(rotation);
            mCamera.cancelAutoFocus();
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            mCamera.setDisplayOrientation(90);  //指定相机顶部画面方向 0表示左侧，90表示手机顶部，180表示手机右侧，270表示手机底部，只能是这些值
            Point point = getBestCameraResolution(parameters, getWidth(), getHeight());
            parameters.setPreviewSize(point.x,point.y);
        }
    }

    private Point getBestCameraResolution(Camera.Parameters parameters, int x, int y){
        float tmp = 0f;
        float mindiff = 100f;
        float x_d_y = x / (float)y;
        Camera.Size best = null;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        for(Camera.Size s : supportedPreviewSizes){
            tmp = Math.abs(((float)s.height/(float)s.width)-x_d_y);
            if(tmp<mindiff){
                mindiff = tmp;
                best = s;
            }
        }
        return new Point(best.width, best.height);
    }

    private void startOrientationChangeListener(){
        OrientationEventListener listener = new OrientationEventListener(getContext()) {
            @Override
            public void onOrientationChanged(int rotation) {
                Log.e("test_ratation: ", rotation+"");
                if (((rotation >= 0) && (rotation <= 45)) || (rotation > 315 )) {
                    rotation = 0;
                } else if ((rotation > 45 ) && (rotation <= 135)) {
                    rotation = 90;
                } else if ((rotation > 135 ) && (rotation <= 225)) {
                    rotation = 180;
                } else if ((rotation > 225 ) && (rotation <= 315)) {
                    rotation = 270;
                } else {
                    rotation = 0;
                }
                if (rotation == mOrientation)
                    return;
                mOrientation = rotation;
                updateCameraOrientation() ;
            }
        };
        listener.enable();
    }

    public void focus(int x, int y){
        if(mCamera != null){
            Camera.Parameters parameters = mCamera.getParameters();
            parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
            if(parameters.getMaxNumFocusAreas() > 0){
                List<Camera.Area> list = new ArrayList<>();
                Rect rect = new Rect(x-50,y-50,x+50,y+50);
                Camera.Area area = new Camera.Area(rect,300);
                list.add(area);
                parameters.setFocusAreas(list);
            }
            mCamera.cancelAutoFocus();
            mCamera.autoFocus(this);
        }
    }


    @Override
    public void onAutoFocus(boolean success, Camera camera) {
        Toast.makeText(getContext(),success+"",Toast.LENGTH_SHORT).show();
    }

    private Camera.ShutterCallback mShutterCallback = new Camera.ShutterCallback() {
        @Override
        public void onShutter() {

        }
    };

    private Camera.PictureCallback raw = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

        }
    };

    private Camera.PictureCallback jpeg = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            mCamera.stopPreview();
            savePicture(data);
            mCamera.startPreview();
        }
    };

    private void savePicture(byte[] data){
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        String name = System.currentTimeMillis() + ".jpg";
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), name);
        if(file.exists()){
            file.delete();
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG,90,fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  class CameraSizeComparator implements Comparator<Camera.Size> {

        @Override
        public int compare(Camera.Size lhs, Camera.Size rhs) {
            if(lhs.width == rhs.width){
                return 0;
            }
            else if(lhs.width > rhs.width){
                return 1;
            }
            else{
                return -1;
            }
        }
    }
}
