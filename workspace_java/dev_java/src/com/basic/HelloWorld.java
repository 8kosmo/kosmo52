package com.basic;
//나는 클래스 입니다.
//클래스 이름은 HelloWorld입니다.
public class HelloWorld {
//Ctrl+S 저장 된 후 즉시 컴파일 해줌(이클립스)
//한글에서 코딩을 해도 된다|안된다	
	public static void main(String[] args) {
		// 여기는 메인메소드 입니다.
		//명사형을 쓸 수 있다.
		//변수 선언하기
		//대입연산자가 있다. =
		//같다 1==1 참(true)
		//자바에서는 여러가지 타입을 제공함.
		//오라클에 저장된 정보가 여러가지 임
		//SELECT ename, sal FROM emp
		//변수를 선언했고 대입연산자를 사용해서 그 변수에 800(값)을
		//저장했어요
		//정수를 담을때는 타입은 반드시 int를 사용한다.
	    int sal = 200;
	    //sal = 300;
	    //변수 sal안에 담겨있는 800 숫자 출력해 보기(화면)
	    //System  -  너 PC를 가리킴
	    //out - 명사형인데 출력을 내보낼때 사용하는 명사형
	    //println() - 메소드야 -  화면에 출력을 할 수 있다.
	    System.out.println(sal);//800
	    System.out.println(sal+10);//810
	    sal = sal+10;
	    System.out.println(sal-10);//790
	    System.out.println(sal+100);//900
	    System.out.println(sal+200);//1000
	    //아래 코드는 변수를 사용하지 않았다.
	    System.out.println(500);//500변수이다:상수이다.
	    System.out.println(501);//500변수이다:상수이다.
	    System.out.println(502);//500변수이다:상수이다.
	    System.out.println(503);//500변수이다:상수이다.
	    System.out.println(504);//500변수이다:상수이다.
		//a
		//name="SMITH"

	}

}
