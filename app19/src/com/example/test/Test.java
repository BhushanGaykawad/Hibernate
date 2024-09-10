package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.example.entity.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try {
			Configuration cfg=new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			builder=builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry=builder.build();
			sessionFactory =cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			Employee emp=new Employee();
//			emp.setEno(1000);
			emp.setEname("BHUSHA");
			emp.setEaddr("Pune");
			emp.setEsal(10200);
//			int pk_Val=(int)session.save(emp);
			String pk_Val=(String)session.save(emp);
			//assigne Pk Generation
//			if(pk_Val==111) {
//				System.out.println("Insertion ok");
//				tx.commit();
//			}else {
//				System.out.println("Insertion Nok");
//
//				tx.rollback();
//			}
			tx.commit();
			
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
