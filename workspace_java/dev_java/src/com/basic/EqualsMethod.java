package com.basic;

public class EqualsMethod {

	public static void main(String[] args) {
		String s = new String("select");
		String s1 = "delete";
		String s2 = new String("select");
		System.out.println(s==s2);
		System.out.println(s.equals(s2));
		if(s==s2) {
			
		}
	}

}
