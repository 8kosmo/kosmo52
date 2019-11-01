package com.ch6;

import javax.swing.JButton;
import javax.swing.JFrame;
/*
 * A is a B관계에 있다면 서로 상속처리한다.
 * 상속받을 땐 하위클래스를 상속받는 것이 더 많은 걸 누릴 수 있다.
 */
public class P170_1 extends JFrame {
	//this.setTitle(title);에서 title변수가 선언되지 않았다.
	//선언이 먼저 사용이 다음
	String title = null;
	JButton jbtn = new JButton("전송");
	public P170_1() {
		initDisplay();
	}//디폴트 생성자
	public P170_1(String title) {
		this.title = title;
		//주의 : title을 먼저 초기화하고 화면을 출력해야 함.
		initDisplay();
	}
	public void initDisplay() {
		//디폴트생성자는 없으면 JVM이 대신 추가해줌.
		//생성자가 하나라도 있으면 대신 해주지 않음.
		p170_1Event pEvent = new p170_1Event();
		//p170_1Event pEvent = new p170_1Event(jbtn);
		//이벤트 감지
		jbtn.addActionListener(pEvent);
		this.add("North",jbtn);		
		this.setTitle(title);
		this.setSize(400, 500);
		this.setVisible(true);
	}
	/*
	 * 39-40-17-18(전변초기화)-20(화면처리)-25(Event생성자호출)-11(p170_1Event)
	 * -12(초기화)-7(전변에 주소번지담김)-13(앤딩->P170_1)-28-29-30-31-32
	 * 
	 */
	public static void main(String[] args) {
		P170_1 p = new P170_1("this의 활용기");
		//p.initDisplay();
	}

}
