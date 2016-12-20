package com.test.demo.okio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.test.demo.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

public class OkioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okio);
        readFile();
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
