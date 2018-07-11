package com.example.booking3;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.booking3.DataBase.DataBaseHelper;
import com.example.booking3.UI.CourtActivity;
import com.example.booking3.UI.OrderActivity;
import com.example.booking3.UI.UserActivity;

public class MainActivity extends AppCompatActivity {
    private DataBaseHelper courtDataBaseHelper;//创建DataBaseHelper的实例
    private SQLiteDatabase db1;//SQLite数据库的实例

    Button btn1;
    Button btn2;
    Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button)findViewById(R.id.main_btn_court);
        btn2=(Button)findViewById(R.id.main_btn_order);
        btn3=(Button)findViewById(R.id.main_btn_user);

        myclick m = new myclick();
        btn1.setOnClickListener(m);
        btn2.setOnClickListener(m);
        btn3.setOnClickListener(m);

        courtDataBaseHelper=new DataBaseHelper(this,"Court.db",null,10);//创建DataBaseHelper的实例，注意version变量，和后面courtresult相关联，要改动必须都改，不然出错
        db1=courtDataBaseHelper.getWritableDatabase();//帮助类的实例调用这个函数就可以去检查是否存在这个数据库，如果没有则调用oncreate进行创建
        db1.execSQL("delete from Court");//每次进入该APP就先清空数据再插入 免得插入重复
        courtDataBaseHelper.insert_court(db1);//插入数据
    }

    /*
    类名：myclick
    类功能：一个封装函数，包含不同的点击事件，使结构清晰
    变量说明：被点击的按钮的id
    返回值说明：无
     */
    class myclick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Integer id = v.getId();
            Intent intent = new Intent();
            switch (id) {
                case R.id.main_btn_court:
                    intent.setClass(MainActivity.this,CourtActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_btn_order:
                    intent.setClass(MainActivity.this, OrderActivity.class);
                    startActivity(intent);
                    break;
                case R.id.main_btn_user:
                    intent.setClass(MainActivity.this, UserActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    }

}
