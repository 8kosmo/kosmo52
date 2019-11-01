package com.ch4;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class P96 extends JFrame {

	public static void main(String[] args) {
		System.out.println("당신의 자바점수를 입력하세요.");
		Scanner scan = new Scanner(System.in);
		int jumsu = scan.nextInt();
		System.out.println("당신이 입력한 점수는 "+jumsu+" 입니다.");
		char hakjum = 'Z';
		//if((jumsu/10)==9 || (jumsu/10)==10) {//너 90점 이상이니?
		if(90<=jumsu && 100>=jumsu) {//너 90점 이상이니?
			hakjum = 'A';
		}else if((jumsu/10)==8) {//너 89~80사이에 점수를 받은거니?
			hakjum = 'B';
		}else if((jumsu/10)==7) {
			hakjum = 'C';
		}else if((jumsu/10)==6) {
			hakjum = 'D';			
		}else {
			hakjum = 'F';
		}
		System.out.println("당신의 학점은 "+ hakjum + " 입니다.");
		//static으로 선언된 메소드를 호출할때는 인스턴스화 없이도 가능함.
		P96 p96 = new P96();
		JOptionPane.showMessageDialog
		(p96, "당신의 학점은 "+ hakjum + " 입니다.");
	}

}
