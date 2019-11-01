package UI.swing;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

public class SungJukApp extends JFrame implements ActionListener{
	//선언부
	//레이아웃 종류
	//BorderLayout, FlowLayout, CardLayout, GridLayout, GridBagLayout
	//BoxLayout
	//JPanel은 디폴트 레이아웃이 FlowLayout
	JPanel      jp_north  = new JPanel();
	JLabel 		jlb_inwon = new JLabel("인원수",JLabel.RIGHT);
	JLabel 		jlb 	  = new JLabel("명",JLabel.LEFT);
	JTextField 	jtf_inwon = new JTextField(10);
	JButton 	jbtn_add  = new JButton("추가");
	Object      data[][]  = new Object[0][7];
	String      cols[]    = {"이름","JAVA","Oracle","JSP","총점","평균","석차"};
	DefaultTableModel dtm_list = null;
	DefaultTableColumnModel dtcm = null;
	DefaultListSelectionModel dlsm = null;
	TableColumn tc,tc1,tc2,tc3,tc4,tc5,tc6; 
	DefaultTableCellRenderer dtcr,dtcr1,dtcr2,dtcr3,dtcr4,dtcr5,dtcr6;
	DefaultCellEditor dce,dce1,dce2,dce3,dce4,dce5,dce6;
	JTextField jtf, jtf1, jtf2, jtf3, jtf4, jtf5, jtf6;
	JTableHeader jth;
	JTable 		jtb_list  = null;
	JScrollPane jsp_list  = null;
	Container ct = this.getContentPane();
	int num = 0;
	//생성자
	/*
	 * 문제 제기
	 * 화면을 처리하는 메소드 호출을 생성자에서 할 수도 있고
	 * 메인 메소드에서 할 수도 있다.
	 * 둘 의 차이점에 대해 생각해 보세요.
	 * 
	 */
	public SungJukApp() {
		//initDisplay();
	}
	//화면처리 구현
	public void initDisplay() {
		Font f = new Font("굴림체",Font.BOLD,20);
		jbtn_add.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		jbtn_add.setFont(f);
		jbtn_add.addActionListener(this);
		jp_north.add(jlb_inwon);
		jp_north.add(jtf_inwon);
		jp_north.add(jlb);
		jp_north.add(jbtn_add);
		ct.add("North",jp_north);
		//this.setResizable(false);
		this.setSize(300,250);
		this.setVisible(true);
	}
	//메인메소드
	public static void main(String[] args) {
		SungJukApp sja = new SungJukApp();
		sja.initDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		String inwon = jtf_inwon.getText();
		if(inwon!=null) {
			num = Integer.parseInt(inwon);
		}
		if(obj == jbtn_add) {
			dtm_list = new DefaultTableModel(num,7);
			dtcm = new DefaultTableColumnModel();
			dlsm = new DefaultListSelectionModel();
			jtb_list = new JTable(dtm_list,dtcm,dlsm);
			jsp_list = new JScrollPane(jtb_list);
			////////////이름
			dtcr = new DefaultTableCellRenderer();
			jtf = new JTextField();
			tc = new TableColumn(1,120,dtcr,dce);
			tc.setHeaderValue("이름");
			dtcm.addColumn(tc);
			////////////JAVA
			dtcr1 = new DefaultTableCellRenderer();
			jtf1 = new JTextField();
			tc1 = new TableColumn(1,120,dtcr1,dce1);
			tc1.setHeaderValue("JAVA");
			dtcm.addColumn(tc1);			
			////////////ORACLE
			dtcr2 = new DefaultTableCellRenderer();
			jtf2 = new JTextField();
			tc2 = new TableColumn(1,120,dtcr2,dce2);
			tc2.setHeaderValue("ORACLE");
			dtcm.addColumn(tc2);			
			////////////JSP
			dtcr3 = new DefaultTableCellRenderer();
			jtf3 = new JTextField();
			tc3 = new TableColumn(1,120,dtcr3,dce3);
			tc3.setHeaderValue("JSP");
			dtcm.addColumn(tc3);			
			////////////총점
			dtcr4 = new DefaultTableCellRenderer();
			jtf4 = new JTextField();
			tc4 = new TableColumn(1,120,dtcr4,dce4);
			tc4.setHeaderValue("총점");
			dtcm.addColumn(tc4);			
			////////////평균
			dtcr5 = new DefaultTableCellRenderer();
			jtf5 = new JTextField();
			tc5 = new TableColumn(1,120,dtcr5,dce5);
			tc5.setHeaderValue("평균");
			dtcm.addColumn(tc5);				
			////////////석차
			dtcr6 = new DefaultTableCellRenderer();
			jtf6 = new JTextField();
			tc6 = new TableColumn(1,120,dtcr6,dce6);
			tc6.setHeaderValue("석차");
			dtcm.addColumn(tc6);	
			ct.add("Center",jsp_list);
			ct.validate();
			this.pack();
			 
		}
		
	}

}




