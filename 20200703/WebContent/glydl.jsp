<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>管理员登录</title>
</head>

<body>
<div class="all">
  <h2>
  <span>管理员</span>&nbsp;&nbsp;登录
  </h2>
  <form action="glydlServlet" method="post">
    <div class="kong">
		<span>${AdministratorsBean }</span>
    <br>
      <span1 style="width:10%">用户名：</span>
      <input type="text" name="username" id="username" class="hm" placeholder="请输入用户名" />
      <br>
      <span>${formBean.errors.username}</span>
    </div>
    <br/><br/>
    <div class="kong">
      <span1 style="width:10%">密码：</span>
      <input type="password" name="password" id="pwd" class="hm" placeholder="请输入密码" />
      <br>
      <span>${formBean.errors.password}</span>
    </div>
    <input type="submit" value="登录" class="dl" />
  </form>
</div>
</body>
<style>
body{background:url("images/glydl.jpg");}
.all {
	text-align: center;
	width: 500px;
	margin: 150px auto;
}
h2 {
	font-size: 42px;
	font-weight: 500;
	color: red;
	font-style: italic;
}
span {
	color: #00F;
}
.kong {
	border: 0;
	border-bottom: solid #999 1px;
	display: inline;
	margin: auto 0;
	padding: 20px 0;
}
.hm {
	width: 90%;
	border: 0;
	font-size: 16px;
	padding: 20px 0;
	outline: none;
	margin: auto 0;
}
.dl {
	border-radius: 40px;
	height: 40px;
	width: 90%;
	border: 0;
	background:#0F0;
	color: #FFF;
	margin: 20px auto;
}
</style>
</html>