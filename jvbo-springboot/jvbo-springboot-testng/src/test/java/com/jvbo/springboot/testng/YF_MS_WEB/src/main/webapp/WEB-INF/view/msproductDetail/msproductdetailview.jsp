<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form >
	商品产地:${msproductdetail.productplace }</br>
	商品名称:${msproductdetail.productname }</br>
	商品品牌:${msproductdetail.brandname }</br>
	商品重量:${msproductdetail.productweight }</br>
	规格和包装:${msproductdetail.specification }</br>
	商品详情图片地址:${msproductdetail.productdetailpicture }</br>
</form>
</body>
<script type="text/javascript">
	function submit(obj){
		obj.parent.sumbit();
	}
</script>
</html>