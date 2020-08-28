package aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AopExpressions {
	
	// Pointcut declaration for re-use      
	@Pointcut("execution(* aopdemo.dao.*.*(..))") 
	public void forDaoPackage() {}
	
	
	// create pointcut for getter methods
	@Pointcut("execution(* aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create pointcut for setter methods 
	@Pointcut("execution(* aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut : include package, but exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
	
}
