package com.test.demo.io.serialzable;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by lizhilog0919 on 2017/3/6.
 */

public class SerializableUtil {

    public static void write(Cat cat, String path) throws IOException {
        File file = new File(path);{
            if(!file.exists()){
                file.createNewFile();
            }
        }
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(path));
        outputStream.writeObject("start");
        outputStream.writeObject(cat);
        outputStream.writeObject("end");
        outputStream.close();
    }

    public static Cat read(String path) throws IOException, ClassNotFoundException {
        File file = new File(path);{
            if(!file.exists()){
                file.createNewFile();
            }
        }
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(path));
        String start = (String) inputStream.readObject();
        Object object = inputStream.readObject();
        Cat cat;
        if(object instanceof Cat){
             cat = (Cat) object;
        }else{
            cat = null;
        }
        String end = (String) inputStream.readObject();
        return cat;
    }

}
