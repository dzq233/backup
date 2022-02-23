package com.ygx.qqlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","This task's id is"+this.getTaskId());
        setContentView(R.layout.activity_second);
        Log.i("SecondActivity","调用了onCreate()方法");
    }

    public void back(View view) {
        finish();//关闭Activity
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("SecondActivity","调用了onStart()方法");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("SecondActivity","调用了onRestrat()方法");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("SecondActivity","调用了onPause()方法");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("SecondActivity","调用了onResume()方法");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("SecondActivity","调用了onStop()方法");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("SecondActivity","调用了onDestroy()方法");
    }
}