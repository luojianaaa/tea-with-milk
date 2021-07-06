<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
</head>

<body>
<div id="aaa">
<div class="all" >
  <h2>
  <span>Welcome</span>&nbsp;&nbsp;用户登录
  </h2>
  <form action="dljmServlet" method="post">
    <p>手机号码：</p>
    <input type="text" id="username" name="phonenumber" 
    placeholder="请输入手机号码" maxlength="11" class="yhm" />
    <br>
    <span>${formBean.errors.phonenumber}</span>
    <br />
    <br />
    <p>验证码：</p>
    <img src="/20200703/CheckServlet">
    <input type="text" name="check_code" class="yzm" placeholder="请输入验证码" />
    <br>
    <span>${formBean.errors.check_code}</span>
    <br />
    <br />
    <input type="submit" value="立&nbsp;即&nbsp;登&nbsp;录" class="dl" />
  </form>
</div>
</div>
</body>
<style type="text/css">
* {
	padding: 0;
	margin: 0;
	font-family: "微软雅黑";
}
body{background:url("images/timg.jfif");}
.all {
	text-align: center;
	width: 500px;
	margin: 150px auto;
}
.yhm, .yzm {
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
	background: -webkit-linear-gradient(left, pink ,  orange);
	color: #FFF;
	margin: 20px auto;
}
.all p {
	text-align: left;
}
h2{color:#03F;}
span{color:#F00;
font-style:italic;}
</style>
</html>