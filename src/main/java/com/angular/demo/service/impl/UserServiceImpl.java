package com.angular.demo.service.impl;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.angular.demo.dao.UserMapper;
import com.angular.demo.entity.User;
import com.angular.demo.service.UserService;



@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper  userInfoDAO;

	
	public User findUser(String username,String password) {
		 User user = userInfoDAO.selectByUser(username, password);
		  
		return user ;
	}

	public User findById(int id) {
		User user = userInfoDAO.selectByPrimaryKey(id);
		return user;
	}

	
	public int updateUser(User user) {
		
		  Date date= new Date();
		  user.setCreate_time(date);
		int byId = userInfoDAO.updateByPrimaryKey(user);
		return byId;
	}
	
	
	
	

}
