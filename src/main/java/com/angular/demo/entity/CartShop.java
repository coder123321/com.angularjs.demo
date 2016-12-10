package com.angular.demo.entity;

import java.util.Date;

public class CartShop {
    private Integer id;

    private Integer user_id;

    private String cart_name;

    private Float cart_price;

    private Integer cart_count;

    private Date creat_time;
    
    private Integer shop_id;
    
    

    public Integer getShop_id() {
		return shop_id;
	}

	public void setShop_id(Integer shop_id) {
		this.shop_id = shop_id;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getCart_name() {
        return cart_name;
    }

    public void setCart_name(String cart_name) {
        this.cart_name = cart_name == null ? null : cart_name.trim();
    }

    public Float getCart_price() {
        return cart_price;
    }

    public void setCart_price(Float cart_price) {
        this.cart_price = cart_price;
    }

    public Integer getCart_count() {
        return cart_count;
    }

    public void setCart_count(Integer cart_count) {
        this.cart_count = cart_count;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }
}