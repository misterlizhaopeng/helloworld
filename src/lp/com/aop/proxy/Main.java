package lp.com.aop.proxy;

import java.util.Properties;

public class Main {
	public static void main(String[] args) throws Exception {
		 Properties properties = System.getProperties();
//		 properties.put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		 System.out.println(properties);
		 System.out.println("===============>>>");

		 
		 
		ArithCalculator arithCalculator = (ArithCalculator) new ArithCalctorProxy(new ArithCalculatorImpl()).getProxy2();
		System.out.println(arithCalculator.add(11, 2));

	}
}
