package com.quiz0607;
interface Status{
	int MY_VALUE = 10;
	final int TEST1=0;
	final static double TEST2 =50.0;
	public final static String NAME="이순신";
}
public class Question1 implements Status{
	//인터페이스와 추상클래스는 반드시 구현체 클래스가 있어야 한다.
	public static void main(String[] args) {
		Status sta = new Question1();
		//Status sta1 = new Status();
		System.out.println(sta.MY_VALUE);
		System.out.println(sta.TEST1);
		System.out.println(sta.TEST2);
		System.out.println(sta.NAME);
	}

}
