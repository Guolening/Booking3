package com.example.booking3.UI;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.booking3.Adapter.CourtAdapter;
import com.example.booking3.DataBase.DataBaseHelper;
import com.example.booking3.Model.Court;
import com.example.booking3.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by t520win764zy on 2018/7/7.
 */

public class CourtResultRecycleviewActivity extends AppCompatActivity {
    private List<Court> courtList=new ArrayList<>();
    private DataBaseHelper courtDataBaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.court_result);

        ArrayList<String> court_select= new ArrayList<String>();//从court_activity传过来的筛选条件，解包，拿值
        Bundle bundle =getIntent().getExtras();
        court_select = bundle.getStringArrayList("court");

        String name = court_select.get(0);//将拿到的筛选条件分别赋值给不同的变量
        String type = court_select.get(1);
        String fee = court_select.get(2);
        String opentime = court_select.get(3);
        String closetime = court_select.get(4);

        courtDataBaseHelper=new DataBaseHelper(this,"Court.db",null,10);//通过这种方式拿到一开始创建的数据库
        db=courtDataBaseHelper.getWritableDatabase();//因为之前创建了，所以这次就算调用了getWritableDatabase也不会再建新的

        int inum=0;
        Cursor cursor = db.rawQuery("select * from Court", null);//cursor索引，在数据库的数据中进行顺序查找

        //利用查询条件查找满足条件的cursor
        //0个全部
        if(!name.equals("全部")&&!type.equals("全部")&&!fee.equals("全部")&& !opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and type = ? and fee = ? and opentime = ? and closetime = ?", new String[]{name,type,fee,opentime,closetime});
        }
        //1个全部
        else if(name.equals("全部")&&!type.equals("全部")&&!fee.equals("全部")&& !opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where type=? and fee = ?and opentime = ? and closetime = ?", new String[]{type,fee,opentime,closetime});
        }
        else if(!name.equals("全部")&& type.equals("全部")&&!fee.equals("全部")&& !opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and fee = ?and opentime = ? and closetime = ?", new String[]{name,fee,opentime,closetime});
        }
        else if(!name.equals("全部")&&!type.equals("全部")&& fee.equals("全部")&& !opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and type = ?and opentime = ? and closetime = ?", new String[]{name,type,opentime,closetime});
        }
        else if(!name.equals("全部")&&!type.equals("全部")&&!fee.equals("全部")&& opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and type = ? and fee = ? and closetime = ?", new String[]{name,type,fee,closetime});
        }
        else if(!name.equals("全部")&&!type.equals("全部")&&!fee.equals("全部")&& !opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and type = ? and fee = ? and opentime = ?", new String[]{name,type,fee,opentime});
        }
        //2个全部
        else if(name.equals("全部")&&type.equals("全部")&&!fee.equals("全部")&& !opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where fee = ? and opentime = ? and closetime = ?", new String[]{fee,opentime,closetime});
        }
        else if(name.equals("全部")&&!type.equals("全部")&&fee.equals("全部")&& !opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where type = ? and opentime = ? and closetime = ?", new String[]{type,opentime,closetime});
        }
        else if(name.equals("全部")&&!type.equals("全部")&&!fee.equals("全部")&& opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where type = ? and fee = ? and closetime = ?", new String[]{type,fee,closetime});
        }
        else if(name.equals("全部")&&!type.equals("全部")&&!fee.equals("全部")&& !opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where type = ? and fee = ? and opentime = ?", new String[]{type,fee,opentime});
        }
        else if(!name.equals("全部")&&type.equals("全部")&&fee.equals("全部")&& !opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and opentime = ? and closetime = ?", new String[]{name,opentime,closetime});
        }
        else if(!name.equals("全部")&&type.equals("全部")&&!fee.equals("全部")&& opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=?and fee = ? and closetime = ?", new String[]{name,fee,closetime});
        }
        else if(!name.equals("全部")&&type.equals("全部")&&!fee.equals("全部")&& !opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and fee = ? and opentime = ?", new String[]{name,fee,opentime});
        }
        else if(!name.equals("全部")&&!type.equals("全部")&&fee.equals("全部")&& opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and type = ? and closetime = ?", new String[]{name,type,closetime});
        }
        else if(!name.equals("全部")&&!type.equals("全部")&&fee.equals("全部")&& !opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and type = ? and opentime = ?", new String[]{name,type,opentime});
        }
        else if(!name.equals("全部")&&!type.equals("全部")&&!fee.equals("全部")&& opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and type = ? and fee = ?", new String[]{name,type,fee});
        }
        //3个全部
        else if(name.equals("全部")&&type.equals("全部")&&fee.equals("全部")&& !opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where opentime = ? and closetime = ?", new String[]{opentime,closetime});
        }
        else if(name.equals("全部")&&type.equals("全部")&&!fee.equals("全部")&& opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where fee = ? and closetime = ?", new String[]{fee,closetime});
        }
        else if(name.equals("全部")&&type.equals("全部")&&!fee.equals("全部")&& !opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where fee = ? and opentime = ?", new String[]{fee,opentime});
        }
        else if(name.equals("全部")&&!type.equals("全部")&&fee.equals("全部")&& opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where type = ? and closetime = ?", new String[]{type,closetime});
        }
        else if(name.equals("全部")&&!type.equals("全部")&&fee.equals("全部")&& !opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where type = ? and opentime = ?", new String[]{type,opentime});
        }
        else if(name.equals("全部")&&!type.equals("全部")&&!fee.equals("全部")&& opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where type = ? and fee = ?", new String[]{type,fee});
        }
        else if(!name.equals("全部")&&type.equals("全部")&&fee.equals("全部")&& opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and closetime = ?", new String[]{name,closetime});
        }
        else if(!name.equals("全部")&&type.equals("全部")&&fee.equals("全部")&& !opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and opentime = ?", new String[]{name,opentime});
        }
        else if(!name.equals("全部")&&type.equals("全部")&&!fee.equals("全部")&& opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and fee = ?", new String[]{name,fee});
        }
        else if(!name.equals("全部")&&!type.equals("全部")&&fee.equals("全部")&& opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=? and type = ?", new String[]{name,type});
        }
        //4个全部
        else if(name.equals("全部")&&type.equals("全部")&&fee.equals("全部")&& opentime.equals("全部")&& !closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where closetime = ?", new String[]{closetime});
        }
        else if(name.equals("全部")&&type.equals("全部")&&fee.equals("全部")&& !opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where opentime = ?", new String[]{opentime});
        }
        else if(name.equals("全部")&&type.equals("全部")&&!fee.equals("全部")&& opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where fee = ?", new String[]{fee});
        }
        else if(name.equals("全部")&&!type.equals("全部")&&fee.equals("全部")&& opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where type = ?", new String[]{type});
        }
        else if(!name.equals("全部")&&type.equals("全部")&&fee.equals("全部")&& opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court where name=?", new String[]{name});
        }
        //5个全部
        else if(name.equals("全部")&&type.equals("全部")&&fee.equals("全部")&& opentime.equals("全部")&& closetime.equals("全部")) {
            cursor = db.rawQuery("select * from Court", null);
        }

        if(cursor.moveToFirst()){//调用moveToFirst使得cursor的指针移到第一行的位置
            do{//进入循环，从而遍历每一行数据，然后把他们都放进数组中，从而在recycleview中显示出来
                name = cursor.getString(cursor.getColumnIndex("name"));//getColumnIndex是将该列在表中的位置索引通过getString传到相应的值中
                type = cursor.getString(cursor.getColumnIndex("type"));
                fee = cursor.getString(cursor.getColumnIndex("fee"));
                opentime = cursor.getString(cursor.getColumnIndex("opentime"));
                closetime = cursor.getString(cursor.getColumnIndex("closetime"));
                inum++;
                Court er = new Court(name,type,fee,opentime,closetime);//将得到的数组组成一条数据，放进数组
                courtList.add(er);
            }while(cursor.moveToNext());
        }
        else{
            //对话框  倘若没有得到数据，给出提醒，当用户点击“确认”时调回输入查询条件画面
            AlertDialog.Builder dia = new AlertDialog.Builder(this);
            dia.setTitle("Sorry");//title
            dia.setMessage("没有数据满足所选条件！\n请重新选择！");//内容
            dia.setPositiveButton("确定", new DialogInterface.OnClickListener() {//包含的按钮内容及其点击事件
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent();
                    intent.setClass(CourtResultRecycleviewActivity.this, CourtActivity.class);
                    startActivity(intent);
                }
            });
            AlertDialog a = dia.create();
            a.show();
        }
        cursor.close();

        //recycleview的显示设置
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.court_result_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        CourtAdapter adapter = new CourtAdapter(courtList);
        recyclerView.setAdapter(adapter);

    }
}
