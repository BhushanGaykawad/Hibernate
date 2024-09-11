package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.Account;
import com.example.entity.EmployeeAccount;
import com.example.entity.StudentAccount;

public class Tesst {

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
			sessionFactory=cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			
			StudentAccount sa=(StudentAccount)session.get(Account.class, "a111");
			System.out.println("Student Account Details");
			System.out.println("--------------");
			System.out.println("Acct No:"+sa.getAccNo());
			System.out.println("Acct Name:"+sa.getAccName());
			System.out.println("ACct Type:"+sa.getAccType());
			System.out.println("Student Id:"+sa.getSid());
			System.out.println("Student Brnach:"+sa.getSbranch());
			System.out.println("Student MArks:"+sa.getSmarks());
			
			EmployeeAccount ea=(EmployeeAccount)session.get(Account.class, "a222");
			
			System.out.println("Employee Account Details");
			System.out.println("--------------");
			System.out.println("Acct No:"+ea.getAccNo());
			System.out.println("Acct Name:"+ea.getAccName());
			System.out.println("ACct Type:"+ea.getAccType());
			System.out.println("Emp Id:"+ea.getEid());
			System.out.println("EMp sal:"+ea.getEsal());
			System.out.println("EMp Addr:"+ea.getEaddr());
			
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
