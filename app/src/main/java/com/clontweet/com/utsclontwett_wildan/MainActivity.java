package com.clontweet.com.utsclontwett_wildan;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.clontweet.com.utsclontwett_wildan.Config.DataHelper;
import com.clontweet.com.utsclontwett_wildan.Config.PostAdapter;
import com.clontweet.com.utsclontwett_wildan.Config.SessionManagement;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends Activity {

    SessionManagement mSesion;
    DataHelper mDb;
    private ArrayList<Post> mPost = new ArrayList<>();
    private CircleImageView img_profil;
    HashMap<String,String> user;
    Cursor Cusr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        img_profil = findViewById(R.id.imagess);

        mDb = new DataHelper(this);
        mSesion = new SessionManagement(this);

        getImages();
        initRecyclerview();

        user = mSesion.getUserInformation();
        Cusr = mDb.lihatUser(user.get("username"));


        img_profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ProfilActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"OnStrt goinggg ",Toast.LENGTH_SHORT).show();

        Cusr = mDb.lihatUser(user.get("username"));
        Glide.with(this).asBitmap().load(Cusr.getString(Cusr.getColumnIndex("img_profil"))).into(img_profil);
    }

    private void getImages(){

        mPost.add(new Post("WildanAl2","02, Aug 18","Good Morning :D","https://pbs.twimg.com/profile_images/950559922051153921/Idi6wwNA_400x400.jpg"));
        mPost.add(new Post("SavDp","22, Nov 18","Welcome back to #TEI2018 @PeterStylesMLA\n" +
                "                    As we examine @jokowi Global Maritime Fulcrum","https://pbs.twimg.com/profile_images/681728290860609537/lAvQRQMI_400x400.jpg"));
        mPost.add(new Post("Nova.bP","22, Oct 18","Laporan bertajuk \"Southeast Asian Tech Report\" mencantumkan delapan startup di Asia Tenggara yang menjadi unicorn: startup yang memiliki valuasi di atas USD1 miliar. ","https://pbs.twimg.com/profile_images/803070669353168898/JmbMlUbf_400x400.jpg"));
        mPost.add(new Post("Rio_kr","18, Sep 18","Never Mind","https://pbs.twimg.com/profile_images/839298349148717056/yEE35xbx_400x400.jpg"));
        mPost.add(new Post("jokowi","02, Aug 18","Jaket baru saya ini buatan Bandung, warna terakota, yang saya temukan di salah satu gerai pameran IdeaFest 2018 di Jakarta. Bisa jadi jas hujan, bisa dipakai juga kalau sedang tidak hujan.","https://pbs.twimg.com/profile_images/953822043211886592/IUEJdPg9_400x400.jpg"));
        mPost.add(new Post("Nova.bP","22, Oct 18","Ini kalau nanyain kabar kapan pulang, sekangen itu kadang akutu sm mamakohh,  kyk sama temen, papa sm mama pun kyk temen juga,  pasangan idamanku pokoknya:'). ","https://pbs.twimg.com/profile_images/803070669353168898/JmbMlUbf_400x400.jpg"));


    }

    private void  initRecyclerview(){

        LinearLayoutManager laymanager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewww = findViewById(R.id.recyler_home);
        recyclerViewww.setLayoutManager(laymanager);

        PostAdapter adapter = new PostAdapter(mPost,this);
        recyclerViewww.setAdapter(adapter);
    }
}
