<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>      
<%
	response.setContentType("text/html;charset=utf-8");
	StringBuffer sb = new StringBuffer();
    sb.append("<records>");
    sb.append("<record>");
    sb.append("<r_id>1</r_id>");
    sb.append("<rnk>5</rnk>");
    sb.append("<keyword>류현진</keyword>");
    sb.append("</record>");
    sb.append("<record>");
    sb.append("<r_id>2</r_id>");
    sb.append("<rnk>6</rnk>");
    sb.append("<keyword>유재석</keyword>");
    sb.append("</record>");
    sb.append("<record>");
    sb.append("<r_id>3</r_id>");
    sb.append("<rnk>7</rnk>");
    sb.append("<keyword>김종국</keyword>");
    sb.append("</record>");
    sb.append("</records>");
    out.print(sb.toString());
%>