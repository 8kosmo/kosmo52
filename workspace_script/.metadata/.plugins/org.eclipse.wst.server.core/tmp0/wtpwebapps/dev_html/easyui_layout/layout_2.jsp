<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add and Remove Layout - jQuery EasyUI Demo</title>
    <!-- 
    easyui.css는 jeasyui가 제공하는 콤포넌트(예:datagrid,layout 등)에 
       디자인을 입힐 때 사용됨
     -->
    <link rel="stylesheet" type="text/css" href="/themes/default/easyui.css">
	<!-- icon.css는 아이콘 이미지 처리하는데 사용됨 -->   
    <link rel="stylesheet" type="text/css" href="/themes/icon.css">
    <!-- jeasyui 데모페이지에 사용되는 css임 -->
    <link rel="stylesheet" type="text/css" href="/demo/demo.css">
    <!-- jeasyui가 jquery기반이므로 호환성을 검증한 스크립트 코드만 따로 모아둠. -->
    <!-- <script type="text/javascript" src="/js/jquery.min.js"></script> -->
    <script type="text/javascript" src="http://code.jquery.com/jquery-1.6.min.js"></script>
    <!-- 
    jeasyui가 jquery기반이므로 아래 파일을 import하기 전에 반드시 jquery.min.js
       가 import되어 있어야 함. 순서 반드시 지킬것. 
     -->
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		var db_name="김유신";
		//입력화면에서 저장 버튼 클릭했을 때
		//사용자가 입력한 정보를 서버로(Tomcat) 전송해야 함.
		//get 인터셉트를 한다. 누가(브라우저) -> 서버로 요청이 전송되지 않음.
		//한번 요청된 페이지는 각 사용자 PC에 그 내용이 다운로드
		//두 번째 같은 페이지를 요청하면 서버에 전달한 다음 응답을 받아오는것이 아니라
		// XXX.html?1 주소창에 다른글자를 한자로 붙이면 새로운 요청으로 인식
	    // XXX.html?mem_id=test&mem_pw=123
		//브라우저가 열릴 때마다 네이버 서버측에서 너에게 세션아이디 		
		//사용자 컴터에 있는 정보가 그대로 다시 출력된다.
		//클라이언트측에 다운로드(html,css,js)
		//<form>태그 -> method->get(default-인터셉트)|post, action->이 요청을 처리해줄 페이지를
		function add(){
			$("#f_add").submit();//전송. 어디로 가는거지?, 전송방식?
		}
		//입력화면에서 취소 버튼 클릭했을 때
		function cancel(){
			
		}
		//입력 다이얼로그창 열기
		function addForm(){
			$('#dlg_add').dialog('open');
		}
		//수정 다이얼로그창 열기
		function updForm(){
			var row = $("#dg_member").datagrid("getSelected");
			//datagrid초기화시 소문자로 작성하였으므로 반드시 소문자로 접근해야 함.
			//만일 대문자로 작성하면 undefine
			var c_id = row.id; 
			//alert(c_id);
			//톰캣 서버로 이 아이디와 같은 상세정보를 조회하면 화면에 출력해야함.
			location.href="./memberUpdateForm.jsp?id="+c_id;
		}		
		//이름으로 검색하기
		function nameSearch(){
			alert("nameSearch호출 성공");
		}
		//로그인 요청시 구현
		function loginAction(){
			//front-end언어는 오라클 서버와 연동할 수 없다. - 상수처리한다.
			var db_id = "test";
			var db_pw = "123";
			var u_id = $("#tb_id").val();
			var u_pw = $("#tb_pw").val();
			if(db_id==u_id){//아이디가 존재하니
				if(db_pw==u_pw){//비번까지 같은거야? 네
					//로그인폼 숨기고 대신 로그인 성공화면 show
					$("#d_login").hide();
					$("#d_logout").show();
					//span태그에 메시지를 추가  - 김유신님 환영합니다.
					$("#s_msg").html("<b>"+db_name+"</b>님 환영합니다.");
				}
				else{//비번이 틀린거 같아
					alert("비번이 틀렸습니다.");
					$("#tb_pw").textbox('setValue','');
				}
			}
			else{//아이디가 존재하지 않아
				alert("아이디가 없습니다.");
			}
		}
		//로그아웃 요청시 구현
		function logoutAction(){
			$("#d_logout").hide();
			$("#d_login").show();
			$("#tb_id").textbox('setValue','');
			$("#tb_pw").textbox('setValue','');
			
		}
	</script>
