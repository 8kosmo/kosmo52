package com.ch7;

import java.util.ArrayList;

public class ArrayListTest1 {
	// 맥북 3대를 담을 참조변수가 필요하다.
	public ArrayList<MacBook> setArrayList() {//담기
		ArrayList macList = new ArrayList();
		ArrayList<MacBook> macList2 = new ArrayList<MacBook>();
		MacBook myBook = new MacBook("13형 MacBook Pro");
		MacBook herBook = new MacBook("13형 MacBook air");
		MacBook yourBook = new MacBook("15형 MacBook Pro");
		boolean isMyBook = macList2.add(myBook);
		if(isMyBook) System.out.println("내 맥북 담기성공");
		else System.out.println("담기실패");
		boolean isHerBook = macList2.add(herBook);
		if(isHerBook) System.out.println("그녀의 맥북 담기성공");
		else System.out.println("담기실패");
		boolean isYourBook = macList2.add(yourBook);
		if(isYourBook) System.out.println("당신의 맥북담기성공");
		else System.out.println("담기실패");
		return macList2;
	}
	public static void main(String[] args) {
		ArrayListTest1 al = new ArrayListTest1();
		//메소드의 리턴 타입으로 주소번지를 받아온다.
		ArrayList<MacBook> macList = al.setArrayList();
		//개선된 for문을 사용하여 반복처리
		for(MacBook mbook:macList) {
			//ArrayList안에 담긴 타입이 MacBook이므로 타입을 맞춘다.
			//MacBook mbook = (MacBook)obj;
			//System.out.println(obj);
			//주소번지를 활용하여 전역변수를 출력한다.
			System.out.println(mbook.name);
		}
		System.out.println("========================================");
		for(int i=0;i<macList.size();i++) {
			//MacBook mBook = (MacBook)macList.get(i);
			MacBook mBook2 = macList.get(i);
			String name = mBook2.name;
			System.out.println(name);
		}
	}

}





