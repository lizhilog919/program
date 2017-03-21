package com.test.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

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
        list.add(getHashMap("GifTest","COM.TEST.GIF"));
        list.add(getHashMap("OkioTest","COM.TEST.OKIO"));
        list.add(getHashMap("RetrofitTest","COM.TEST.RETROFIT"));
        list.add(getHashMap("AIDL","COM.TEST.AIDL"));
        list.add(getHashMap("VOLLEY","COM.TEST.VOLLEY"));
        list.add(getHashMap("NORMAL_TEST","COM.TEST.NORMAL_TEST"));
        list.add(getHashMap("EventBus","COM.TEST.EVENT_BUS"));
        list.add(getHashMap("Socket","COM.TEST.SOCKET"));
        list.add(getHashMap("Notification","COM.TEST.REMOTEVIEWS"));
        return list;
    }

    private HashMap<String,String> getHashMap(String name, String action){
        HashMap<String,String> hashMap = new HashMap<>();
        hashMap.put("name",name);
        hashMap.put("action",action);
        return hashMap;
    }
}
