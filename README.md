# UI
第二次实验
# 1.  Android ListView 的用法

Activity文件：

```
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

```

ListView布局文件：

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="horizontal"
    >
    <TextView
        android:layout_width="30dp"
        android:layout_height="30dp"
        android:id="@+id/name"
        android:layout_weight="1"
        android:text="text"
        />
    <ImageView
        android:layout_width="30dp"
        android:layout_height="30dp"
        android:id="@+id/imgtou"
        android:background="@drawable/dog"
        android:padding="2dp"
        />
</LinearLayout>
```

主布局文件：

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    xmlns:app="http://schemas.android.com/apk/res-auto">
    <ListView
        android:id="@+id/listview"
        android:layout_width="match_parent"
        android:layout_height="match_parent">
    </ListView>
</android.support.constraint.ConstraintLayout>
```

截图：

![](http://ww1.sinaimg.cn/large/8cc1690dgy1g1e9utkkcoj20a50gimya.jpg)



# 2. 创建自定义布局的AlertDialog

activity文件：

```
package com.example.ui;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;

public class Dialog1 extends DialogFragment {
    @NonNull
    @Override
    public android.app.Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = getActivity().getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_signin, null))
                // Add action buttons
                .setPositiveButton(R.string.signin, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Dialog1.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}

```

布局文件：

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content">
    <ImageView

        android:layout_width="match_parent"
        android:layout_height="64dp"
        android:scaleType="center"
        android:background="#FFFFBB33"
        android:contentDescription="@string/app_name" />
    <EditText
        android:id="@+id/username"
        android:inputType="textEmailAddress"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="16dp"
        android:layout_marginLeft="4dp"
        android:layout_marginRight="4dp"
        android:layout_marginBottom="4dp"
        android:hint="@string/username" />
    <EditText
        android:id="@+id/password"
        android:inputType="textPassword"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="4dp"
        android:layout_marginLeft="4dp"
        android:layout_marginRight="4dp"
        android:layout_marginBottom="16dp"
        android:fontFamily="sans-serif"
        android:hint="@string/password"/>
</LinearLayout>

```

截图：

![](http://ww1.sinaimg.cn/large/8cc1690dgy1g1e9wiefmtj20a60ha3z0.jpg)



# 3. 使用 XML 定义菜单

activity 文件

```
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

```

页面布局文件：

```
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".XmlMenu">

    <EditText
        android:id="@+id/editText"
        android:layout_width="306dp"
        android:layout_height="55dp"
        android:layout_marginStart="8dp"
        android:layout_marginLeft="8dp"
        android:layout_marginTop="16dp"
        android:ems="10"
        android:inputType="textPersonName"
        android:text="用于测试的内容"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        />
</android.support.constraint.ConstraintLayout>
```

菜单布局文件：

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
        <item
            android:id="@+id/item1"
            android:title="@string/textsize">
                <menu>
                    <item
                        android:id="@+id/small"
                        android:title="@string/samll">
                    </item>
                    <item
                        android:id="@+id/middle"
                        android:title="@string/middle">
                    </item>
                    <item
                        android:id="@+id/big"
                        android:title="@string/big">
                    </item>
                </menu>
        </item>
        <item android:id="@+id/item2"
            android:title="@string/plainmenu">
        </item>
        <item android:id="@+id/item3"
            android:title="@string/fontcolor">
            <menu>
                <item
                    android:title="@string/red"
                    android:id="@+id/red">

                </item>
                <item android:title="@string/black"
                    android:id="@+id/black">

                </item>
            </menu>
        </item>
</menu>
```

截图：

![](http://ww1.sinaimg.cn/large/8cc1690dgy1g1ea4eu0x5j20a60hat9g.jpg)

# 4. 创建上下文操作模式 (ActionMode) 的上下文菜单

activity文件：

```
package com.example.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActionMode extends AppCompatActivity {
    private String[] names = {"one","two","three","four","five"};
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
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(android.view.ActionMode mode, int position, long id, boolean checked) {

            }

            @Override
            public boolean onCreateActionMode(android.view.ActionMode mode, Menu menu) {
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.delete_menu, menu);
                mode.setTitle("选中对象");
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

```

布局文件1：

```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <ImageView
        android:layout_width="30dp"
        android:layout_height="30dp"
        android:id="@+id/androidimg"

        android:padding="2dp"
        />
    <TextView
        android:layout_width="30dp"
        android:layout_height="30dp"
        android:id="@+id/num"
        android:layout_weight="1"

        />

</LinearLayout>

```

菜单布局文件2：

```
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:icon="@drawable/delete" android:title="@string/delete"></item>
</menu>
```

截图：

![](http://ww1.sinaimg.cn/large/8cc1690dgy1g1eaaw6kqvj20a60ha74z.jpg)

