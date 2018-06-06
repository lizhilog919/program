package com.test.demo.jni;

public class AlgorithmNativeInterface {

    static {
        System.loadLibrary("native-lib");
    }


    public native void runAlgorithm(int id);

}
