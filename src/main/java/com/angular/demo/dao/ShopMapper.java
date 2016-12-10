package com.angular.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.angular.demo.entity.Shop;
import com.angular.demo.util.Page;



public interface ShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
    
    
    List<Shop> loadGoods(Page p);
    
    List<Shop> findMen(Shop shop);
    
    
}