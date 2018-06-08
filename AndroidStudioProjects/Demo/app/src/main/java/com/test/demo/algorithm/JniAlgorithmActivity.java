package com.test.demo.algorithm;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.test.demo.R;
import com.test.demo.jni.AlgorithmNativeInterface;

public class JniAlgorithmActivity extends Activity implements View.OnClickListener{

    AlgorithmNativeInterface nativeInterface = new AlgorithmNativeInterface();

    private Button mBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jni_algorithm);
        mBtn = findViewById(R.id.call);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.call:
                nativeInterface.runAlgorithm(5);
        }
    }
}
