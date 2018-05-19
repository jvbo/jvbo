<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center><a href="toadd">添加商家</a></center>
<table border="2">
	<tr>
		<td>商家的姓名</td>
		<td>商家的店铺名称</td>
		<td>商家账号</td>
		<td>商家密码</td>
		<td>商家经营范围</td>
		<td>操作</td>
	</tr>
	<c:forEach items="${msmerchantlist}" var="item">
		<tr>
			<td>${item.merchantname }</td>
			<td>${item.merchantshopname }</td>
			<td>${item.merchantaccount }</td>
			<td>${item.merchantpassword }</td>
			<td>${item.merchantscope }</td>
			<td><a href="toupdate?id=${item.id}">修改</a>||<a href="del?id=${item.id}">删除</a>||<a href="querybyid?id=${item.id}">查看</a></td>
		</tr>
	</c:forEach>
</table>

</body>
</html>