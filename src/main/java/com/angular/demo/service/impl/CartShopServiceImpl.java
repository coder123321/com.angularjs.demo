package com.angular.demo.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.demo.dao.CartShopMapper;
import com.angular.demo.entity.CartShop;
import com.angular.demo.service.CartShopService;


@Service
public class CartShopServiceImpl implements CartShopService {
	@Autowired
	private CartShopMapper cartShopInfoDAO;

	
	public CartShop findByShopId(Integer userId, Integer shopId) {
		CartShop shop = cartShopInfoDAO.findByShopId(shopId, userId);
		return shop;
	}

	
	public void addShopCart(Integer userId, Integer shopId, String shopName,
			float shopPrice,Integer shopType) {
		CartShop shop = cartShopInfoDAO.findByShopId(shopId, userId);
		if(shop==null){
			Integer count = 0;
			CartShop cart = new CartShop();
			cart.setUser_id(userId);
			cart.setShop_id(shopId);
			cart.setCart_name(shopName);
			cart.setCart_price(shopPrice);
			cart.setCart_count(++count);
			Date date = new Date();
			cart.setCreat_time(date);
			cartShopInfoDAO.addShopCart(cart);
			
		}else{
			if(shopType==0){
				Integer count =shop.getCart_count();
				cartShopInfoDAO.updateShopCart(shop.getShop_id(),shop.getUser_id(),++count);
			}else{
				Integer count =shop.getCart_count();
				cartShopInfoDAO.updateShopCart(shop.getShop_id(),shop.getUser_id(),--count);
			}
			
		}
		
		
	}

	
	public List<CartShop> loadcartshop(Integer userId) {
		List<CartShop> list= cartShopInfoDAO.loadcartshop(userId);
		return list;
	}

	
	public void deleteShopCart(Integer id) {
		cartShopInfoDAO.deleteShopCart(id);
		
	}

	
	public void cleanShopCart(Integer userId) {
		cartShopInfoDAO.cleanShopCart(userId);
		
	}

}
