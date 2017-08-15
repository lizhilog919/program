package com.test.mvpdemo.presenter;

import com.test.mvp.BaseMvpPresenter;
import com.test.mvpdemo.data.api.AccountApi;
import com.test.mvpdemo.data.model.User;
import com.test.mvpdemo.data.rx.ResponseObserver;
import com.test.mvpdemo.presenter.base.RxMvpPresenter;
import com.test.mvpdemo.ui.module.account.LoginView;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public class LoginPresenter extends RxMvpPresenter<LoginView> {

    private AccountApi mAccountApi;

    LoginPresenter(AccountApi accountApi){
        mAccountApi = accountApi;
    }

    public void login(String name,String password){
        mSubscription.add(mAccountApi.login(name,password)
        .observeOn(Schedulers.io())
                .subscribeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        getMvpView().showLoading();
                    }
                })
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        getMvpView().dismissLoading();
                    }
                })
                .subscribe(new ResponseObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
                        getMvpView().showSuccess(user);
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().error(e);
                    }
                })
        );
    }
}
