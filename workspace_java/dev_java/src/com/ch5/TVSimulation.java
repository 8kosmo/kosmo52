package com.ch5;

public class TVSimulation {

	public static void main(String[] args) {
		TV myTV = new TV();
		TV herTV = new TV();
		TV gnomTV = new TV();
		gnomTV.onoff = true;
		TV himTV = null;
		himTV = new TV(true);
		System.out.println("그의 TV는 현재 켜진 상태인가요? "+himTV.onoff);
	}

}
