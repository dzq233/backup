package com.DZQ.memory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.DZQ.memory.adapter.MemoryAdapter;
import com.DZQ.memory.bean.MemoryBean;
import com.DZQ.memory.database.MemoryHelper;

import java.util.List;

import DZQ.memory.R;

public class MemoryActivity extends AppCompatActivity {
    //第一步：定义相关变量
    ListView listView;
    MemoryHelper memoryHelper;
    MemoryAdapter adapter;
    List<MemoryBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        // 第二步：初始化控件变量
        //用于显示记录的列表
        listView = findViewById(R.id.listView);
        ImageView add = findViewById(R.id.imageAdd);//(初始化两个控件)
        //通过匿名 内部类的方式实现 imageADD的点击事件，跳转到RecordActivity去添加，并要求能够返回数据
        //此跳转是带数据回传的跳转
        add.setOnClickListener(new View.OnClickListener() {//匿名内部类
            @Override
            public void onClick(View view) {
                //从当前Activity跳转到RecordActivity
                Intent intent = new Intent(MemoryActivity.this,RecordActivity.class);
                //启动带数据回传的Activity
                startActivityForResult(intent,1);
            }
        });
        //第三步：初始化数据
        initData();
    }
    private void initData() {
        memoryHelper = new MemoryHelper(this);//调用MemoryHelper的构造方法创建数据库
        //显示数据
        showQueryData();
        //实现listview的item的点击事件，跳转到修改记录界面，修改后保存并返回到主界面显示修改结果
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                //获取当前item的记录内容，记录内容要用MemoryBean的对象来封装
                MemoryBean memoryBean=list.get(i);//跳转
                //通过Intent实现跳转
                Intent intent=new Intent(MemoryActivity.this,RecordActivity.class);
                //将当前记录的数据添加到intent对象中一起传递
                intent.putExtra("id",memoryBean.getId());//记录的id
                intent.putExtra("content",memoryBean.getMemoryContent());//记录的内容
                intent.putExtra("time",memoryBean.getSaveTime());//记录的时间
                //启动带数据回传的Activity
                startActivityForResult(intent,1);
            }
        });
        }
    private void showQueryData() {
        //判断集合是否有数据
        if (list != null) {
            list.clear();//清除list集合
        }
        //从数据库表中查询所有数据
        list = memoryHelper.queryData();
        //将获取的数据传递到适配器中
        adapter = new MemoryAdapter(this, list);
        //将适配器添加到listview控件中
        listView.setAdapter(adapter);
    }
    //数据回传的回调方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&&resultCode==2){
            showQueryData();
    }
}
}