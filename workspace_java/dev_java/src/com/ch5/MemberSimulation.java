package com.ch5;

public class MemberSimulation {

	public static void main(String[] args) {
		MemberVO memVO = new MemberVO();
		/*
		 * MemberVO에는 여러 변수가 선언되어 있음.
		 * 그러나 선언만 되어 있음. 초기화는 안되어 있음.
		 * 즉 어떤 정보도 가지고 있지 않은 상태임
		 * 어떤 정보를 초기화 해주어야 값을 꺼낼 수 있음.
		 */
		String mem_id = memVO.getMem_id();
		System.out.println("before 아이디 :"+mem_id);//null출력
		//insert here - 멤버변수 mem_id에 값을 담아보세요.
		memVO.setMem_id("test");
		System.out.println("after 아이디 :"+memVO.getMem_id());//null출력
//아래서 호출한 mem_id는 13번에 선언된 변수이다.
//mem_id변수에 값을 담을 수 있는 setter메소드가 호출되기 전이므로 null
//이 들어있는 상태이므로 null을 출력하는 것임.		
		System.out.println("after 아이디 :"+mem_id);//null출력
//24번에서는 변수이름은 동일한 mem_id이지만 MemberVO에 선언된 전역변수 이다.
//그런데 접근제한자가 private이 왔으므로 변수 호출이 불가함.- 문법에러 발생됨.		
		//System.out.println("after 아이디 :"+memVO.mem_id);//null출력
	}

}
