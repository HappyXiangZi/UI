package com.example.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class listview extends AppCompatActivity {


    private String[] names = {"cat","dog","elephant","lion","monkey","tiger"};
    private int[] imgIds = {R.drawable.cat,R.drawable.dog,R.drawable.elephant,R.drawable.lion,
            R.drawable.monkey,R.drawable.tiger};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);


        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String, Object> showitem = new HashMap<String,Object>();
            showitem.put("touxiang",imgIds[i]);
            showitem.put("name",names[i]);
            listItems.add(showitem);
        }

        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), listItems,R.layout.list_item,
                new String[]{"touxiang","name"},new int[]{R.id.imgtou,R.id.name});
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listview.this,names[position],Toast.LENGTH_SHORT).show();
                for (int i =0;i<names.length;i++){
                    if (i!=position) {
                        View v = parent.getChildAt(i);
                        v.setBackgroundColor(Color.TRANSPARENT);
                    }
                }
                view.setBackgroundColor(Color.RED);
            }
        });
    }
}
