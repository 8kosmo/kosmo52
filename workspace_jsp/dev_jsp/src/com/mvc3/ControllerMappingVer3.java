package com.mvc3;


public class ControllerMappingVer3 {
	static String crud = "";
	/***************************************************************
	 * 
	 * @param command onLineTest/test.mo?work=select
	 * @param crud - select
	 * @return
	 **************************************************************/
	public static ControllerVer3 getController(String command, String crud) {
		ControllerMappingVer3.crud = crud;
		ControllerVer3 controller = null;
		String commands[] = command.split("/");
		String work = commands[0];//
		String requestName = commands[1];//test.mo?work=select
		if("mySNS".equals(work)) {
			controller = new SNSController(requestName,ControllerMappingVer3.crud);
		}
		return controller;
	}
}
