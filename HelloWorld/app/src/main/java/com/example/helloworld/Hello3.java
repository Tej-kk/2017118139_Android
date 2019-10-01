package com.example.helloworld;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Hello3 extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="Hello3";
    private static int objcount=0;;//整个类中只有一个,所有对象都能共享
    private int mobjcount;//每个对象都有一个

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3);
        objcount++;
        mobjcount=objcount;
        Log.d(TAG+"-"+mobjcount,"onCreate execute");
        settupclick();
        setTitle("Hello3");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG+"-"+mobjcount ,"onStart");//打印出回调函数
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG+"-"+mobjcount ,"onResume");//打印出回调函数
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG+"-"+mobjcount ,"onPause");//打印出回调函数
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG +"-"+mobjcount,"onStop");//打印出回调函数
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG+"-"+mobjcount ,"onDestroy");//打印出回调函数
    }


    @Override
    public void onClick(View view) {
        Intent intent;
        if(view.getId()==R.id.btToHello1)
        {
            //构造出Intent的意图（传入this作为上下文，传入Hello1.class作为目标活动)
            intent=new Intent(this,Hello1.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.btToHello2)
        {
            intent=new Intent(this,Hello2.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.btToHello3)
        {
            intent=new Intent(this,Hello3.class);
            startActivity(intent);
        }
    }
    private void settupclick()
    {
        Button b;
        b=(Button)findViewById(R.id.btToHello1);
        b.setOnClickListener(this);
        b=(Button)findViewById(R.id.btToHello2);
        b.setOnClickListener(this);
        b=(Button)findViewById(R.id.btToHello3);
        b.setOnClickListener(this);
    }
}
