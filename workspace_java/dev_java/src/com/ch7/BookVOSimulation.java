package com.ch7;

public class BookVOSimulation {
	public static void main(String args[]) {
		BookVO bVO = new BookVO();//책정보를 하나만 담을 수 있다.
		//방이 3개, 그안에 있는건 - null
		BookVO bVOS[] = new BookVO[3];
		for(BookVO bVO2:bVOS) {
			System.out.println(bVO2);
		}
		for(int i=0;i<bVOS.length;i++) {
			System.out.println(bVOS[i]);
		}
		//String book_title = bVOS[0].getBook_title();
		//System.out.println(book_title);
		bVO.setBook_title("자바의 정석");
		bVO.setBook_price(35000);
		bVOS[0] = bVO;
		if(bVOS[0]!=null) {
			System.out.println("bVOS[0]:"+bVOS[0].getBook_title()+bVOS[0].getBook_price()+bVOS[0].getBook_author());			
		}else {
			System.out.println("bVOS[0]안에 객체가 생성되지 않았음.");			
		}
	}
}
