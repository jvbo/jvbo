<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="#">
购买数量：1 <input type="hidden" name="num" value="1"><span id="remainnoties"></span>
<input type="hidden" name="id" value="${msproduct.id}">
<table border="1">
	<tr>
		<td>商品标题</td>
		<td>商品图片</td>
		<td>秒杀价格</td>
		<td>秒杀原价</td>
		<td>秒杀开始时间</td>
		<td>秒杀结束时间</td>
		<td>秒杀商品数</td>
		<td>库存</td>
	</tr>
	<tr>
		<td>${msproduct.producttitle}</td>
		<td>${msproduct.productpicture}</td>
		<td>${msproduct.miaoshaprice}</td>
		<td>${msproduct.originalprice}</td>
		<td><span id="starttime"><fmt:formatDate value="${msproduct.starttime}" pattern="yyyy-MM-dd HH:mm:dd"/></span></td>
		<td><span id="endtime"><fmt:formatDate value="${msproduct.endtime}" pattern="yyyy-MM-dd HH:mm:dd"/></span></td>
		<td>${msproduct.productcount}</td>
		<td>${msproduct.stockcount}</td>
	</tr>
</table>
<table border="1">
<tr>
		<td>商品产地</td>
		<td>商品名称</td>
		<td>商品品牌</td>
		<td>商品重量</td>
		<td>规格和包装</td>
		<td>商品详情图片地址</td>
	</tr>
	<tr>
		<td>${msproductdetail.productplace}</td>
		<td>${msproductdetail.productname}</td>
		<td>${msproductdetail.brandname}</td>
		<td>${msproductdetail.productweight}</td>
		<td>${msproductdetail.specification}</td>
		<td>${msproductdetail.productdetailpicture}</td>
	</tr>
</table>
<input id="sellbnt" type="button" value="立即购买" onclick="submit(this)"/>
</form>
</body>
<script type="text/javascript" src="/YF_MS_WEB/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
function submit(obj){
	
	obj.parent.sumbit();
}
document.write( "<script src='/YF_MS_WEB/js/remain.js?radom=" + Math.random() + " '></s" + "cript>" )
</script>
</html>