package com.clontweet.com.utsclontwett_wildan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clontweet.com.utsclontwett_wildan.Config.DataHelper;
import com.clontweet.com.utsclontwett_wildan.Config.SessionManagement;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfilActivity extends Activity {

    SessionManagement mSesion;
    DataHelper mDb;

    TextView mtxNama,mtxuname;
    CircleImageView img_profil;
    Button btn_logout,btn_edit,btn_back;
    HashMap<String,String> user;
    Cursor Cusr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_profil);

        mDb = new DataHelper(this);
        mSesion = new SessionManagement(this);
        mtxNama = findViewById(R.id.tv_Nama_profil);
        mtxuname = findViewById(R.id.tv_uname_profil);
        img_profil = findViewById(R.id.img_profil);
        btn_logout = findViewById(R.id.btn_logout_profil);
        btn_edit = findViewById(R.id.btn_edit_profil);
        btn_back = findViewById(R.id.btn_back_tweet);


        user = mSesion.getUserInformation();


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ProfilEditActivity.class);
                i.putExtra("username",Cusr.getString(Cusr.getColumnIndex("username")));
                i.putExtra("email",Cusr.getString(Cusr.getColumnIndex("email")));
                i.putExtra("img_profil",Cusr.getString(Cusr.getColumnIndex("img_profil")));
                startActivity(i);
//                finish();
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSesion.logoutUser();
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Cusr = mDb.lihatUser(user.get("username"));

        mtxNama.setText("@"+user.get("username"));
        mtxuname.setText(Cusr.getString(Cusr.getColumnIndex("email")));

        Glide.with(this).asBitmap().load(Cusr.getString(Cusr.getColumnIndex("img_profil"))).into(img_profil);
    }
}
