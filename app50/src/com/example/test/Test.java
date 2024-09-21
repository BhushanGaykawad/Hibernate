package com.example.test;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Filter;
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
		StandardServiceRegistryBuilder builder=null;
		StandardServiceRegistry registry=null;
		
		try {
			Configuration cfg=new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			builder= new StandardServiceRegistryBuilder();
			builder=builder.applySettings(cfg.getProperties());
			registry=builder.build();
			sessionFactory=cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			Query query=session.createQuery("from Employee");
			Filter filter=session.enableFilter("empFilter");
			Scanner sc=new Scanner(System.in);
			System.out.println("Emp Type:");
			System.out.println("1.Perm");
			System.out.println("2.Temp");
			System.out.println("3.Both");

			System.out.println("Your Option [1/2/3] :");
			int option =sc.nextInt();
			if(option==1) {
				filter.setParameter("type", "Perm");
			}else if(option==2) {
				filter.setParameter("type", "Temp");
			}else {
				session.disableFilter("empFilter");
			}
			
			List<Employee>empList=query.list();
			System.out.println("ENO\tENAME\tESAL\tEADDR\tETYPE");
			System.out.println("-------------------------");
			for(Employee emp:empList) {
				System.out.print(emp.getEno()+"\t");
				System.out.print(emp.getEname()+"\t");
				System.out.print(emp.getEsal()+"\t");
				System.out.print(emp.getEaddr()+"\t");
				System.out.print(emp.getEtype()+"\n");


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
