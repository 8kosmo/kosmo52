package com.ch6;
class Sorento{
	Sorento(Pride herCar){
		herCar.speed = 150;
	}
}
public class Pride {
	int speed =0;
	public Pride() {
		//10번에서 전변인 speed에 100을 초기화 했네.
		//그리고 Sorento를 인스턴스화 할 때 생성자의 파라미터로 this를 넘김				
		speed = 100;
		//아래 this는 Pride의 주소번지를 가짐
		//Sorento와 Pride간의 객체 협력을 위한 인스턴스화 임.
		//또 다른 말로 바꾸면 Pride객체안에서 Sorento객체를 주입했다고도 함.
		Sorento himCar = new Sorento(this);
	}
	public static void main(String[] args) {
//Pride를 인스턴스화 하면 Pride생성자를 호출 합니다.	
		Pride herCar =new Pride();
		System.out.println(herCar.speed);
	}

}
