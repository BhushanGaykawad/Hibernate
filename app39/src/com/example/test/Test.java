package com.example.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		SessionFactory sessionFactory=null;
		Session session=null;
		Transaction tx=null;
		try {
			Configuration cfg=new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			builder= builder.applySettings(cfg.getProperties());
			StandardServiceRegistry registry=builder.build();
			sessionFactory=cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			tx=session.beginTransaction();
	//		Query query=session.createQuery("from Employee");
/*
			List<Employee>list=query.list();
			System.out.println("Using list() method");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------");
			for(Employee e:list) {
				System.out.print(e.getEno()+"\t");
				System.out.print(e.getEname()+"\t");
				System.out.print(e.getEsal()+"\t");
				System.out.print(e.getEaddr()+"\t");
				System.out.println();
			}
*/			
			//Iterate Method
/*			
			Iterator<Employee> it=query.iterate();
			System.out.println("Using iterate method");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			while(it.hasNext()) {
				Employee e=it.next();
				System.out.print(e.getEno()+"\t");
				System.out.print(e.getEname()+"\t");
				System.out.print(e.getEsal()+"\t");
				System.out.print(e.getEaddr()+"\n");
			}
	*/		
			//using scroll() method:
			/* ScrollableResults results=query.scroll();
			System.out.println("using Scroll() method");
			System.out.println("Employee Deatils in Forward direction");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("----------------------------");
			while(results.next()) {
				Object[] obj=results.get();
				for(Object o:obj) {
					Employee e=(Employee)o;
					System.out.print(e.getEno()+"\t");
					System.out.print(e.getEname()+"\t");
					System.out.print(e.getEsal()+"\t");
					System.out.print(e.getEaddr()+"\n");
					
				}
			}
			
			//backward direction
			System.out.println("using Scroll() method");
			System.out.println("Employee Deatils in Backwaard direction");
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("----------------------------");
			while(results.previous()) {
				Object[] obj=results.get();
				for(Object o:obj) {
					Employee e=(Employee)o;
					System.out.print(e.getEno()+"\t");
					System.out.print(e.getEname()+"\t");
					System.out.print(e.getEsal()+"\t");
					System.out.print(e.getEaddr()+"\n");
					
				}
			}
			*/
			//unique Results
			/*
			 
			System.out.println("Using UniqueResults");
			System.out.println("Employee Details");
			System.out.println("----------------------------");
			System.out.println(e.getEno()+"\t");
			System.out.println(e.getEname()+"\t");
			System.out.println(e.getEsal()+"\t");
			System.out.println(e.getEaddr()+"\n");
			*/
			
			/*
			Query query=session.createQuery("update Employee set esal=esal+500 where esal<100000");
			int row_Count=query.executeUpdate();
			tx.commit();
			System.out.println("Data Updated"+row_Count);
			*/
			
			Query query=session.createQuery("delete from Employee where esal<150000000000000000");
			int row_count=query.executeUpdate();
			tx.commit();
			System.out.println("No of employee deleted"+row_count);
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
			
		}
	}

}
