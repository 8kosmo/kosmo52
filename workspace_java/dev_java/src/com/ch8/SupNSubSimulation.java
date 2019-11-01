package com.ch8;
/*
 * 자바의 특징  - 자바답게 코딩을 할까? - 재사용성과 다형성
 * 인스턴스화 할 때 선언부와 생성부의 이름이 다를 수 있다.
 * 기억할것. - 생성부에 오는 클래스이름으로 객체 생성된다.
 * 
 */
public class SupNSubSimulation {

	public static void main(String[] args) {
		Sup sup1 = new Sup();
		Sup sup2 = new Sub();
		
		Sub sub1 = new Sub();
		//methodA와 methodB를  호출하시오.
		//sup1.methodA();
		//sup2는 Sup타입의 변수이고 실제로 생성된 객체는 Sub이다.
		//선언부의 타입과 생성부의 타입이 다를 수 있다. - 이때 다형성을 기대할 수 있다.
		//만일 선언부의 타입과 생성부의 타입이 같을 땐 다형성은 불가함.
		//sup2 = (Sub)sup2;
		//sup2.methodB();
		sup1.methodA();
		sup2.methodA();
		sub1.methodA();
		//sub1.methodA();
		//sub1.methodB();
		
	}

}
