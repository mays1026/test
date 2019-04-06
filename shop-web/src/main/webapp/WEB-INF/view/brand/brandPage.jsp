<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:if test="${!empty list}">
<table id="table" border="1" cellspacing="0">
<tr>
	<th>选择</th>
	<th>编号</th>
	<th>产品名</th>
	<th>录入时间</th>
	<th>修改时间</th>
	<th>操作</th>
</tr>
<tbody id="dataTbody">
<c:forEach items="${list}" var="brand">
		<tr>
			<td><input type="checkbox" name="brandIdCheck" value="${brand.id}" onclick="this.checked = !this.checked;"/></td>
			<td>${brand.id}</td>
			<td data-id="${brand.id}" data-brandName="${brand.brandName}">${brand.brandName}</td>
			<td><fmt:formatDate value="${brand.createTime}" type="both"/></td>
			<td><fmt:formatDate value="${brand.updateTime}" type="both"/></td>
			<td>
			<input type="button" value="删除" onclick="deleteBrand('${brand.id}')"/>
			<input type="button" value="修改" onclick="toUpdateBrand('${brand.id}')"/>
			</td>
		</tr>
</c:forEach>
</tbody>
</table>
<jsp:include page="/common/ajaxpage.jsp"></jsp:include>
</c:if>
<c:if test="${empty list}">
<h2><font color="red">sorry, 暂无数据！！！</font></h2>
</c:if>