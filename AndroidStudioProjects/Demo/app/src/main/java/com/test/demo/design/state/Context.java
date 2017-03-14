package com.test.demo.design.state;

/**
 * Created by Li Zhi
 * 2017/3/10.
 */

public class Context {
    State mState;

    public void setState(State state) {
        mState = state;
    }

    public State getState() {
        return mState;
    }

    public void method(){
        switch (mState){
            case STATE_1:
                mState.method1();
                break;
            case STATE_2:
                mState.method2();
                break;
            default:
        }
    }
}
