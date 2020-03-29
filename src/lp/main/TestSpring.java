package lp.main;

import org.junit.Test;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import lp.com.annotation.contoller.UserController;
import lp.com.annotation.repository.UserRepository;
import lp.com.annotation.service.UserService;
import lp.com.model.Person;

public class TestSpring {

	@Test
	public void test01() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:auto.xml");
		Person person = ctx.getBean("person", Person.class);
		System.out.println(person);
	}

	@Test
	public void test02() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("autoConfig.xml");
		UserController bean = ctx.getBean("userController", UserController.class);
		System.out.println(bean);

		UserService userService = ctx.getBean("userService", UserService.class);
		System.out.println(userService);
		
		UserRepository userRepository = ctx.getBean("userRepository", UserRepository.class);
		System.out.println(userRepository);
	}
}
