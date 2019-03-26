package com.example.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionMode extends AppCompatActivity {
    private String[] names = {"one","two","three","four","five"};
    private boolean[] isCheck ={false,false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listview);
        List<Map<String,Object>> listItems = new ArrayList<Map<String,Object>>();
        for(int i=0;i<names.length;i++){
            Map<String, Object> showitem = new HashMap<String,Object>();
            showitem.put("touxiang",R.drawable.android);
            showitem.put("name",names[i]);
            listItems.add(showitem);
        }
        SimpleAdapter adapter = new SimpleAdapter(getApplicationContext(), listItems,R.layout.list_item2,
                new String[]{"touxiang","name"},new int[]{R.id.androidimg,R.id.num});
        final ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setDrawSelectorOnTop(true);


        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {

            @Override
            public void onItemCheckedStateChanged(android.view.ActionMode mode, int position, long id, boolean checked) {
              if (checked){
                  View view = (View) listView.getChildAt(position);
                  view.setBackgroundColor(getResources().getColor(R.color.blue));
                  isCheck[position]=true;
              }else {
                  View view = (View) listView.getChildAt(position);
                  view.setBackgroundColor(Color.TRANSPARENT);
                  isCheck[position]=false;
              }
              int c = 0;
              for (int i=0;i<isCheck.length;i++){
                if (isCheck[i]){
                    c++;
                }
              }
              mode.setTitle(c+"选中对象");
            }

            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.delete_menu, menu);
//                mode.setTitle("选中对象");
                return true;

            }

            @Override
            public boolean onPrepareActionMode(android.view.ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(android.view.ActionMode mode, MenuItem item) {

                return false;
            }

            @Override
            public void onDestroyActionMode(android.view.ActionMode mode) {

            }
        });

    }
}
