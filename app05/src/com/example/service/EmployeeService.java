package com.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.example.pojo.Employee;

public class EmployeeService {
	Configuration config;
	SessionFactory sessionFactory;
	Session session;
	Employee emp;
	public EmployeeService() {
		try {
			config=new Configuration();
			config.configure("/com/example/resources/hibernate.cfg.xml");
			sessionFactory=config.buildSessionFactory();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public Employee search(int eno) {
	    Employee emp = null;
	    try {
	        session = sessionFactory.openSession();
	        System.out.println("Session opened.");
	        emp = (Employee) session.get(Employee.class, eno);
	        System.out.println("Employee fetched: " + emp);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        if (session != null) {
	            session.close();
	            System.out.println("Session closed.");
	        }
	    }
	    return emp;
	}


}
