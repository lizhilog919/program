package com.test.demo.io.okio;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.test.demo.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class OkioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okio);
        readFileByNio();
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    private void readFileByNio(){
        try {

            RandomAccessFile file = new RandomAccessFile("file:///android_asset/test.txt","rw");
            FileChannel channel = file.getChannel();
            RandomAccessFile toFile = new RandomAccessFile("file:///android_asset/to.txt","rw");
            FileChannel toFileChanel = toFile.getChannel();
            toFileChanel.transferFrom(channel,0,channel.size());

            InputStream inputStream = getAssets().open("to.txt");
            BufferedSource bufferedSource = Okio.buffer(Okio.source(inputStream));
            String result = bufferedSource.readUtf8();
            Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(){
        InputStream inputStream = null;
        try {
            inputStream = getAssets().open("test.txt");
            BufferedSource bufferedSource = Okio.buffer(Okio.source(inputStream));
            String result = bufferedSource.readUtf8();
            bufferedSource.close();
            Toast.makeText(this,result,Toast.LENGTH_SHORT).show();

            File file = new File(getFilesDir() + "/test.txt");
            if(!file.exists()){
                file.createNewFile();
            }
            BufferedSink bufferedSink = Okio.buffer(Okio.sink(file));
            bufferedSink.writeUtf8("lizhi test");
            bufferedSink.writeUtf8("\nxxxx");
            bufferedSink.close();

            BufferedSource source = Okio.buffer(Okio.source(new File(getFilesDir() + "/test.txt")));
            Toast.makeText(this,source.readUtf8(),Toast.LENGTH_SHORT).show();
            source.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
