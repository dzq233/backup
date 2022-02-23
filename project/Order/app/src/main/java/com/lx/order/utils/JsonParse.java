package com.lx.order.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lx.order.bean.ShopBean;

import java.lang.reflect.Type;
import java.util.List;

public class JsonParse {
    private  static  JsonParse instance;//定义一个jsonparse类的实列

    public JsonParse() {
        //无参构造方法

    }
    public  static  JsonParse getInstance(){
        if(instance==null){
            instance=new JsonParse();
        }
        return instance;
    }
    //使用Gson库解析从服务器获得的json数据
    public List<ShopBean> getShopList(String json){
        //实列化一个Gson类的对象
        Gson gson = new Gson();
        //创建一个TypeTokeb的匿名子类对象，并调用对象的个体type方法
        Type listTyp=new TypeToken<List<ShopBean>>(){}.getType();
        //把获取到的信息集合存到shoplist中
        List<ShopBean> shopList=gson.fromJson(json,listTyp);
        return  shopList;
    }
}
