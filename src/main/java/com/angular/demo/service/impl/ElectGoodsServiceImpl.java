package com.angular.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.demo.dao.ShopMapper;
import com.angular.demo.entity.Shop;
import com.angular.demo.service.ElectGoodsService;
import com.angular.demo.util.Page;
import com.angular.demo.util.Result;



@Service
public class ElectGoodsServiceImpl implements ElectGoodsService {
	@Autowired
	private ShopMapper shopInfoDAO;
	
	
	public Result<List<Shop>> loadElectGoods(Integer type,Integer page,Integer rows,String title,Double price) {
		Integer begin = (page-1)*rows;
		Integer end = page*rows;
		String name = "%"+title+"%";
		
		Page p = new Page();
		p.setType(type);
		p.setBegin(begin);
		p.setEnd(end);
		p.setName(name);
		p.setPrice(price);
		
		List<Shop> list = shopInfoDAO.loadGoods(p);
		Result<List<Shop>> result =new Result<List<Shop>>();
		result.setData(list);
		return result;
	}

	
	public List<Shop> findMenList(Shop shop) {
		shop.setType("2");
		List<Shop> list = shopInfoDAO.findMen(shop);
		return list;
	}
	

}
