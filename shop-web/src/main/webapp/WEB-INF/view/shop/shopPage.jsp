<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${!empty list}">
	<table border="1" cellspacing="0">
		<tr>
			<th>选择</th>
			<th>编号</th>
			<th>店铺名称</th>
			<th>店铺公司名称</th>
			<th>店铺状态</th>
			<th>录入时间</th>
			<th>关闭时间</th>
			<th>操作</th>
		</tr>
		<tbody id="dataTbody">
			<c:forEach items="${list}" var="shop">
				<tr bgcolor="${shop.storeStatus==1?"green":"#ccc"}">
					<td><input type="checkbox" name="shopIdCheck" value="${shop.id}" onclick="this.checked = !this.checked;"/></td>
					<td>${shop.id}</td>
					<td data-id="${shop.id}" data-shopName="${shop.storeName}">${shop.storeName}</td>
					<td>${shop.companyName}</td>
					<td>${shop.storeStatus==1?"正常":"关闭"}</td>
					<td><fmt:formatDate value="${shop.createTime}" type="both"/></td>
					<td><fmt:formatDate value="${shop.closeTime}" type="both"/></td>
					<td>
						<input type="button" value="修改" onclick="toUpdateShop('${shop.id}')"/>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="javascript:deleteAllData();">批量删除</a>
	<jsp:include page="/common/ajaxpage.jsp"></jsp:include>
</c:if>
<c:if test="${empty list}">
	<h2><font color="red">sorry, 暂无数据！！！</font></h2>
</c:if>