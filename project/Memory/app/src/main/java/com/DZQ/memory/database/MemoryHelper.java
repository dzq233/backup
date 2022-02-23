package com.DZQ.memory.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.DZQ.memory.bean.MemoryBean;
import com.DZQ.memory.utils.DBUtils;

import java.util.ArrayList;
import java.util.List;

public class MemoryHelper extends SQLiteOpenHelper {
    //定义一个数据库的对象
    private static SQLiteDatabase sqLiteDatabase = null;

    public MemoryHelper(@Nullable Context context) {//实现了数据库的创建
        super(context, DBUtils.DATABASE_NAME, null, DBUtils.DATABASE_VERSION);//创建数据库
        sqLiteDatabase = this.getWritableDatabase();//打开数据库的写入权限
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {//创建数据表
        //通过执行SQL语句来创建数据库表
        sqLiteDatabase.execSQL("create table " + DBUtils.DATABASE_TABLE + "(" + DBUtils.NOTE_ID +
                " integer primary key autoincrement,"
                + DBUtils.NOTE_CONTENT + " text," + DBUtils.NOTE_TIME + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //添加数据，即向数据表中插入记录的操作
    public static boolean inserData(String noteContent, String noteTime) {
        //通过ContentValues类来实现数据的序列化，也就持久化，将数据保存到数据表中
        //ContenValues是通过键值对的方式来存储数据，键必须是String类型，值可以是任意的数据类型
        ContentValues contentValues = new ContentValues();//实例化一个CintentValues类的对象
        //将传递过来的内容和时间添加到contentValues对象中
        contentValues.put(DBUtils.NOTE_CONTENT, noteContent);
        contentValues.put(DBUtils.NOTE_CONTENT, noteTime);
        //执行插入方法并返回结果
        return sqLiteDatabase.insert(DBUtils.DATABASE_TABLE, null, contentValues) > 0;
    }

    //删除数据，即从数据表中删除一条记录的操作
    public boolean deleteData(String id) {
        //准备删除的条件语句
        String sql = DBUtils.NOTE_ID + "=?";
        //通过传递的id值,来获取条件值
        String[] contenValuesArray = new String[]{String.valueOf(id)};
        //执行删除方法并返回结果
        return sqLiteDatabase.delete(DBUtils.DATABASE_TABLE, sql, contenValuesArray) > 0;
    }

    //修改数据，即修改数据库表中的记录的内容或保存时间
    public boolean updateDate(String id, String noteContent, String noteTime) {
        ContentValues contentValues = new ContentValues();//实例化一个CintentValues类的对象,值可以是任意的基本类型
        //将传递过来的内容和时间添加到contentValues对象中
        contentValues.put(DBUtils.NOTE_CONTENT, noteContent);
        contentValues.put(DBUtils.NOTE_CONTENT, noteTime);
        //SQL条件语句
        String sql = DBUtils.NOTE_ID + "=?";//修改条件
        //获取修改条件值
        String[] strings = new String[]{id};
        //执行修改操作，并返回结果
        return sqLiteDatabase.update(DBUtils.DATABASE_TABLE, contentValues, sql, strings) > 0;
    }
    //查询数据库，即查询数据库中的所有记录
    @SuppressLint("Range")
    public static List<MemoryBean> queryData(){
        //定义用来存放一个用来存放查询结果的集合
        List<MemoryBean> list=new ArrayList<>();
        //执行查询操作
        Cursor cursor=sqLiteDatabase.query(DBUtils.DATABASE_TABLE,null,null,null
        ,null,null,DBUtils.NOTE_ID+" desc");
        //处理结果集，遍历结果集
        if(cursor !=null){
            while (cursor.moveToNext()){
                //将记录封装到MemoryBean类中，并将记录添加到list集合中
                MemoryBean memoryBean=new MemoryBean();//实例化一个MemoryBean类对象
                //取出记录中的每一个字段值
                String id=String.valueOf(cursor.getInt(cursor.getColumnIndex(DBUtils.NOTE_ID)));
                String content=cursor.getString(cursor.getColumnIndex(DBUtils.NOTE_CONTENT));
                String time=cursor.getString(cursor.getColumnIndex(DBUtils.NOTE_TIME));
                //将记录封装到MemoryBean类的对象中
                memoryBean.setId(id);
                memoryBean.setMemoryContent(content);
                memoryBean.setSaveTime(time);
                //将此实体添加到List集合中
                list.add(memoryBean);
            }
            cursor.close();//关闭结果集
        }
        return list;
    }
}
