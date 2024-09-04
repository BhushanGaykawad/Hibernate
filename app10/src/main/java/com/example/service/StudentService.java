package com.example.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.example.HibernateUtil.HibernateUtil;
import com.example.pojo.Student;

public class StudentService {
	
	public String Register(String sid, String sname, String saddr) {
		String status="";
		Transaction tx=null;
		try {
			SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
			Session session=sessionFactory.openSession();
			Student std=(Student) session.get(Student.class, sid);
			if(std==null) {
				std=new Student();
				std.setSid(sid);
				std.setSname(sname);
				std.setSaddr(saddr);
				tx=session.beginTransaction();
				String pk_Value=(String)session.save(std);
				tx.commit();
				if(pk_Value.equals(sid)) {
					status="success";
				}else {
					status="failure";
				}
			}else {
				status="existed";
			}
			
		}catch(Exception e) {
//			tx.rollback();
			status="failure";
			e.printStackTrace();
		}
		return status;				
	}

}
