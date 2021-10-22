package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure()
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
					
		Session session = factory.getCurrentSession();
		
		try {
			
			Instructor instructor = new Instructor("Fakie", "Dayby", "fake@gmail.com");
			
			InstructorDetail instructorDetail = new InstructorDetail("http://www.detail.com/youtube",
					"theerapon");
			
			instructor.setInstructorDetail(instructorDetail);
			
			session.beginTransaction();

			session.save(instructor);
			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		} finally {
			factory.close();
		}
	}
	
}
