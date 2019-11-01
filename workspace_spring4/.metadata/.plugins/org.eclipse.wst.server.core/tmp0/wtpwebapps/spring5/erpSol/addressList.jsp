<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<script type="text/javascript">
	$(document).ready(function(){
		$.ajax({
			method:"get"
		   ,url:"zdoList"
		   ,success:function(data){
			   $("#d_zdo").html(data);
			   $("#zdo").change(function(){
				  var vzdo = $("#zdo option:selected").text();//경기 
				  alert("vzdo:"+vzdo);
				  
				  if(vzdo!=null && vzdo.length>1){
						$.ajax({
							method:"get"
						   ,url:"siguList?zdo="+vzdo
						   ,success:function(data){
							   $("#d_sigu").html(data);
							   $("#zdo").change(function(){
								  var vzdo = $("#zdo option:selected").text();//경기 
								  if(vzdo!=null && vzdo.length>1){
									  
								  }
							   }); 
						   }
						});///////////////end of sigu
				  }///////////////////////end of if
				  
			   });
		   }
		});
	});
</script>
  <div class="container-fluid">
    <div class="row">
      <div class="col-sm-2 bg-success">
        <div id="d_zdo">
     	<select id="zdo">
     		<option>도를선택</option>
     	</select>
     	</div>
      </div>
      <div class="col-sm-2 bg-warning">
        <div id="d_sigu">
     	<select id="sigu">
     		<option>시구를선택</option>
     	</select>
     	</div>
      </div>
      <div class="col-sm-2 bg-success">
        <div id="d_dong">
     	<select id="dong">
     		<option>동을선택</option>
     	</select>
     	</div>
      </div>
      <div class="col-sm-6 bg-warning">
       &nbsp;
      </div>
    </div>
  </div>
</div>
</body>
</html>