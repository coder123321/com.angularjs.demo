package com.angular.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angular.demo.entity.Shop;
import com.angular.demo.service.ElectGoodsService;
import com.angular.demo.util.Result;



@Controller
public class ElectGoodsAction {
	@Autowired
	private ElectGoodsService service;

	@RequestMapping("loadelectgoods")
	@ResponseBody
	public Result<List<Shop>> loadElectGoodsList(Integer page,Integer rows,String title,Double price ) {
		Integer type = 1;
		
		Result<List<Shop>> result = service.loadElectGoods(type,page,rows,title,price);
		return result;
	}

	@RequestMapping("findMenList")
	@ResponseBody
	public List<Shop> findMenList(@RequestBody Shop shop) {

		List<Shop> list = service.findMenList(shop);
		return list;

	}

}
