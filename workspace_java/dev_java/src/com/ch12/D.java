package com.ch12;

import java.util.ArrayList;

public class D {

	public static void main(String[] args) {
		ArrayList al1 = new ArrayList();//내안에 Object
		ArrayList<String> al2 = new ArrayList<String>();
		al1.add("바나나");
		al2.add("딸기");
		for(int i=0;i<al1.size();i++) {
			String str=al1.get(0);
		}
		for(int i1=0;i1<al2.size();i1++) {
			String str=al2.get(0);
		}
	}

}
