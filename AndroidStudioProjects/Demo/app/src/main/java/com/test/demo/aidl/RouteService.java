package com.test.demo.aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhi
 * 17-2-16
 */
public class RouteService extends Service {

    private List<Dog> mDogList;

    public final IDogManager.Stub mIDogManager = new IDogManager.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public List<Dog> getDogList() throws RemoteException {
            if(mDogList == null){
                mDogList = new ArrayList<>();
            }
            return mDogList;
        }

        @Override
        public void addDog(Dog dog) throws RemoteException {
            if(mDogList == null){
                mDogList = new ArrayList<>();
            }
            mDogList.add(dog);
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIDogManager;
    }
}
