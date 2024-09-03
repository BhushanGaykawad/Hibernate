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
			config.configure();
			sessionFactory=config.buildSessionFactory();
			session=sessionFactory.openSession();
			tx=session.getTransaction();
			tx.begin();
			Employee emp=new Employee();
			emp.setEno(116);
			emp.setEname("XXX");
			emp.setEsal(42999);
			emp.setEaddr("Mumbai");
//			session.update(emp);
			session.saveOrUpdate(emp);
			tx.commit();
			System.out.println("Inserted Successfully");
		}catch(Exception e) {
			tx.rollback();
			System.out.println("Insertion Failure");
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
