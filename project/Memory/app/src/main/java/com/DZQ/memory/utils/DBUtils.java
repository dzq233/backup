package com.DZQ.memory.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
*这是一个工具类，主要定义数据相关的常量和获取系统时间的方法
* */
public class DBUtils {
    //定义数据库常量
    public static final String DATABASE_NAME="Memory";
    public static final String DATABASE_TABLE="Note";
    public static final int DATABASE_VERSION=1;
    //定义数据库的字段常量
    public static final String NOTE_ID="id";//三个表的字段名
    public static final String NOTE_CONTENT="content";
    public static final String NOTE_TIME="savetime";
    //定义一个获取系统时间并格式化输出的方法
        public static final String getTime(){
            //定义要输出的格式
            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            //获取系统时间
            Date date=new Date(System.currentTimeMillis());
            //格式化并返回输出时间
            return simpleDateFormat.format(date);
        }
}
