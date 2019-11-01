package ui.jeasyui;

public class Dialog {
	public static String setDialog(String question) {
		String imsi="";
		StringBuffer sb = new StringBuffer();
		sb.append("<div id='dd' class='"+JEasyUIConstant._DIALOG+"'> ");
		sb.append(question);
		sb.append("</div>                              ");
		return imsi;
	}
}
