package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.Customer;
import com.example.entity.Employee;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionFactory=null;
		Session session =null;
		Transaction tx=null;
		
		try {
			Configuration cfg=new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder =new StandardServiceRegistryBuilder();
			builder =builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry=builder.build();
			sessionFactory=cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			
			Employee emp=(Employee) session.get(Employee.class, "AAA");
			System.out.println("EMployee Details");
			System.out.println(emp.getPname());
			System.out.println(emp.getPaddr());
			System.out.println(emp.getEid());
			System.out.println(emp.getEsal());
			
			Customer cust= (Customer) session.get(Customer.class, "BBB");
			System.out.println("Customer Details");
			System.out.println(cust.getPname());
			System.out.println(cust.getPaddr());
			System.out.println(cust.getCid());
			System.out.println(cust.getCmobile());
			
			
		}catch(Exception e) {
//			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
			
		}
	}

}
