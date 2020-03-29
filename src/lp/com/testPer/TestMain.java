package lp.com.testPer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("appContext.xml");
		Person person = (Person) context.getBean("person");
		Student student = context.getBean("student", Student.class);
		System.out.println(person);
		System.out.println(student);
	}
}