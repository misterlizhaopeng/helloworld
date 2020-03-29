package lp.com.aop.annotationJ;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation.xml");
		ArithCalculator calculator = ctx.getBean("arithCalculatorImpl", ArithCalculator.class);
//		System.out.println("对象名称："+calculator.getClass().getName());
 		System.out.println(calculator.add(10, 1));
		System.out.println(calculator.div(10, 1));

	}
}
