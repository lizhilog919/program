package com.test.mvp.lce;

import android.support.annotation.UiThread;

import com.test.mvp.MvpView;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public interface LceView<M> extends MvpView {

    @UiThread
    void showLoading();

    @UiThread
    void dismissLoading();

    @UiThread
    void showContent(M data);

    @UiThread
    void showError(Throwable e);

    @UiThread
    void showEmpty();
}
