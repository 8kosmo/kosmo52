package com.ch5;

public class MemberSimulation3 {

	public static void main(String[] args) {
		MemberVO mVO = new MemberVO();
		mVO = new MemberVO(10);
		//파라미터에 준 상수값들은 XXXX에 담긴다.
		mVO = new MemberVO("test","123","이순신","서울시 금천구 가산동","21689");
		System.out.println(mVO.getMem_id());
		System.out.println(mVO.getMem_pw());
		System.out.println(mVO.getMem_name());
		System.out.println(mVO.getMem_addr());
		System.out.println(mVO.getMem_zipcode());
	}

}
