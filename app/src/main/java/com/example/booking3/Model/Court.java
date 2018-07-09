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

    public Court( String name, String type, String fee, String opentime, String
            closetime)
    {
        //this.no=no;
        this.name=name;
        this.type=type;
        this.fee=fee;
        this.opentime=opentime;
        this.closetime=closetime;
    }
    /*public int getNo() {
        return no;
    }*/
    public String getName() {return name;}
    public String getType() {return type;}
    public String getFee() {return fee;}
    public String getOpentime() {return opentime;}
    public String getClosetime() {return closetime;}




}
