package com.test.mvpdemo.presenter.base;

import com.test.mvp.BaseMvpPresenter;
import com.test.mvp.MvpView;

import rx.subscriptions.CompositeSubscription;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public class RxMvpPresenter<V extends MvpView> extends BaseMvpPresenter<V> {

    protected CompositeSubscription mSubscription;

    @Override
    public void attachView(V view) {
        super.attachView(view);
        mSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        super.detachView();
        mSubscription.clear();
        mSubscription = null;
    }
}
