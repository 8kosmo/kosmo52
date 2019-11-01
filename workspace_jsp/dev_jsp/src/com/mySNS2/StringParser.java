package com.mySNS2;

public class StringParser {
/*
 * login(req,res)
 * msgList(req,res)
 * msgList(req,res,Model mod)
 * void doGet(req,res)
 * void doPost(req,res)
 * 
 */
	public static void main(String[] args) {
		String url =  "mySNS2/msgList.sns";
		url =  "memberAdd.sns";
		String methodName = 
				UrlParser.parse(url);
		System.out.println("methodName : "+methodName);//login
	}

}
