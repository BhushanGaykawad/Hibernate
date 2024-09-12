package com.example.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.CardPayment;
import com.example.entity.ChequePayment;
import com.example.entity.Payment;

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
				
			CardPayment card_pay=(CardPayment) session.get(Payment.class, "t111");
			System.out.println("Card Payment Details");
			System.out.println("-------------");
			System.out.println("Transaction Id:"+card_pay.getTx_Id());
			System.out.println("Payament Date:"+card_pay.getPay_Date());
			System.out.println("Payment Amot:"+card_pay.getPay_Amt());
			System.out.println("Card Number:"+card_pay.getCard_No());
			System.out.println("EXP DATE:"+card_pay.getExpr_Date());
			
			System.out.println();
			
			ChequePayment ch_pay=(ChequePayment) session.get(Payment.class, "t222");
			System.out.println("Cheque Payemtn Details");
			System.out.println("---------------");
			System.out.println("Transaction Id:"+ch_pay.getTx_Id());
			System.out.println("Payment Date:"+ch_pay.getPay_Date());
			System.out.println("Payment Amt:"+ch_pay.getPay_Amt());
			System.out.println("Cheque Number:"+ch_pay.getCheque_No());
			System.out.println("Account Number:"+ch_pay.getAccNo());
						
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
