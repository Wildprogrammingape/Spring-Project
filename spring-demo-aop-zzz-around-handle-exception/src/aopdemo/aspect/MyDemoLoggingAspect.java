package aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import aopdemo.Account;
import aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{
		
		// print out method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n========>>>Executing @Around on method" + method);		
		
		// get begin time 
		long begin = System.currentTimeMillis();
		
		// execute the method
		Object result = null;
		
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			// log the exception
			myLogger.warning(e.getMessage());
			
			// give user a custom message (fixed exception)
			//result = "Major accident! But no worries, your private AOP helicopter is on the way";
			
			// rethrow exception  (not fixed)
			throw e;
		}
		
		// get end time
		long end = System.currentTimeMillis();
		
		// compute duration and display it
		long duration = end - begin;
		myLogger.info("\n========>>>Duration is :" + duration / 1000.0 + " seconds");
		
		return result;
	}
	
	
	
	
	
	@After("execution(* aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========>>>Executing @After (finally) on method" + method);
		
		
	}
	
	
	@AfterThrowing(
			pointcut="execution(* aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing="theExc")
	public void afterThrowingFindAccountsAdvice(
				JoinPoint theJoinPoint, Throwable theExc) {
		
		// print out which method we are advising on 
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========>>>Executing @AfterThrowing on method" + method);
		
		
		// log the excepetion
		myLogger.info("\n========>>>The exception is " + theExc);
		
	}
	
	
	
	// add a new advice for @AfterReturning on findAccounts method
	@AfterReturning(
			pointcut="execution(* aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result")
	public void afterReturningFindAccountsAdvice(
				JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n========>>>Executing @AfterReturning on method" + method);
		
		
		// print out the result of the method call
		myLogger.info("\n========>>>result is " + result);
		
		// let's post-process the data ... modify it
		
		// convert the account names to upper case
		convertAccountNamesToUpperCase(result);
		
		myLogger.info("\n========>>>result is " + result);
	}
	
	
	
	
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		
		// loop through accounts
		
		for (Account tempAccount : result) {
			
			// get upper case of name
			String theUpperName = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperName);
			
		}
		
		
		
		
		
		
	}





	@Before("aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")   
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		myLogger.info("\n========>>>Executing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("Method: " + methodSig);
		
		// display the method argument
		
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if (tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account theAccount = (Account) tempArg;
				
				myLogger.info("account name: " + theAccount.getName());
				myLogger.info("account level: " + theAccount.getLevel());
				
			}
		}
	}
	

}





















