package com.clontweet.com.utsclontwett_wildan;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends Activity {

    CircleImageView mImages;
    TextView mtxNama,mtxUname,mtxStatus,mtxtgl;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detail);

        Bundle extra = getIntent().getExtras();

        btn_back = findViewById(R.id.btn_back_tweet);
        mImages = findViewById(R.id.images_profil_tweet);
        mtxStatus = findViewById(R.id.tv_status_tweet);
        mtxNama = findViewById(R.id.tv_named_tweet);
        mtxUname = findViewById(R.id.tv_uname_tweet);
        mtxtgl = findViewById(R.id.tv_tgl_tweet);

        Glide.with(this).asBitmap().load(extra.getString("foto")).into(mImages);
        mtxNama.setText(extra.getString("nama"));
        mtxUname.setText("@"+extra.getString("username"));
        mtxStatus.setText(extra.getString("status"));
        mtxtgl.setText(extra.getString("tgl"));

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}