<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>商品表</h3>
	<div>${commodityBean }</div><br>
	<form action="commodityServlet" method="post">
		商品编号：<input type="text" name="coid" />
		商品名称：<input type="text" name="coname" />
		商品价格：<input type="text" name="coprice" />
		商品库存：<input type="text" name="costock" />
		<input type="reset" value="重置 " />
		<input type="submit" value="修改或添加" />
	</form>
	
</body>
</html>