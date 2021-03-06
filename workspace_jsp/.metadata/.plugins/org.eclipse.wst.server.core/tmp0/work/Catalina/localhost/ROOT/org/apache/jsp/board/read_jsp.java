/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-08-14 01:59:32 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public final class read_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/common/JEasyUICommon.jsp", Long.valueOf(1564466214299L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("java.util.Map");
    _jspx_imports_classes.add("java.util.HashMap");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");

	List<Map<String,Object>> boardDetail = 
	(List<Map<String,Object>>)request.getAttribute("boardDetail");
	Map<String,Object> rMap = new HashMap<>();
	/*
	마이바티스 사용시 자동으로 담아주므로 vo의 경우 사용자가 대소문자를 구분해서 사용하지만
	Map의 경우 마이바티스가 컬럼명을 기준으로 자동으로 키값을 생성하는데 디폴트가 대문자임.
	*/
	if(boardDetail!=null){
		rMap = boardDetail.get(0);
	}

      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>글상세보기</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/commons.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.cookie.js\"></script>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction addAction(){\r\n");
      out.write("\t\t$(\"#f_boardAdd\").attr(\"method\",\"post\");\r\n");
      out.write("\t\t$(\"#f_boardAdd\").attr(\"action\",\"/board/test.mo?crud=boardAdd\");\r\n");
      out.write("\t\t$(\"#f_boardAdd\").submit();\r\n");
      out.write("\t\t//부모창에 함수를 호출할때 opener.함수명();\r\n");
      out.write("\t\topener.boardList();\r\n");
      out.write("\t\tself.close();\r\n");
      out.write("\t}\r\n");
      out.write("//댓글쓰기\r\n");
      out.write("\tfunction repleForm(){\r\n");
      out.write("\t\t$(\"#dlg_boardAdd\").dialog('open');\r\n");
      out.write("\t}\r\n");
      out.write("//수정\r\n");
      out.write("\tfunction updateForm(){\r\n");
      out.write("\t\tcmm_window_popup('/board/test.mo?crud=updateForm&bm_no=");
      out.print(rMap.get("BM_NO"));
      out.write("','700','470','updaeForm');\r\n");
      out.write("\t}\r\n");
      out.write("//삭제화면 열기\r\n");
      out.write("\tfunction deleteForm(){\r\n");
      out.write("\t\t$(\"#dlg_boardDel\").dialog({\r\n");
      out.write("\t\t\tbuttons: btn_boardDel\r\n");
      out.write("\t\t   ,title:'글삭제'\r\n");
      out.write("\t\t   ,width: 420\r\n");
      out.write("\t\t   ,height:250\r\n");
      out.write("\t\t   ,modal:true\r\n");
      out.write("\t\t   ,href:'boardDelForm.jsp'\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\t$(\"#dlg_boardDel\").dialog('open');\r\n");
      out.write("    }\r\n");
      out.write("    //삭제창 처리\r\n");
      out.write("    function boardDelClose(){\r\n");
      out.write("\t\t$(\"#dlg_boardDel\").dialog('close');    \t\r\n");
      out.write("    }\r\n");
      out.write("    //삭제 처리 화면에서 확인 버튼을 클릭했을 때\r\n");
      out.write("    function boardDel(){\r\n");
      out.write("    \tvar db_pw = ");
      out.print(rMap.get("BM_PW"));
      out.write(";\r\n");
      out.write("    \t//현재 내가 위치하는 페이지와 비번 입력받는 화면이 다르다. 접근이 가능한가?\r\n");
      out.write("    \tvar u_pw = $(\"#u_pw\").textbox('getValue');\r\n");
      out.write("    \talert(db_pw + \", \"+u_pw);\r\n");
      out.write("    \t/*\r\n");
      out.write("    \t사용자가 입력한 비번과 DB에서 읽어들인 비번을 비교하여 일치하면 삭제 처리 진행\r\n");
      out.write("    \t불일치시 비번을 다시 입력받도록 한다.\r\n");
      out.write("    \t*/\r\n");
      out.write("    \tif(db_pw == u_pw){//비번이 일치했을때 삭제 프로세스를 태운다.\r\n");
      out.write("    \t\t//alert(\"같다\");\r\n");
      out.write("    \t\t$.messager.confirm('Confirm','정말 삭제하겠습니까?',function(r){\r\n");
      out.write("    \t\t\tif(r){\r\n");
      out.write("    \t\t\t\tlocation.href=\"/board/test.mo?crud=boardDel&bm_no=");
      out.print(rMap.get("BM_NO"));
      out.write("&bs_file=");
      out.print(rMap.get("BS_FILE"));
      out.write("\";\r\n");
      out.write("    \t\t\t}\r\n");
      out.write("    \t\t});\r\n");
      out.write("    \t}else{//비번이 틀릴때는 새로 입력 받는다.\r\n");
      out.write("    \t\t//alert(\"다르다\");\r\n");
      out.write("    \t\t$(\"#dlg_boardDel\").textbox('setValue','');\r\n");
      out.write("    \t}\r\n");
      out.write("    } \r\n");
      out.write("//목록\r\n");
      out.write("\tfunction boardList(){\r\n");
      out.write("\t\tlocation.href=\"/board/test.mo?crud=boardList\";\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$(\"document\").ready(function (){\t\t\r\n");
      out.write("\t\t$(\"#dlg_boardDel\").hide();\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<table id=\"pan_read\" class=\"easyui-panel\" title=\"글상세보기\" data-options=\"footer:'#tb_read'\"\r\n");
      out.write(" style=\"width:670px;height:380px;padding:10px;background:#fafafa;\">\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>제목</td>\r\n");
      out.write("\t\t<td><input class=\"easyui-textbox\" value=\"");
      out.print(rMap.get("BM_TITLE") );
      out.write("\" id=\"bm_title\" data-options=\"width:'450px'\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>작성자</td>\r\n");
      out.write("\t\t<td><input class=\"easyui-textbox\" value=\"");
      out.print(rMap.get("BM_WRITER") );
      out.write("\" id=\"bm_writer\" data-options=\"width:'450px'\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>이메일</td>\r\n");
      out.write("\t\t<td><input class=\"easyui-textbox\" value=\"");
      out.print(rMap.get("BM_EMAIL") );
      out.write("\" id=\"bm_email\" data-options=\"width:'450px'\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>내용</td>\r\n");
      out.write("\t\t<td><input class=\"easyui-textbox\" value=\"");
      out.print(rMap.get("BM_CONTENT") );
      out.write("\" id=\"bm_content\" data-options=\"multiline:'true',width:'450px', height:'90px'\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>비밀번호</td>\r\n");
      out.write("\t\t<td><input class=\"easyui-textbox\" value=\"");
      out.print(rMap.get("BM_PW") );
      out.write("\" id=\"bm_pw\" data-options=\"width:'450px'\"></td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
      out.write(" <div id=\"tb_read\" style=\"padding:2px 5px;\" align=\"center\">\r\n");
      out.write("    <a href=\"javascript:repleForm()\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\">댓글쓰기</a>\r\n");
      out.write("    <a href=\"javascript:updateForm()\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\">수정</a>\r\n");
      out.write("    <a href=\"javascript:deleteForm()\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\">삭제</a>\r\n");
      out.write("    <a href=\"javascript:boardList()\" class=\"easyui-linkbutton\" iconCls=\"icon-search\" plain=\"true\">목록</a>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 수정하기, 삭제하기, 댓글쓰기, 목록 버튼 -->\r\n");
      out.write("\r\n");
      out.write("<!--================== [[글수정하기 화면]] ==================-->\r\n");
      out.write("\r\n");
      out.write("<!--================== [[글삭제하기 화면]] ==================-->\r\n");
      out.write("<div id=\"dlg_boardDel\" closed=\"true\" class=\"easyui_dialog\" style=\"padding: 20px 50px\">\r\n");
      out.write("\r\n");
      out.write("    <!-- 확인 버튼과 닫기 버튼 추가 -->\r\n");
      out.write("\t<div id=\"btn_boardDel\" align=\"right\">\r\n");
      out.write("    <a href=\"javascript:boardDel()\" class=\"easyui-linkbutton\" iconCls=\"icon-ok\" plain=\"true\">확인</a>\r\n");
      out.write("    <a href=\"javascript:boardDelClose()\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" plain=\"true\">닫기</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("<!--================== [[댓글쓰기 화면]] ==================-->\r\n");
      out.write("<div id=\"dlg_boardAdd\" title=\"댓글쓰기\" class=\"easyui-dialog\" style=\"width:600px;height:400px;padding:10px\" data-options=\"closed:'true',modal:'true',footer:'#tbar_boardAdd'\">\t\r\n");
      out.write("<!-- \r\n");
      out.write("form전송시 encType옵션이 추가되면 request객체로 사용자가 입력한 값을 꺼낼 수 없다.\r\n");
      out.write("MultipartRequest  => cos.jar\r\n");
      out.write(" -->\t\r\n");
      out.write("\t<form id=\"f_boardAdd\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bm_no\" value=\"");
      out.print(rMap.get("BM_NO"));
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bm_group\" value=\"");
      out.print(rMap.get("BM_GROUP"));
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bm_pos\" value=\"");
      out.print(rMap.get("BM_POS"));
      out.write("\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"bm_step\" value=\"");
      out.print(rMap.get("BM_STEP"));
      out.write("\">\r\n");
      out.write("\t<!-- <form id=\"f_boardAdd\"> -->\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"100px\">제목</td>\r\n");
      out.write("\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" data-options=\"width:'350px'\" id=\"bm_title\" name=\"bm_title\" required>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\t\r\n");
      out.write("\t\t\t<td width=\"100px\">작성자</td>\r\n");
      out.write("\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" data-options=\"width:'150px'\" id=\"bm_writer\" name=\"bm_writer\" required>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td width=\"100px\">이메일</td>\r\n");
      out.write("\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" data-options=\"width:'250px'\" id=\"bm_email\" name=\"bm_email\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\t\t\t\r\n");
      out.write("\t\t\t<td width=\"100px\">내용</td>\r\n");
      out.write("\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" id=\"bm_content\" name=\"bm_content\" data-options=\"multiline:'true',width:'400px',height:'90px'\" required>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\t\t\t\r\n");
      out.write("\t\t\t<td width=\"100px\">비번</td>\r\n");
      out.write("\t\t\t<td width=\"500px\">\r\n");
      out.write("\t\t\t\t<input class=\"easyui-textbox\" data-options=\"width:'100px'\" id=\"bm_pw\" name=\"bm_pw\" required>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- 입력 화면 버튼 추가 -->\r\n");
      out.write("<div id=\"tbar_boardAdd\" align=\"right\">\r\n");
      out.write("\t<a href=\"javascript:addAction()\" class=\"easyui-linkbutton\" iconCls=\"icon-save\">저장</a>\r\n");
      out.write("\t<a href=\"javascript:$('#dlg_boardAdd').dialog('close')\" \r\n");
      out.write("\t   class=\"easyui-linkbutton\" iconCls=\"icon-cancel\">닫기</a>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
