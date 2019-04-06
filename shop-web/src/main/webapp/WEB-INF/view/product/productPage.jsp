<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${!empty list}">
	<table border="1" cellspacing="0">
		<tr>
			<th>选择</th>
			<th>编号</th>
			<th>商品名</th>
			<th>品牌</th>
			<th>店铺名称</th>
			<th>商品图片</th>
			<th>成本价</th>
			<th>销售价</th>
			<th>库存</th>
			<th>是否推荐</th>
			<th>录入时间</th>
			<th>关闭时间</th>
			<th>操作</th>
		</tr>
		<tbody id="dataTbody">
			<c:forEach items="${list}" var="product">
				<tr bgcolor="${product.repertory<=10?"red":"green"}">
					<td><input type="checkbox" name="productIdCheck" value="${product.id}" onclick="this.checked = !this.checked;"/></td>
					<td>${product.id}</td>
					<td data-id="${product.id}" data-productName="${product.productName}">${product.productName}</td>
					<td>${product.brandId.brandName}</td>
					<td>${product.shopId.storeName}</td>
					<td><img src="<%=request.getContextPath()%>${product.imagePath}" width="100px" height="100px"></td>
					<td>${product.costPrice}</td>
					<td>${product.marketPrice}</td>
					<td>${product.repertory}</td>
					<td>${product.recommend==1?"是":"否"}</td>
					<td><fmt:formatDate value="${product.createTime}" type="both"/></td>
					<td><fmt:formatDate value="${product.updateTime}" type="both"/></td>
					<td>
						<input type="button" value="修改" onclick="toUpdateProduct('${product.id}')"/>
						<input type="button" value="查看图片" onclick="toFindImgPath('${product.id}')"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="javascript:deleteAllData();">批量删除</a>
	<a href="javascript:exportData();">excel导出数据</a>
	<a href="javascript:findExportByBrandData();">excel按品牌导出数据</a>
	<jsp:include page="/common/ajaxpage.jsp"></jsp:include>
</c:if>
<c:if test="${empty list}">
	<h2><font color="red">sorry, 暂无数据！！！</font></h2>
</c:if>