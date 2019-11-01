package com.ch4;

public class SwitchTest2 {

	public static void main(String[] args) {
		int i = 2;
		int j = 2;
		switch(i) {
			case 2: ++i;
			break;
			case 3: ++i;
			case 4: ++i;
			break;
			default: j+=i;
			break;
		}//////////end of switch
		//insert here
		//i=?  j=?
	}

}
