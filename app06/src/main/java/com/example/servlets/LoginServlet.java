package com.example.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.factory.UserServiceFactory;
import com.example.service.UserService;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uname=request.getParameter("uname");
		String upwd=request.getParameter("upwd");
		
		
		UserService userService=UserServiceFactory.getUserService();
		String status= userService.checkLogin(uname, upwd);
		
		if(status.equals("success")) {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("success.html");
			requestDispatcher.forward(request, response);

		}else {
			RequestDispatcher requestDispatcher=request.getRequestDispatcher("failure.html");
			requestDispatcher.forward(request, response);

		}
	}

}
