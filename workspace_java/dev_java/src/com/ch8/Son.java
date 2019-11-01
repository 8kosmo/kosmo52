package com.ch8;

public class Son extends Father{
	String book = "성경책";
	//생성자는 메소드 오버로딩의 규칙을 준수한다.
	public Son() {
		System.out.println("Son 디폴트 생성자 호출");
	}
	public Son(String book) {
		this.book = book;
	}
	//메소드 오버로딩임
	public void walk(int i) {
		System.out.println("아빠는 시간당 "+i+"km 속도로 걷는 중......");
	}
	@Override
	public void walk() {
		System.out.println("아빠는 빨리 걷는 중......");
	}
}
