package com.test.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        toastMaxMemory();
    }

    private void initView(){
        mListView = (ListView) findViewById(R.id.list);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,getList(),android.R.layout.simple_list_item_1,new String[]{"name"},new int[]{android.R.id.text1});
        mListView.setAdapter(simpleAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getList().get(position).get("action")));
            }
        });
    }

    private List<HashMap<String,String>> getList(){
        List<HashMap<String,String>> list = new ArrayList<>();
        list.add(getHashMap("Opengl","COM.TEST.OPENGL"));
        list.add(getHashMap("NativeAlgorithm","COM.TEST.JNI_ALGORITHM"));
        list.add(getHashMap("GifTest","COM.TEST.GIF"));
        list.add(getHashMap("OkioTest","COM.TEST.OKIO"));
        list.add(getHashMap("RetrofitTest","COM.TEST.RETROFIT"));
        list.add(getHashMap("Aidl","COM.TEST.AIDL"));
        list.add(getHashMap("Volley","COM.TEST.VOLLEY"));
        list.add(getHashMap("Normal Test","COM.TEST.NORMAL_TEST"));
        list.add(getHashMap("EventBus","COM.TEST.EVENT_BUS"));
        list.add(getHashMap("Socket","COM.TEST.SOCKET"));
        list.add(getHashMap("Notification","COM.TEST.REMOTEVIEWS"));
        list.add(getHashMap("Xml parser","COM.TEST.XML_PARSER"));
        list.add(getHashMap("Widgets","COM.TEST.WIDGETS"));
        list.add(getHashMap("Bluetooth","COM.TEST.BLUETOOTH"));
        list.add(getHashMap("ThreadTest","COM.TEST.THREAD_TEST"));
        list.add(getHashMap("Camera","COM.TEST.CAMERA"));
        list.add(getHashMap("HeartTest","COM.TEST.HEART"));
        list.add(getHashMap("FallBallTest","COM.TEST.BALL"));
        list.add(getHashMap("BowTest","COM.TEST.BOW"));

        return list;
    }

    private HashMap<String,String> getHashMap(String name, String action){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("name",name);
        hashMap.put("action",action);
        return hashMap;
    }

    private void toastMaxMemory(){
        Runtime runtime = Runtime.getRuntime();
        Toast.makeText(this,((runtime.maxMemory()/1024)/1024)+"",Toast.LENGTH_SHORT).show();
    }
}
