package com.example.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.example.entity.Employee;
import com.example.hibernateUtil.HibernateUtil;

public class EmployeeService {

	Session session=null;
	Query query=null;
	public EmployeeService() {
	try {
		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
		session=sessionFactory.openSession();
		query=session.createQuery("from Employee");
		query.setMaxResults(3);
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public List<Employee>getEmployees(String label){
		List <Employee> empList=null;
		try {
			if(label.equals("1")) {
				System.out.println("Here1");
				query.setFirstResult(0);
				System.out.println("Here 2");
			}
			if(label.equals("2")) {
				query.setFirstResult(3);
			}
			if(label.equals("3")) {
				query.setFirstResult(6);
			}
			empList=query.list();
			System.out.println(empList.isEmpty());
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return empList;
	}
}

