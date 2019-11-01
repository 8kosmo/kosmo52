package com.mvc1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.util.MyBatisCommonFactory;
import com.vo.DeptVO;

public class MyProcSimulation {
	static SqlSessionFactory sqlSessionFactory = null;
	static {
		sqlSessionFactory=
				MyBatisCommonFactory.getSqlSessionFactory();
	}
	public MyProcSimulation() {
		try {
			SqlSession sqlSession = sqlSessionFactory.openSession();
			/*
			 * 저장프로시저의 특이사항은 파라미터로 넘긴 주소번지의 out속성의 값이 담긴다는 사실이다.			
			 */
			Map<String,Object> pMap = new HashMap<>();
			sqlSession.selectOne("my_proc",pMap);
			Object keys[] = pMap.keySet().toArray();//키값을 배열로 담음
			//sys_refcursor가 어떤 자료형으로 담아주는지를 반드시 체크
			//파라미터 타입을 Map으로 하였으나 그 안에 자료구조가 List형인지 반드시 점검
			//Iterator iter = pMap.get("key").iterator();
			List<Map<String,Object>> list = new ArrayList<>();
			// {mem_name="김유신", key=[com.vo.DeptVO]}
			//Gson
			Iterator iter2 = list.iterator();
			while(iter2.hasNext()) {
				String s=(String)iter2.next();
				DeptVO dVO = (DeptVO)iter2.next();
				System.out.println(dVO.getDeptno());
				System.out.println(dVO.getDname());
				System.out.println(dVO.getLoc());
			}
			for(int i=0;i<keys.length;i++) {
				String value = (String)pMap.get(keys[i]);
				System.out.println(value);//Object출력 or 주소번지출력
			}
			if(pMap instanceof HashMap) {
				System.out.println("여기");
			}
			System.out.println(pMap.getClass());//실제 타입을 확인
			System.out.println(pMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new MyProcSimulation();
	}

}
