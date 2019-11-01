package com.ch6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class p170_1Event implements ActionListener {
	P170_1 p170_1 = null;
	//생성자는 전역변수 초기화
	public p170_1Event() {
	}
	public p170_1Event(P170_1 p170_1) {
		this.p170_1 = p170_1;//new P170_1("this의 활용기")
	}//////end of 생성자

	//P170_1클래스에서 생성된 버튼을 사용하고 싶다.
	//어떡하지?
	@Override
	public void actionPerformed(ActionEvent e) {
		String label = e.getActionCommand();//전송
		if("전송".equals(label)) {
			System.out.println("전송 버튼 클릭2");
			p170_1.jbtn.setText("보내기");
		}
	}

}
