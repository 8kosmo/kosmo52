/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-09-05 01:04:30 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.login;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.vo.MemberVO;

public final class customLogin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("  \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("<script>\r\n");
      out.write("\tfunction signIn(){\r\n");
      out.write("\t \t$('#f_signin').attr(\"method\",\"post\");\r\n");
      out.write("\t\t$('#f_signin').attr(\"action\",\"/mySNS/test.mvc?crud=signIn\"); //전송을 하는 곳.\r\n");
      out.write("\t\t$('#f_signin').submit(); \r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\tfunction login(){\r\n");
      out.write("\t\talert(\"로그인\");\r\n");
      out.write("\t\t$('#f_login').attr(\"method\",\"post\");\r\n");
      out.write("\t\t$('#f_login').attr(\"action\",\"/mySNS/test.mvc?crud=login\"); //전송을 하는 곳.\r\n");
      out.write("\t\t$('#f_login').submit(); \r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   <style>\r\n");
      out.write("        .jumbotron {\r\n");
      out.write("            background-image: url('/sample/images/nikuq.png');\r\n");
      out.write("            background-size: cover;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("<div align=\"center\">\r\n");
      out.write("\t<div class=\"jumbotron bg-info text-dark\">\r\n");
      out.write("\t  <h1 class=\"display-4\">HELLO</h1>\r\n");
      out.write("\t  <p class=\"lead\">여기서 말하는 모든 이야기들은 비밀이야!</p>\r\n");
      out.write("\t  <hr class=\"my-4\">\r\n");
      out.write("\t  <p>두근두근>_<</p>\r\n");
      out.write("\t  <!-- 로그인화면 -->\r\n");
      out.write("\t  <form id=\"f_login\" class=\"was-validated\">\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t\t<!--<div class=\"col-sm-10\"> -->\r\n");
      out.write("\t\t    <label for=\"uname\"></label>\r\n");
      out.write("\t\t    <input type=\"text\" class=\"form-control col-sm-3\" id=\"mem_id\" placeholder=\"Enter your ID\" name=\"mem_id\" required>\r\n");
      out.write("\t\t    <div class=\"valid-feedback\">Valid.</div>\r\n");
      out.write("\t\t    <div class=\"invalid-feedback text-dark\">Please fill out this field.</div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"form-group\">\r\n");
      out.write("\t\t    <label for=\"pwd\"></label>\r\n");
      out.write("\t\t    <input type=\"password\" class=\"form-control col-sm-3\" id=\"mem_pw\" placeholder=\"Enter password\" name=\"mem_pw\" required>\r\n");
      out.write("\t\t    <div class=\"valid-feedback \">Valid.</div>\r\n");
      out.write("\t\t    <div class=\"invalid-feedback text-dark\">Please fill out this field.</div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"form-group form-check\">\r\n");
      out.write("\t\t    <label class=\"form-check-label \">\r\n");
      out.write("\t\t      <input class=\"form-check-input\" type=\"checkbox\" name=\"remember\" required> 여기서 말하는 건 다 비밀이야!\r\n");
      out.write("\t\t      <div class=\"valid-feedback\">Valid.</div>\r\n");
      out.write("\t\t      <div class=\"invalid-feedback text-dark\">Check this checkbox to continue.</div>\r\n");
      out.write("\t\t    </label>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div align=center>\r\n");
      out.write("\t\t\t<a role=\"button\" class=\" btn text-dark btn-warning  \" href=\"javascript:login()\">Login</a>\r\n");
      out.write("\t\t\t<a role=\"button\" class=\"btn btn-warning text-dark\" href=\"#signIn\" data-toggle=\"modal\">Signin</a>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t </form> \r\n");
      out.write("\t\t<!-- ==========================[[    modal창     ]] ======================================= -->\r\n");
      out.write("\t\t<form id=\"f_signin\" name=\"f_signin\">\r\n");
      out.write("\t\t\t<div class=\"modal\" role=\"dialog\" id=\"signIn\">\r\n");
      out.write("\t\t\t\t<div  class=\"modal-dialog modal-m modal-dialog-centered\" >\r\n");
      out.write("\t\t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("\t\t\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("\t\t\t\t\t\t\t<h5 class=\"modal-title\">회원가입</h5>\r\n");
      out.write("\t\t\t\t\t\t</div>\t\r\n");
      out.write("\t\t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("\t\t\t\t\t\t  \t<input type=\"text\" class=\"form-control mb-4 mr-sm-4\" placeholder=\"아이디를 입력하세요\" id=\"mem_id\" name=\"mem_id\" >\r\n");
      out.write("\t\t\t\t\t\t  \t<input type=\"text\" class=\"form-control mb-4 mr-sm-4\" placeholder=\"닉네임을 입력하세요\" id=\"mem_name\" name=\"mem_name\" >\r\n");
      out.write("\t\t\t\t\t\t  \t<input type=\"text\" class=\"form-control mb-4 mr-sm-4\" placeholder=\"이메일을 입력하세요\" id=\"mem_email\" name=\"mem_email\" >\r\n");
      out.write("\t\t\t\t\t\t  \t<input type=\"text\" class=\"form-control mb-4 mr-sm-4\" placeholder=\"비밀번호를 입력하세요\" id=\"mem_pw\" name=\"mem_pw\" >\r\n");
      out.write("\t\t\t\t\t  \t <div class=\"modal-footer\">\r\n");
      out.write("\t\t\t\t\t  \t\t<a role=\"button\"  href=\"javascript:signIn()\" class=\"btn btn-success btn-sm\">가입하기</a>\r\n");
      out.write("\t\t\t\t\t  \t</div>\r\n");
      out.write("\t\t\t\t  \t\t</div>\r\n");
      out.write("\t\t\t\t  \t</div>\r\n");
      out.write("\t\t\t  \t</div>\r\n");
      out.write("\t\t\t </div> \t\r\n");
      out.write("\t\t</form>\r\n");
      out.write("\t\t<!-- ==========================[[    modal창 끝          ]] ======================================= -->\r\n");
      out.write("\t</div>\r\n");
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
