package com.angular.demo.entity;

import java.util.Date;

public class Shop {
    private Integer id;

    private String shop_name;

    private Float shop_price;

    private Integer shop_count;

    private Date create_time;
    
    private String type;
    

    public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name == null ? null : shop_name.trim();
    }

    public Float getShop_price() {
        return shop_price;
    }

    public void setShop_price(Float shop_price) {
        this.shop_price = shop_price;
    }

    public Integer getShop_count() {
        return shop_count;
    }

    public void setShop_count(Integer shop_count) {
        this.shop_count = shop_count;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}