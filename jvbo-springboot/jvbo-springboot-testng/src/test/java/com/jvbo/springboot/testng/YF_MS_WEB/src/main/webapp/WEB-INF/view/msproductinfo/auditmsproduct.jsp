<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="updatemsproductstate" method="post">
<input name="id" value="${msproductinfo.id }" type="hidden">
	商品id:${msproductinfo.productid }"</br>
	商家id:${msproductinfo.msmerchantid }"</br>
	商品标题:${msproductinfo.producttitle }</br>
	商品图片地址:${msproductinfo.productpicture }</br>
	秒杀价格:${msproductinfo.miaoshaprice }</br>
	商品原价:${msproductinfo.originalprice }</br>
	秒杀开始时间:${starttimestring }</br>
	秒杀结束时间:${endtimestring}</br>
	秒杀商品数量:${msproductinfo.productcount }</br>
	库存:${msproductinfo.stockcount }</br>
	描述:${msproductinfo.description }</br>
	审核通过:<input type="radio" name="state" value="2">审核不通过:<input type="radio" name="state" value="3">
	<input type="button" value="提交" onclick="submit(this)">
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>