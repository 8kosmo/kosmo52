/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.35
 * Generated at: 2019-09-20 03:04:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.erpSol;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.text.DecimalFormat;

public final class calendarUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes.add("java.util.Calendar");
    _jspx_imports_classes.add("java.text.DecimalFormat");
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
      out.write(" \r\n");

	String smem_id = "test";
	if(session.getAttribute("smem_id")!=null){
		smem_id = (String)session.getAttribute("smem_id");
	}
	//메모 등록하는 모달창에 출력될 날짜 정보 가져오기
	

      out.write("   \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>일정관리[calendarUI.jsp]</title>\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\">\r\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n");
      out.write("  <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"></script>\r\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tfunction memoForm(yyyy,mm,dd){\r\n");
      out.write("\t\t\t//alert(\"메모입력창\");\r\n");
      out.write("\t\t\t$(\"#d_curday\").text(yyyy+\"년\"+mm+\"월\"+dd+\"일\");\r\n");
      out.write("\t\t\t$(\"#myModal\").modal();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tfunction moAdd(){\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");

	Calendar cal = Calendar.getInstance();
	int day[][][] = new int[12][6][7];
	DecimalFormat df = new DecimalFormat("00");
	String week[] = {"일","월","화","수","목","금","토"};
	//이번 달 정보 가져오기
	Calendar currCal = Calendar.getInstance();
	//달 정보는 0부터 11사이의 값이다.1~12
	String cyyyy = df.format(currCal.get(Calendar.YEAR));
	String cmonth = df.format(currCal.get(Calendar.MONTH)+1);
	int icmonth = Integer.parseInt(cmonth)-1;
	//out.print("이번달 : "+cmonth);
	for(int month=0;month<12;month++){
		if(month==icmonth){
			//이번달 마지막 날짜 저장하기
			cal.set(Calendar.MONTH,month);
			int maxDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			for(int i=1;i<=maxDay;i++){
				cal.set(Calendar.DATE,i);
				day[cal.get(Calendar.MONTH)]
						[cal.get(Calendar.WEEK_OF_MONTH)-1]
								[cal.get(Calendar.DAY_OF_WEEK)-1]=i;		
			}
		}
	}

      out.write("\r\n");
      out.write("<table align=\"center\" border=\"0\" width=\"1200\">\r\n");
      out.write("\t<tr align=\"left\">\r\n");
      out.write("\t\t<td>\r\n");
      out.write("\t\t  <button type=\"button\" class=\"btn btn-dark\">출근</button>\r\n");
      out.write("\t\t  <button type=\"button\" class=\"btn btn-success\">퇴근</button>\r\n");
      out.write("\t\t  <button type=\"button\" class=\"btn btn-warning\">조퇴</button>\r\n");
      out.write("\t\t</td>\r\n");
      out.write("\t</tr>\r\n");
      out.write("</table>\r\n");
 	
//계산한 카렌더 정보를 화면에 출력하기	
	for(int month=0;month<12;month++){
		//12달 중에 오늘인 달 9월달
		if(month==icmonth){

      out.write("\r\n");
      out.write("<center><font size=\"30\" color=\"green\">");
      out.print(month+1 );
      out.write("</font></center>\r\n");
      out.write("<table align=\"center\" border=\"1\" width=\"1200\"><tr>\t\r\n");
		
		for(int i=0;i<week.length;i++){
			//일 월 화 수 목 금 토 
			out.print("<td align='center'width='170' height='30'>"+week[i]+"</td>");
		}
		out.print("</tr>");
		//날짜 출력하기
		//한달에 속한 주를 계산해서 반복처리
		for(int i=0;i<cal.get(Calendar.WEEK_OF_MONTH);i++){
			out.print("<tr>");
			//일주일씩 출력하기
			for(int j=0;j<7;j++){
				//날짜 정보를 가지고 있니?
				if(day[month][i][j]!=0){
					out.print("<td align='right'width='170' height='90' valign='top'>");
					out.print("<table border='1' width='100%' height='100%'>");	
					out.print("<tr><td align='right'>"+day[month][i][j]+"</td></tr>");
					if(day[month][i][j]==20 
					  |day[month][i][j]==21 
					  |day[month][i][j]==22 
					  |day[month][i][j]==23 
					 ){
						out.print("<tr bgcolor='red'><td align='right'>"+""+"</td></tr>");
					}
					out.print("<tr><td align='right'>"+""+"</td></tr>");
					out.print("<tr><td align='right'>"+""+"</td></tr>");
					out.print("<tr><td align='right'>"+""+"</td></tr>");
					out.print("<tr><td align='right'>"+""+"</td></tr>");
/* +버튼을 추가하여 메모등록 구현해보기 */			
					out.print("<tr><td align='right'><a href='javascript:memoForm("+cyyyy+","+(month+1)+","+day[month][i][j]+")'>+</a></td></tr>");
					out.print("</table></td>");
				}else{
					out.print("<td>&nbsp;</td>");					
				}
			}////////// end of inner for[주간일자]
			out.print("</tr>");
		}////////////// end of  outter for[월별일자]

      out.write("\r\n");
      out.write("</table>\r\n");

		}/////////////////end of if[이번달 정보만 출력하기]
	}

      out.write("\r\n");
      out.write("\r\n");
      out.write("  <!-- The Modal -->\r\n");
      out.write("  <div class=\"modal fade\" id=\"myModal\">\r\n");
      out.write("    <div class=\"modal-dialog\">\r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("        <!-- Modal Header -->\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <h4 class=\"modal-title\">메모 등록</h4>\r\n");
      out.write("          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">×</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <!-- Modal body -->\r\n");
      out.write("        <div class=\"modal-body\">\r\n");
      out.write("        <form class=\"was-validated\">\r\n");
      out.write("          <div class=\"form-group\">\r\n");
      out.write("          \t<label><div id=\"d_curday\">2019년9월20일</div></label>\r\n");
      out.write("          \t<input type=\"text\" class=\"form-control\" id=\"content\" name=\"content\" placeholder=\"내용 적기\" required>\r\n");
      out.write("          \t<div class=\"valid-feedback\">Valid.</div>\r\n");
      out.write("          \t<div class=\"invalid-feedback\">메모를 작성하세요.</div>\r\n");
      out.write("          </div>\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-primary\" onClick=\"moAdd()\">등록</button>\r\n");
      out.write("        </form>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <!-- Modal footer -->\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  <!-- Modal  end -->\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
