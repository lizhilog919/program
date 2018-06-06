package com.test.demo.opengl;

import android.app.Activity;
import android.os.Bundle;

import com.test.demo.R;

public class GLActivity extends Activity {

    MySurfaceView mySurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gl);
        mySurfaceView = findViewById(R.id.surfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mySurfaceView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mySurfaceView.onResume();
    }
}
