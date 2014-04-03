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
    <link rel="stylesheet" href="css/bootstrap.css">
    <script type="text/javascript">
   	 //验证码的刷新
		function changeValidateCode(obj) {       
			var timenow = new Date().getTime();          
			obj.src="rand.action?d="+timenow;      
		}
	//验证码的验证
		function validateCode(){
			var code = $('input[name = randcode]').val;
			$.ajax({
				url:'validate!validateCode.action',
				data:{code:code},
				type:'post',
				datatype:'json',
				//async:false, 默认设置卫异步，此时为同步
				success:function(data){
						data = eval('('+data+')');
						if(data.tip == "true"){
							alert("the code is right!");
						}
				},
				error:function(){
					alert("验证码错误！");
				}
				});
		}
	</script>
    <style type="text/css">
    .form-control {
    	width: 25%;
    }
    .place-left {
    	margin: 6px;
    	float: left;
    }
    .passwd {
    	clear: left;
    }
    .passwd-left {
    	margin: 6px;
    	float: left;
    }
   .btn {
   		margin-left: 298px;
   }
</style>
</head>
<body>
	<div class="container">
		<form role="form">
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
  				<label for="exampleInputPassword1" class="checkCode-left">验证码 :</label>
  			</div>
    		<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
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
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>





	<!--<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript">
	//验证码的刷新
	function changeValidateCode(obj) {       
		var timenow = new Date().getTime();          
		obj.src="rand.action?d="+timenow;      
	}
	//验证码的验证
	function validateCode(){
		var code = $('input[name = randcode]').val;
		$.ajax({
				url:'validate!validateCode.action',
				data:{code:code},
				type:'post',
				datatype:'json',
				//async:false, 默认设置卫异步，此时为同步
				success:function(data){
						data = eval('('+data+')');
						if(data.tip == "true"){
							alert("the code is right!");
						}
				},
				error:function(){
					alert("验证码错误！");
				}
				});
	}
	</script>
	<style type="text/css">
		
	</style>
</head>

<body>
<table width="100%" border="0">
  <tr>
    <td height="170" colspan="3">&nbsp;</td>
  </tr>
  <tr>
    <td width="24%" height="399">&nbsp;</td>
    <td width="36%">
    <form action="loginAction" method="post">
    	<table width="100%" border="0" id="2">
	      <tr>
	        <td height="46" colspan="2" align="center"><b>登&nbsp;&nbsp;&nbsp;陆</b></td>
	        </tr>
	      <tr>
	        <td width="30%" height="46" align="center">用户名</td>
	        <td width="70%" align="left"><input type="text" style="height: 30px" class="form-control" name="username" placeholder="用户名" data-var="@input-border-focus" required autofocus></td>
	      </tr>
	      <tr>
	        <td height="30"  height="46" align="center">密码</td>
	        <td width="70%"align="left"><input type="password" style="height: 30px" class="form-control" name="userpasswd" placeholder="密码" data-var="@input-border-focus" required autofocus></td>
	      </tr>
	       <tr>
	        <td height="30" height="46" align="center">验证码</td>
	        <td width="70%" align="left"><input type="text" style="height: 30px" class="form-control" onblur="validateCode();" name="randcode" placeholder="验证码" data-var="@input-border-focus" required autofocus></td>
	      </tr>
		  <tr>
		    <td height="39"  height="46"><br><br></td> 
	        <td>
	        <img src="rand.action"  onclick="changeValidateCode(this)" title="点击刷新验证码"/>
			</td>
	      </tr>
	      <tr>
	        <td height="42"  height="46">&nbsp;</td>
	        <td align="center"><button id="btn1" type="submit" style="width:80px;" class="btn btn-default">登陆</button></td>
	      </tr>
	    </table>
	 </form>
    </td>
    <td width="50%">&nbsp;</td>
  </tr>
</table>


</body>
</html>-->