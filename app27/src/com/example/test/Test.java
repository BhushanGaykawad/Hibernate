package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.CardPayment;
import com.example.entity.ChequePayment;

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
				
			CardPayment card_pay=new CardPayment();
			card_pay.setTx_Id("t111");
			card_pay.setPay_Date("12/12/2202");
			card_pay.setPay_Amt(92838234);
			card_pay.setCard_No(1231221312);
			card_pay.setExpr_Date("12/12/2221");
			
			ChequePayment cheque_pay=new ChequePayment();
			cheque_pay.setTx_Id("t222");
			cheque_pay.setPay_Date("23/12/2321");
			cheque_pay.setPay_Amt(102392190);
			cheque_pay.setCheque_No(523423);
			cheque_pay.setAccNo("a222");
			
			String pk_Value=(String)session.save(card_pay);
			System.out.println(pk_Value+"Inserted");
			String pk_Value1=(String)session.save(cheque_pay);
			tx.commit();
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
