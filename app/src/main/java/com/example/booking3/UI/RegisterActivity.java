package com.example.booking3.UI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.booking3.R;

/**
 * Created by t520win764zy on 2018/7/8.
 */

public class RegisterActivity extends AppCompatActivity {
    private EditText edt_registerusername;
    private EditText edt_registerpasswd;
    private EditText edt_registername;
    private EditText edt_registerphone;
    private EditText edt_registeremail;
    private Spinner spinner_registerident;
    private Button btn_registerok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        edt_registerusername=(EditText)findViewById(R.id.user_register_registerusername);
        edt_registerpasswd=(EditText)findViewById(R.id.user_register_registerpasswd);
        edt_registername=(EditText)findViewById(R.id.user_register_registername);
        edt_registerphone=(EditText)findViewById(R.id.user_register_registerphone);
        edt_registeremail=(EditText)findViewById(R.id.user_register_registeremail);
        spinner_registerident = (Spinner) findViewById(R.id.user_spn_registerident);
        btn_registerok = (Button) findViewById(R.id.user_btn_register);

        //设置密码的加密显示
        edt_registerpasswd.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }
}
