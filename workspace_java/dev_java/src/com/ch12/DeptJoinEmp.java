package com.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vo.DeptVO;
import com.vo.EmpVO;
/*
 * 리턴타입이 참조형인 경우
 * 
 */
public class DeptJoinEmp {
	/************************************************
	 * 아래 코드 개선해 보기
	 * 문제제기
	 * List를 사용하더라도 제네릭 타입을 두 개 선정할 수가 없어요.
	 * 그래서 DeptVO에 EmpVO를 추가 선언한거죠.
	 * 그러나 조인 갯수가 5개 라면........ㅠㅠ
	 * 닷트 연산자가 너무 열거되어서 가독성도 떨어지고 코드는 길어지고
	 * 관리하기가 어려울것 같아요.
	 * 해결방법
	 * 제네릭 타입으로 Map을 생각해봐요.
	 * Map은키와 값으로 정보를 관리하니깐...... 테이블과 상관없이
	 * 여러개의 컬럼정보를 키로 사용할 수 있어요
	 * 단 VO처럼 테이블은 구분되지 않는 다는 거죠.
	 * 득과 실을 따져볼 때 그래도 득이 많은 편인 거니까....
	 * List<Map> 패턴으로 사용하는 것이 효과적일 겁니다.....
	 * 또 하나 불편할 수 있는 점은 VO는 타입이 정해져 있어서
	 * ClassCastingException은 예방되는 효과가 있는데
	 * Map의 경우 타입이 정해지지 않아서 캐스팅 익셉션에 노출되어 
	 * 있다는 겁니다.
	 * 그러나 본인이 예방하고 코딩할 수 있다면 문제가 되지는 않겠죠.
	 ************************************************/
	List<Map<String,Object>> list = null;
	Map<String,Object> rMap = null;
	public void listPrint() {
		unitTestVer2();
		//Iterator는 자료구조(컬렉션프레임워크)안에 있는 정보의 
		//유무를 체크해주는 메소드를 지원함.
		Iterator<Map<String,Object>> it 
							= list.iterator();
		while(it.hasNext()) {
			Map<String,Object> pMap = it.next();
			System.out.println(pMap.get("empno"));
			System.out.println(pMap.get("ename"));
			System.out.println(pMap.get("dname"));
		}
	}
	public void unitTestVer2() {
		//정보는 아래 코드에서 입양하기
		//Map에는 여러개 행을 담을 수 가 없데요.
		//그럼 어떡하지? ...........................
		//List에 제네릭 형태로 담아서 써보자.
		// <>다이아몬트 연산자
		list = new ArrayList<>();//전변 인스턴스화
		rMap = new HashMap<String,Object>();
		rMap.put("empno", 7934);
		rMap.put("ename", "MILLER");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);
		rMap = new HashMap<String,Object>();
		rMap.put("empno", 7782);
		rMap.put("ename", "CLARK");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);
		rMap = new HashMap<String,Object>();
		rMap.put("empno", 7839);
		rMap.put("ename", "KING");
		rMap.put("dname", "ACCOUNTING");
		list.add(rMap);	
	}
	public void unitTest() {
		List<DeptVO> deptList = null;
		List<EmpVO> empList = null;
		DeptVO dvo = new DeptVO();
		dvo.setDname("ACCOUNTING");
		EmpVO evo = new EmpVO();
		evo.setEmpno(7934);
		evo.setEname("MILLER");
		dvo.setEmpVO(evo);
		//insert here 사원번호
		System.out.println(dvo.getEmpVO().getEmpno());
		//insert here 사원이름
		System.out.println(dvo.getEmpVO().getEname());
		//insert here 부서명
		System.out.println(dvo.getDname());
		dvo = new DeptVO();
		dvo.setDname("ACCOUNTING");
		dvo = new DeptVO();
		dvo.setDname("ACCOUNTING");
		//insert here - 사원정보 2개를 담기
		evo = new EmpVO();
		evo.setEmpno(7782);
		evo.setEname("CLARK");
		evo = new EmpVO();
		evo.setEmpno(7839);
		evo.setEname("KING");
	}
	public static void main(String[] args) {
		//
		DeptJoinEmp dje = new DeptJoinEmp();
		dje.unitTest();
	}

}
