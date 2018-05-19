<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="add">
	商家的姓名:${msmerchant.merchantname }</br>
	商家的店铺名称:${msmerchant.merchantshopname }</br>
	商家账号:${msmerchant.merchantaccount }</br>
	商家密码:${msmerchant.merchantpassword }</br>
	商家经营范围:${msmerchant.merchantscope }</br>
</form>
</body>
</html>