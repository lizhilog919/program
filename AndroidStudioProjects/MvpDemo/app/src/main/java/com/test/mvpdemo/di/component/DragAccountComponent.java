package com.test.mvpdemo.di.component;

import android.app.Activity;
import android.app.Notification;

import com.test.mvpdemo.di.module.AccountModule;
import com.test.mvpdemo.di.module.ActivityModule;
import com.test.mvpdemo.di.module.ApplicationModule;
import com.test.mvpdemo.ui.module.account.LoginActivity;

/**
 * Created by Li Zhi
 * 2017/4/12.
 */

public final class DragAccountComponent {

    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{

        private ApplicationComponent mApplicationComponent;
        private ActivityModule mActivityModule;
        private AccountModule mAccountModule;

        public Builder applicationModule(ApplicationComponent applicationComponent){
            mApplicationComponent = applicationComponent;
            return this;
        }

        public Builder activityModule(ActivityModule activityModule){
            mActivityModule = activityModule;
            return this;
        }

        public Builder accountModule(AccountModule accountModule){
            mAccountModule = accountModule;
            return this;
        }

        public AccountComponent build(){
            return new AccountComponent() {
                @Override
                public void inject(LoginActivity loginActivity) {
                }

                @Override
                public Activity activity() {
                    return mActivityModule.provideActivity();
                }
            };
        }

    }
}
