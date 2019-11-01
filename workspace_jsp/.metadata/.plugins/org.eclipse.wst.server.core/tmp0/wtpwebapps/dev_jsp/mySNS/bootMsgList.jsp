<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.vo.SNSMessageVO" %>    
<%@ page import="com.vo.SNSMessageSet, com.vo.SNSRepleVO" %>  

<%
	List<SNSMessageSet> msgList = null;
	msgList = (List<SNSMessageSet>)request.getAttribute("smsgList");
	int size = 0;
	if(msgList!=null)
		size = msgList.size();
	//out.print("size:"+size);
%>  
<div class="card bg-warning text-white">
<%
	for(int i=0;i<size;i++){
		SNSMessageSet smSet = msgList.get(i);
		SNSMessageVO smVO = smSet.getMsgVO();
		List<SNSRepleVO> reList = smSet.getReList();
		int rsize = 0;
		if(reList!=null){
			rsize = reList.size();
		}
%>
  <div class="card-header"><%=smSet.getMsgVO().getMsg() %></div>
<%
		if(rsize>0){//친구 상태글에 대한 댓글이 존재하는 경우
			for(int j=0;j<rsize;j++){
				SNSRepleVO srVO = reList.get(j);
%>  
  <div class="card-body" style="padding:10px"><%=srVO.getMsg() %></div> 
<%
			}//end of inner for 상태글에 대한 댓글 출력
		}///////end of 댓글이 있을 때
	}/////////////////end of outter for
%>  
</div>




