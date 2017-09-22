package com.comba.platform.platformapp.bean;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

/**
 * Created by liangchunfeng on 2017/9/20.
 */

public class GoodsBean implements Serializable {

    private Integer id;
    private String name;
    private float price;
    private Drawable image;

    public GoodsBean(Integer id,String name,float price,Drawable image){
        this.id = id;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
