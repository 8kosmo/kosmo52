package UI.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
class InnerFrame extends JInternalFrame{
	//테이블에 들어갈 데이터 2차 배열 선언
	String data[][] = {
						{"1_1","1_2","1_3"}
					   ,{"2_1","2_2","2_3"}
					   ,{"3_1","3_2","3_3"}
					  };
	//테이블 헤더에 들어갈 컬럼정보
	String cols[] = {"1번","2번","3번"};
	//테이블 생성시 첫번째 파라미터에는 데이터2차배열 추가
	//두번재 파라미터에는 1차 배열 추가
	JTable jt = new JTable(data,cols);
	//스크롤바를 제공하는 속지 생성
	JScrollPane jsp = new JScrollPane(jt);
	//생성자 파라미터 1번 타이틀 문자열
	//2번부터 4번까지는 창 옵션
	//5번은 옵져버
	InnerFrame(String title,boolean a,boolean b,boolean c,boolean d){
		super(title,a,b,c,d);
		this.setTitle(title);
		this.setSize(300, 200);
		this.setVisible(true);
	}
}
public class JInternalFrameTest extends JFrame implements ActionListener {
	JRootPane jrp = this.getRootPane();//JMenuBar 붙이는 속지
	Container cp = this.getContentPane();//swing component붙임
	JDesktopPane jdp = new JDesktopPane();//윈도우 안에 붙이는 속지
	JPanel jp_south = new JPanel(new FlowLayout(FlowLayout.LEFT));
	JButton jbtn_new = new JButton("새창");
	JButton jbtn_excel = new JButton("엑셀");
	static int num = 0;
	public void initDisplay() {
		jbtn_new.addActionListener(this);
		jbtn_excel.addActionListener(this);
		jp_south.add(jbtn_new);
		jp_south.add(jbtn_excel);
		cp.add("South",jp_south);
		cp.add("Center",jdp);//센터에 들어올 내부 프레임 InnerFrame
		this.setSize(700, 400);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JInternalFrameTest jif = new JInternalFrameTest();
		jif.initDisplay();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jbtn_new) {
			InnerFrame inn = new InnerFrame("새창",true,true,true,true);
			jdp.add(inn);
		}
		if(e.getSource()==jbtn_excel) {
			ExcelFrame inn = new ExcelFrame("제목"+ ++num,true,true,true,true);
			jdp.add(inn);
		}
	}

}





