package com.quiz0529;

public class Question4 {
	public void testIfA() {
		if(testIfB("True")) {
			System.out.println("True");
		} else {
			System.out.println("Not true");
		}
	}/////////end of testIfA
	public Boolean testIfB(String str) {
		return Boolean.valueOf(str);//레퍼클래스 기억
	}
	/* 17-18-19-4-5-6[True가 출력됨]
	 * 
	 */
	public static void main(String[] args) {
		Question4 q4 = new Question4();
		q4.testIfA();
	}

}
