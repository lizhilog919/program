package com.test.demo.observable;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by lizhi
 * 17-2-6
 */
public class ObservableUtil {

    public static void execute(){
        Observable<String> observable =Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onStart();
                subscriber.onNext("hello");
                subscriber.onCompleted();
            }
        });


        Observer<String> observer = new Observer<String>() {

            @Override
            public void onCompleted() {
                System.out.println("completed");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("on next : " + s);
            }
        };

        observable.subscribe(observer);
        Observable.just("1", "2", "3", "4", "5").cast(String.class)
                .map(new Func1<String, String>() {
                    @Override
                    public String call(String s) {
                        return s + "+";
                    }
                }).subscribe(new Subscriber<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                System.out.println("on next : " + s);
            }
        });

        Observable.interval(100, TimeUnit.MILLISECONDS, Schedulers.io()).subscribe(new Subscriber<Long>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("on next : " + aLong.intValue());

            }
        });
    }
}
