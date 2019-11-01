package com.ch4;

public class GuGuDan_While {
	
	public static void main(String[] args) {
		int i=1;
		while(i<10) {//변수 i는 1부터 9까지 곱해지는 숫자
			int j=2;
			while(j<10) {//1부터 9까지 숫자를 카운트 하기 -단수가 변경될때 1로 초기화해야한다.
				System.out.print(j+"*"+i+"="+(i*j)+"  ");
				j++;
			}///////////end of inner for
			i++;
			System.out.print("\n");
		}///////////////end of outter for
	}///////////////////end of main
}///////////////////////end of 
