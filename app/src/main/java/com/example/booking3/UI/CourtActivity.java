package com.example.booking3.UI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.booking3.R;

import java.util.ArrayList;

/**
 * Created by t520win764zy on 2018/7/7.
 */

public class CourtActivity extends AppCompatActivity {
    Button btn1;
    Button btn2;
    private Spinner spinner_name;
    private Spinner spinner_type;
    private Spinner spinner_fee;
    private Spinner spinner_opentime;
    private Spinner spinner_closetime;
    private String name;
    private String type;
    private String fee;
    private String opentime;
    private String closetime;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.court_activity);
        context=this;

        btn1 = (Button) findViewById(R.id.court_btn_search);
        btn2 = (Button) findViewById(R.id.court_btn_back);
        spinner_name = (Spinner) findViewById(R.id.court_spn_name);
        spinner_type = (Spinner) findViewById(R.id.court_spn_type);
        spinner_fee = (Spinner) findViewById(R.id.court_spn_fee);
        spinner_opentime= (Spinner) findViewById(R.id.court_spn_opentime);
        spinner_closetime= (Spinner) findViewById(R.id.court_spn_closetime);

        spinner_name.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name = spinner_name.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner_type.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                type = spinner_type.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner_fee.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                fee = spinner_fee.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner_opentime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                opentime = spinner_opentime.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        spinner_closetime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view,int position, long id) {
                closetime = spinner_closetime.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                ArrayList<String> court_select = new ArrayList<String>();//activity之间需要传的数值，创建一个数组
                court_select.add(name);
                court_select.add(type);
                court_select.add(fee);
                court_select.add(opentime);
                court_select.add(closetime);

                Bundle bundle=new Bundle();//创建一个bundle数据包，将数组进行打包
                bundle.putStringArrayList("court",court_select);

                Intent intent = new Intent();
                intent.putExtras(bundle);//将数据包绑定到intent事件上，一边跳转界面一边传值
                intent.setClass(CourtActivity.this,CourtResultRecycleviewActivity.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
