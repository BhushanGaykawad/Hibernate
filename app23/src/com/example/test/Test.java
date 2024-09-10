package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.Account;
import com.example.entity.Address;
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
			builder =builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry=builder.build();
			sessionFactory =cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			
			Account acc=new Account();
			acc.setAccNo("abc123");
			acc.setAccName("AAA");
			acc.setAccType("Savings");
			
			Address addr= new Address();
			addr.setPno("23/rt");
			addr.setCity("PUNE");
			addr.setStreet("Hinjewadi");
			
			Employee emp= new Employee();
			emp.setEno(111);
			emp.setEname("SHubham");
			emp.setEsal(291000);
			emp.setAcc(acc);
			emp.setAddr(addr);
			tx=session.beginTransaction();
			int pk_Value=(int)session.save(emp);
			if(pk_Value==111) {
				tx.commit();
			}else {
				tx.rollback();
			}
			
		}catch(Exception e) {
//			tx.rollback();
			e.printStackTrace();
			
		}finally {
//			session.close();
//			sessionFactory.close();
		}
	}

}
