package com.ch2;

public class Question5_1 {

	public static void main(String[] args) {
		int i = 1;
		int hap = 0;
		for(i=1;i<=5;i=i+1) {
			hap = hap + i;
			System.out.println("hap==>"+hap);//for문
		}//////////////end of for
		//아래는  for문 밖에 있어요
		System.out.println("1부터 5까지의 합은 "+hap);//15
		//insert here -변수(hap) 초기화 하세요.
		//int hap2;
		hap=15;
		for(i=1;i<=5;i=i+2) {
			hap = hap+i;
		}
		System.out.println("1부터 "+i+"까지의 홀수의  합은 "+hap);//9
	}

}
