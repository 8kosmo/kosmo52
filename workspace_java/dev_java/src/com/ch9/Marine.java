package com.ch9;

public class Marine extends Unit {
	public Marine() {
		System.out.println("Marine 디폴트 생성자 호출 성공");
	}
	void steamPack() {
		
	}
	/*
	 * 오버라이딩은 반드시 부모 메소드와 동일해야함.(파라미터, 리턴타입)
	 * 단 접근제한자는  더 넓은 것은 가능
	 */
	@Override
	public void display() {
		System.out.println("나는 마린입니다.");
	}


}
