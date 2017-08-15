package com.test.mvp.lce;

import android.support.annotation.UiThread;

import com.test.mvp.MvpView;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public interface LoadView extends MvpView {

    @UiThread
    void showLoading();

    @UiThread
    void dismissLoading();

    @UiThread
    void error(Throwable e);
}
