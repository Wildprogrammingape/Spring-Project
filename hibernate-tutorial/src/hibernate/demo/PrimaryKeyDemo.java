package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			// create three  student objects
			System.out.println("Create 3 student objects");
			Student tempStudent1 = new Student("Jone","Doe","john@hotmail.com");
			Student tempStudent2 = new Student("Mary","public","mary@hotmail.com");
			Student tempStudent3 = new Student("Bonita","Applebum","bonita@hotmail.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Save the student objects");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			// commit transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}

	}

}
