/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-09-06 09:18:36 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pizza;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pizzaVer2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html> \r\n");
      out.write(" <head>\r\n");
      out.write("  <meta charset=\"UTF-8\">\r\n");
      out.write("  <title>Break Neck Pizza Delivery</title>     \r\n");
      out.write("  <script type=\"text/javascript\" src=\"http://code.jquery.com/jquery-1.9.1.min.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\">\r\n");
      out.write("    function orderPizza(){\r\n");
      out.write("    \talert(\"주소:\"+$(\"#mem_addr\").val());\r\n");
      out.write("    \t$(\"#f_pizza\").attr(\"action\",\"orderConfirm.jsp\");\r\n");
      out.write("    \t$(\"#f_pizza\").attr(\"method\",\"get\");\r\n");
      out.write("    \t$(\"#f_pizza\").submit();\r\n");
      out.write("    }\r\n");
      out.write("  \tfunction getCustomerInfo(){\r\n");
      out.write("\t\t//alert(\"11\");\r\n");
      out.write("\t\t//태그의 아이디인 mem_tel을 사용하여 val()메소드를 호출하면 사용자가 입력한\r\n");
      out.write("\t\t//값을 읽어올 수 있다.\r\n");
      out.write("\t\tvar user_tel = $(\"#mem_tel\").val();\r\n");
      out.write("\t\t//alert(user_tel);\r\n");
      out.write("\t\t//$(\"#mem_tel\").text(\"입력한 값\");\r\n");
      out.write("\t\t/*\r\n");
      out.write("\t\tjquery api를 사용하면 비동기 통신 객체 생성하지 않고 바로 요청 처리할 수 있어서\r\n");
      out.write("\t\t코딩양도 줄어들고 메소드 한개로 처리가 가능함.\r\n");
      out.write("\t\t*/\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\tmethod:\"GET\"\r\n");
      out.write("\t\t   ,url:\"/sample/rest/customerInfo.do?mem_tel=\"+user_tel+\"&\"+new Date().getTime()\r\n");
      out.write("\t\t   ,success:function(data){\r\n");
      out.write("\t\t\t   //alert(data);\r\n");
      out.write("\t\t\t   $(\"#mem_addr\").text(data);\r\n");
      out.write("\t\t   }///////////////end of success\r\n");
      out.write("\t\t});////////////////end of ajax\r\n");
      out.write("  \t}\r\n");
      out.write("  </script>\r\n");
      out.write(" </head>\r\n");
      out.write(" <body>\r\n");
      out.write("  <p><img src=\"../images/breakneck-logo.gif\" alt=\"Break Neck Pizza\" /></p>\r\n");
      out.write("   <p>Enter your phone number:\r\n");
      out.write("    <input type=\"text\" size=\"14\" id=\"mem_tel\" name=\"mem_tel\" onChange=\"getCustomerInfo()\"/>\r\n");
      out.write("   </p>\r\n");
      out.write(" \t <form id=\"f_pizza\"> \r\n");
      out.write(" \t<input type=\"hidden\" id=\"mem_name\" name=\"mem_name\" value=\"홍길동\">\r\n");
      out.write("   <p>Type your order in here:</p>\r\n");
      out.write("   <p><textarea name=\"paper\" id=\"paper\" rows=\"6\" cols=\"50\"></textarea></p>\r\n");
      out.write("   <p>Your order will be delivered to:</p>\r\n");
      out.write("   <!-- \r\n");
      out.write("   JSON포맷의 이름과 태그의 name속성과 id속성을 같은 값으로 통일함.\r\n");
      out.write("   name속성은 jsp에서 사용자가 입력한 값을 읽을 때 사용함.\r\n");
      out.write("   id속성은 javascript에서 사용자가 입력한 값을 읽을 때 사용함.\r\n");
      out.write("   name과 id속성은 같은 값을 사용함.\r\n");
      out.write("   오라클 서버에 테이블 컬럼명과 VO패턴의 멤버변수 이름, Map의 key는 모두 통일해서 사용함.\r\n");
      out.write("    -->\r\n");
      out.write("   <p><textarea name=\"mem_addr\" id=\"mem_addr\" rows=\"4\" cols=\"50\"></textarea></p>\r\n");
      out.write("   <p><input type=\"button\" id=\"btn_order\" value=\"Order Pizza\" onclick=\"orderPizza()\"/></p>\r\n");
      out.write("  <div id=\"d_msg\"></div>\r\n");
      out.write("  </form>\r\n");
      out.write(" </body>\r\n");
      out.write("</html>\r\n");
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
