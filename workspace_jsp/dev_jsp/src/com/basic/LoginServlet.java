package com.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class LoginServlet extends HttpServlet {
	Logger logger = Logger.getLogger(LoginServlet.class);
	public void doGet(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException
	{
		//사용자가 입력한 값을 서버에서 읽기
		String user_id = req.getParameter("mem_id");
		String user_pw = req.getParameter("mem_pw");
		logger.info("사용자가 입력한 아이디:"+user_id);
		logger.info("사용자가 입력한 비번:"+user_pw);
		out.print("정재현");
	}
}






