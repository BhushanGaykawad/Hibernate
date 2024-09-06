package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.example.pojo.Employee;

public class Test {

	public static void main(String[] args) {

		Configuration cfg=null;
		SessionFactory sessionFactory =null;
		Session session=null;
		Transaction tx=null;
		try {
		
			cfg=new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			sessionFactory=cfg.buildSessionFactory();
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Employee emp=new Employee();
			emp.setEno(111);
			emp.setEname("Bhusahn");
			emp.setEsal(102003);
			emp.setEaddr("PUNE");
			session.save(emp);
			tx.commit();
			System.out.println("Inserted Successfully");
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
		
	}

}
