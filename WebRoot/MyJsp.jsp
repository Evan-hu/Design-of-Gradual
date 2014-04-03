<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/registe.css" rel="stylesheet">
	<script src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="js/valdata.js" charset="utf-8"></script>
    <style type="text/css" media="screen">
    </style>
  </head>
  <body>
    <div class="container">
      <form class="form-signin" action="userAction" method="post">
      	<div class="head-top">
        <span>  
          <h2><strong >  注 册  </strong></h2>
        </span>
      </div>
      <div class="mail">
          <label class="username-left charset">邮 &nbsp&nbsp&nbsp箱 : </label>
          <input class="form-control" placeholder="Enter email" type="text" id="checkmail">
      	  <span id="msg-mail" style="color: red"></span>
      </div>
      <div class="username">
          <label class="username-left charset">用户名 : </label>
          <input type="text" class="form-control" placeholder="Enter userName" id="user" name="username" onfocus="$('#message').hide();" onblur="validateName()">
      	  <span id="message" style="display: none; color: red">请输入用户名</span>
      </div>
      <div class="passwd">
          <label class="username-left charset">密 &nbsp&nbsp&nbsp码 : </label>
          <input type="password" class="form-control" placeholder="Enter password" name="userpasswd" required autofocus>
      </div>
      <div class="checkCode">
            <label class="username-left charset">验证码 : </label>
            <input type="text" class="form-control" placeholder="Enter Code" name="checkCode" required autofocus>
      		<span id="msg-code" style="display: none; color: red">请输入验证码</span>
      </div>
      <div>
          <img src="rand.action" class="checkImg"  onclick="changeValidateCode(this)" title="点击刷新验证码"/>
      </div>
      <div class="btn-place">
         <button type="submit" class="btn btn-default">提&nbsp&nbsp交</button>
      </div>
      
      </form>
    </div>
    
  </body>
</html>

