package com.example.booking3.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by t520win764zy on 2018/7/7.
 */

public class DataBaseHelper extends SQLiteOpenHelper {//继承自一个现有的封装好的帮助类，帮助建立数据库
    //建表语句
    public static final String CREATE_COURT = "create table Court("
            + "no integer primary key autoincrement,"//autoincrement代表自增
            + "name text,"
            + "type text,"
            + "fee text,"
            + "opentime text,"
            + "closetime text)";

    private Context mContext;//全局变量，上下文

    public DataBaseHelper(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        //构造函数，声明类的对象之后可以调用这个函数帮助创建数据库
        super(context, dbname, factory, version);
        mContext = context;
    }
    @Override//如果需要建库会自动调用oncreate，还可以顺便建表
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_COURT);
    }
    @Override//更新表 若存在则删除，然后再创建新的以升级
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Court");
        onCreate(db);
    }

    //插入篮球场数据  注意前后属性数量类型保持一致
    public void insert_court(SQLiteDatabase db) {
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "小型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "小型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "小型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "小型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "小型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "小型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "小型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "小型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "中型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "中型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "中型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "中型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "中型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "中型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "中型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "中型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "大型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "大型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "大型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "大型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "大型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "大型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "大型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"工大球场", "大型", "200r/h", "下午", "21:00"});


        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "小型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "小型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "小型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "小型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "小型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "小型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "小型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "小型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "中型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "中型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "中型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "中型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "中型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "中型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "中型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "中型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "大型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "大型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "大型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "大型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "大型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "大型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "大型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"人大球场", "大型", "200r/h", "下午", "21:00"});


        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "小型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "小型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "小型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "小型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "小型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "小型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "小型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "小型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "中型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "中型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "中型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "中型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "中型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "中型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "中型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "中型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "大型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "大型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "大型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "大型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "大型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "大型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "大型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"东单球场", "大型", "200r/h", "下午", "21:00"});


        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "小型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "小型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "小型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "小型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "小型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "小型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "小型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "小型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "中型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "中型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "中型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "中型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "中型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "中型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "中型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "中型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "大型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "大型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "大型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "大型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "大型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "大型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "大型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"五棵松球场", "大型", "200r/h", "下午", "21:00"});


        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "小型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "小型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "小型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "小型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "小型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "小型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "小型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "小型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "中型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "中型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "中型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "中型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "中型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "中型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "中型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "中型", "200r/h", "下午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "大型", "50r/h", "中午", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "大型", "100r/h", "上午", "21:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "大型", "150r/h", "下午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "大型", "200r/h", "晚上", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "大型", "50r/h", "晚上", "20:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "大型", "100r/h", "中午", "23:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "大型", "150r/h", "上午", "22:00"});
        db.execSQL("insert into Court(name,type,fee,opentime,closetime)values(?,?,?,?,?)", new String[]{"首经贸球场", "大型", "200r/h", "下午", "21:00"});
    }
}
