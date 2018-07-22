package com.unbone.corp.recycleview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    ListView listView ;
    HashMapAdapter hashMapAdapter;
    ArrayList arrayList = new ArrayList();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataDefine();
        defineView();
    }

    private void dataDefine() {

        HashMap hashMap = new HashMap();
        hashMap.put("name","nm1");
        hashMap.put("tableNo","tNo1");
        arrayList.add(hashMap);
        hashMap = new HashMap();
        hashMap.put("name","nm2");
        hashMap.put("tableNo","tNo2");

        arrayList.add(hashMap);

    }

    private void defineView() {

ArrayAdapter arrayAdapter;


        hashMapAdapter = new HashMapAdapter(this,arrayList);
        listView = findViewById(R.id.listview_test);
        listView.setAdapter(hashMapAdapter);
    }
}
