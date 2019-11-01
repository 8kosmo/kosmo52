package com.quiz0607;
//클래스의 형변환
interface Foo{}
class Alpha implements Foo{
}
class Beta extends Alpha{	
}
public class Delta extends Beta{

	public static void main(String[] args) {
		Beta x = new Beta();
		Foo f= (Delta)x;
		//Beta b = (Beta)(Alpha)x;

	}

}
