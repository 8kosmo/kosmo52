package com.quiz0607;
class Money {
	private String country, name;
	public String getCountry() { 
		System.out.println("getCounty호출 성공");
		return country; 
	}
}
class Yen extends Money {
	//public String getCountry() { return super.country; }
}
class Euro extends Money {
	public String getCountry(String timeZone) {
		return super.getCountry();
	}
}
public class Question4 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Euro euro = new Euro();
		String s = euro.getCountry();
		System.out.println("s:"+s);
	}
}
