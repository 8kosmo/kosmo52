package com.oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

import com.util.DBConnectionMgr;
import com.vo.DeptVO;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

public class EmpJDBC {
	Connection 			con = null;//연결통로확보
	CallableStatement 	cstmt = null;//프로시저를 호출,요청
	OracleCallableStatement ocstmt = null;
	public DeptVO[] getMy_proc3() {
		DeptVO[] dvos = null;
		DeptVO dvo = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			//예외가 발생할 가능성이 있는 코드
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call MY_PROC(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet rs = ocstmt.getCursor(1);
			//ArrayList al = new ArrayList();//싱글스레드 안전한 자료구조
			Vector v = new Vector();//멀티스레드 안전한 자료구조
			while(rs.next()) {
				dvo = new DeptVO();
				dvo.setDeptno(rs.getInt("deptno"));
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("loc"));
				//벡터클래스 추가한 이유는 테이블의 로우수를 알 수 없으므로 
				//벡터클래스에 add할때마다 원소의 갯수가 카운트 된다.
				v.add(dvo);
				System.out.println
				(dvo.getDeptno()+", "+dvo.getDname()+", "+dvo.getLoc());
				dvo = null;
			}
			//아래 객체배열을 생성할 때 사용하였다. size()
			dvos = new DeptVO[v.size()];
			//파라미터로 비어있는 객체배열을 넣어주면 벡터에 담긴 값들이 복제된다.
			v.copyInto(dvos);
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		} finally {
			//사용한 자원 반납할것. - 명시적으로
			//생성된 역순으로 반납처리 할것.
			try {
				if(cstmt!=null) {
					cstmt.close();
				}
				if(ocstmt!=null) {
					ocstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dvos;
	}	
	public ArrayList<DeptVO> getMy_proc2() {
		ArrayList<DeptVO> deptList = new ArrayList<DeptVO>();
		DeptVO dvo = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			//예외가 발생할 가능성이 있는 코드
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call MY_PROC(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet rs = ocstmt.getCursor(1);
			while(rs.next()) {
				dvo = new DeptVO();
				dvo.setDeptno(rs.getInt("deptno"));
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("loc"));
				deptList.add(dvo);
				System.out.println
				(dvo.getDeptno()+", "+dvo.getDname()+", "+dvo.getLoc());
				dvo = null;
			}
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		} finally {
			//사용한 자원 반납할것. - 명시적으로
			//생성된 역순으로 반납처리 할것.
			try {
				if(cstmt!=null) {
					cstmt.close();
				}
				if(ocstmt!=null) {
					ocstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return deptList;
	}	
	public DeptVO getMy_proc() {
		DeptVO dvo = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			//예외가 발생할 가능성이 있는 코드
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call MY_PROC(?)}");
			cstmt.registerOutParameter(1, OracleTypes.CURSOR);
			cstmt.execute();
			ocstmt = (OracleCallableStatement)cstmt;
			ResultSet rs = ocstmt.getCursor(1);
			while(rs.next()) {
				dvo = new DeptVO();
				dvo.setDeptno(rs.getInt("deptno"));
				dvo.setDname(rs.getString("dname"));
				dvo.setLoc(rs.getString("loc"));
				System.out.println
				(dvo.getDeptno()+", "+dvo.getDname()+", "+dvo.getLoc());
				dvo = null;
			}
		} catch (Exception e) {
			System.out.println("[[Exception]]"+e.toString());
		} finally {
			//사용한 자원 반납할것. - 명시적으로
			//생성된 역순으로 반납처리 할것.
			try {
				if(cstmt!=null) {
					cstmt.close();
				}
				if(ocstmt!=null) {
					ocstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dvo;
	}
	public void getProc_deptnoUpdate() {
		String msg = null;//프로시저의 out속성값 받아서 저장할 변수
		//외부클래스의 객체를 주입받기 위해서 작성
		//직접 인스턴스화 하지 않았다.
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			//물리적으로 떨어져 있는 오라클 서버의 연결통로 확보
			//자바에서는 오토커밋이 디폴트
			//con.setAutoCommit(false);
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_deptnoUpdate(?,?)}");
			System.out.println("부서번호를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			int u_deptno = scan.nextInt();//사용자가 입력한 부서번호 받아오기	
			cstmt.setInt(1, u_deptno);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			int result = cstmt.executeUpdate();
			System.out.println(cstmt.getString(2));
			/*
			 * if(result==1) { //con.commit(); con.rollback(); }
			 */
		} catch (Exception e) {
			//절대로 print안에 넣지 말것.
			//stack메모리 영역에 쌓여있는 에러메시지를 모두 출력해줌.
			e.printStackTrace();
		} finally {
			//사용한 자원 반납할것. - 명시적으로
			//생성된 역순으로 반납처리 할것.
			try {
				if(cstmt!=null) {
					cstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public String getProc_empnoUpdate() {
		String msg = null;
		DBConnectionMgr dbMgr = DBConnectionMgr.getInstance();
		try {
			con = dbMgr.getConnection();
			cstmt = con.prepareCall("{call proc_empnoUpdate(?,?)}");
			System.out.println("사원번호를 입력하세요.");
			Scanner scan = new Scanner(System.in);
			int u_empno = scan.nextInt();//사용자가 입력한 사원번호 받아오기
			cstmt.setInt(1, u_empno);
			cstmt.registerOutParameter(2, java.sql.Types.VARCHAR);
			//오라클서버에서 처리요청
			int result = cstmt.executeUpdate();
			msg = cstmt.getString(2);
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return msg;
	}
	public static void main(String[] args) {
		//insert here
		EmpJDBC ej = new EmpJDBC();
		//ej.getProc_deptnoUpdate();
		ArrayList<DeptVO> deptList = ej.getMy_proc2();
		//insert here
		//원시방법
		for(int j=0;j<deptList.size();j++) {
			DeptVO dvo = deptList.get(j);
			System.out.println(dvo.getDeptno()
					     +", "+dvo.getDname()
					     +", "+dvo.getLoc());
		}
		
		System.out.println("=======================================");
		//개선방법
		for(DeptVO dvo:deptList) {
			System.out.println(dvo.getDeptno()
				     +", "+dvo.getDname()
				     +", "+dvo.getLoc());			
		}
		//insert here
		DeptVO[] dvos = ej.getMy_proc3();
		for(int x=0;x<dvos.length;x++) {
			DeptVO dvo = dvos[x];
			System.out.println(dvo.getDeptno()
					     +", "+dvo.getDname()
					     +", "+dvo.getLoc());
		}
		System.out.println("============[개선된 for문]==========");
		for(DeptVO dvo:dvos) {
			System.out.println(dvo.getDeptno()
					+", "+dvo.getDname()
					+", "+dvo.getLoc());			
		}
	}

}





