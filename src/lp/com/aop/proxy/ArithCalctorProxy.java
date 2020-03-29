package lp.com.aop.proxy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ArithCalctorProxy {

	private ArithCalculator target;

	public ArithCalctorProxy(ArithCalculator target) {
		this.target = target;
	}

	public Object getProxy() {
		ClassLoader classLoader = target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		Object proxy = Proxy.newProxyInstance(classLoader, interfaces, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// proxy :表示当前的代理
				// method:表示执行的目标方法
				// args：方法执行的参数

				System.out.println("before invoke ...");
				Object invoke = method.invoke(target, args);
				System.out.println("after invoke ...");

				return invoke;
			}
		});
		System.out.println("=========>:" + proxy);
		return proxy;
	}

	/**
	 * 获取代理方法的第二种方法：
	 * 
	 * @date 2018年12月2日
	 * @author misterLip
	 * @throws Exception
	 */
	public Object getProxy2() throws Exception {
		Object proxy = null;
		ClassLoader classLoader = target.getClass().getClassLoader();
		Class<?>[] interfaces = target.getClass().getInterfaces();
		// 代理类
		Class<?> proxyClass = Proxy.getProxyClass(classLoader, interfaces);
		Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
		proxy = cons.newInstance(new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				return method.invoke(target, args);
			}
		});
		System.out.println("=========>:" + proxy);
		return proxy;
	}
}
