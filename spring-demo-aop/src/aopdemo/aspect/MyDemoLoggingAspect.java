package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advice for logging

	// let's start with an @Before advice
	
	//@Before("execution(public void add*())")
	@Before("execution(* aopdemo.dao.*.*(..))")   // .*.*  any class, any method
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n========>>>Executing @Before advice on addAccount()");
	}
}
