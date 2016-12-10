package com.angular.demo.service;

import java.util.List;

import com.angular.demo.entity.Shop;
import com.angular.demo.util.Result;



public interface ElectGoodsService {
	
	Result<List<Shop>> loadElectGoods(Integer type,Integer page,Integer rows,String title,Double price);
	
	List<Shop> findMenList(Shop shop);
	
}