</head>
<body>
	<style>
		#d_login {
		    /*border: 1px solid red;*/
			width: 190px;
			height: 110px;
		}
	</style>
	<script type="text/javascript">
	//날짜 포맷 형식을 디폴트에서 사용자 정의로 변경하므로
	//body태그 안에 해당 콤포넌트가 정의되기 전에 처리함.
		//datebox에 대한 날짜 포맷 재정의함.
		$.fn.datebox.defaults.formatter = function(date){
			var y = date.getFullYear();
			var m = date.getMonth()+1;
			var d = date.getDate();
			return y+'-'+(m<10 ? "0"+m:m)+'-'+(d<10 ? "0"+d:d);
		}	
		//datebox에 날짜 포맷을 적용함.
		$.fn.datebox.defaults.parser = function(s){
			var t = Date.parse(s);
			if (!isNaN(t)){
				return new Date(t);
			} else {
				return new Date();
			}
		}	
		$(document).ready(function (){
			/* 회원관리에 필요한 데이터그리드 추가  - 설정*/
			$("#dg_member").datagrid({
			    columns:[[
					{field:'id', title:'아이디', width:100}/* 아이디 */
				   ,{field:'name', title:'이름', width:120}/* 이름 */
				   ,{field:'address', title:'주소', width:300}/* 주소 */
				   ,{field:'hp', title:'H.P', width:140}/* HP */
				]]
				,singleSelect:'true'
				,toolbar:'#tbar_member'
				//,url:'./jsonMember.json'
				,data: [
					     {id:"test", name:"김유신",address:"서울시 마포구 공덕동",   hp:"010-222-2256"}
				        ,{id:"apple",name:"이순신",address:"서울시 금천구 가산동",   hp:"010-333-1477"}
				        ,{id:"haha", name:"이성계",address:"서울시 영등포구 영등포동", hp:"010-211-5588"}
				       ]
				
			});//////////////end of dg_member
			/* 사원관리에 필요한 데이터그리드 추가  - 설정*/
			$("#dg_emp").datagrid({
			    columns:[[
					{field:'empno', title:'사원번호', width:100}/* 아이디 */
				   ,{field:'ename', title:'사원명', width:120, editor:'text'}/* 이름 */
				   ,{field:'hiredate', title:'입사일자', width:300}/* 주소 */
				   ,{field:'deptno', title:'부서번호', width:140,
					   formatter:function(value,row){
							return row.empno||value;   
					   }
					   ,editor:{
							type:'combobox'
						   ,options:{
							   valueField:'deptno'
							  ,textField:'dname'
					          ,url:'jsonDept.json'
						   }////////////end of options
						}///////////////end of editor   
				    }/* HP */
				]]
				,singleSelect:'true'
				,toolbar:'#tbar_emp'
				,data: [
			        {empno:7566, ename:'김유신', hiredate:'1999-10-24', deptno:10},
			        {empno:7499, ename:'이성계', hiredate:'1997-05-14', deptno:20},
			        {empno:7566, ename:'김춘추', hiredate:'1999-07-15', deptno:30},
	            ]
				
			});//////////////end of dg_emp			
//세개 페이지(회원관리,DVD관리,대여관리) 숨김 처리하기			
			$("#d_member").hide();
			$("#d_dvd").hide();
			$("#d_rental").hide();	
			//로그인 성공했을 때 화면을 숨기자
			$("#d_logout").hide();
//easyui에서 제공하는 tree객체에 onClick이벤트 처리하기 시작			
			$('#te_menu').tree({//따로 함수 선언하지 않고 즉시 처리
				//파라미터로 넘어오는 node는 사용자가 선택한 엘리먼트 정보 가짐
				onClick: function(node){//트리메뉴 선택했을때 이벤트 처리
					//alert(node.text);  // alert node text property when clicked
					//node.text하면 선택한 노드문자열 가져옴.
					if("회원관리"==node.text){//너 회원관리 누른거야?
						//alert("11");
					//show메소드 호출하면 화면에 출력되고
					//hide메소드 호출하면 화면에 숨김 처리됨.
						$("#d_member").show();
						$("#d_emp").hide();
						$("#d_dvd").hide();
						$("#d_rental").hide();
					}
					else if("사원관리"==node.text){
						//alert("22");
						$("#d_emp").show();
						$("#d_member").hide();
						$("#d_dvd").hide();
						$("#d_dvd").hide();
						$("#d_rental").hide();						
					}
					else if("DVD관리"==node.text){
						//alert("22");
						$("#d_member").hide();
						$("#d_emp").hide();
						$("#d_dvd").show();
						$("#d_rental").hide();						
					}
					else if("대여관리"==node.text){
						//alert("33");
						$("#d_member").hide();
						$("#d_emp").hide();
						$("#d_dvd").hide();
						$("#d_rental").show();						
					}
				}
			});//////////////end of tree

		});//////////////////end of ready DOM구성이 끝났을 때
	</script>
    <div id="cc" class="easyui-layout" style="width:950px;height:550px;">
        <div data-options="region:'west',split:true" title="코딩놀이" style="width:200px;">
		<!-- 여백을 주기 위해 -->
		<div style="margin:10px 0;"></div>
