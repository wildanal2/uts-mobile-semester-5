package com.clontweet.com.utsclontwett_wildan;

public class Post {
    String uname,tgl,status,img;

    public Post(String uname, String tgl, String status, String img) {
        this.uname = uname;
        this.tgl = tgl;
        this.status = status;
        this.img = img;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
