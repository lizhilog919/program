package com.test.mvp;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public class BaseMvpPresenter<V extends MvpView> implements MvpPresenter<V> {

    protected V mMvpView;

    @Override
    public void attachView(V view) {
        mMvpView = view;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

    public V getMvpView() {
        return mMvpView;
    }

    public boolean isViewAttached(){
        return mMvpView != null;
    }

    public void checkViewAttached(){
        if(!isViewAttached()){
            throw new MvpViewNotAttachException();
        }
    }

    public static class MvpViewNotAttachException extends RuntimeException{
        public MvpViewNotAttachException(){
            super("please call MvpPresenter.attachView() before bind data to MvpView");
        }
    }

}
