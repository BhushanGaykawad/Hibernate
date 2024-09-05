package com.example.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;

import com.example.HibernateUtil.HibernateUtil;

public class MyController extends ActionServlet {

	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("=======================");
		System.out.println("My controller initialization started");
		System.out.println("==============================");
		HibernateUtil.getSessionFactory();
		System.out.println("Hibernate loaded");
		System.out.println("====================");
		super.init(config);
		System.out.println("Struct loaded");
		System.out.println("=================");
		System.out.println("Mycontorller intializaiton end");
		System.out.println("======================");
	}
}
