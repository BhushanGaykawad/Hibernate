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
			System.out.println("ok");
			Employee emp=new Employee();
			emp.setPname("AAA");
			emp.setPaddr("Pune");
			emp.setEid("E-111");
			emp.setEsal(142099);
			
			System.out.println("ok2");
			Customer cust=new Customer();
			cust.setPname("BBB");
			cust.setPaddr("Mumbai");
			cust.setCid("C-111");
			cust.setCmobile("9128219811");
			System.out.println("ok3");
			tx=session.beginTransaction();
			
			String pk_Value1=(String) session.save(emp);
			String pk_Value2=(String)session.save(cust);
			System.out.println("ok4");
			tx.commit();
			if(pk_Value1.equals("E-111")&&(pk_Value2.equals("C-111"))) {
				tx.commit();
				System.out.println("ok5");
			}else {
//				tx.rollback();
			}
			
		}catch(Exception e) {
//			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
			
		}
	}

}
