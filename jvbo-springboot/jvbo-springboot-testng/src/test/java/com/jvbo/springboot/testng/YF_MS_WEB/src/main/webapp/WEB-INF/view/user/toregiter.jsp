<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="regiter" method="post">
	用户姓名:<input name="name"></br>
	用户账号:<input name="useraccount"></br>
	用户密码:<input name="userpassword"></br>
	用户性别:<input name="usersex"></br>
	用户年龄:<input name="userage"></br>
	用户的地址:<input name="useraddress"></br>
	用户的邮箱:<input name="useremail"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>