package com.mvc2;

import com.mvc3.RestController;

public class ControllerMapping {
	static String crud = "";
	/***************************************************************
	 * 
	 * @param command onLineTest/test.mo?work=select
	 * @param crud - select
	 * @return
	 **************************************************************/
	public static Controller getController(String command, String crud) {
		ControllerMapping.crud = crud;
		Controller controller = null;
		String commands[] = command.split("/");
		String work = commands[0];//onLineTest
		String requestName = commands[1];//test.mo?work=select
		if("board".equals(work)) {
			controller = new BoardController(requestName,ControllerMapping.crud);
		}
		else if("onLineTestVer2".equals(work)) {
			controller = new Test2Controller(requestName,ControllerMapping.crud);
		}
		else if("member".equals(work)) {
			controller = new Member2Controller(requestName,ControllerMapping.crud);
		}
		else if("json".equals(work)) {
			controller = new RestController(requestName,ControllerMapping.crud);
		}
		return controller;
	}
}






