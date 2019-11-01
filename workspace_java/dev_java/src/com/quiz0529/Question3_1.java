package com.quiz0529;

import javax.swing.JButton;
//생성자와 this
/*
 * this:자기자신의 주소번지, this():자기자신 생성자 호출
 * 생성자도 메소드 오버로딩의 규칙을 따른다.
 * 리턴타입이 있다면 
 */
public class Question3_1 {
	String name="김유신";
	int age = 40;
	public Question3_1() {
		
	}
	//this는 반드시 맨 앞에 사용해야 함.
	public Question3_1(int age) {
		this("이순신",20);
		age = age;
		//this.age = age;
		System.out.println("파라미터 한개짜리 호출");
	}
	public Question3_1(String name,int age) {
		System.out.println("파라미터 두개짜리 호출");
		
	}
	public static void main(String[] args) {
		Question3_1 q3_1 = new Question3_1(25);
		//25가 출력되도록 코드를 수정해 보세요.
		System.out.println(q3_1.age);
	}

}






