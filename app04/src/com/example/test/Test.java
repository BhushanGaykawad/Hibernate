package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.pojo.Employee;

public class Test {

	public static void main(String[] args) {

		Configuration config=null;
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try {
			config=new Configuration();
			config.configure("/com/example/resources/myconfig.xml");
			sessionFactory=config.buildSessionFactory();
			session=sessionFactory.openSession();
//			Employee emp=(Employee)session.get(Employee.class, 111);
//			if(emp== null) {
//				System.out.println("EMployee not existed");
//			}else {
//				System.out.println("Employee Details");
//				System.out.println("*************************");
//				System.out.println("Employee Number	:"+emp.getEno());
//				System.out.println("Employee Name	:"+emp.getEname());
//				System.out.println("Employee Address :"+emp.getEaddr());
//				System.out.println("Employee Salary	:"+emp.getEsal());
//			}
			System.out.println("Before");
			Employee emp=(Employee)session.load(Employee.class, 111);
			System.out.println("After");
			
//			if(emp== null) {
//				System.out.println("EMployee not existed");
//			}else {
//				System.out.println("Employee Details");
//				System.out.println("*************************");
//				System.out.println("Employee Number	:"+emp.getEno());
//				System.out.println("Employee Name	:"+emp.getEname());
//				System.out.println("Employee Address :"+emp.getEaddr());
//				System.out.println("Employee Salary	:"+emp.getEsal());
//			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
	}

}
