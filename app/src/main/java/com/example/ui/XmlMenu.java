package com.example.ui;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class XmlMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml_menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        EditText text = findViewById(R.id.editText);
        switch (item.getItemId()){
            case R.id.big:
               text.setTextSize(20);
               break;
            case R.id.small:
                text.setTextSize(10);
                break;
            case R.id.middle:
                text.setTextSize(16);
                break;
            case R.id.item2:
                Toast toast = Toast.makeText(this,"普通菜单项",
                        Toast.LENGTH_SHORT);
                toast.show();
                break;
            case R.id.red:
                text.setTextColor(getResources().getColor(R.color.red));
                break;
            case R.id.black:
                text.setTextColor(getResources().getColor(R.color.black));
            default:
                return super.onOptionsItemSelected(item);
        }
        return super.onOptionsItemSelected(item);
    }
}
