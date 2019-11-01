package com.baseball;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaseBallGameEvent implements ActionListener {
	BaseBallGameView bgView = null;
	public BaseBallGameEvent(BaseBallGameView bgView) {
		this.bgView = bgView;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("콜백메소드 호출 성공");
		if(ae.getSource()==bgView.jbtn_new) {
			System.out.println("새게임버튼 호출 성공");
		}
	}

}
