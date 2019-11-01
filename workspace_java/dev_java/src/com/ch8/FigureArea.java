package com.ch8;

public class FigureArea {
	//삼각형의 면적을 구해줄래?
	public double area(int width,int height, double d) {
		double t_area = 0.0;
		t_area = width*height*d;
		return t_area;
	}
	//사각형의 면적을 구해볼까?
	public double area(int width,int height) {
		double r_area = 0.0;
		r_area = width*height;
		return r_area;
	}
	//원의 면적은 얼마니?
	public double area(double r, double pi) {
		double c_area = 0.0;
		c_area = r*r*pi;
		return c_area;
	}
}
