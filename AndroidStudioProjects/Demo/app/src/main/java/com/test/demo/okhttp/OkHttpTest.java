package com.test.demo.okhttp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by lizhi
 * 16-12-20
 */
public class OkHttpTest {
    public static void main(String[] args){
        OkHttpUtil.executeRequest();
    }

    public static void executorService(){
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
    }
}
