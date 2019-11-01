package com.quiz0510;

public class Test3 {
	static int i;
	int j;//non-static타입은 static영역에서 사용이 불가함.
	public static void main(String[] args) {
		Test3 t3 = new Test3();
		System.out.println(Test3.i);
		//boolean b = (boolean)0;
		boolean b1 = (5>=4);
		System.out.println(b1);
		boolean b2 = Boolean.TRUE;
		System.out.println(b2);
	}

}
