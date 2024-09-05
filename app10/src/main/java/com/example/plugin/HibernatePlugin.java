package com.example.plugin;

import javax.servlet.ServletException;

import org.apache.struts.action.ActionServlet;
import org.apache.struts.action.PlugIn;
import org.apache.struts.config.ModuleConfig;

import com.example.HibernateUtil.HibernateUtil;

public class HibernatePlugin implements PlugIn {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init(ActionServlet arg0, ModuleConfig arg1) throws ServletException {
		System.out.println("=================");
		System.out.println("Hibernate PlugIN:Initialization strd" );
		HibernateUtil.getSessionFactory();
		System.out.println("Hibernate software loaded");
		System.out.println("Hibernate plugin: Initialization end");
		System.out.println("====================");
	}

}
