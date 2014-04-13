<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Design</title>
<meta name="name" content="charset=utf-8">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/font-awesome.min.css">
<link rel="stylesheet" href="../css/jquery.qeditor.css">
<script type="text/javascript" src="../js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="../js/jquery.qeditor.js"></script>
<script src="../js/bootstrap.min.js"></script>
<style>
	.container {
		margin-top: 50px;
		margin-left: 15%;
	}
	.place-left, .secl-div, .title-control  {
		float: left;
	}
	#title, .title-control {
	margin-left: -170px;;
		width: 350px;
	}
	.secl-div {
		margin-left: -150px;
	}
	.control-group {
		clear: both;
	}
	.control-label {
		width: 50px;
	}
	.content {
		margin-top: 8px;
	}
	.textarea {
	float: left;
	margin-left: -9px;
    background-color: #ffffff;
    border: 1px solid #cccccc;
    -webkit-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    -moz-box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075);
    -webkit-transition: border linear .2s, box-shadow linear .2s;
    -moz-transition: border linear .2s, box-shadow linear .2s;
    -o-transition: border linear .2s, box-shadow linear .2s;
    transition: border linear .2s, box-shadow linear .2s;
    padding: 14px 4px;
    font-size: 14px;
    line-height: 20px;
    color: #555555;
    -webkit-border-radius: 4px;
    -moz-border-radius: 4px;
    border-radius: 4px;
    vertical-align: middle;
    outline: none;
    width: 760px;
	height: 400px;
  }
  .btn {
  	margin-left: 650px;
  }
</style>
</head>
<body>
<div class="container">
   <form class="form-horizontal" action="postAction" method="post">
   <!-- 如数标题的区域 -->
   <div class="control-group">
        <label class="control-label">标题 : </label>
        <div class="controls title-control">
          <input type="text" id="title" name="posttitle" placeholder="Type your title">
          <input type="hidden" name="userId" value="${user.userid}">
		  <input type="hidden" name="userName" value="${user.username}">
        </div>
        <div class="secl-div">
				<select name="itemname" class="secletor">
					<option value="-1">
					--- 请选择版块名 ---
					</option>
					<s:iterator value="#session.itemNames" status="st" id="itemname">
					<s:set name="sequence" value="#st.count" />
						<option value="${sequence}">
								${itemname[1]}
						</option>
					</s:iterator>
				</select>
		</div>
      </div>
      <!-- 输入内容的区域 -->
      <div class="control-group  content">
        <label class="control-label" for="post_body" >内容 : </label>
        <div class="controls">
           <textarea id="post_body" name="postcontent" class="textarea" placeholder="Type your post"></textarea>
        </div>
      </div>
      <!-- 显示图片的区域  -->
      <div class="control-group">
       <label class="control-label" for="post_body" >图片 : </label>
        <div class="controls">
          <input type="file"  name="Img"  placeholder="Input the image.....">
        </div>
      </div>
      <!--  -->
      <div class="control-group">
        <div class="controls">
          <button type="submit" id="submit" class="btn btn-success">发表</button>  
        </div>
      </div>
      
    </form>
</div>
<script type="text/javascript">
    $("#post_body").qeditor({});
</script>
</body>
</html>
