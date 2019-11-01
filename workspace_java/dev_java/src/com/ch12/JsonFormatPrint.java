package com.ch12;

import java.util.List;
import java.util.Vector;

import com.google.gson.Gson;

public class JsonFormatPrint {

	public static void main(String[] args) {
		List<ChatVO> list = new Vector<>();
		ChatVO cVO = new ChatVO();
		cVO.setNickName("바나나");
		cVO.setAge(25);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("나초보");
		cVO.setAge(27);
		list.add(cVO);
		cVO = new ChatVO();
		cVO.setNickName("나신입");
		cVO.setAge(29);
		list.add(cVO);
		Gson g = new Gson();
		String jsonChat = g.toJson(list);
		System.out.println(jsonChat);
	}

}
