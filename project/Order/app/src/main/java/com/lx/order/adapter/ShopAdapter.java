package com.lx.order.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.lx.order.R;
import com.lx.order.bean.ShopBean;

import java.util.List;

public class ShopAdapter extends BaseAdapter {
    private Context context;//上下文
    private List<ShopBean> sblist;

    public ShopAdapter(Context context) {//构造方法
        this.context = context;
    }

    /**
     * 设置数据更新界面
     */
    public  void setDate(List<ShopBean> sblist){
        this.sblist=sblist;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {//获取item的总数
        return sblist==null ?0:sblist.size();
    }
    @Override
    public Object getItem(int i) {
     //根据i得到对应的item的对象
        return sblist==null?null:sblist.get(i);
    }
    @Override
    public long getItemId(int i) {
        //根据i得到对应的item的id
        return i;
    }

    /**
     * 得到相应i对应的item的试图，i是当前item的位置
     * view参数是滚出屏幕的item的view
     * @param i
     * @param view
     * @param viewGroup
     * @return
     */

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final  ViewHolde vh;//定义一个viewHolder类的对象
        //复用view
        if(view==null){
               vh=new ViewHolde() ;//实列化一个viewholder对象
            view= LayoutInflater.from(context).inflate(R.layout.shop_item,null);//加载了子布局到view中
            //绑定控件与变量，即初始化控件变量
            vh.tv_shop_name=view.findViewById(R.id.tv_shop_name);
            vh.tv_sale_num=view.findViewById(R.id.tv_sale_num);
            vh.tv_cost=view.findViewById(R.id.tv_cost);
            vh.tv_welfare=view.findViewById(R.id.tv_welfare);
            vh.tv_time=view.findViewById(R.id.tv_time);
            vh.iv_shop_pic=view.findViewById(R.id.iv_shop_pic);
            view.setTag(vh);//将vh放入缓冲中
        }
        else {
            vh= (ViewHolde) view.getTag();//从缓存中取出vh
        }
        //获取i对应的item的数据对象
        final  ShopBean bean= (ShopBean) getItem(i);
        //将数据展示到对应控件上
        if(bean!=null){
            vh.tv_shop_name.setText(bean.getShopName());
            vh.tv_sale_num.setText(" 月售 "+bean.getSaleNum());
            vh.tv_cost.setText(" 起送￥ "+bean.getOfferPrice()+" |配送￥ "+bean.getDistributionCost());
            vh.tv_welfare.setText(bean.getWelfare());
            vh.tv_time.setText(bean.getTime());
            Glide.with(context).load(bean.getShopPic()).error(R.mipmap.ic_launcher).into(vh.iv_shop_pic);//加载网络图片通过Glide框架
        }
        //每个item的点击事件
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击跳转到店铺详情界面

            }
        });
        return view;

    }
    //创建一个viewHolder类，用来作为子布局的控件容器
    class ViewHolde{
        public TextView tv_shop_name,tv_sale_num,tv_cost,tv_welfare,tv_time;
        public ImageView iv_shop_pic;
    }
}
