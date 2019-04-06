<%--
  Created by IntelliJ IDEA.
  User: MYS
  Date: 2019/02/21
  Time: 16:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>用户注册</title>
    <jsp:include page="/common/script.jsp"></jsp:include>
    <script>
        function md5Password(){
            $("[type='password']").val(hex_md5($("[type='password']").val()));
            return true;
        }
    </script>
</head>
<body>
    <form action="<%=request.getContextPath()%>/user/addUser.action" method="post" onsubmit="return md5Password()">
        用户名：<input type="text" name="userName">
        密码：    <input type="password" name="userPassword">
        <input type="submit" value="注册">
        <input type="reset" value="重置">
    </form>
</body>
</html>
