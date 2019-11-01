package com.ch12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/*
 * deptMap은 지변이다.
 * 지역변수를 다른 메소드에서 사용하려면 어떡하지?
 * 1)파라미터
 * 2)리턴타입
 * 
 */
public class MapTest {
	//사용자가 정의한 메소드
	public void setMap() {//초기화
		//Map이라는 자료구조(백팩)는
		//ORM 솔루션
		List<Map<String,Object>> deptList = new ArrayList<>();//0
		Map<String,Object> deptMap = new HashMap<>();
		Map<String,Object> empMap = new HashMap<>();
		mapPrint(deptMap);
		deptMap.put("deptno", 10);
		deptMap.put("dname", "ACCOUNTING");
		deptMap.put("loc", "New Yor");
		deptList.add(deptMap);
		deptMap = new HashMap<>();
		deptMap.put("deptno", 20);
		deptMap.put("dname", "RESEARCH");
		deptMap.put("loc", "DALLAS");		
		deptList.add(deptMap);
		deptMap = new HashMap<>();
		deptMap.put("deptno", 30);
		deptMap.put("dname", "SALES");
		deptMap.put("loc", "CHICAGO");		
		deptList.add(deptMap);
		deptMap = new HashMap<>();
		deptMap.put("deptno", 40);
		deptMap.put("dname", "OPERATION");
		deptMap.put("loc", "BOSTON");		
		deptList.add(deptMap);
		//메소드 호출
		//mapPrint(deptMap);
		mapPrint(deptList);
	}
	private void mapPrint(List<Map<String, Object>> deptList) {
		//insert here - List->Map->map.get(key)
		for(int i=0;i<deptList.size();i++) {
			//System.out.println(deptList.get(i));//Map에 대한 주소번지
			Map<String,Object> rMap = deptList.get(i);
			Object keys[] = rMap.keySet().toArray();
			for(int j=0;j<keys.length;j++) {
				System.out.print(rMap.get(keys[j]));
				if(j==keys.length) {
					break;
				}
				System.out.print(" ");
			}
			System.out.println();//줄바꿈 처리
		}
	}
	public void mapPrint(Map<String,Object> deptMap) {
		//get은 자바에서 제공하는 메소드
		//System.out.println(deptMap.get("deptno"));
		//Set은 집합을 담을 수 있는 클래스 이다.
		//Map에 담긴 key를 하나의 집합으로 생각하여 Set안에 keySet메소드를 제공함.
		Set<String> set = deptMap.keySet();
		//Set안에서 키값을 꺼내야 하는데 3개이므로 (또는 n개가 될수도 있음)
		//toArray메소드를 호출하면 Object배열에 담아 줌.
		Object keys[] =set.toArray();
		for(int i=0;i<keys.length;i++) {
			System.out.println(keys[i]);//deptno, dname, loc
			//insert here
			System.out.println(deptMap.get(keys[i]));
		}
		/*
		 * 정리하기
		 * list도 꺼낼때는 get메소드를 호출하지만 파라미터가 int이고
		 * map은 파라미터가 Object이다.
		 * list에 담을 때는 add, map에 담을때는 put
		 * list에서 꺼낼때는 get(int), map에서 꺼낼 때는 get(Object)
		 * 
		 */
		//System.out.println(deptMap.get);
		//insert here
		
	}
	public static void main(String[] args) {
		MapTest mt = new MapTest();
		mt.setMap();
		//mt.mapPrint(null);
		//도전 - 만일 키 종류가 100가지라면 어떡하지?
		
		//도전2 - 여러개의 행을 담으려면 어떡하지?
		
	}

}
