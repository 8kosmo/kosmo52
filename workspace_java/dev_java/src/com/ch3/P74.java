package com.ch3;

public class P74 {
	public double getTotal(int jumsu1,int jumsu2, double jumsu3) {
		double tot = 0.0;
		tot = jumsu1+jumsu2+jumsu3;
		return tot;
	}
	public double getAverage(double tot, int inwon) {
		double avg = 0.0;
		avg = tot/inwon;
		return avg;
	}
	public static void main(String[] args) {
		P74 p74 = new P74();
		double tot = p74.getTotal(85, 80, 82.5);
		int inwon = 3;
		double avg = p74.getAverage(tot, inwon);
		System.out.println("총점은 "+tot+" 입니다.");
		System.out.println("평균은 "+avg+" 입니다.");
	}

}
