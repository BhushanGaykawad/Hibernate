package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.Account;

public class Test {

	public static void main(String[] args) {
		Configuration MySQLcfg=null;
		Configuration cfg=null;
		
		SessionFactory MySQLsessionFactory=null;
		SessionFactory sessionFactory=null;

		Session MySQLsession=null;
		Session session=null;

		StandardServiceRegistry MySQLregistry=null;
		StandardServiceRegistry registry=null;

		Transaction MySQLtx=null;
		Transaction tx=null;

		

		
		try {
			
			MySQLcfg=new Configuration();
			MySQLcfg.configure("/com/example/resources/mysql.cfg.xml");
			
			
			cfg=new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			
			
			StandardServiceRegistryBuilder MySQLBuilder=new StandardServiceRegistryBuilder();
			MySQLBuilder=MySQLBuilder.applySettings(MySQLcfg.getProperties());
			MySQLregistry=MySQLBuilder.build();
			
			
			StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
			builder=builder.applySettings(cfg.getProperties());
			registry=builder.build();
			
			
			MySQLsessionFactory=MySQLcfg.buildSessionFactory(MySQLregistry);
			sessionFactory=cfg.buildSessionFactory(registry);
			
			MySQLsession=MySQLsessionFactory.openSession();
			session=sessionFactory.openSession();
			
			Account source_Account=(Account)MySQLsession.get(Account.class, "a111");
			source_Account.setBalance(source_Account.getBalance()-5000); //debit
			
			Account target_Account=(Account)session.get(Account.class, "b111");
			target_Account.setBalance(target_Account.getBalance()+5000); //credit
			
			MySQLtx=MySQLsession.beginTransaction();
			tx=session.beginTransaction();
			
			MySQLsession.update(source_Account);
			session.update(target_Account);
			
			MySQLtx.commit();
			tx.commit();
			System.out.println("Tx successfull");
			
			
			
		}catch(Exception e)
		{	MySQLtx.rollback();
			tx.rollback();
			e.printStackTrace();
		}finally {
			MySQLsession.close();
			session.close();
			
			MySQLsessionFactory.close();
			sessionFactory.close();
			
			StandardServiceRegistryBuilder.destroy(MySQLregistry);
			StandardServiceRegistryBuilder.destroy(registry);

	
		}
		
	}

}
