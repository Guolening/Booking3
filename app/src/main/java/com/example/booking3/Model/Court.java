package com.example.booking3.Model;

/**
 * Created by t520win764zy on 2018/7/7.
 */

public class Court {
    //private int no;
    private String name;
    private String type;
    private String fee;
    private String opentime;
    private String closetime;

    /*
    函数名：Court
    函数功能：重载函数，设置变量定义
    变量说明：Court所有属性对应变量
    返回值说明：无
    */
    public Court( String name, String type, String fee, String opentime, String closetime)
    {
        //this.no=no;
        this.name=name;
        this.type=type;
        this.fee=fee;
        this.opentime=opentime;
        this.closetime=closetime;
    }

    /*
    函数名：get系列函数
    函数功能：实现变量的get操作，这些函数可以自动生成
    变量说明：无
    返回值说明：对应get操作的变量
    */
    public String getName() {return name;}
    public String getType() {return type;}
    public String getFee() {return fee;}
    public String getOpentime() {return opentime;}
    public String getClosetime() {return closetime;}

}
