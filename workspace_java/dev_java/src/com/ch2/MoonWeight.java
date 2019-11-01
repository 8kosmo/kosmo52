package com.ch2;

public class MoonWeight {

	public static void main(String[] args) {
		//지구의 몸무게를 담을 변수 선언해 볼까?
		int earth_weight = 100;
		String unit = "kg";
		double moon_weight = 0.0;
		int a = 17;
		int b = 100;
		System.out.println("a/b ===>"+(a/b));
		System.out.println("a/b ===>"+(a/100.0));
		System.out.println("a/b ===>"+(a/100.0f));
		//달의 몸무게를 계산해서 출력하시오.
		System.out.println(100*0.17);
		//insert here
		System.out.println(100*(17/100));
		System.out.println(earth_weight*(a/b));
		int x = 5;
		int y = 0;
		y = x;
		moon_weight = earth_weight*(a/b);
		moon_weight = earth_weight*(17/100);//변수 두개에 상수 두 개사용
		moon_weight = earth_weight*(0.17);//변수 두개에 상수 한 개사용
		System.out.println(moon_weight);
	}


}
