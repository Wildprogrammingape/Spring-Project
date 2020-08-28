package myspringdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationPractise {

	public static void main(String[] args) {
	
		// read spring configuration file
		ClassPathXmlApplicationContext context = new
				ClassPathXmlApplicationContext("applicationContext.xml");
		
		//get the bean from spring container
		NewCoach newCoach = context.getBean("basketballCoach", NewCoach.class);
		
		// call a method on the bean
		System.out.println(newCoach.getNewDailyWorkout());
		
		// close the context
		context.close();

	}

}
