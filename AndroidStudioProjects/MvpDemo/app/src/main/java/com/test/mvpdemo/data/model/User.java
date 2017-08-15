package com.test.mvpdemo.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Li Zhi
 * 2017/4/11.
 */

public class User implements Parcelable {

    private String name;
    private String password;

    public User() {
    }

    public User(Parcel parcel) {
        name = parcel.readString();
        password = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(password);
    }

    public static final Parcelable.Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel parcel) {
            return new User(parcel);
        }

        @Override
        public User[] newArray(int i) {
            return new User[i];
        }
    };
}
