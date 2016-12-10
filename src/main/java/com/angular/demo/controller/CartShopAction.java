package com.angular.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angular.demo.entity.CartShop;
import com.angular.demo.service.CartShopService;


@Controller
public class CartShopAction {
	@Autowired
	private CartShopService service;
	
	@RequestMapping("addShopCart")
	@ResponseBody
	public List<CartShop> addShopCart(Integer userId,Integer shopId,String shopName,float shopPrice,Integer shopType){
		 service.addShopCart(userId, shopId, shopName, shopPrice,shopType);
		 List<CartShop> list = service.loadcartshop(userId);
		 return list;
	}
	@RequestMapping("loadcartshop")
	@ResponseBody
	public List<CartShop> loadcartshop(Integer userId){
		  List<CartShop> list = service.loadcartshop(userId);
		
		  return list;
	}
	
	@RequestMapping("deleteShopCart")
	@ResponseBody
	public List<CartShop> deleteShopCart(Integer id,Integer userId){
		  service.deleteShopCart(id);
		  List<CartShop> list = service.loadcartshop(userId);
		  return list;
	}
	
	@RequestMapping("cleanShopCart")
	@ResponseBody
	public List<CartShop> cleanShopCart(Integer userId){
		  service.cleanShopCart(userId);
		  List<CartShop> list = service.loadcartshop(userId);
		  return list;
	}

}
