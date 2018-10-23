package com.clontweet.com.utsclontwett_wildan;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;

import com.clontweet.com.utsclontwett_wildan.Config.PostAdapter;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ArrayList<Post> mPost = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        getImages();
        initRecyclerview();
    }

    private void getImages(){

        mPost.add(new Post("WildanAl2","02, Aug 18","Good Morning :D","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"));

        mPost.add(new Post("SavDp","22, Nov 18","Welcome back to #TEI2018 @PeterStylesMLA\n" +
                "                    As we examine @jokowi Global Maritime Fulcrum","https://i.redd.it/0h2gm1ix6p501.jpg"));
        mPost.add(new Post("Nova.bP","22, Oct 18","Wkwkkwkwk ","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"));
        mPost.add(new Post("Rio_kr","18, Sep 18","Never Mind","https://i.redd.it/qn7f9oqu7o501.jpg"));
        mPost.add(new Post("WildanAl2","02, Aug 18","Good Morning :D","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"));

        mPost.add(new Post("SavDp","22, Nov 18","Welcome back to #TEI2018 @PeterStylesMLA\n" +
                "                    As we examine @jokowi Global Maritime Fulcrum","https://i.redd.it/0h2gm1ix6p501.jpg"));
        mPost.add(new Post("Nova.bP","22, Oct 18","Wkwkkwkwk ","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"));
        mPost.add(new Post("Rio_kr","18, Sep 18","Never Mind","https://i.redd.it/qn7f9oqu7o501.jpg"));
        mPost.add(new Post("WildanAl2","02, Aug 18","Good Morning :D","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"));

        mPost.add(new Post("SavDp","22, Nov 18","Welcome back to #TEI2018 @PeterStylesMLA\n" +
                "                    As we examine @jokowi Global Maritime Fulcrum","https://i.redd.it/0h2gm1ix6p501.jpg"));
        mPost.add(new Post("Nova.bP","22, Oct 18","Wkwkkwkwk ","https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg"));
        mPost.add(new Post("Rio_kr","18, Sep 18","Never Mind","https://i.redd.it/qn7f9oqu7o501.jpg"));


    }

    private void  initRecyclerview(){

        LinearLayoutManager laymanager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerViewww = findViewById(R.id.recyler_home);
        recyclerViewww.setLayoutManager(laymanager);

        PostAdapter adapter = new PostAdapter(mPost,this);
        recyclerViewww.setAdapter(adapter);
    }
}
