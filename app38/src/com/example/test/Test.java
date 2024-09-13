package com.example.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.example.entity.Course;
import com.example.entity.Student;

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
			session =sessionFactory.openSession();
			tx=session.beginTransaction();
			
			Student s1=(Student) session.get(Student.class, "S-111");
			System.out.println("Student Details");
			System.out.println(s1.getSid());
			System.out.println(s1.getSname());
			System.out.println(s1.getSaddr());
			Set<Course>c1=s1.getCourses();
			System.out.println("CID\tCNAME\tCCOST");
			System.out.println("----------------");
			for(Course c:c1) {
				System.out.print(c.getCid()+"\t");
				System.out.print(c.getCname()+"\t");
				System.out.print(c.getCcost()+"\n");
			}
			
			System.out.println("-----------------------");
			
			Student s2=(Student) session.get(Student.class, "S-112");
			System.out.println("Student Details");
			System.out.println(s2.getSid());
			System.out.println(s2.getSname());
			System.out.println(s2.getSaddr());
			Set<Course>c2=s2.getCourses();
			System.out.println("CID\tCNAME\tCCOST");
			System.out.println("----------------");
			for(Course c:c2) {
				System.out.print(c.getCid()+"\t");
				System.out.print(c.getCname()+"\t");
				System.out.print(c.getCcost()+"\n");
			}
			
			System.out.println("-----------------------");
			Student s3=(Student) session.get(Student.class, "S-113");
			System.out.println("Student Details");
			System.out.println(s3.getSid());
			System.out.println(s3.getSname());
			System.out.println(s3.getSaddr());
			Set<Course>c3=s3.getCourses();
			System.out.println("CID\tCNAME\tCCOST");
			System.out.println("----------------");
			for(Course c:c3) {
				System.out.print(c.getCid()+"\t");
				System.out.print(c.getCname()+"\t");
				System.out.print(c.getCcost()+"\n");
			}
			
			
			
			
			
			
//			Course c1=new Course();
//			c1.setCid("C-111");
//			c1.setCname("C");
//			c1.setCcost(500);
//			
//			Course c2=new Course();
//			c2.setCid("C-112");
//			c2.setCname("C++");
//			c2.setCcost(900);
//			
//			Course c3=new Course();
//			c3.setCid("C-113");
//			c3.setCname("JAVA");
//			c3.setCcost(900);
//			
//			Set<Course>courses=new HashSet<>();
//			courses.add(c1);
//			courses.add(c2);
//			courses.add(c3);
//			
//			Student s1=new Student();
//			s1.setSid("S-111");
//			s1.setSname("AAA");
//			s1.setSaddr("HYD");
//			s1.setCourses(courses);
//			
//			Student s2=new Student();
//			s2.setSid("S-112");
//			s2.setSname("BBB");
//			s2.setSaddr("PUNE");
//			s2.setCourses(courses);
//			
//			Student s3=new Student();
//			s3.setSid("S-113");
//			s3.setSname("CCC");
//			s3.setSaddr("MUM");
//			s3.setCourses(courses);
//			
//			session.save(s1);
//			session.save(s2);
//			session.save(s3);
//			tx.commit();
//			System.out.println("Inserted");
			
		}catch(Exception e) {
			tx.rollback();
			e.printStackTrace();
			
		}finally {
			session.close();
			sessionFactory.close();
		}
	}

}
