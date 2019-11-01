package com.ch2;

public class P49_1 {

	public static void main(String[] args) {
		int i = 5;
		int j = 10;
		System.out.println("i:"+i);//5
		i=j;
		System.out.println("i:"+i);//10
		System.out.println(i+j);//?20
		//int+int=int
		//int+String=String
		System.out.println("10");
		//int-int=int
		//int/int=int
		//int*int=int
		System.out.println(""+i+j);//?1010 or 20
		System.out.println(""+(i+j));//?1010 or 20
		int x = (int)3.14;//강제 형전환
		System.out.println("x:"+x);
		
	}

}
