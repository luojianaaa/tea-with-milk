<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
	<div>恭喜你，登录成功</div>
             <hr />
		    <div>您的信息</div>
		    <div>
				您的手机号码:${userBean.cphonenumber}
		    </div>
		    <br>
		    <br>
		    <div>商品名称：${commodityBean[0].coname }</div>
		    <div>商品价格：${commodityBean[0].coprice }</div>
		    <div>商品库存：${commodityBean[0].costock }</div><br>
		    
		    <div>商品名称：${commodityBean[1].coname }</div>
		    <div>商品价格：${commodityBean[1].coprice }</div>
		    <div>商品库存：${commodityBean[1].costock }</div>
		    
</body>
</html>