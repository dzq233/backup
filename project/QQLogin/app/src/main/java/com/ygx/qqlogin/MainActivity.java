package com.ygx.qqlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener */ {

    private ImageView Login;
    private EditText username,password;
    protected void onCreate(Bundle savedInstanceState) {
        //定义控件
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//加载布局文件
        //第二布找到布局文件中要实现点击事件的控件，并与控件变量绑定
            Login = findViewById(R.id.imLogin);
            //绑定控件变量
            username = findViewById(R.id.editName);
            password = findViewById(R.id.editpassword);
            //第三步：通过控件的匿名内部类来实现点击事件
        /* login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
            }
        });
         */
        //第三种方法第一步：通过接口的方式实现点击事件
        //Login.setOnClickListener(this);
        // 隐藏标题栏
        //Objects.requireNonNull(getSupportActionBar()).hide();
        //
        // 隐藏系统状态栏
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

//    @Override
//    public void onClick(View view) {
//        //通过Toast控件来显示登录成功的信息
//        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
//    }
    //通过控件的OnClck属性来创建点击事件
    public void login(View view){
        String name = username.getText().toString().trim();
        String psw = password.getText().toString().trim();
        if(name.equals("") || name == ""){
            Toast.makeText(MainActivity.this,"用户名不能为空",Toast.LENGTH_SHORT).show();
        }else if(psw.equals("")||psw == ""){
            Toast.makeText(MainActivity.this,"密码不能为空",Toast.LENGTH_SHORT).show();
        }else if(name.equals("admin")&&psw.equals("123456")){
            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_SHORT).show();
            //通过Intent意图来实现Activity之间的跳转
            //实例化一个Intent对象
            Intent intent = new Intent(MainActivity.this,SecondActivity.class);
            //启动Activity
            startActivity(intent);
        }else{
            Toast.makeText(MainActivity.this,"用户名错误或者密码错误！",Toast.LENGTH_SHORT).show();
        }

    }
    /*通过onclick属性实现点击事件
    public void login(View view){
        //通过Toast控件来显示登录成功的信息
        Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
    }
     */
}