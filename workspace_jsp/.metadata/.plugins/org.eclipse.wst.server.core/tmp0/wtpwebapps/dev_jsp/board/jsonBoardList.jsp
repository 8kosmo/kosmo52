<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.google.gson.Gson, java.util.Map, java.util.List" %>
<%
	List<Map<String,Object>> boardList = 
			(List<Map<String,Object>>)request.getAttribute("boardList");
	Gson g = new Gson();
	String imsi = g.toJson(boardList);
	out.print(imsi);
%>