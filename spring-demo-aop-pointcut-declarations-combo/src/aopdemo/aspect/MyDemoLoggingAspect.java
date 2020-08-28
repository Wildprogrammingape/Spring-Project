package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// Pointcut declaration for re-use      
	@Pointcut("execution(* aopdemo.dao.*.*(..))") 
	private void forDaoPackage() {}
	
	
	// create pointcut for getter methods
	@Pointcut("execution(* aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create pointcut for setter methods 
	@Pointcut("execution(* aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut : include package, but exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}

	
	
	@Before("forDaoPackageNoGetterSetter()")   
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n========>>>Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")   
	public void performApiAnalytics() {
		System.out.println("\n========>>>Perform API analytics");
	}
}
