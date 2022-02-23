package com.lx.order.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lx.order.R;
import com.lx.order.adapter.ShopAdapter;
import com.lx.order.views.ShopListView;

public class ShopActivity extends AppCompatActivity {
//定义变量第一步
    private TextView tv_back,tv_title;//返回键和标题控件
    private ShopListView slv_list;//列表控件展示店铺
    private RelativeLayout rl_title_bar;//标题栏的布局
    private ShopAdapter adapter;//列表的适配器
    public  static  final  int MSG_SHOP_OK=1;//消息处理的常量，获取数据
    private MHandler mHandler;//定义一个消息处理的类
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        //第二步初始化变量，主要是控件变量的初始化以及数据处理的初始化
        //实列化一个消息处理器
        mHandler=new MHandler();
        initView();//初始化控件

    }

    private void initView() {
        tv_back=findViewById(R.id.tv_back);
        tv_title=findViewById(R.id.tv_title);
        tv_title.setText("店铺");
        rl_title_bar=findViewById(R.id.title_bar);
        rl_title_bar.setBackgroundColor(getResources().getColor(R.color.blue_color));//设置背景涩
        tv_back.setVisibility(View.GONE);//隐藏返回按钮
        //实列化适配器
        adapter=new ShopAdapter(this);
        slv_list.setAdapter(adapter);

    }

    private class MHandler extends Handler {

    }
}