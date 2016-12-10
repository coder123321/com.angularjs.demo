package com.angular.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.angular.demo.entity.User;
import com.angular.demo.service.UserService;



@Controller
public class UserAction {

	@Autowired
	private UserService userService;

	

	@ResponseBody
	@RequestMapping("login")
	public User showLogin(@RequestBody User user) {

		return userService.findUser(user.getUsername(), user.getPassword());
	}
	
	@ResponseBody
	@RequestMapping("findUser")
	public User findUserById(@RequestBody User user){
	
		
		return userService.findById(user.getId());
		
	}
	
	
	@ResponseBody
	@RequestMapping("updateUser")
	public int updateUserById(@RequestBody User user){
		
		
		return userService.updateUser(user);
		
	}
	
	

}
