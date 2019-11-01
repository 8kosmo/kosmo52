package com.ch4;

public class SwitchTest {

	public static void main(String[] args) {
		int i = 1;
		switch(i) {
			case 2: System.out.println(i);
			break;
			case 3: System.out.println(i);
			break;
			case 4: System.out.println(i);
			break;
			default: System.out.println(i);
			break;
		}//////////end of switch
		System.out.println("여기");
		int j = ++i;
		System.out.println("j는 "+j);
	}//////////////end of main
}//////////////////end of SwitchTest
