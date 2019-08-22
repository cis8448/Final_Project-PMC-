package com.example.finalproject;
import android.graphics.Bitmap;
public class ProductBean {
    private String pc_id;       //상품 카테고리 ID
    private String pr_id;       //상품 ID
    private String pr_name;     //상품 이름
    private String pr_price;    //상품 가격
    private String pr_img;      //상품 이미지
    private int pr_qty;         //상품 갯수
    private String pc_name;     //상품 카테고리 이름
    private String p_id;        //피시방 아이디
    private Bitmap bimg;

    public Bitmap getBimg() {
        return bimg;
    }

    public void setBimg(Bitmap bimg) {
        this.bimg = bimg;
    }

    public String getPc_id() {
        return pc_id;
    }

    public void setPc_id(String pc_id) {
        this.pc_id = pc_id;
    }

    public String getPr_id() {
        return pr_id;
    }

    public void setPr_id(String pr_id) {
        this.pr_id = pr_id;
    }

    public String getPr_name() {
        return pr_name;
    }

    public void setPr_name(String pr_name) {
        this.pr_name = pr_name;
    }

    public String getPr_price() {
        return pr_price;
    }

    public void setPr_price(String pr_price) {
        this.pr_price = pr_price;
    }

    public String getPr_img() {
        return pr_img;
    }

    public void setPr_img(String pr_img) {
        this.pr_img = pr_img;
    }

    public int getPr_qty() {
        return pr_qty;
    }

    public void setPr_qty(int pr_qty) {
        this.pr_qty = pr_qty;
    }

    public String getPc_name() {
        return pc_name;
    }

    public void setPc_name(String pc_name) {
        this.pc_name = pc_name;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }
}