<!--============= 로그인 화면 처리 시작 =============-->		
		<div id="d_login" align="center">
			<input id="tb_id" name="mem_id">	
			 <div style="margin:5px 0;"></div>
			<input id="tb_pw" name="mem_pw">
			 <div style="margin:5px 0;"></div>
			<a href="javascript:loginAction()" class="easyui-linkbutton">로그인</a>	
			<a href="javascript:memberAction()" class="easyui-linkbutton">회원가입</a>	
			<script type="text/javascript">
			$('#tb_id').textbox({
			    iconCls:'icon-man',
			    iconAlign:'right',
			    prompt:'아이디'
			})
			$('#tb_pw').textbox({
			    iconCls:'icon-lock',
			    iconAlign:'right',
			    prompt:'비밀번호'
			})
			</script>	
		</div><!-- 110px -->
<!--============= 로그인 화면 처리 끝 =============-->		
<!--============= 로그아웃 화면 처리 시작 =============-->		
		<div id="d_logout" align="center">
			<span id="s_msg">ㄹ홀호</span>
			 <div style="margin:5px 0;"></div>
			<a href="javascript:logoutAction()" class="easyui-linkbutton">로그아웃</a>	
			<a href="javascript:memberUpdate()" class="easyui-linkbutton">정보수정</a>				
		</div>	
<!--============= 로그아웃 화면 처리 끝 =============-->		
<!--============== 메뉴 트리 시작 =============--> 
        <ul id="te_menu" class="easyui-tree">
	        <li data-options="state:'closed'">
	            <span>회원관리</span>
	            <ul>
	                <li>
	                    <span>회원목록</span>
	                </li>
	                <li>
	                    <span>회원등록</span>
	                </li>
	                <li>
	                    <span>회원수정</span>
	                </li>
	                <li>
	                    <span>회원삭제</span>
	                </li>
	            </ul>
	        </li>
	        <li data-options="state:'closed'">
				<span>사원관리</span>
				<ul>
					<li>
						<span>사원목록</span>
					</li>
					<li>
						<span>사원등록</span>
					</li>
					<li>
						<span>사원수정</span>
					</li>
					<li>
						<span>사원삭제</span>
					</li>
				</ul>
			</li>
	        <li data-options="state:'closed'">
	            <span>DVD관리</span>
	            <ul>
	                <li>
	                    <span>DVD목록</span>
	                </li>
	                <li>
	                    <span>DVD등록</span>
	                </li>
	                <li>
	                    <span>DVD수정</span>
	                </li>
	                <li>
	                    <span>DVD삭제</span>
	                </li>
	            </ul>
	        </li>
	        <li data-options="state:'closed'">
	            <span>대여관리</span>
	            <ul>
	                <li>
	                    <span>대여목록</span>
	                </li>
	                <li>
	                    <span>대여등록</span>
	                </li>
	                <li>
	                    <span>대여수정</span>
	                </li>
	                <li>
	                    <span>대여삭제</span>
	                </li>
	            </ul>
	        </li>
        </ul>
<!--============== 메뉴 트리  끝 =============--> 
        </div>
        <div data-options="region:'center',title:'DVD관리시스템'">
		<!-- 회원관리 -->
		     <div style="margin:10px 0;"></div>
<!-- 
================================================================
	회원 관리 페이지 구현
================================================================
 -->		     
		     <div id="d_member">
		     Home - 회원관리 
		        <div style="margin:10px 0;"></div>
				<table title="회원목록" id="dg_member" width="700px" height="450px" class="easyui-datagrid">				
				</table>
<!--============== 회원관리화면에 필요한 툴바 시작 ==============-->
				<div id="tbar_member">
				<table align='left' width="100%">
					<!-- 조건 검색 추가 -->
					<tr>
						<td>
						<label>이름 : </label>
						<input class="easyui-searchbox" data-options="prompt:'이름을 입력하세요.',searcher:nameSearch" style="width:140px;">
						&nbsp;&nbsp;&nbsp;
						<label>H.P : </label>
						<input class="easyui-maskedbox" mask="999-9999-9999" style="width:140px;"> 
						<label>생년월일 : </label>
						<input class="easyui-datebox" style="width:140;">
						</td>
					</tr>
					<!-- 툴바 버튼 추가 -->
					<tr>
						<td style="padding:2px 5px;">
        				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
				        <a href="javascript:addForm()" class="easyui-linkbutton" iconCls="icon-add" plain="true">입력</a>
				        <a href="javascript:updForm()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">수정</a>
				        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>
						</td>
					</tr>
				</table>
				</div>
