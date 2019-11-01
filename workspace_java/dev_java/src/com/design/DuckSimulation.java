package com.design;

public class DuckSimulation {

	public static void main(String[] args) {
		Duck myDuck = new MallardDuck();
		myDuck.prefly();
		myDuck.preQuack();
		Duck herDuck = new RubberDuck();
		herDuck.prefly();
		herDuck.preQuack();
		Duck himDuck = new WoodDuck();
		himDuck.prefly();
		himDuck.preQuack();
		
	}

}
