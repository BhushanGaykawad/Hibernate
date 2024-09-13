package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.Branch;
import com.example.entity.Student;

public class Test {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		
		try {
			Configuration cfg=new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder= new StandardServiceRegistryBuilder();
			builder =builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry=builder.build();
			sessionFactory=cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
			
			
			Branch branch=new Branch();
			branch.setBid("B-111");
			branch.setBname("MEchanical");
			
			Student std1=new Student();
			std1.setSid("S-111");
			std1.setSname("AAA");
			std1.setSaddr("Pune");
			std1.setBranch(branch);
			

			Student std2=new Student();
			std2.setSid("S-112");
			std2.setSname("BBB");
			std2.setSaddr("Pune");
			std2.setBranch(branch);
			

			Student std3=new Student();
			std3.setSid("S-113");
			std3.setSname("CCC");
			std3.setSaddr("Pune");
			std3.setBranch(branch);
			
			session.save(std1);
			session.save(std2);
			session.save(std3);
			tx.commit();
			System.out.println("Inserted");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
