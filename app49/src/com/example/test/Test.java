package com.example.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.example.entity.Employee;

public class Test {

	public static void main(String[] args) {
		SessionFactory sessionFactory=null;
		Session session=null;
		StandardServiceRegistryBuilder builder=null;
		StandardServiceRegistry registry=null;
		
		try {
			Configuration cfg = new Configuration();
			cfg.configure("/com/example/resources/hibernate.cfg.xml");
			builder=new StandardServiceRegistryBuilder();
			builder=builder.applySettings(cfg.getProperties());
			registry=builder.build();
			sessionFactory=cfg.buildSessionFactory(registry);
			session=sessionFactory.openSession();
			
			Criteria c=session.createCriteria(Employee.class);
			Criterion c1=Restrictions.gt("esal",6000.0f);
			Criterion c2=Restrictions.lt("esal",9000.0f);
			c.add(c1);
			c.add(c2);
			
			Projection p1=Projections.property("eno");
			Projection p2=Projections.property("ename");
			Projection p3=Projections.property("esal");
			Projection p4=Projections.property("eaddr");
			
			ProjectionList pl=Projections.projectionList();
			pl.add(p1);
			pl.add(p2);
			pl.add(p3);
			pl.add(p4);
			c.setProjection(pl);
			Order o=Order.desc("ename");
			c.addOrder(o);
			
			List<Object[]>empList=c.list();
			System.out.println("ENO\tENAMe\tESAL\tEADDR");
			System.out.println("---------------------------");
			for(Object[] obj:empList) {
				for(Object ob :obj) {
					System.out.print(ob+"\t");
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
