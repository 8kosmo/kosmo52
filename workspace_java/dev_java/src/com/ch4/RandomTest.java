package com.ch4;

import java.util.Random;
import java.util.Scanner;

public class RandomTest {

	public static void main(String[] args) {
		Random r = new Random();
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<5;i++) {
			System.out.println("숫자?");
			int user = scan.nextInt();
			System.out.println(user);
		}
	}

}
