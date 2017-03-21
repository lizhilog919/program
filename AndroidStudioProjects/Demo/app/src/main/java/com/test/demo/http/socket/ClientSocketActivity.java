package com.test.demo.http.socket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.test.demo.BaseActivity;
import com.test.demo.R;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSocketActivity extends BaseActivity implements View.OnClickListener {

    private EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_socket);
        mEditText = (EditText) findViewById(R.id.text);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.button:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        sendMessage();
                    }
                }).start();
                break;
        }
    }

    private void sendMessage(){
        String str = mEditText.getText().toString();
        str = TextUtils.isEmpty(str)?"normal":str;
        Socket socket = null;
        try {
            socket = new Socket("192.168.99.119",1680);
            PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            writer.print(str);
        } catch (IOException e) {
            e.printStackTrace();
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }
}
