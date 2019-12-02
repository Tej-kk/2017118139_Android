package com.example.threadtest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private static final int UPDATE_TEXT=1;
    private TextView text;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    text.setText(msg.obj.toString());
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text_view);
        Button button = (Button) findViewById(R.id.change_text);
        button.setOnClickListener(this);
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.change_text :
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int count=0;
                        while(true){
                            count++;
                            Message message=new Message();
                            message.what=UPDATE_TEXT;
                            message.obj=new Integer(count);
                            handler.sendMessage(message);
                            try{
                                Thread.sleep(2000);
                            }
                            catch (Exception e){

                            }
                        }

                    }
                }).start();
                break;
            default:
                break;
        }
    }
}
