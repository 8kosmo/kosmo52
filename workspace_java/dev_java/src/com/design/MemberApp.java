package com.design;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MemberApp {
	//메소드의 파라미터로 어떤 타입을 선택하는것이 유연한 것인지?
	public void methodA(List<String> nameList) {
		System.out.println("List 호출 성공");
	}
	public void methodA(ArrayList<String> nameList) {
		System.out.println("ArrayList 호출 성공");		
	}
	public void methodA(Vector<String> nameList) {
		System.out.println("Vector 호출 성공");		
	}
	public static void main(String[] args) {
		MemberApp ma = new MemberApp();
		//List<String> list = new List<String>();
		List<String> 		names = new ArrayList<String>();
		List<String> 		names2 = new Vector<String>();
		ArrayList<String> 	names3 = new ArrayList<String>();
		Vector<String> 		names4 = new Vector<String>();
		ma.methodA(names);
		ma.methodA(names2);
		ma.methodA(names3);
		ma.methodA(names4);
	}

}
