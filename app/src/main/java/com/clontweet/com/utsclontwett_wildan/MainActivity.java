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
import android.widget.Button;
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
    Button btn_home,btn_search,btn_notif,btn_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        img_profil = findViewById(R.id.imagess);

        mDb = new DataHelper(this);
        mSesion = new SessionManagement(this);

        btn_notif= findViewById(R.id.notif_btn);
        btn_home =findViewById(R.id.home_btn);
        btn_search = findViewById(R.id.search_btn);
        btn_message = findViewById(R.id.message_btn);

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

        btn_notif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Notification Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });

        btn_message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Messages Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Search Coming Soon",Toast.LENGTH_SHORT).show();
            }
        });

        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Ini Home",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!mSesion.isLoggedIn()){
            Intent i = new Intent(getApplicationContext(),LoginActivity.class);
            startActivity(i);
            finish();
        }

        Cusr = mDb.lihatUser(user.get("username"));
        Glide.with(this).asBitmap().load(Cusr.getString(Cusr.getColumnIndex("img_profil"))).into(img_profil);
    }

    private void getImages(){
        mPost.add(new Post("Agnes Mo","agnezmo","Ketika fans bikin hashtag, dan saya sendiri ga tau ada apaan... \uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02\uD83D\uDE02 \uD83D\uDE18\uD83D\uDE18\uD83D\uDE18 \uD83D\uDE02 omg.","https://pbs.twimg.com/profile_images/1024094642608861184/CpnYQOep_400x400.jpg","","11:38 AM","20 Oct 18"));
        mPost.add(new Post("Joko Widodo","jokowi","Di antara keluarga korban musibah jatuhnya pesawat Lion Air JT-610, saya ikut merasakan duka yang amat dalam.","https://pbs.twimg.com/profile_images/953822043211886592/IUEJdPg9_400x400.jpg","https://pbs.twimg.com/media/DquYH3pU8AAyS3t.jpg","09:43 AM","20 Oct 18"));
        mPost.add(new Post("M. Wildan","WildanAl2","Good Morning :D","https://pbs.twimg.com/profile_images/950559922051153921/Idi6wwNA_400x400.jpg","","12:54 PM","02, Aug 18"));
        mPost.add(new Post("Savita Dwi","SavDp","Huawei P20 Pro Vs Iphone XS Max Mantappp!!!!!","https://pbs.twimg.com/profile_images/1053919536867463168/50NXRxTV_400x400.jpg","https://pbs.twimg.com/media/DqVPL7BU8AAMfuW.jpg","07:49 AM","01, Mar 18"));
        mPost.add(new Post("Donna","Nova.Bp","Laporan bertajuk \"Southeast Asian Tech Report\" mencantumkan delapan startup di Asia Tenggara yang menjadi unicorn: startup yang memiliki valuasi di atas USD1 miliar. ","https://pbs.twimg.com/profile_images/803070669353168898/JmbMlUbf_400x400.jpg","","10:50 AM","15, Sep 18"));
        mPost.add(new Post("Najwa Sihab","NajawaShb","Never Mind","https://pbs.twimg.com/profile_images/839298349148717056/yEE35xbx_400x400.jpg","","08:59 AM","01, Sep 18"));
        mPost.add(new Post("Joko Widodo","jokowi","Beskap hitam bercorak emas dengan mahkota seolah raja,lalu diarak dengan kereta yang dihela dua ekor kuda. Tumben?","https://pbs.twimg.com/profile_images/953822043211886592/IUEJdPg9_400x400.jpg","https://pbs.twimg.com/media/DqpIrrsUUAAfY8l.jpg","08:40 PM","18, Sep 18"));
        mPost.add(new Post("Gisella uci","GisellaCik","Ini kalau nanyain kabar kapan pulang, sekangen itu kadang akutu sm mamakohh,  kyk sama temen, papa sm mama pun kyk temen juga,  pasangan idamanku pokoknya:'). ","https://pbs.twimg.com/profile_images/1055839190212997121/h1eyNeKH_400x400.jpg","","11:49 AM","15, Aug 18"));

    }

    private void  initRecyclerview(){

        LinearLayoutManager laymanager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewww = findViewById(R.id.recyler_home);
        recyclerViewww.setLayoutManager(laymanager);

        PostAdapter adapter = new PostAdapter(mPost,this);
        recyclerViewww.setAdapter(adapter);
    }
}
