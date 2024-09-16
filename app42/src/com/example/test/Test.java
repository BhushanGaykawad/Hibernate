package com.example.test;

import java.util.List;

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
//			Query query=session.createQuery("select e.eno,e.ename,e.esal,e.eaddr from Employee e");
//			Query query=session.createQuery("select e.eno,e.ename,e.esal,e.eaddr from Employee e where e.esal<10000");
//			Query query=session.createQuery("select e.eno,e.ename,e.esal,e.eaddr from Employee e where e.esal<10000 order by e.ename desc");
//			Query query=session.createQuery("select sum(e.esal) from Employee e group by e.eaddr");
//			Query query=session.createQuery("select avg(e.esal) from Employee e group by e.eaddr");
//			Query query=session.createQuery("select  count(e.ename) from Employee e group by e.eaddr having e.eaddr='HYD'");
//			Query query=session.createQuery("select sum(e.esal) from Employee e group by e.eaddr having e.eaddr='HYD'");
			
//			Query query=session.createQuery("select e.eno,lower(e.ename),e.esal,upper(e.eaddr) from Employee e where e.esal IN (5000,7000)");

//			Query query=session.createQuery("select e.eno,lower(e.ename),e.esal,upper(e.eaddr) from Employee e where e.esal BETWEEN 6000 AND 8000");
			
//			Query query=session.createQuery("select e.eno,lower(e.ename),e.esal,upper(e.eaddr) from Employee e where e.ename LIKE '%B' ");
//			Query query=session.createQuery("select e.eno,lower(e.ename),e.esal,upper(e.eaddr) from Employee e where e.ename IS null ");

//			Query query=session.createQuery("select e.eno,lower(e.ename),e.esal,upper(e.eaddr) from Employee e where e.ename IS NOT Null ");
			
			//Posistional PArameter
			
//			Query query=session.createQuery("select e.eno,lower(e.ename),e.esal,upper(e.eaddr) from Employee e where e.esal < ? ");
//			query.setParameter(0, 10000.0f);

//			Query query=session.createQuery("select e.eno,lower(e.ename),e.esal,upper(e.eaddr) from Employee e where e.esal > :min_Val and e.esal< :max_Val");
//			Query query=session.createQuery("select e.eno,lower(e.ename),e.esal,upper(e.eaddr) from Employee e where e.esal >? and e.esal< :max_Val");
//			query.setParameter(0, 4000.0f);
//			query.setFloat(0, 6000.0f);
//			query.setFloat("max_Val", 10000.0f);
			
			Query query=session.createQuery("select e.eno,lower(e.ename),e.esal,upper(e.eaddr) from Employee e where e.esal<(select e2.esal from Employee e2 where e2.ename='DDD')");

			
			
			
			
			
			
			//aggregate functions
//			List<Long>list=query.list();
//			for(Long d:list) {
//				System.out.println(d);
//			}
//			
//			List<Double>list=query.list();
//			for(Double d:list) {
//				System.out.println(d);
//			}
			
			
			
			//for normal select query which returns object[]
			List<Object[]>list=query.list();
			System.out.println("ENO\tENAME\tESAL\tEADDR");
			System.out.println("-------------------------");
			for(Object[] obj:list) {
				for(Object ob:obj) {
				System.out.print(ob+"\t");
				
			}
				System.out.println();

				}
			
//	
	
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
			
		}
	}

}
