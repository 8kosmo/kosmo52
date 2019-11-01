package com.quiz0514;

public class Fibonacci {

	public static void main(String[] args) {
		int a1=1, a2=1, a3=0;
		//첫째항과 두번째 항은 규칙을 적용할 수 없으니까 그냥 출력함.
		//피보나치수열은 하나 앞에 숫자 더하기 두번째 앞에 숫자를 더한 값이 세번째 항이 되는 것임.
		System.out.print(a1+" "+a2+" ");
		for(int i=0;i<18;i++) {
			a3 = a2+a1;
			//세번째 항이 계산되었으므로 값을 출력함.
			System.out.print(a3+" ");
			//세번째 항이 출력된 다음 값을 변경시켜줌 - 다시 초기화함.
			a1 = a2;
			a2 = a3;
		}////////////////end of for
	}////////////////////end of main
}////////////////////////end of Fibonacci
