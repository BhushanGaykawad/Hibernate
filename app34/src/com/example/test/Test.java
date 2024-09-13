package com.example.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.Department;
import com.example.entity.Employee;

public class Test {

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
			
			Department dept=(Department) session.get(Department.class, "D-111");
			System.out.println("Dept details");
			System.out.println(dept.getDid());
			System.out.println(dept.getDname());
			
			Set<Employee> emps=dept.getEmps();
			System.out.println("ENO\tENAMe\tESAL\tEADDR");
			for(Employee e:emps) {
				System.out.print(e.getEno()+"\t");
				System.out.print(e.getEname()+"\t");
				System.out.print(e.getEsal()+"\t");
				System.out.print(e.getEaddr()+"\n");
			}
			
//			Employee e1=new Employee();
//			e1.setEno(111);
//			e1.setEname("AAA");
//			e1.setEaddr("pune");
//			e1.setEsal(9898);
//			
//			Employee e2=new Employee();
//			e2.setEno(222);
//			e2.setEname("BBB");
//			e2.setEaddr("pune");
//			e2.setEsal(989218);
//			
//			Employee e3=new Employee();
//			e3.setEno(333);
//			e3.setEname("CCC");
//			e3.setEaddr("pune");
//			e3.setEsal(98198);
//			
//			Set<Employee>emps=new HashSet<>();
//			emps.add(e1);
//			emps.add(e2);
//			emps.add(e3);
//			
//			Department dept=new Department();
//			dept.setDid("D-111");
//			dept.setDname("ADMIN");
//			dept.setEmps(emps);
//			String pk_Value=(String) session.save(dept);
////			tx.commit();
//			if(pk_Value.equals("D-111")) {
//				tx.commit();
//			}else {
//				tx.rollback();
//			}
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
