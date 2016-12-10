package com.angular.demo.service;

import com.angular.demo.entity.User;





public interface UserService {
	
	User findUser(String username,String password);
	
	User findById(int id);
	
	int updateUser(User user);

}
