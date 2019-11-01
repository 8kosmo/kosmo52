package com.quiz0607;

import java.util.Arrays;

public class Question6 {
	String str[] = {"1","2","3"};
	Object [] myObjects = {
			new Integer(12),
			new String("foo"),
			new Integer(5),
			new Boolean(true)
	};  
	public void methodA() {
		try {
			Arrays.sort(myObjects);  //정렬시 형변환 오류 발생
		} catch (Exception e) {
			System.out.println("EXCEPTION:"+e.toString());
		}
		for( int i=0; i<myObjects.length; i++) {
			System.out.print(myObjects[i].toString());
			System.out.print(" ");
		}
	}
	
	public static void main(String[] args) {
		Question6 q6 = new Question6();
		q6.methodA();
	}

}
