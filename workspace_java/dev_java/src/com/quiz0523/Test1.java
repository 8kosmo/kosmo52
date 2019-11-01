package com.quiz0523;

import java.util.Random;

public class Test1 {
	int a[] = new int[5];
	public void orderBy() {
		int tmp = 0;
		for(int i=0;i<a.length;i++) {
			for(int j=i+1;j<a.length;j++) {
				if(a[i] > a[j]) {//i=0, j=1
					tmp = a[i];
					a[i]= a[j];
					a[j]= tmp;
				}////end of if
			}////////end of inner for
		}////////////end of outter for
	}
	public void arrayInit() {
		Random r = new Random();
		for(int i=0;i<a.length;i++) {
			a[i]=r.nextInt(21);
		}
	}
	public void arrayPrint() {
		for(int i=0;i<a.length;i++) {
			System.out.println(a[i]);
		}		
	}
	public static void main(String[] args) {
		Test1 t1 = new Test1();
		t1.arrayInit();
		System.out.println("===================[[before]]====================");
		t1.arrayPrint();
		t1.orderBy();
		System.out.println("===================[[after]]====================");
		t1.arrayPrint();
	}

}
