package hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create a session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// create the objects
//			Instructor tempInstructor =
//					new Instructor("Chad","Darby","darby@hotmail.com");
//			
//			InstructorDetail tempInstructorDetail =
//					new InstructorDetail("http://www.longchen.com/youtube",
//							"love to code");
			
			
			Instructor tempInstructor =
					new Instructor("madhu","Patel","madhu@hotmail.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://www.youtube.com/",
							"Guitar");
			
			// associate the objects (in memory)
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// *note: also save the tempInstructorDetail object
			// because of CascadeType.ALL 
			//
			System.out.println("Saving instructor: " + tempInstructor);
			
			session.save(tempInstructor);
			
			
			// commit transaction
			session.getTransaction().commit(); 
			
			System.out.println("Done!");
			
		}
		finally {
			factory.close();
		}
		
		
	}

}
