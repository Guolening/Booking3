package com.example.booking3.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.booking3.R;

/**
 * Created by t520win764zy on 2018/7/7.
 */

public class UserActivity extends AppCompatActivity {
    private EditText edt_loginname;
    private EditText edt_loginpasswd;
    private Spinner spinner_loginident;
    private Button btn_register;
    private Button btn_login;
    private String loginname=null;
    private String loginpasswd=null;
    private String loginident=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        edt_loginname=(EditText)findViewById(R.id.user_update_loginname);
        edt_loginpasswd=(EditText)findViewById(R.id.user_update_loginpasswd);
        spinner_loginident = (Spinner) findViewById(R.id.user_spn_loginident);
        btn_register = (Button) findViewById(R.id.user_btn_loginregister);
        btn_login = (Button) findViewById(R.id.user_btn_login);

        loginname=edt_loginname.getText().toString();
        loginpasswd=edt_loginpasswd.getText().toString();
        edt_loginpasswd.setTransformationMethod(PasswordTransformationMethod.getInstance());
        spinner_loginident.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {//下拉框选项设置，保存所选择的内容到一个变量中
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loginident = spinner_loginident.getSelectedItem().toString();
            }
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        btn_register.setOnClickListener(new View.OnClickListener() {//注册 按钮的点击事件，使得页面跳转
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(UserActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });


    }
}
