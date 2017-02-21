package com.test.demo.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lizhi
 * 17-2-16
 */
public class Dog implements Parcelable {

    public Dog(){
    }

    public Dog(Parcel in){
        this.num = in.readInt();
    }


    private int num;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.num);
    }

    public static final Parcelable.Creator<Dog> CREATOR = new Creator<Dog>() {
        @Override
        public Dog createFromParcel(Parcel source) {
            return new Dog(source);
        }

        @Override
        public Dog[] newArray(int size) {
            return new Dog[size];
        }
    };
}
