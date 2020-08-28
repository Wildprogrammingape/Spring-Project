package hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// start a transaction
			session.beginTransaction();
			
			// query students
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			
			// display the students
			for (Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			// query students: lastName = 'Doe'
			theStudents = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			for (Student tempStudent : theStudents) {
				System.out.println("\nstudent who has last name of Doe " + tempStudent);
			}
			
			// query students: lastName= 'Doe' OR firstName='daffy'
			theStudents = 
					session.createQuery("from Student s where" 
									+ " s.lastName='Doe' OR s.firstName='Daffy'").getResultList();
			
			for (Student tempStudent : theStudents) {
				System.out.println("\nstudent who has last name of Doe or first name of Daffy " + tempStudent);
			}
			
			// query students where email LIKE "hotmail.com"
			theStudents = session.createQuery("from Student s where"
					+" s.email LIKE '%hotmail.com'").getResultList();
			
			for (Student tempStudent : theStudents) {
				System.out.println("\nstudent who has email LIKE 'hotmail.com' " + tempStudent);
			}
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
