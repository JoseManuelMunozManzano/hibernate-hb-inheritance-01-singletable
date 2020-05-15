package com.neimerc.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.neimerc.hibernate.demo.entity.Instructor;
import com.neimerc.hibernate.demo.entity.Student;

public class CreateUserStudentInstructorDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession(); 
		
		try {
			// create the object
			Student tempStudent = new Student("José Manuel", "Muñoz Manzano", "aaa@bb.com", "Mathematics");
			Instructor tempInstructor = new Instructor("Luisa", "Perez Gomez", "eee@ee.com", 35000.00);
					
			// start a transaction
			session.beginTransaction();
		
			// save the object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			System.out.println("Saving the instructor...");
			session.save(tempInstructor);
		
			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {		
			// clean up code
			session.close();
			factory.close();
		}
	}

}
