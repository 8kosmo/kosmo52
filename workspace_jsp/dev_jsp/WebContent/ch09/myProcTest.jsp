<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.mvc1.MemberDao, com.vo.MemberVO" %>    
<%@ page import="java.util.ArrayList, java.util.Map, java.util.HashMap" %>    
<%@ page import="java.util.List, com.google.gson.Gson" %>    
<%
	MemberDao mDao = new MemberDao();
	Map<String,Object> pMap = new HashMap<>();
	mDao.my_proc2(pMap);
	//out.print("<br>");
	//ArrayList 안에는 어떤 타입이 들어있지? MemberVO
	//out.print(pMap);	
	//out.print("<br>");
	//out.print(pMap.get("key"));	
	List list = (List)pMap.get("key");
	//out.print("<br>");
/* 	out.print(list.size());
	for(int i=0;i<list.size();i++){
		MemberVO mVO = (MemberVO)list.get(i);
		out.print(mVO.getMem_id()+" "+mVO.getMem_pw()+" "+mVO.getMem_name());
	} */
	Gson g = new Gson();
	String imsi = g.toJson(list);
	out.print(imsi);
%>




















