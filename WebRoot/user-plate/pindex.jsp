<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
		if(session.getAttribute("cur_user") != null){
			String cur_user = session.getAttribute("cur_user").toString();
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="charset=utf-8" />
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/registe.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/itemAjax.js"></script>
  	<style type="text/css" media="screen">
		.header {
			margin-top: 20px;
			margin-left: 100px;
			padding: 20px;
			width: 100%;
		}
		.content {
			margin-top: 20px;
			margin-left: 100px;
			padding: 20px;
			width: 100%;
		}	
	</style>
</head>
  
<body>
   <div class="header"> 
  		登录成功<br>
    欢迎版主：登陆<br>
    <s:debug>LL</s:debug>
    </div>
    
    <div class="content">
    	<table border="0">
  	 		<tr>
  	 			<td>
  	 				<div>
 						版块名 : <input type="text" class="item">
			  			版主 :<input type="text" class="owner" value="${user.username}"> 		  
			  			<button class="btn btn-primary" onclick="addItem_ajax()">添加版块</button>
					</div>
  	 			</td>
  	 			<td>
  	 				<span id="mesg"></span>
  	 			</td>
  	 		</tr>
  	 	</table>
  		 <table class="table table-bordered table-striped" id="itemName" border="1"></table>
    </div>
    </body>
</html>
