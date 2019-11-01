package com.ch2;

public class VariableTest1 {
	//non-static타입의 변수는 static영역에서 사용불가
	//해결방법이 있다. - 인스턴스화를 하면 가능함.
	//전역변수는 초기화를 생략할 수도 있다.이유? 생성자가 대신해주니까.....
	int i=100;//전역변수이다. 다른 메소드에서도 사용이 가능하다.
	void methodA() {
		//지역변수는 반드시 초기화를 해야됨. 안하면 컴파일 에러
		int i;//지역변수임
		i=10;
		System.out.println(i);//100|10
	}
	void methodA(int i) {//메소드의 파라미터 자리에도 지역변수를 선언할 수 있다.
		System.out.println(i);//100
	}

	/*
	 * void methodA(String id, String pw) {//메소드의 파라미터 자리에도 지역변수를 선언할 수 있다.
	 * System.out.println(i); }
	 */
	public static void main(String[] args) {
		VariableTest1 vt = new VariableTest1();
		vt.methodA();//메소드 호출하기
		System.out.println(vt);//@abcd1234주소번지
		System.out.println(vt.i);
	}

}
