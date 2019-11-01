package com.quiz0607;

public class Father {
	public void methodA() {
		System.out.println("Father methodA호출 성공");
	}
	public static void main(String args[]) {
		Father fa1 = new Father();
		Father fa2 = new Son();
		Son    so2 = new Son();
		//fa1.methodA();
		//fa2.methodA();
		//so2.methodA();
		//so2 = new Father();// so2 = new Father();
		//so2 = (Son)fa1;// so2 = new Father();
		//so2 = new Son();
		so2 = (Son)fa2;
		so2.methodB();
		//fa1.methodB();
//부모타입으로 선언한 변수로 호출할 수 있는 메소드는 부모에도 있고 자녀에도 있는거
//부모한테 없고 자녀한테만 있는거 이건 에러		
		fa2.methodB();
	}
}
class Son extends Father{
	@Override
	public void methodA() {
		System.out.println("Son methodA호출 성공");
	}
	//Overloading
	public void methodA(int a) {
		System.out.println("Son methodA호출 성공");
	}
	public void methodB() {
		System.out.println("Son methodB호출 성공");
	}
}





