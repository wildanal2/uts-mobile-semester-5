package com.clontweet.com.utsclontwett_wildan;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.clontweet.com.utsclontwett_wildan.Config.DataHelper;

public class ProfilEditActivity extends AppCompatActivity {

    ImageView img;
    EditText link,email,uname;
    Button btn_update,btn_back,btn_cek;
    Bundle extra;
    DataHelper dbb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_edit);

        extra = getIntent().getExtras();
        dbb = new DataHelper(this);

        email = findViewById(R.id.email_edit);
        uname = findViewById(R.id.tx_nama_prof_ed);
        btn_cek = findViewById(R.id.btn_cek_IMG);
        link = findViewById(R.id.et_link);
        img = findViewById(R.id.img_ck);
        btn_update = findViewById(R.id.btnUpdate);
        btn_back = findViewById(R.id.btn_back);

        uname.setText(extra.getString("username"));
        email.setText(extra.getString("email"));
        link.setText(extra.getString("img_profil"));

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbb.updateuser(email.getText().toString(),link.getText().toString(),extra.getString("username"));
                Toast.makeText(getApplicationContext(),"Sukses Update",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        btn_cek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(getApplicationContext()).asBitmap().load(link.getText().toString()).into(img);
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
