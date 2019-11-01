package com.quiz0514;

import java.util.Scanner;

public class RangeCount {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		Scanner s2 = new Scanner(System.in);
		//첫번째 숫자를 담을 변수 선언 및 초기화
		int firstNumber = s1.nextInt();
		//두번째 숫자를 담을 변수 선언 및 초기화
		int secondNumber = s2.nextInt();
		//두 정수 사이의 3의 배수를 카운트 한 값 담을 변수 선언
		int cnt = 0;
		for(int i=firstNumber+1;i<secondNumber;i++) {
			if(i%3==0) {
				cnt++;
			}////////////end of if
		}////////////////end of for
		System.out.println(s1+"과 "+s2+" 사이에 3의 배수의 갯수는 "+cnt+" 입니다.");
	}////////////////////end of main
}////////////////////////end of RangeCount




