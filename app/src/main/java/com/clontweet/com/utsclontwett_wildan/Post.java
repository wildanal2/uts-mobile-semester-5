package com.clontweet.com.utsclontwett_wildan;

import java.util.ArrayList;

public class Post {
    String nama,uname,status,img_profil,img_post,jam,tgl;

    public Post(String nama, String uname, String status, String img_profil, String img_post, String jam, String tgl) {
        this.nama = nama;
        this.uname = uname;
        this.status = status;
        this.img_profil = img_profil;
        this.img_post = img_post;
        this.jam = jam;
        this.tgl = tgl;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg_profil() {
        return img_profil;
    }

    public void setImg_profil(String img_profil) {
        this.img_profil = img_profil;
    }

    public String getImg_post() {
        return img_post;
    }

    public void setImg_post(String img_post) {
        this.img_post = img_post;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }
}
