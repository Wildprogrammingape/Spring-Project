package springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CRMLoggingAspect {

	
	// setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* springdemo.controller.*.*(..))")  // match any class, method, args
	private void forControllerPackage() {}
	
	// do the same for service and DAO
	@Pointcut("execution(* springdemo.service.*.*(..))")  
	private void forServicePackage() {}	

	@Pointcut("execution(* springdemo.dao.*.*(..))")  
	private void forDaoPackage() {}	
	
	// combination for "Controller", "Service" and "DAO"
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	
	
	
	// add @Before advice  -- and JoinPoint gives metadata about the method call
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=======>> in @Before: calling method: " + theMethod);
		
		// display the arguments to the method
		
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through and display the arguments
		for (Object tempArg : args) {
			myLogger.info("======>> argument: " + tempArg);
		}
		
		
	}
	
	
	
	
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=======>> in @AfterReturning: from method: " + theMethod);
		
		
		// display data returned
		myLogger.info("=======>> result: " + theResult);		
		
	}
	
	
	
	
	
	
	
	
	
}
