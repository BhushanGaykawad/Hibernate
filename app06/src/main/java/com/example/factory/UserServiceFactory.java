package com.example.factory;

import com.example.service.UserService;
import com.example.service.UserServiceImpl;

public class UserServiceFactory {
	private static UserService userService;
	static {
		userService=new UserServiceImpl();
	}
	public static UserService getUserService() {
		return userService;
	}
}
