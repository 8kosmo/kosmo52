package com.ch4;

public class GuGuDan {
	
	public static void main(String[] args) {
		for(int i=1;i<10;i++) {//단수를 카운트 하기 2단 9단
			for(int j=2;j<10;j++) {//1부터 9까지 숫자를 카운트 하기 -단수가 변경될때 1로 초기화해야한다.
				System.out.print(j+"*"+i+"="+(i*j)+"  ");
			}///////////end of inner for
			System.out.print("\n");
		}///////////////end of outter for
	}///////////////////end of main
}///////////////////////end of 
