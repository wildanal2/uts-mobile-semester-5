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

        btn_singup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = dbb.getWritableDatabase();
                db.execSQL("insert into user(username,email,password) values('" +
                        et_uname.getText().toString() + "','" +
                        et_email.getText().toString() + "','" +
                        et_pwd.getText().toString() + "')");

                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();

                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });
    }
}
