package com.test.dagger.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.test.dagger.R;
import com.test.dagger.base.BaseActivity;
import com.test.dagger.component.DaggerLauncherComponent;
import com.test.dagger.component.LauncherComponent;
import com.test.dagger.data.LauncherApp;
import com.test.dagger.module.LauncherModule;


import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LauncherActivity extends Activity {


    @BindView(R.id.text)
    TextView mTextView;

    @Inject
    LauncherApp mLauncherApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);
        getComponent().inject(this);
        mLauncherApp.setName("test");
        mTextView.setText(mLauncherApp.toString());
    }

    protected LauncherComponent getComponent(){
        return DaggerLauncherComponent.builder().launcherModule(new LauncherModule()).build();
    }


}
