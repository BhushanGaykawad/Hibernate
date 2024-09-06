package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.pojo.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try {
		Configuration config=new Configuration();
		config.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		config.setProperty("hibernate.connection.username", "bhushan");
		config.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/demo");
		config.setProperty("hibernate.connection.password", "Bhushan@25");
		config.setProperty("hibernate.connection.dialect", "org.hibernate.MySQLDialect");
		config.setProperty("hibernate.show_sql", "true");
//		config.addResource("Employee.hbm.xml");
		
		config.addAnnotatedClass(Employee.class);
		
		sessionFactory=config.buildSessionFactory();
		session=sessionFactory.openSession();
		System.out.println("Session is created");
		tx=session.beginTransaction();
		Employee emp= new Employee();
		emp.setEno(334);
		emp.setEname("Bhushan");
		emp.setEaddr("hyd"); 
		emp.setEsal(100000);
		int pk_Value=(int) session.save(emp);
		tx.commit();
		System.out.println(pk_Value);
		if(pk_Value==333) {
			System.out.println("Employee Inserted Successfully");
		}
		
	}catch(Exception e) {
		tx.rollback();
		e.printStackTrace();
	}finally {
		session.close();
		sessionFactory.close();
	}

}
	}
