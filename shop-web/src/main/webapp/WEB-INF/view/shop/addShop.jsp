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
</head>
<body>
	<form action="<%=basePath%>shop/addShop.action" method="post">
	<table>
			<tbody>
				<tr>
					<td>店铺名称</td>
					<td><input name="storeName"/></td>
				</tr>
				<tr>
					<td>店铺公司名称</td>
					<td><input name="companyName"/></td>
				</tr>
				<tr>
					<td>店铺状态</td>
					<td>
						<label><input type="radio" name="storeStatus" value="1"/>正常</label>
						<label><input type="radio" name="storeStatus" value="0"/>关闭</label>
					</td>
				</tr>
				<tr>
					<td>关闭时间</td>
					<td>
						<input type="data" name="closeTime">
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" value="提交" tabindex="3">
		<input type="reset" value="重置">
	</form>
</body>
<script type="text/javascript" src="<%=basePath%>js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="<%=basePath%>My97DatePicker/WdatePicker.js"></script>
<script type="text/javascript">
	
	//给my97的input框绑定事件
	$(function(){
		$("input[type='data']").each(function(){
			$(this).attr("class", "Wdate");
			$(this).bind({
				click:function(){
					WdatePicker({el:this,dateFmt:'yyyy-MM-dd'});
				}
			});
		});
	});
</script>
</html>