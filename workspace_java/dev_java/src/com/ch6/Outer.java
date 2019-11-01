package com.ch6;

public class Outer {
	int i;
	public Outer() {
		System.out.println(i);		
	}
	class Inner{
		int x;
		void methodA() {
			System.out.println(i);					
		}
	}
	public static void main(String[] args) {
		Outer outer = new Outer();
		Outer.Inner inn = new Outer().new Inner();
	}

}
