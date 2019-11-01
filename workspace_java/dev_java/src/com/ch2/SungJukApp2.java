package com.ch2;
public class SungJukApp2 {
	int hap(int jumsu1, int jumsu2, int jumsu3) {
		int tot = 0;
		tot = jumsu1+jumsu2+jumsu3;
		return tot;
	}
	void average(int tot, int inwon) {
		double avg = 0.0;
		avg = tot/(double)inwon;
		System.out.println("평균은 "+avg+"입니다.");
	}
	//실행순서는.............
	/* 17-18-19(70,80,90)-3(70,80,90)-4(tot:0)-5(0->240)-6-7(우중괄호)
	 * -20-8(240,3)-9(avg:0.0)-10(240/3.0)-11(80.0출력)-12-21-끝
	 */
	public static void main(String[] args) {
		SungJukApp2 sa2 = new SungJukApp2();
		int tot = sa2.hap(70, 80, 90);
		sa2.average(tot, 3);
	}
}
