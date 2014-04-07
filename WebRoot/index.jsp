
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/index.css">
    <script src="js/jquery-1.8.3.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	function click(){
    		$(".header .login-form").show();
    	}
    </script>
  </head>
  <body>
  	<div class="container">
  		<div class="header">
  			<div class="header-1">
  				<div class="place-right input-group">
  					<form>
  						<input type="text"  placeholder="Search..." class="form-control">
  						<button type="button"  class="btn btn-default" >搜索</button>
  					</form>
  				</div>
  				<a href="#" class="place-left">
  					<h2>欢迎来到BBS For Evan</h2>
  				</a>
  			</div>
  			<!-- 导航条 -->
  			<div class="header-2">
  				<ul>
  					<!-- <h1>Hello, world!</h1> -->
  					<li>
  						<a href="#" class="fg-orange">娱乐八卦</a>
  					</li>
  					<li>
  						<a href="#" class="fg-cobalt">老生杂谈</a>
  					</li>
  					<li>
  						<a href="#"  class="fg-orange">情感天地</a>
  					</li>
  					<li>
  						<a href="#"  class="fg-cobalt">经济论坛</a>
  					</li>
  					<li>
  						<a href="#"  class="fg-orange">国际观察</a>
  					</li>
  					<li class="place-right">
  						<a class="fg-cobalt" href="login.jsp">登陆</a>
						<a class=" fg-cobalt" href="register.jsp">注册</a>
  					</li>
  				</ul>	
  			</div>
  		</div>
  		<!--   登陆的div默认为display：none   -->
  		<div class="login-form" style="display: none">
  			<form id="login-form" action="loginAction" method="post">
  				<div class="form-group">
    		<div class="email place-left">
    		<label for="exampleInputEmail1" >用户名 :</label>
    		</div>
    		<input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
  		</div>
  		<div class="form-group">
  			<div class="passwd">
  				<label for="exampleInputPassword1" class="passwd-left">密 &nbsp&nbsp&nbsp码 :</label>
  			</div>
    		<input type="password" class="form-control place-right" id="exampleInputPassword1" placeholder="Password">
  		</div>
  		<div class="form-group">
  			<div class="checkCode">
            <label class="username-left charset">验证码 : </label>
            <input type="text" class="form-control" id="code" placeholder="Enter Code" name="checkCode" required autofocus>
      		<span id="msg-code" style="display: none; color: red">请输入验证码</span>
      	</div>
  		</div>
  			<div>
  				<img src="rand.action" class="checkImg"  onclick="changeValidateCode(this)" title="点击刷新验证码"/>
  			</div>
  		<div class="checkbox">
    		<label>
      		<input type="checkbox"> Check me out
    		</label>
  		</div>
  		<button type="submit" class="btn btn-default">登陆</button>
  			</form>
  		</div>
  		<div class="main-content">
  		<div>
  			<p>
  				元素框的最内部分是实际的内容，直接包围内容的是内边距。内边距呈现了元素的背景。内边距的边缘是边框。边框以外是外边距，外边距默认是透明的，因此不会遮挡其后的任何元素。
提示：背景应用于由内容和内边距、边框组成的区域。
内边距、边框和外边距都是可选的，默认值是零。但是，许多元素将由用户代理样式表设置外边距和内边距。可以通过将元素的 margin 和 padding 设置为零来覆盖这些浏览器样式。这可以分别进行，也可以使用通用选择器对所有元素进行设置：
  			</p>
  		</div>
  		</div>
  	</div>
  </body>
</html>
