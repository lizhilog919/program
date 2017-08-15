package com.test.dagger.base;

import android.app.Activity;
import android.os.Bundle;

import com.test.dagger.DaggerApplication;
import com.test.dagger.DbManager;
import com.test.dagger.component.AppComponent;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Li Zhi
 * 2017/6/9.
 */

public class BaseActivity extends Activity {


    @Inject
    protected DbManager mDbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().inject(this);
    }

    protected AppComponent getAppComponent(){
        return ((DaggerApplication)getApplication()).getAppComponent();
    }

}
