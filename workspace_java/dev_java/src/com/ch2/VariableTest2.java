package com.ch2;

public class VariableTest2 {
	void methodC(double pi) {
		System.out.println("pi:"+pi);
	}
	public static void main(String[] args) {
		VariableTest2 vt2 = new VariableTest2();
		vt2.methodC(3.14);
	}

}
