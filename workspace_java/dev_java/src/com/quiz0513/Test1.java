package com.quiz0513;

public class Test1 {

	public static void main(String[] args) {
		int i = 1;
		System.out.println("i:"+1);//1
		int j = i++;
		System.out.println("i:"+2+", j:"+1);//1
		/*
		 * | 연산자가 한개이든 두개이든 실행문이 실행되고 안되고는 동일하다.
		 * 다른것은 한개일땐 두번째 조건을 무조건 따진다.
		 * 2번째 조건에서 증감연산자 있게 되면 변수 i나 변수 j값에 영향을 미친다.
		 */
		if((i == j) && (++i == j)) {
			i += j;
		}
		System.out.println("i = " + i);
	}

}
