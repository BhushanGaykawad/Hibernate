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
//			SQLQuery sqlQuery=session.createSQLQuery("select * from emp1");
//			SQLQuery sqlQuery=session.createSQLQuery("select * from emp1 where ESAL> ? and ESAL < ?");
//			sqlQuery.setFloat(0,6000);
//			sqlQuery.setFloat(1, 9000);
//			SQLQuery sqlQuery=session.createSQLQuery("select * from emp1 where ESAL> :min and ESAL < :max");
//			sqlQuery.setFloat("min", 6000);
//			sqlQuery.setFloat("max", 9000);
			
//			SQLQuery sqlQuery=session.createSQLQuery("select * from emp1 where ESAL> ? and ESAL < :max");
//			sqlQuery.setFloat(0, 6000);
//			sqlQuery.setFloat("max", 9000);
//			sqlQuery.addEntity(Employee.class);

			Query sqlQuery=session.getNamedQuery("sql_Query");
			sqlQuery.setFloat(0, 6000);
			sqlQuery.setFloat("max", 9000);

			List<Employee>empList=sqlQuery.list();
			System.out.println("ENO\tENAMe\tESAL\tEADDR");
			System.out.println("-------------------------");
			for(Employee emp:empList) {
				System.out.print(emp.getEno()+"\t");
				System.out.print(emp.getEname()+"\t");
				System.out.print(emp.getEsal()+"\t");
				System.out.print(emp.getEaddr()+"\n");

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
