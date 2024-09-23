package com.example.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session=null;
		StandardServiceRegistry registry=null;
		
		try {
			Configuration cfg=new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			builder=builder.applySettings(cfg.getProperties());
			registry=builder.build();
			sessionFactory=cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			
			Query query=session.createQuery("from Employee");
			List<Employee>empList=query.list();
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("---------------------------");
			for(Employee e:empList) {
				System.out.print(e.getEno()+"\t");
				System.out.print(e.getEname()+"\t");
				System.out.print(e.getEsal()+"\t");
				System.out.print(e.getEaddr()+"\n");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}

}
