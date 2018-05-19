<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="update" method="post">
	<input name="id" value="${msmerchant.id }" type="hidden"/>
	商家的姓名:<input name="merchantname" value="${msmerchant.merchantname }"></br>
	商家的店铺名称:<input name="merchantshopname" value="${msmerchant.merchantshopname }"></br>
	商家账号:<input name="merchantaccount" value="${msmerchant.merchantaccount }"></br>
	商家密码:<input name="merchantpassword" value="${msmerchant.merchantpassword }"></br>
	商家经营范围:<input name="merchantscope" value="${msmerchant.merchantscope }"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>