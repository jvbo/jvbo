<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="paywithorder" method="post">
支付方式：
支付宝 :<input type="radio" name="paytype" value="1" />
微信:<input type="radio" name="paytype" value="2" />
银联:<input type="radio" name="paytype" value="3" />
支付总额：${payamount}
流水号:${tradeserialnumber}
<input type="hidden" name="userid" value="${userid}">
<input type="hidden" name="productid" value="${productid}">
<input type="hidden" name="merchantid" value="${merchantid}">
<input type="hidden" name="tradeserialnumber" value="${tradeserialnumber}">
<input type="hidden" name="payamount" value="${payamount}">
<input type="button" value="立即付款" onclick="submit(this)"/>
</form>
</body>
<script type="text/javascript">
function submit(obj){
	obj.parent.sumbit();
}
</script>
</html>