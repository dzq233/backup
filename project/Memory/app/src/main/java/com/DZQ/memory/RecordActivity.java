package com.DZQ.memory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.DZQ.memory.database.MemoryHelper;
import com.DZQ.memory.utils.DBUtils;

public class RecordActivity extends AppCompatActivity implements View.OnClickListener {
     //定义相关变量，控件变量及其他变量
    ImageView back,delete,save;
    TextView note_time,textTitle;
    EditText content;
    MemoryHelper memoryHelper;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        //第二步，初始化控件变量
        back=findViewById(R.id.imback);
        delete=findViewById(R.id.imDelete);
        save=findViewById(R.id.imSave);
        note_time=findViewById(R.id.textTime);
        textTitle=findViewById(R.id.textTitle);
        content=findViewById(R.id.editContent);
        //通过实现接口的方式，实现多个控件的点击事件
            back.setOnClickListener(this);
            delete.setOnClickListener(this);
            save.setOnClickListener(this);
            //初始化数据
        initData()  ;
    }
    protected void initData() {
        //第四步 初始化数据
        //创建数据库
        memoryHelper=new MemoryHelper(this) ;
        textTitle.setText("添加记录");
        //获得intent对象
        Intent intent=getIntent();
        if (intent !=null){
            //表示有数据传递，分别取出对应的数据，记录的id，记录的内容，记录的保存时间
            id=intent.getStringExtra("id");
            if(id!=null){
                textTitle.setText("修改记录");
                //将内容和时间显示到修改记录的界面
                content.setText(intent.getStringExtra("content"));
                note_time.setText(intent.getStringExtra("time"));
                note_time.setVisibility(View.VISIBLE);//在布局文件中显示保存时间
            }
        }
    }
    @Override
    public void onClick(View view) {
        //有三个控件，要通过条件判断点击的是哪一个，通过控件的id来判断
        switch (view.getId()) {
            case R.id.imback://表示点击的是返回控件，关闭当前Activity,返回到主界面
                finish();
                break;
            case R.id.imDelete://表示点击的是清空控件，清楚记录内容
                content.setText("");
                break;
            case R.id.imSave://表示点击的是保存控件，将当前记录保存到数据表中，并且带数据返回到主界面
                //获取输入的记录内容
                String noteContent = content.getText().toString().trim();
                if (id != null) {//表示是修改记录
                    if (noteContent.length() > 0) {
                        //修改并保存记录
                        if (memoryHelper.updateDate(id, noteContent, DBUtils.getTime())) {
                            showToast("修改成功");
                            setResult(2);
                            finish();//关闭当前Activity
                        } else {
                            showToast("修改失败");
                        }
                    } else {
                        showToast("记录内容不能为空");
                    }
                }else{
                    if (noteContent.length() > 0) {//表示有内容,向数据库表中插入一条记录
                        if (MemoryHelper.inserData(noteContent, DBUtils.getTime())) {
                            showToast("保存成功");
                            setResult(2);//设置结果码
                            finish();//关闭当前Activity
                        } else {
                            showToast("保存失败");
                        }
                    } else {
                        showToast("记录内容不能为空");
                    }
                }
        }
    }
    public void showToast(String message) {
        Toast.makeText(RecordActivity.this, message, Toast.LENGTH_LONG).show();
    }
}