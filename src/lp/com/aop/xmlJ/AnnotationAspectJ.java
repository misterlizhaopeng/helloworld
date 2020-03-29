package lp.com.aop.xmlJ;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 声明一个切面
 * 
 * @author misterLip
 * @date 2018年12月3日
 */
//@Component // 作用为声明一个组件
//@Aspect // 作用为声明一个切面
//@Order(value = 10) // 作用为声明当前切面在多个切面中的执行顺序，数据越小，优先级别越大
public class AnnotationAspectJ { 

//	@Pointcut("execution(* lp.com.aop.annotationJ.*.*(..))")
//	private void expression() {
//	}

	/**
	 * 前置通知（方法执行前被切到）
	 * 
	 * @date 2018年12月3日
	 * @author misterLip
	 */
//	@Before("expression()") // 加载包下的所有类的任意参数的所有方法
	public void beforeMethodd(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("前置通知==>methodName=" + methodName + ",args with" + Arrays.asList(args));
	}

	/**
	 * 返回通知（在没有异常的情况系下，才能返回，有异常就不能返回了）
	 * 
	 * 
	 * 注意：接受的参数类型不对（我一开始写的是String，然而方法返回的是int），该切点不能被正常调用，所以定义为Object为好
	 * 
	 * @date 2018年12月3日
	 * @author misterLip
	 */
//	@AfterReturning(pointcut = "expression()", returning = "result")
	public void returningMethod(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out
				.println("返回通知==>methodName=" + methodName + ",args with" + Arrays.asList(args) + ",return =" + result);

	}

	/**
	 * 后置通知（有没有异常都会被切到）
	 * 
	 * @date 2018年12月3日
	 * @author misterLip
	 */
//	@After(value = "expression()")
	public void afterMethod(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println("后置通知==>methodName=" + methodName + ",args with" + Arrays.asList(args));

	}

	/**
	 * 异常通知(没有异常，当前切点不会被切到)
	 * 
	 * 注意：注解AfterThrowing中的throwing的写法必须和切点方法的参数写法一致，否则找不到值，会出现异常
	 * 
	 * @date 2018年12月3日
	 * @author misterLip
	 */
//	@AfterThrowing(pointcut = "expression()", throwing = "ex")
	public void exceptionMethod(JoinPoint joinPoint, Exception ex) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		System.out.println(
				"异常通知==>methodName=" + methodName + ",args with" + Arrays.asList(args) + ",Exception:" + ex.toString());
	}
	
	/**
	 * 环绕通知:  环绕着目标方法执行。  可以理解为 前置 后置 返回 异常 通知的结合体.  更像是动态代理的整个过程(invoke方法)
	 */
	
//	@Around("execution(* lp.com.aop.annotation.*.*(..))")
	public Object aroundMethod(ProceedingJoinPoint  pjp ) {
		try {
			//前置
			
			//执行目标方法
			Object result = pjp.proceed();
			
			//返回
			return result ;
		} catch (Throwable e) {
			e.printStackTrace();
			//异常
		}finally {
			//后置
		}
		
		return -1;
	}
}
