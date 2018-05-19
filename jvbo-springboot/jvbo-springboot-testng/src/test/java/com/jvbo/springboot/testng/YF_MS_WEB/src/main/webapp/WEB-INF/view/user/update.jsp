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
<input name="id" value="${msuser.id }" type="hidden"/>
             用户姓名:<input name="name" value="${msuser.name }"></br>
	用户账号:<input name="useraccount" value="${msuser.useraccount }"></br>
	用户密码:<input name="userpassword" value="${msuser.userpassword }"></br>
	用户性别:<input name="usersex" value="${msuser.usersex }"></br>
	用户年龄:<input name="userage" value="${msuser.userage }"></br>
	用户的地址:<input name="useraddress" value="${msuser.useraddress}" ></br>
	用户的邮箱:<input name="useremail" value="${msuser.useremail }"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>