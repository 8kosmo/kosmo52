package com.baseball;

public class B {
	int b;
	A a = null;
	public B(A a) {//a=new A()
		System.out.println("B(A a)생성자 호출 성공");
		this.a = a;
	}
	public B() {
		// TODO Auto-generated constructor stub
	}
	public void methodB() {
		//생성자의 파라미터로 넘어온 a변수를 전역변수와
		//초기화(7번라인) 했으므로 12번 정상적으로 호출 
		a.methodA();
		System.out.println("methodB() 호출 성공");
	}
}
