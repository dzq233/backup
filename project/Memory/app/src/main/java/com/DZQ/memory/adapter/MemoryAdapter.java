package com.DZQ.memory.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.DZQ.memory.R;
import com.DZQ.memory.bean.MemoryBean;

import java.util.List;

public class MemoryAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;//加载布局
    private List<MemoryBean> list;//数据列表

    public MemoryAdapter(Context context, List<MemoryBean> list) {
        this.layoutInflater = LayoutInflater.from(context);//拿一个参数加载布局
        this.list = list;
    }
    @Override
    public int getCount() {//获取数据表的记录数量

        return list ==null ? 0 : list.size();
    }
    @Override
    public Object getItem(int i) {//获取对应位置上的每一条记录值
        return list.get(i);
    }
    @Override
    public long getItemId(int i) {//获取记录的编号
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {//获取子布局，即视图界面
        ViewHolder viewHolder;//定义一个ViewHolder类的对象，用来初始控件
            if (view==null){//表示第一次加载
            //加载子布局文件
                view=layoutInflater.inflate(R.layout.memory_item_layout,null);//第一个l是小写
                viewHolder=new ViewHolder(view);//初始化子布局中的两个控件
                view.setTag(viewHolder);//将viewHolder对象添加到convertView中进行缓存
            }else {
            viewHolder= (ViewHolder) view.getTag();//从view缓存中获取viewHolder对象
            }
            //获取数据并显示
        MemoryBean memoryBean= (MemoryBean) getItem(i);//强制转换
        viewHolder.textContent.setText(memoryBean.getMemoryContent());
        viewHolder.textTime.setText(memoryBean.getSaveTime());

        return view;
    }
    //定义一个内部类，用来实现子布局中的两个控件的初始化
    class ViewHolder{
        TextView textContent,textTime;//定义两个控件
        //定义一个构造方法，实现控件的初始化
            public ViewHolder(View view){
                textContent=view.findViewById(R.id.textContent);
                textTime=view.findViewById(R.id.textTime);
            }

    }
}
