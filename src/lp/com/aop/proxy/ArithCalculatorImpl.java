package lp.com.aop.proxy;

public class ArithCalculatorImpl implements ArithCalculator {

	@Override
	public int add(int i, int j) {
		return i + j;
	}
	
	@Override
	public int del(int i, int j) {
		return i - j;
	}

}
