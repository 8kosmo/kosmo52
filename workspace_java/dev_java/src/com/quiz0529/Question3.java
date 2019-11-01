package com.quiz0529;

import javax.swing.JButton;
//생성자와 this
/*
 * this:자기자신의 주소번지, this():자기자신 생성자 호출
 * 생성자도 메소드 오버로딩의 규칙을 따른다.
 * 리턴타입이 있다면 
 */
public class Question3 {
	int bootch;
	String snootch;
	
	public Question3() {  // 
		this("snootchy");   // 
		System.out.print("first ");  // 
	}
	
	public Question3(String snootch) {  // 3
		this(420, "snootchy");  // 4 :
		System.out.print("second ");  // 
	}
	
	public Question3(int bootch, String snootch) {  // 5
		this.bootch = bootch;  // 6 : 420
		this.snootch = snootch;  // 7 :  snootchy
		System.out.print("third ");  // 8 : third
	}
	/* 33-34-14-19-24[420,"snootchy"- 초기화]-27(third출력)-28
	 * 21(second출력)-22-16(first출력)-35(snootchy출력 420출력)
	 * 
	 */
	public static void main(String[] args) {
		Question3 b = new Question3();
		System.out.print(b.snootch +" " + b.bootch);  //
	}

}






