package com.ch9;

public abstract class Unit {
	int x, y;
	public Unit() {
		System.out.println("Unit 디폴트 생성자 호출 성공");
	}
	abstract void display();
	void stop() {}
}
