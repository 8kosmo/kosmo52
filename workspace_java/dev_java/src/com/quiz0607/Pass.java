package com.quiz0607;

public class Pass {
	int x;
	public static void main(String []args) {
	int x = 5;  
	Pass p = new Pass();
	p.x= 3;
	p.doStuff(p);//12
		System.out.print(" main x = "+ x);
	}
	private void doStuff(Pass p) {
		System.out.print(" doStuff x = "+ ++p.x);
		
	}
	void doStuff(int x) {
		System.out.print(" doStuff x = "+ x++);
	}
}
