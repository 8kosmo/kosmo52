package com.ch7;

public class ParameterTypeA {
	void methodA(int jumsu[]){
		//insert here
		for(int i=0;i<jumsu.length;i++) {
			System.out.println(jumsu[i]);
		}
		for(int i:jumsu) {//배열의 인덱스를 사용할 수 없다.-구구단, 야구숫자게임
			System.out.println(i);
		}
	}
	void methodB(String names[]){
		for(int i=0;i<names.length;i++) {
			System.out.println(names[i]);
		}
		for(String name:names) {//배열의 인덱스를 사용할 수 없다.-구구단, 야구숫자게임
			System.out.println(name);
		}		
	}
	void methodZ(int jumsu[], String names[]) {
		for(int i=0;i<jumsu.length;i++) {
			//insert here
			//System.out.println("names["+i+"]="+names[i]);
			// 김유신 : 85
			System.out.println(names[i]+" : "+jumsu[i]);
		}
	}
	
	public static void main(String[] args) {
	//insert here - 배열선언 및 초기화 처리
		String names[] = new String[3];//null,null,null
		String names2[] = new String[]{"정지우","유승기","정재현"};
		String names3[] = {"정지우","유승기","정재현"};
		int jumsu[] = null;
		jumsu = new int[3];
		jumsu[0] = 70;
		jumsu[1] = 85;
		jumsu[2] = 95;
		ParameterTypeA pta = new ParameterTypeA();
		pta.methodA(jumsu);
		pta.methodB(names2);
		pta.methodZ(jumsu, names3);
	}

}
