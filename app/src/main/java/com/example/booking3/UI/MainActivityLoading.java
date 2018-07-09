package com.example.booking3.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.example.booking3.MainActivity;
import com.example.booking3.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by t520win764zy on 2018/7/7.
 */

public class MainActivityLoading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏

        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//隐藏状态栏

        setContentView(R.layout.activity_main_loading);

        final Intent intent=new Intent(this,MainActivity.class);
        Timer timer=new Timer();
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                startActivity(intent);
            }
        };
        timer.schedule(task,1000*1);
    }
}
