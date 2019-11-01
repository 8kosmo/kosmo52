package com.ch8;

public class FigureAreaSimulation {

	public static void main(String[] args) {
		//인스턴스화 하기
		FigureArea fa = new FigureArea();
		//삼각형 면적구하는 메소드 호출 한 후 결과값 출력하기
		double t_area = fa.area(10, 15, 0.5);
		System.out.println(t_area);
		//사각형 면적구하는 메소드 호출 한 후 결과값 출력하기
		double r_area = fa.area(20, 15);
		System.out.println(r_area);
		//원의 면적구하는 메소드 호출 한 후 결과값 출력하기
		double c_area = fa.area(0.5, 3.14);
		System.out.println(c_area);
	}

}
