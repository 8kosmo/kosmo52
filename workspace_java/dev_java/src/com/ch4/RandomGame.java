package com.ch4;

import java.util.Random;
import java.util.Scanner;
/*
 * java.lang폴더 안에 있는 클래스는 따로 import안해도 괜찮아
 */
public class RandomGame {

	public static void main(String[] args) {
	//클래스이름을 자바가상머신이 찾을 수 없을때	
		Random r = new Random();
		//컴터가 채번한 숫자를 담을 변수 선언 = 채번한 숫자를 반환하는 함수호출
		int com = r.nextInt(10); 
		//System.out.println("정답com:"+com);
		//기회 카운트해서 담을 변수 선언
		int cnt = 0;
		java.util.Scanner scan = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.println("0~9사이의 정수만 입력하세요.");
			int user = scan.nextInt();
			System.out.println("사용자가 입력한 숫자는 ====>"+user);
			if(com==user) {//정답을 맞춘거야?
				System.out.println("축하합니다. 정답입니다.");
				System.exit(0);//가상머신과 연결고리를 끊음.
			}
			else if(user>com) {//힌트는 낮춰라.
				System.out.println("입력한 숫자가 너무 커요. 낮춰라....");
				cnt++;
				System.out.println("낮춰라 cnt:"+cnt);
			}
			//너무 작은숫자를 입력했어요
			else if(com>user) {
				System.out.println("입력한 숫자가 작아요. 높여라....");
				cnt++;
				System.out.println("높여라 cnt:"+cnt);
			}
		}
		//넌 바보 라고 출력하기
		if(cnt==5) {
			System.out.println("넌 바보~~~!!!");
			System.exit(0);
		}
		/*
		 * for(int x=0;x<10;x++) { int com = r.nextInt(10); System.out.println(com); }
		 */
	}

}
