package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.pojo.Employee;

public class Test {

	public static void main(String[] args) throws Exception {
		Configuration config=new Configuration();
		config.configure();
		SessionFactory sessionFactory=config.buildSessionFactory();
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Employee emp=new Employee();
		emp.setEid(115);
		emp.setEname("AAA");
		emp.setEsal(5000);
		emp.setEaddr("Pune");
//		int eno=(Integer)session.save(emp);
		session.persist(emp);
		tx.commit();
		System.out.println("Employee Inserted Successfullly");
//		if(eno==113) {
//			System.out.println("Employee Inserted Successfully");
//		}else {
//			System.out.println("Employee Insertion Failure");
//		}
		session.close();
	}

}
