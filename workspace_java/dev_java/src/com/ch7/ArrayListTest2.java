package com.ch7;

import java.util.ArrayList;

/*
 * 사원집합에서 사원번호가 7566인 사원에 대한 정보를 조회하여 ArrayList에 담고자 한다.
 * 제네릭 타입을 무엇을 해야 할까요?
 * 힌트:타입이 서로 다르다.
 * 
 */
public class ArrayListTest2 {
	
	public static void main(String[] args) {
		//이름은 String으로 해야 한다.
		//급여는 double로 해야 한다.
		//부서번호는 int로 해야한다.
		String name = new String("JONES");
		Double sal = new Double(3000.56);
		Integer deptno = new Integer(20);
		ArrayList<String> aList1 = new ArrayList<String>();
		ArrayList<Double> aList2 = new ArrayList<Double>();
		ArrayList<Integer> aList3 = new ArrayList<Integer>();
		ArrayList<Object> aList4 = new ArrayList<Object>();
		aList1.add(name);
		//aList1.add(sal);
		//aList1.add(deptno);
		aList4.add(name);
		aList4.add(sal);
		aList4.add(deptno);
		aList4.add(1, "우리 헤어져....");
		if(aList4.isEmpty()) {
			System.out.println("내 안에 아무도 없네.....");
		}else {
			System.out.println("내 안에 너 있다........");
		}
		for(Object obj:aList4) {
		//화면 솔루션과 연계할 때 instanceof 활용되니까... 꼭 기억해 두자.	
			if(obj instanceof String) {
				System.out.println(obj.toString());
			}
			else if(obj instanceof Double) {
				System.out.println(Double.valueOf(obj.toString())+10);
			}
			else if(obj instanceof Integer) {
				System.out.println(obj.toString());
			}
			
		}
		String msg = aList4.remove(1).toString();
		System.out.println("msg:"+msg);
		System.out.println("============[[after]]==============");
		for(Object obj:aList4) {
			System.out.println(obj.toString());
		}
	}

}
