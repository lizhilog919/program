package com.test.demo;

import android.app.Application;
import android.content.Context;
import android.os.Trace;
import android.support.v4.os.TraceCompat;
import android.util.Log;

/**
 * Created by lizhi
 * 17-2-21
 */
public class TestApplication extends Application {
    private static Context sContext;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        CrashHandler handler = CrashHandler.getInstance();
        handler.init(this);
    }

    public static Context getContext(){
        return sContext;
    }

    public static final class CrashHandler implements Thread.UncaughtExceptionHandler{

        private static CrashHandler sInstance = null;

        private CrashHandler(){}

        public static final CrashHandler getInstance(){
            if(sInstance != null){
                synchronized (CrashHandler.class){
                    if (sInstance!=null){
                        sInstance = new CrashHandler();
                    }
                }
            }
            return sInstance;
        }

        public void init(Context context){
            Context c = context.getApplicationContext();
            Thread.setDefaultUncaughtExceptionHandler(this);
        }

        @Override
        public void uncaughtException(Thread thread, Throwable ex) {
            StringBuilder builder = new StringBuilder();
            builder.append("Thread: ");
            builder.append(thread.toString());
            builder.append("\t");
            builder.append(ex.toString());
            Log.e("crash", builder.toString());
        }
    }
}
