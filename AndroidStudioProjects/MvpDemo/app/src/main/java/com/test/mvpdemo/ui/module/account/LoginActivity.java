package com.test.mvpdemo.ui.module.account;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.test.mvp.lce.LoadView;
import com.test.mvpdemo.MvpDemoApplication;
import com.test.mvpdemo.R;
import com.test.mvpdemo.data.model.User;
import com.test.mvpdemo.di.HasComponent;
import com.test.mvpdemo.di.component.AccountComponent;
import com.test.mvpdemo.di.component.ApplicationComponent;
import com.test.mvpdemo.di.component.DragAccountComponent;
import com.test.mvpdemo.di.module.AccountModule;
import com.test.mvpdemo.di.module.ActivityModule;
import com.test.mvpdemo.presenter.LoginPresenter;
import com.test.mvpdemo.ui.base.BaseActivity;
import com.test.mvpdemo.ui.widget.LoadingView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView, HasComponent<AccountComponent> {

    LoadingView mLoadingView;

    @BindView(R.id.name)
    EditText mEditTextName;

    @BindView(R.id.password)
    EditText mEditTextPwd;

    @BindView(R.id.login)
    Button mButtonLogin;

    @Inject
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoadingView = new LoadingView(this, "login...");
        getComponent().inject(this);
    }

    @OnClick(R.id.login)
    public void loginClicked(){
        String name = mEditTextName.getText().toString();
        String password = mEditTextPwd.getText().toString();
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)){
            mLoginPresenter.login(name, password);
        }
    }

    @Override
    public void showSuccess(User user) {

    }

    @Override
    public void showLoading() {
        mLoadingView.show();
    }

    @Override
    public void dismissLoading() {
        mLoadingView.dismiss();
    }

    @Override
    public void error(Throwable e) {
    }

    @Override
    public AccountComponent getComponent() {
        return DragAccountComponent.builder().applicationModule(MvpDemoApplication.getApplication(this).getApplicationComponent())
                .accountModule(new AccountModule())
                .activityModule(new ActivityModule(this))
                .build();
    }
}
