package com.puzzle;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PuzzleView extends JFrame {
	public JButton jbtns[] = new JButton[9];
	public String jbtn_label[] = {"1","2","3","4","5","6","7","8","9"};
	public PuzzleView() {
		initDisplay();
	}
	public void initDisplay() {
		this.setLayout(new GridLayout(3,3));
		for(int i=0;i<jbtn_label.length;i++) {
			JButton jbtn = new JButton(jbtn_label[i]);
			this.add(jbtn);
		}
		this.setSize(500, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new PuzzleView();
	}

}
