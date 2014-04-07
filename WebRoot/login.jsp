<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

 <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript" src="js/valdata.js"></script>
    <style type="text/css">
    .container {
    	width: 570px;
        margin-left: 250px;
        margin-top: 100px;
        padding: 20px;
    }
    .form-control {
    	width: 250px;
    	margin: 10px;
    }
    .place-left {	
    	float: left;
    	margin: 14px;
    }
    .passwd .checkcode {
    	clear: left;
    }
    .checkImg {
    	margin: 10px;
    	margin-left:180px;
    	padding: 10px;
    }
   .btn {
   		margin-left: 258px;
   		width: 80px;
    }
</style>
</head>
<body>
	<div class="container">
		<form class="login-form" action="loginAction" method="post">
  		<div class="email">
    		<label  class="email place-left">用户名 : </label>
    		<input type="text" class="form-control" name="username" placeholder="Enter UserName">
  		</div>
  		<div class="passwd">
  			<label class="place-left">密&nbsp&nbsp&nbsp码 : </label>
    		<input type="password" class="form-control place-right" name="userpasswd" placeholder="Password">
  		</div>
  		<div class="checkcode">
            <label class="place-left">验证码 : </label>
            <input type="text" id="code" class="form-control" placeholder="Enter Code" name="checkCode" required autofocus>
      		<span id="msg-code" style="color: red"></span>
  		</div>
  		<div>
  			<img src="rand.action" class="checkImg"  onclick="changeValidateCode(this)" title="点击刷新验证码"/>
  		</div>
  		<button type="submit" class="btn btn-default">登陆</button>
		</form>
	</div>
</body>
</html>