<!--============== 회원관리화면에 필요한 툴바   끝 ==============-->   
<!--
	============== 회원정보 등록 화면 시작  ==============
    easyui에서 제공하는 API활용시 주요속성
    id를 통해서 자바스크립트로 이벤트 처리하거나 옵션 추가 등 기능처리가 이루어짐
        해당 콤포넌트에 대한 상세 속성들은 data-options에 추가하면 됨
        자바스크립트 에서도 속성을 추가하거나 변경할 수 있음. - 방법확인해 둘 것.
        태그 안에서 속성 추가시 더블 쿼테이션 으로 묶어주고 속성과 값은 따로 분리하되 
        기호는 : 콜론을 사용함.
        태그 마다 스타일속성을 따로 처리할 때는 style속성에 값 자리에 속성명과 값을 주면 됨.
        제공되는 콤퍼넌트들은 모두 자바스크립트 코드로도 화면 처리 가능함.
    2가지 방법에 대해서는 혼자서 반드시 해볼것.
        외부에 CSS 사용보다는 각 태그 내에 있는 style속성이 우선하여 적용됨.     
--> 
				<div id="dlg_add" data-options="footer:'#tbar_add', closed:true, cache:false" class="easyui-dialog" title="회원등록" style="width:600px;height:350px;padding:10px">
					<form id="f_add" method="get" action="memberAdd.jsp">	
						<table>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>	
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>
							<tr>
								<td></td>
								<td></td>
							</tr>																												
						</table>
				    </form>
				</div>
				<div id="tbar_add">
				<a href="javascript:add()" class="easyui-linkbutton" iconCls="icon-ok" plain="true">저장</a>
				<a href="javascript:cancel()" class="easyui-linkbutton" iconCls="icon-cancel" plain="true">취소</a>
				</div>
<!--============== 회원정보 등록 화면  끝    ==============-->   
<!--============== 회원정보 수정 화면 시작  ==============--> 
<!--============== 회원정보 수정 화면  끝    ==============--> 
<!--============== 회원정보 삭제 화면 시작  ==============--> 
<!--============== 회원정보 삭제 화면  끝    ==============-->    
		     </div>   
<!-- 
================================================================
	회원 관리 페이지 구현
================================================================
 -->	
<!-- 
================================================================
	사원 관리 페이지 구현
================================================================
 -->		     
		     <div id="d_emp">
		     Home - 사원관리 
		        <div style="margin:10px 0;"></div>
				<table title="사원목록" id="dg_emp" width="700px" height="450px" class="easyui-datagrid"></table>
<!--============== 회원관리화면에 필요한 툴바 시작 ==============-->
				<div id="tbar_emp">
				<table align='left' width="100%">
					<!-- 조건 검색 추가 -->
					<tr>
						<td>
						<label>이름 : </label>
						<input class="easyui-searchbox" data-options="prompt:'이름을 입력하세요.',searcher:nameSearch" style="width:140px;">
						&nbsp;&nbsp;&nbsp;
						<label>H.P : </label>
						<input class="easyui-maskedbox" mask="999-9999-9999" style="width:140px;"> 
						<label>생년월일 : </label>
						<input class="easyui-datebox" style="width:140;">
						</td>
					</tr>
					<!-- 툴바 버튼 추가 -->
					<tr>
						<td style="padding:2px 5px;">
        				<a href="#" class="easyui-linkbutton" iconCls="icon-search" plain="true">조회</a>
				        <a href="javascript:addForm()" class="easyui-linkbutton" iconCls="icon-add" plain="true">입력</a>
				        <a href="javascript:updForm()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">수정</a>
				        <a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true">삭제</a>
						</td>
					</tr>
				</table>
				</div>
<!--============== 회원관리화면에 필요한 툴바   끝 ==============-->   
<!--============== 회원정보 등록 화면  끝    ==============-->   
<!--============== 회원정보 수정 화면 시작  ==============--> 
<!--============== 회원정보 수정 화면  끝    ==============--> 
<!--============== 회원정보 삭제 화면 시작  ==============--> 
<!--============== 회원정보 삭제 화면  끝    ==============-->    
		     </div>   
<!-- 
================================================================
	회원 관리 페이지 구현
================================================================
 -->	 			
		<!-- DVD관리 -->
		     <div id="d_dvd">DVD</div>   
		<!-- 대여관리 -->        
		     <div id="d_rental">대여</div>   
        </div>
    </div>
</body>
</html>









