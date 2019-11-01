<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
  <script>
    function loginModal(){
      $("#myModal").modal();
    }
    function loginAction(){
		//사용자가 입력한 아이디와 비번 가져오기
		var mem_id = $("#mem_id").val();
		var mem_pw = $("#mem_pw").val();
		$.ajax({
			url:"/member/login.kos?work=member&mem_id="+mem_id+"&mem_pw="+mem_pw
		   ,method:"get"			
		   ,success:function(data){
			   $("#loginForm").html(data);
		   }
		   ,error:function(e){
			   alert(e.responseText);
		   }
		});
    }   
    function logoutAction(){
		$.ajax({
			url:"logoutAccount.jsp"
		   ,method:"get"			
		   ,success:function(data){
			   $("#loginForm").html(data);
		   }
		   ,error:function(e){
			   alert(e.responseText);
		   }
		});		
    }   
  </script>
</head>
<body>
    <style>
        .jumbotron {
            background-image: url('../images/code6.jpeg');
            background-size: cover;
            text-shadow: black 0.2em 0.2em 0.2em;
            color: white;
        }
    </style>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">자바52기</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">Home</a></li>
      <li><a href="#">소개</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Front-End노트<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">HTML5</a></li>
          <li><a href="#">CSS</a></li>
          <li><a href="#">JavaScript</a></li>
        </ul>
      </li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Back-End노트<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="#">Java</a></li>
          <li><a href="#">서블릿</a></li>
          <li><a href="#">JSP</a></li>
          <li><a href="#">Spring</a></li>
          <li><a href="#">안드로이드</a></li>
        </ul>
      </li>
<!--
==================================================================
	온 라 인 시 험 솔루션 실습 - 자격시험 메뉴 추가
==================================================================
-->   
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">자격시험<span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="testReceipt.jsp">자격시험 접수</a></li>
          <li><a href="reGoTest.jsp">자격시험 보기</a></li>
        </ul>
      </li>  
<!--
==================================================================
	온 라 인 시 험 솔루션 실습 - 자격시험 메뉴 추가
==================================================================
-->       
     </ul>
   
<!-- 로그인 화면 처리 -->   
     <div id="loginForm" class="nav navbar-nav navbar-right">
        <form class="navbar-form navbar-right">
          <div class="form-group">
            <input type="text" class="form-control" id="mem_id" name="mem_id" size="10" placeholder="아이디">
          </div>
          <div class="form-group">
            <input type="text" class="form-control" id="mem_pw" name="mem_pw" size="10" placeholder="비밀번호">
          </div>
          <button type="button" class="btn btn-dark" onclick="loginAction()">Login</button>
        </form>
    </div>
<!-- 로그인 화면 처리 -->    
  </div>
</nav>
  
<div class="container">
    <div class="jumbotron">
      <h1 class="text-center">자바 52기</h1>
      <p class="text-center">자바 52기 수업노트 입니다.
      <p class="text-center"><a class="btn-primary btn-lg" href="lecture.html" role="button">강의 들어 볼까?</a></p>
    </div>
      <!-- =========================== 메인 이미지 다음 사이트 소개=====================-->
      <div class="row">
          <div class="col-sm-4">
              <h4>코딩놀이의 특징</h4>
              <p>코딩놀이는 프로그래밍 언어를 사용하여 자신이 상상하는 것들을 소프트웨어로 만들어 보는 놀이들로 구성되었습니다.</p>
              <p><a class="btn btn-default" data-target="#modal" data-toggle="modal">자세히 알아보기</a></p>
          </div>
           <div class="col-sm-4">
              <h4>코딩놀이의 특징</h4>
              <p>코딩놀이는 프로그래밍 언어를 사용하여 자신이 상상하는 것들을 소프트웨어로 만들어 보는 놀이들로 구성되었습니다.</p>
              <p><a class="btn btn-default" href="instructor.html">자세히 알아보기</a></p>
          </div>
          <div class="col-sm-4">
              <h4>코딩놀이의 특징</h4>
              <p>코딩놀이는 프로그래밍 언어를 사용하여 자신이 상상하는 것들을 소프트웨어로 만들어 보는 놀이들로 구성되었습니다.</p>
              <p><a class="btn btn-default" href="lecture.html">자세히 알아보기</a></p>
          </div>                       
      </div>
      <hr>
      <!-- =========================== 메인 이미지 다음 사이트 소개=====================-->
      <div class="pannel pannel-primary">
          <div class="pannel-heading">
              <h3 class="pannel-title"><span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;최신 강의 목록</h3>
          </div>
          <div class="pannel-body">
              <div class="col-sm-4">
                  <div class="media-left">
                      <a href="lecture.html?lectureName=C"><img src="../images/c.jpeg" width="50px" height="50px" alt="c언어"></a>
                  </div>
                  <div class="media-body">
                      <h4 class="media-heading"><a href="lecture.html?lectureName=C">C언어 강의</a>&nbsp;<span class="badge">New</span></h4>
                          C언어 프로그래밍 강의
                  </div>
              </div>
               <div class="col-sm-4">
                  <div class="media-left">
                      <a href="lecture.html?lectureName=java"><img src="../images/java.png" width="50px" height="50px" alt="c언어"></a>
                  </div>
                  <div class="media-body">
                      <h4 class="media-heading"><a href="lecture.html?lectureName=C">JAVA 강의</a>&nbsp;<span class="badge">New</span></h4>
                          JAVA 프로그래밍 강의
                  </div>
              </div>
              <div class="col-sm-4">
                  <div class="media-left">
                      <a href="lecture.html?lectureName=oracle"><img src="../images/oracle.png" width="50px" height="50px" alt="c언어"></a>
                  </div>
                  <div class="media-body">
                      <h4 class="media-heading"><a href="lecture.html?lectureName=oracle">Oracle 강의</a>&nbsp;<span class="badge">New</span></h4>
                          Oracle 데이터베이스 강의
                  </div>
              </div>      
              <br><br><hr>     
          </div>
      </div>
  </div>
  <footer style="background-color: #000000; color: #ffffff;">
      <div class="container">
          <br>
          <div class="row">
          <!-- 12개 범위에서 맞추어 준다. -->
              <div class="col-sm-2" style="text-align: center;"><h5>Copyright &copy; 2019</h5><h5>김유신</h5></div>
              <div class="col-sm-4"><h4>대표자 소개</h4><p>한국소프트인재개발원에서 자바과정을 담당하고 있습니다.</p></div>
              <div class="col-sm-2"><h4 style="text-align: center;">내비게이션</h4>
                <div class="list-group">
                   <a href="#" class="list-group-item">소개</a>   
                   <a href="#" class="list-group-item">강사진</a>
                   <a href="#" class="list-group-item">강의</a>
                  </div>
              </div>
              <div class="col-sm-2"><h4 style="text-align: center;">SNS</h4>
                  <div class="list-group">
                   <a href="#" class="list-group-item">페이스북</a>   
                   <a href="#" class="list-group-item">유튜브</a>
                   <a href="#" class="list-group-item">네이버 TV</a>
                  </div>
               </div>
                <div class="col-sm-2"><h4 style="text-align: center;"><span class="glyphicon glyphicon-ok" ></span>by &nbsp;김유신</h4></div>
          </div>
      </div>
  </footer>
  </div>  
</body>
</html>

