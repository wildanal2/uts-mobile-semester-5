package com.clontweet.com.utsclontwett_wildan;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{
        public static final String TAG="RecyclerViewAdapter";

        private ArrayList<Post> mpost;
        private Context mContext;

        public PostAdapter(Post post, Context mContext) {
                this.mpost = post;
                this.mContext = mContext;
        }

        @Override
        public PostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                Log.d(TAG, "onCreateViewHolder: called");
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_post,parent,false);
                return new PostAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(PostAdapter.ViewHolder holder, final int position) {
                Log.d(TAG, "onBindViewHolder: called");

//                Glide.with(mContext).asBitmap().load(mImagesUrl.get(position)).into(holder.mImages);
                holder.mTextNama.setText(mNames.get(position));

        }

        @Override
        public int getItemCount() {
                return mpost.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            CircleImageView mImages;
            TextView mTextNama;

            public ViewHolder(View itemView) {
                super(itemView);
//                mImagesages = itemView.findViewById(R.id.imagess);
//                mTextNama = itemView.findViewById(R.id.txt_nama);
            }
        }

}