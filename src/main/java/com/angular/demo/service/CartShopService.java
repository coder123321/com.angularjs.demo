package com.angular.demo.service;

import java.util.List;

import com.angular.demo.entity.CartShop;



public interface CartShopService {
	
	CartShop findByShopId(Integer userId,Integer shopId);
	
	void addShopCart(Integer userId,Integer shopId,String shopName,float shopPrice,Integer shopType);
	
	List<CartShop> loadcartshop(Integer userId);
	
	void deleteShopCart(Integer id);
	
	void cleanShopCart(Integer userId);
	
}
