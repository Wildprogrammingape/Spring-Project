package myspringdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// add annotation here with bean id, so spring will automatically register this bean
//@Component("thatSillyCoach")

@Component   // use default bean id of lower name as class name -- "tennisCoach"
@Scope("singleton")
public class TennisCoach implements Coach{
	
	@Autowired   						// field injection (thanks to java technology reflection)
	@Qualifier("randomFortuneService")   // Qualifier("bean ID), tell spring which component you want to use
	private FortuneService fortuneService; 	// field for .getFortune() method to use
	  					 		
	// configure dependency injection with @Autowired annotation
	// so spring will scan for component that implements FortuneService interface,
	// our example: HappyFortuneService meets the requirement
	
	/*
	@Autowired 
	public TennisCoach(FortuneService theFortuneService) {	// create a constructor for injection
		fortuneService = theFortuneService;
	}
	*/
	
	// define a default constructor
//	public TennisCoach() {
//		System.out.println("Inside default constructor");
//	}
	
	// define my init method
	//@PostConstruct          
	public void dostartup() {
		System.out.println("do it after bean initialized");
	}
	
	//define my destroy method
	//@PreDestroy
	public void docleanup() {
		System.out.println("do it before bean destroyed");
	}
	
	/*
	
	
	// setter injection 
	@Autowired
	public void setFortuneService(FortuneService theFortuneService) {  // name of setter method can be changed to anything
		System.out.println("Inside setFortuneService() method");
		fortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}
