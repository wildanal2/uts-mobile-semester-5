package com.clontweet.com.utsclontwett_wildan.Config;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.clontweet.com.utsclontwett_wildan.Post;
import com.clontweet.com.utsclontwett_wildan.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.ViewHolder>{
        public static final String TAG="RecyclerViewAdapter";

        private ArrayList<Post> mpost;
        private Context mContext;

        public PostAdapter(ArrayList<Post> post, Context mContext) {
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

                Glide.with(mContext).asBitmap().load(mpost.get(position).getImg()).into(holder.mImages);
                holder.mtxuname.setText("@"+mpost.get(position).getUname());
                holder.mtxtgl.setText(mpost.get(position).getTgl());
                holder.mtxstatus.setText(mpost.get(position).getStatus());

        }

        @Override
        public int getItemCount() {
                return mpost.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            CircleImageView mImages;
            TextView mtxuname,mtxtgl,mtxstatus;

            public ViewHolder(View itemView) {
                super(itemView);
                    mImages = itemView.findViewById(R.id.imagess);
                    mtxuname = itemView.findViewById(R.id.tv_named);
                    mtxtgl = itemView.findViewById(R.id.tv_tglpost);
                    mtxstatus = itemView.findViewById(R.id.tv_status);
            }
        }

}