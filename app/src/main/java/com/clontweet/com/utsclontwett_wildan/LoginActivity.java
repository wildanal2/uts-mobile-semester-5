package com.clontweet.com.utsclontwett_wildan;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {

    DataHelper db ;
    EditText et_username,et_pwd;
    Button btn_signup,btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);

        db = new DataHelper(this);

        et_username = findViewById(R.id.et_username_login);
        et_pwd = findViewById(R.id.et_pswd_login);
        btn_login = findViewById(R.id.btn_login);
        btn_signup = findViewById(R.id.btn_tosignup);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = et_username.getText().toString();
                String pwd = et_pwd.getText().toString();

                Boolean chklogin = db.cekLogin(uname,pwd);

                if (chklogin==true){
                    Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("username",uname);
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
