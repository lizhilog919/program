package com.test.mvpdemo.ui.module.account;

import android.support.annotation.UiThread;

import com.test.mvp.lce.LoadView;
import com.test.mvpdemo.data.model.User;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public interface LoginView extends LoadView {
    @UiThread
    void showSuccess(User user);
}
