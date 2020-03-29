package lp.com.aop.xmlJ;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

//@Component
//@Aspect
//@Order(2)
public class ValidationJ {

//	@Pointcut("execution(* lp.com.aop.annotationJ.*.*(..))")
//	public void expre() {}
	
	
	
	/**
	 * 验证切面的前置通知
	 * @date 2018年12月3日
	 * @author misterLip
	 */
//	@Before("expre()")
	public void beforeMethod(JoinPoint joinPoint) {
		String name = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("验证切面的前置通知==>methodName=" + name + ",args with" + Arrays.asList(args));

	}
	
}
