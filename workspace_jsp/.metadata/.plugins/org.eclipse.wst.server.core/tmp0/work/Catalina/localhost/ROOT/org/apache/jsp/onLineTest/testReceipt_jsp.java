/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-07-25 07:43:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.onLineTest;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.vo.MemberVO;

public final class testReceipt_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(1);
    _jspx_dependants.put("/onLineTest/../common/JEasyUICommon.jsp", Long.valueOf(1563429224306L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("com.vo.MemberVO");
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

	MemberVO mVO = (MemberVO)session.getAttribute("rmVO");
	String s_memid = null;
	String s_memname = null;
	if(mVO!=null){
		s_memid = mVO.getMem_id();
		s_memname = mVO.getMem_name();
	}

      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>자격시험 접수 - 정보처리기사</title>\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/default/easyui.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/themes/icon.css\">\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/demo/demo.css\">\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"/js/jquery.easyui.min.js\"></script>");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction receipt(){\r\n");
      out.write("\t\t$(\"#f_receipt\").attr(\"method\",\"get\");\r\n");
      out.write("\t\t$(\"#f_receipt\").attr(\"action\",\"examReceipt.kos\");//crud이름\r\n");
      out.write("\t\t$(\"#f_receipt\").submit();//이 때 전송됨\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\t$.fn.datebox.defaults.formatter = function(date){\r\n");
      out.write("\t\tvar y = date.getFullYear();\r\n");
      out.write("\t\tvar m = date.getMonth()+1;\r\n");
      out.write("\t\tvar d = date.getDate();\r\n");
      out.write("\t\treturn y+'-'+(m<10 ?('0'+m):m)+'-'+(d<10?('0'+d):d);\r\n");
      out.write("\t}\r\n");
      out.write("\t$.fn.datebox.defaults.parser = function(s){\r\n");
      out.write("\t\tvar t = Date.parse(s);\r\n");
      out.write("\t\tif (!isNaN(t)){\r\n");
      out.write("\t\t\treturn new Date(t);\r\n");
      out.write("\t\t} else {\r\n");
      out.write("\t\t\treturn new Date();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\t$(document).ready(function(){\r\n");
      out.write("\t\t$(\"#mem_name\").textbox('setValue','");
      out.print(s_memname);
      out.write("');\r\n");
      out.write("\t\t$(\"#cb_subject\").combobox({\r\n");
      out.write("            url:'/onLineTest/subjectList.kos?work=onLineTest',\r\n");
      out.write("            valueField:'SUB_CD', //서버에 넘어가는 값\r\n");
      out.write("            textField:'SUB_NAME',//화면에 출력되는 값\r\n");
      out.write("            panelHeight:'auto',\r\n");
      out.write("            onSelect:function(record){\r\n");
      out.write("                alert(record.SUB_NAME);\r\n");
      out.write("            }\t\t\t\r\n");
      out.write("\t\t});/////////end of combobox\t\t\r\n");
      out.write("\t});\r\n");
      out.write("</script>\r\n");
      out.write("<div class=\"easyui-panel\" title=\"자격시험 접수\" \r\n");
      out.write("     style=\"width:100%;max-width:600px;padding:30px 30px\">\r\n");
      out.write("     <!-- jquery에서 제공하는 attr()메소드에 쿼리스트링은 값이 넘어가지 않음:결합 hidden -->\r\n");
      out.write("     <form id=\"f_receipt\">\r\n");
      out.write("     <input type=\"hidden\" id=\"mem_id\" name=\"mem_id\" value=\"");
      out.print(s_memid );
      out.write("\">\r\n");
      out.write("     <input type=\"hidden\" id=\"work\" name=\"work\" value=\"onLineTest\">\r\n");
      out.write("\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t<input class=\"easyui-textbox\" id=\"mem_name\" name=\"mem_name\"\r\n");
      out.write("\t\t       label=\"이름 : \" labelPosition=\"top\" \r\n");
      out.write("\t\t       style=\"width:160px\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t<input class=\"easyui-datebox\" id=\"exam_date\" name=\"exam_date\"\r\n");
      out.write("\t\t       label=\"응시일자 : \" labelPosition=\"top\" \r\n");
      out.write("\t\t       style=\"width:160px\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div style=\"margin-bottom:20px\">\r\n");
      out.write("\t\t<select class=\"easyui-combobox\" id=\"cb_subject\" name=\"sub_cd\"\r\n");
      out.write("\t\t        label=\"수험과목 선택:\" labelPosition=\"top\" \r\n");
      out.write("\t\t        data-options=\"prompt:'수험번호를 선택하세요.'\" \r\n");
      out.write("\t\t        style=\"width:250px;\">\r\n");
      out.write("\t\t</select>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<a href=\"javascript:receipt()\" class=\"easyui-linkbutton\" \r\n");
      out.write("\t\t   iconCls=\"icon-ok\" style=\"width:100%;\r\n");
      out.write("\t\t   height:32px\">\r\n");
      out.write("\t\t접수\r\n");
      out.write("\t\t</a>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t</form>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
