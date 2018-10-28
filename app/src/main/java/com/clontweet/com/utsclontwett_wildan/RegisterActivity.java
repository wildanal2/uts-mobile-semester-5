package com.clontweet.com.utsclontwett_wildan;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.clontweet.com.utsclontwett_wildan.Config.DataHelper;

public class RegisterActivity extends Activity {

    DataHelper dbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);

        dbb = new DataHelper(this);

        final EditText et_uname = findViewById(R.id.et_name_reg);
        final EditText et_email = findViewById(R.id.et_email_reg);
        final EditText et_pwd = findViewById(R.id.et_pwd_reg);
        Button btn_singup = findViewById(R.id.btn_singup);
        Button btn_back = findViewById(R.id.btn_back_tweet);

        btn_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbb.getWritableDatabase();
                db.execSQL("insert into user(username,email,password,img_profil) values('" +
                        et_uname.getText().toString() + "','" +
                        et_email.getText().toString() + "','" +
                        et_pwd.getText().toString() + "','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsYBbiqLu9lXhe0ZCrjht08aRU1ZqHSMiYnLUnu4RdLO_L_vW_')");

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();

                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
