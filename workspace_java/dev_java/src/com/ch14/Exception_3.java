package com.ch14;

public class Exception_3 {
	void methodA(String imsi) {
		System.out.println("methodA 호출");
		int x = Integer.parseInt(imsi);
		throw new NumberFormatException();
		//System.out.println("methodA-1 호출");
	}
	public static void main(String[] args) {
		Exception_3 exc1 = null;
		try {
			exc1 = new Exception_3();
			exc1.methodA("123");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.toString());
			e.printStackTrace();
		}
		System.out.println("다른 코드들.....");
	}

}
