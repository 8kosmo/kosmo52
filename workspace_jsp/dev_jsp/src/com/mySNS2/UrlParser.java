package com.mySNS2;

import java.util.StringTokenizer;

public class UrlParser {
	/*******************************************************************
	 * 
	 * @param url mySNS2/login.sns or login.sns
	 * @return methodName - 메소드 이름결정
	 ******************************************************************/
	public static String parse(String url) {
		String methodName = null;
		boolean isFlag = false;
		String urls[] = null;
		StringTokenizer st = new StringTokenizer(url,".");
		int cnt = st.countTokens();
		urls = new String[cnt];
		for(int i=0;i<cnt;i++) {
			//urls[0] = mySNS2/login
			//urls[1] = sns
			urls[i] = st.nextToken();
			//System.out.println(urls[i]);
		}
		if(urls[0]!=null) {
			String temp = urls[0];
			//mySNS2/login 12
			for(int j=0;j<temp.length();j++) {//length():문자열의 길이
				char c = temp.charAt(j);
				if(c=='/') {
					isFlag = true;
				}
			}
		}
		//슬래쉬가 있는 경우
		//work이름이 있는 경우 이므로 배열의 수가 2가 되고 0번째에는 일이름이
		//1번째에는 메소드 이름을 담아서 해당하는 메소드로 연결처리 할 것.
		if(isFlag) {
			String temp = urls[0];
			String commands[] = null;
			commands = temp.split("/");
			//commands[0] = mySNS2저장
			//methodName = commands[1] login이 저장
			methodName = commands[commands.length-1];
		}
		//슬래쉬가 없을 때  login.sns
		//work정보가 없이 요청이 들어온 경우 이므로 urls[0]에 있는 문자열이 메소드 이름으로
		//결정됨.
		else {
			methodName = urls[0];
		}
		return methodName;
	}
}







