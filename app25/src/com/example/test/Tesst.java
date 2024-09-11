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
			
			StudentAccount sa=new StudentAccount();
			sa.setAccNo("a111");
			sa.setAccName("Bhushan");
			sa.setAccType("Saving");
			sa.setSid("S111");
			sa.setSbranch("MEch");
			sa.setSmarks(99);
			
			EmployeeAccount ea=new EmployeeAccount();
			ea.setAccNo("a222");
			ea.setAccName("Bhushan");
			ea.setAccType("Savings");
			ea.setEid("E-111");
			ea.setEsal(2918291);
			ea.setEaddr("Pune");
			
			String pk_Value=(String)session.save(sa);
			String pk_Value1=(String)session.save(ea);
			if(pk_Value.equals("a111") && pk_Value1.equals("a222") ) {
				tx.commit();
			}else {
				tx.rollback();
			}
			
			
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
