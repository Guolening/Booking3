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

    /*
    函数名：DataBaseHelper
    函数功能：重载函数，设置运行所在context
    变量说明：context，数据库名，SQLiteDataBase类型数据库工厂以及int类型版本
    返回值说明：无
    */
    public DataBaseHelper(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version) {
        //构造函数，声明类的对象之后可以调用这个函数帮助创建数据库
        super(context, dbname, factory, version);
        mContext = context;
    }

    /*
    函数名：onCreate
    函数功能：在数据库中执行SQL语句
    变量说明：SQLiteDataBase类型的数据库对象
    返回值说明：无
    */
    @Override//如果需要建库会自动调用oncreate，还可以顺便建表
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_COURT);
    }

    /*
    函数名：onUpgrade
    函数功能：更新表：若存在则删除，然后再创建新的以升级
    变量说明：SQLiteDataBase类型的数据库对象，旧版本和新版本整型标识
    返回值说明：无
    */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists Court");
        onCreate(db);
    }

    /*
    函数名：insert_court
    函数功能：向数据库中插入数据的SQL语句
    变量说明：SQLiteDataBase类型的数据库对象
    返回值说明：无
    */
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
