package com.ch4;

public class HapTest {

	public static void main(String[] args) {
		int i=0;//1부터 10까지 세는 값을 담을 변수 선언
		int sum;//짝수의 합 혹은 홀수의 합을 담을 변수 선언
		for(i=1,sum=0;i<11;i=i+1) {
			if(i%2==0) {//너 짝수니? 네 이면 합을 구하시오.
				sum+=i;
			}////////////end of if
		}////////////////end of for
		System.out.println("1부터 10사이의 짝수의합은 "+sum);
		sum=0;//짝수의 합이 홀수합에 영향을 주면 안되니까 0으로 초기화
		for(i=1;i<11;i=i+1) {
			if(i%2==1) {//너 홀수야? 네 이면 합을 구하시오.
				sum+=i;
			}///////////////end of if
		}///////////////////end of for
		System.out.println("1부터 10사이의 홀수의합은 "+sum);
	}///////////////////////end of main
}///////////////////////////end of HapTest
