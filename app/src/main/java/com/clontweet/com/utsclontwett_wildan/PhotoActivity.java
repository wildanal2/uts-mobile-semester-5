package com.clontweet.com.utsclontwett_wildan;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class PhotoActivity extends Activity {

    ImageView img;
    Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_photo);

        Bundle extra = getIntent().getExtras();
        img = findViewById(R.id.img_view_main);
        btn_back = findViewById(R.id.btn_back);

        Glide.with(this).asBitmap().load(extra.getString("foto_post")).into(img);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
