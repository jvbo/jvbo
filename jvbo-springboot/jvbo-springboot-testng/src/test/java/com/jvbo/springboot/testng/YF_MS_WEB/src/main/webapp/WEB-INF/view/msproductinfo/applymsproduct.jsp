<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="applymsproduct" method="post">
	商品id:<input name="productid"></br>
	商品标题:<input name="producttitle"></br>
	商品图片地址:<input name="productpicture"></br>
	秒杀价格:<input name="miaoshaprice"></br>
	商品原价:<input name="originalprice"></br>
	商家id:<input name="Msmerchantid"></br>
	秒杀开始时间:<input name="starttimestring"></br>
	秒杀结束时间:<input name="endtimestring"></br>
	秒杀商品数量:<input name="productcount"></br>
	库存:<input name="stockcount"></br>
	描述:<input name="description"></br>
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>