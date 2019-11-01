package com.baseball;

import javax.swing.JButton;
import javax.swing.JFrame;

public class BaseBallGameView extends JFrame{
	JButton jbtn_new = new JButton("새게임");
	public BaseBallGameView() {
		BaseBallGameEvent bgEvent = new BaseBallGameEvent(this);
		jbtn_new.addActionListener(bgEvent);
		this.add(jbtn_new);
		this.setSize(500, 350);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new BaseBallGameView();
	}

}
