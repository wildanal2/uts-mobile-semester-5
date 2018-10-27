package com.clontweet.com.utsclontwett_wildan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.clontweet.com.utsclontwett_wildan.Config.DataHelper;
import com.clontweet.com.utsclontwett_wildan.Config.SessionManagement;

import java.util.HashMap;

public class LoginActivity extends Activity {

    DataHelper db ;
    EditText et_username,et_pwd;
    Button btn_signup,btn_login;
    CheckBox chxremeberme;
    SessionManagement mSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        db = new DataHelper(this);
        mSesion = new SessionManagement(this);

        et_username = findViewById(R.id.et_username_login);
        et_pwd = findViewById(R.id.et_pswd_login);
        btn_login = findViewById(R.id.btn_login);
        btn_signup = findViewById(R.id.btn_tosignup);
        chxremeberme = findViewById(R.id.chk_rememberme);

        if (mSesion.isLoggedIn()){
            HashMap<String,String> ses = mSesion.getUserInformation();
            et_username.setText(ses.get(SessionManagement.KEY_EMAIL));
            et_pwd.setText(ses.get(SessionManagement.KEY_PASSWOrD));
        }

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = et_username.getText().toString();
                String pwd = et_pwd.getText().toString();

                Boolean chklogin = db.cekLogin(uname,pwd);
                if (chxremeberme.isChecked()==true){
                    mSesion.createLoginSession(uname,pwd);
                }else {
                    mSesion.logoutUser();
                }

                if (chklogin==true){
                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
//                    i.putExtra("username",uname);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"Anda belum terdaftar",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(i);
            }
        });

    }
}
