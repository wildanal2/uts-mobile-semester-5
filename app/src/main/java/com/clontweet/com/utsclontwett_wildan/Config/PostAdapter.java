package com.clontweet.com.utsclontwett_wildan.Config;

import android.content.Context;
import android.content.Intent;
import android.graphics.Matrix;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.clontweet.com.utsclontwett_wildan.DetailActivity;
import com.clontweet.com.utsclontwett_wildan.PhotoActivity;
import com.clontweet.com.utsclontwett_wildan.Post;
import com.clontweet.com.utsclontwett_wildan.R;

import java.util.ArrayList;
import java.util.Objects;

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
        public void onBindViewHolder(final PostAdapter.ViewHolder holder, final int position) {
                Log.d(TAG, "onBindViewHolder: called");
                final Post mPo = mpost.get(position);

                Glide.with(mContext).asBitmap().load(mPo.getImg_profil()).into(holder.mImages);
                if (!mPo.getImg_post().equals("")) {
                    holder.mimg_post.setMaxHeight(800);
                    holder.mimg_post.setClipToOutline(true);
                    Glide.with(mContext).asBitmap().load(mPo.getImg_post()).into(holder.mimg_post);
                }

                holder.mtxuname.setText("@"+mPo.getUname());
                holder.mtxtgl.setText(mPo.getTgl());
                holder.mtxstatus.setText(mPo.getStatus());
                holder.mtxnamed.setText(mPo.getNama());

                holder.mtxstatus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(mContext,DetailActivity.class);
                        i.putExtra("foto",mPo.getImg_profil());
                        i.putExtra("foto_post",mPo.getImg_post());
                        i.putExtra("nama",mPo.getNama());
                        i.putExtra("username",mPo.getUname());
                        i.putExtra("tgl",mPo.getTgl());
                        i.putExtra("status",mPo.getStatus());
                        mContext.startActivity(i);
                    }
                });

                holder.mimg_post.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(mContext,PhotoActivity.class);
                        i.putExtra("foto_post",mPo.getImg_post());
                        mContext.startActivity(i);
                    }
                });

                holder.mcomment.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext,"Reply for "+mpost.get(position).getUname(),Toast.LENGTH_SHORT).show();
                    }
                });

                holder.mritweet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext,"ReTweet for "+mpost.get(position).getUname(),Toast.LENGTH_SHORT).show();
                    }
                });

                holder.mlike.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext,"Like for "+mpost.get(position).getUname(),Toast.LENGTH_SHORT).show();
                    }
                });

                holder.mshare.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(mContext,"Share for "+mpost.get(position).getUname(),Toast.LENGTH_SHORT).show();
                    }
                });

        }

        @Override
        public int getItemCount() {
                return mpost.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{

            CircleImageView mImages;
            ImageView mimg_post;
            TextView mtxnamed,mtxuname,mtxtgl,mtxstatus;
            Button mcomment,mritweet,mlike,mshare,mcollapse;

            public ViewHolder(View itemView) {
                super(itemView);
                    mImages = itemView.findViewById(R.id.images_profil);
                    mtxuname = itemView.findViewById(R.id.tv_username);
                    mtxtgl = itemView.findViewById(R.id.tv_tglpost);
                    mtxstatus = itemView.findViewById(R.id.tv_status);
                    mcomment = itemView.findViewById(R.id.reply_btn);
                    mritweet = itemView.findViewById(R.id.retwett_btn);
                    mlike = itemView.findViewById(R.id.loved_btn);
                    mshare = itemView.findViewById(R.id.shared_btn);
                    mcollapse = itemView.findViewById(R.id.collaps_btn);
                    mtxnamed = itemView.findViewById(R.id.tv_named);
                mimg_post = itemView.findViewById(R.id.img_upload);
            }
        }

}