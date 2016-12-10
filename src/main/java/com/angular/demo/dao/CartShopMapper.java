package com.angular.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.angular.demo.entity.CartShop;


public interface CartShopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CartShop record);

    int insertSelective(CartShop record);

    CartShop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CartShop record);

    int updateByPrimaryKey(CartShop record);
    
    
//    sh
    
    CartShop findByShopId(@Param("shopId")Integer shopId,@Param("userId")Integer userId);
    
    int addShopCart(CartShop shop);
    
    int updateShopCart(@Param("shopId")Integer shopId,@Param("userId")Integer userId,@Param("count")Integer count);
    
    List<CartShop> loadcartshop(@Param("userId")Integer userId);
    
    int deleteShopCart(@Param("id")Integer id);
    
    int cleanShopCart(@Param("userId")Integer userId);
}




