package myspringdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigurationApp {

	public static void main(String[] args) {
		// test my application of interface NewCoach, method BasketballCoach
		// with Java code configuration (no XML)
		
		
		// read Spring configuration java class "JavaConfigPractise"
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(JavaConfigPractise.class);
		
		// get the bean from spring container
		BasketballCoach myCoach = context.getBean("mybasketballcoach", BasketballCoach.class);
													// bean id
		
		// call methods on the bean
		System.out.println(myCoach.getNewDailyWorkout());
		System.out.println(myCoach.getFinalSumUp());
		
		
		// close the context
		context.close();
	}

}

