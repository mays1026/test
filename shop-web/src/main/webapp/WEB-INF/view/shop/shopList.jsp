<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="<%=basePath%>js/shop/shop.js"></script>
<script type="text/javascript">
	
	//给my97的input框绑定事件
	$(function(){
		bindMy97();
		trClickCkecked();
	});
	
	//查詢
	function getData(pageIndex){
		$.ajax({
			url:"<%=basePath%>shop/findShopList.action",
			type:"post",
			data:{
				"storeName":$("#storeName").val(),
				"companyName":$("#companyName").val(),
				"storeStatus":$("[name='storeStatus']:checked").val(),
				"minCreateTime":$("#minCreateTime").val(),
				"maxCreateTime":$("#maxCreateTime").val(),
				"minCloseTime":$("#minCloseTime").val(),
				"maxCloseTime":$("#maxCloseTime").val(),
				"pageIndex":pageIndex,
				"flag":1
			},
			success:function(data) {
				$("#dataDiv").html(data);
				trClickCkecked();
			}
		});
	}
	
	//修改
	function toUpdateShop(id){
		location.href="<%=basePath%>shop/toUpdateShop.action?id="+id;
	}
	
	//批量删除
	function deleteAllData() {
		if (confirm("确认删除这些数据么？？")) {
			$.ajax({
				url:"/shop/deleteAllData.action",
				data:{
					"ids":checkboxStauts.join(",")
				},
				type:"post",
				dataType:"json",
				success:function(data){
					if (data.code==200) {
						getData(1);
					}else {
						alert(data.message)
					}
				}
			});
		}else{
			//alert("已取消！！")
		}
	}
</script>
</head>
<body>
	<a href="<%=basePath%>shop/toAddShop.action">点击新增</a>
	<!-- 条件查询div -->
	<div id="whereBuild">
		<form>
		<table>
			<tbody>
				<tr>
					<td>店铺名称</td>
					<td><input id="storeName"/></td>
				</tr>
				<tr>
					<td>店铺公司名称</td>
					<td><input id="companyName"/></td>
				</tr>
				<tr>
					<td>店铺状态</td>
					<td>
						<label><input type="radio" name="storeStatus" value="1"/>正常</label>
						<label><input type="radio" name="storeStatus" value="0"/>关闭</label>
						<label><input type="radio" name="storeStatus" value="-1"/>不限</label>
					</td>
				</tr>
				<tr>
					<td>建立时间</td>
					<td>
						<input type="data" id="minCreateTime">
						<input type="data" id="maxCreateTime">
					</td>
				</tr>
				<tr>
					<td>关闭时间</td>
					<td>
						<input type="data" id="minCloseTime">
						<input type="data" id="maxCloseTime">
					</td>
				</tr>
			</tbody>
		</table>
		<input type="button" onclick="getData(1)" value="搜索">
		<input type="reset" value="重置">
		</form>
	</div>

	<!-- 表格数据 -->
	<div id="dataDiv">
		<jsp:include page="/WEB-INF/view/shop/shopPage.jsp"></jsp:include>
	</div>
</body>
</html>