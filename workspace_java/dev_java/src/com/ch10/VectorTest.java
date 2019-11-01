package com.ch10;

import java.util.List;
import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		String fruits[] = new String[3];
		Vector<String> v = new Vector<String>();
		List<String> v1 = new Vector<String>();
		v1.add("사과");
		v1.add("오렌지");
		v1.add(2,"딸기");
		//v1.copyInto(fruits);
		fruits[0] = v1.get(0);
		fruits[1] = v1.get(2);
		fruits[2] = v1.get(1);
		for(String str:fruits) {
			System.out.println(str);
		}
	}

}
