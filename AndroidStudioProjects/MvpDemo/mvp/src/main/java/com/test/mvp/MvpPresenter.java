package com.test.mvp;

import android.support.annotation.UiThread;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public interface MvpPresenter<V extends MvpView> {

    @UiThread
    void attachView(V mvpView);

    @UiThread
    void detachView();
}
