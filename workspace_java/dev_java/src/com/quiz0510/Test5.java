package com.quiz0510;

public class Test5 {

	public static void main(String[] args) {
		Integer a = new Integer(100);//int타입에 대한 Wrapper클래스이다.
		Integer b = new Integer(10);
		int d = 10;
		Integer c = a;
		if(a==c) {
			System.out.println("참");
		}
		if(b==d) {
			System.out.println("참");
		}
		else {
			System.out.println("거짓");
		}
		System.out.println(a);
		int i;
		i=a;//오토박싱
		i=a.intValue();
	}

}
