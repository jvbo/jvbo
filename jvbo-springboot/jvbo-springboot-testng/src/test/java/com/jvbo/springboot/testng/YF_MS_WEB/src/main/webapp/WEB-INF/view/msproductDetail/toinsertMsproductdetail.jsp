<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insertMsproductdetail" method="post">
<input name="productid" type="hidden" value="${productid}">
<input name="merchantid" type="hidden" value="${merchantid}">
	商品产地:<input name="productplace"></br>
	商品名称:<input name="productname"></br>
	商品品牌:<input name="brandname"></br>
	商品重量:<input name="productweight"></br>
	规格和包装:<input name="specification"></br>
	商品详情图片地址:<input name="productdetailpicture"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>