package com.example.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {

		StandardServiceRegistryBuilder builder=null;
		SessionFactory sessionFactory=null;
		Session session=null;
		StandardServiceRegistry registry=null;
		
		try {
		
			Configuration cfg=new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			builder=new StandardServiceRegistryBuilder();
			builder =builder.applySettings(cfg.getProperties());
			registry=builder.build();
			sessionFactory =cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
//			SQLQuery sqlQuery=session.createSQLQuery("select eno,ename,esal,eaddr from emp1");
//			SQLQuery sqlQuery=session.createSQLQuery("select eno,ename,esal,eaddr from emp1 where esal> ? and esal< ?");
//			sqlQuery.setFloat(0, 6000);
//			sqlQuery.setFloat(1, 9000);
//			SQLQuery sqlQuery=session.createSQLQuery("select eno,ename,esal,eaddr from emp1 where esal > ? and esal < :max");
//			sqlQuery.setFloat(0, 6000);
//			sqlQuery.setFloat("max", 9000);
			
			//to get SQL Query from mapping file. 
			Query sqlQuery=session.getNamedQuery("sql_Query");
			sqlQuery.setFloat("max", 9000);
			sqlQuery.setFloat(0, 6000);
			List<Object[]>empList=sqlQuery.list();
			System.out.println("ENO\tENAMe\tESAL\tEADDR");
			System.out.println("-------------------------");
			for(Object[] obj:empList) {
				for(Object o:obj) {
					System.out.print(o+"\t");
				}
				System.out.println();
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
