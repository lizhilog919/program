package com.test.demo.test;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.test.demo.R;
import com.test.demo.io.serialzable.Cat;
import com.test.demo.io.serialzable.SerializableUtil;

import java.io.IOException;

public class NormalTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal_test);
        testSerializable();
    }

    private void testSerializable(){
        Cat cat = new Cat("test", 1, 2);
        try {
            String path = Environment.getExternalStorageDirectory() + "/serializable.txt";
            SerializableUtil.write(cat, path);
            Cat cat1 = SerializableUtil.read(path);
            Toast.makeText(this,cat1.toString(),Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
