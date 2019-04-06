<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="/common/css.jsp"></jsp:include>
    <title>主页</title>
</head>
<body>

    <!-- 导航条div strat -->
    <nav class="navbar navbar-default">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <!-- 主页div strat -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="active navbar-brand" href="/index.jsp">主页</a>
            </div>
            <!-- 主页div strat -->
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="/product/toproductList.action">商品管理 <span
                            class="sr-only">(current)</span></a></li>
                    <li><a href="/brand/toBrandList.action">品牌管理</a></li>
                    <li><a href="/user/touserMangerPage.action">用户管理</a></li>
                    <li><a href="/logs/tologsMangerPage.action">日志查看</a></li>
                </ul>
                <!-- 导航条右侧按钮ul start -->
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/login.jsp" class="glyphicon glyphicon-off">退出</a></li>
                    <%--<li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul>
                    </li>--%>
                </ul>
                <!-- 导航条右侧按钮ul end -->
            </div><!-- /.navbar-collapse -->

        </div><!-- /.container-fluid -->
    </nav>
    <!-- 导航条div end -->

    <!-- 页面头div strat -->
    <div class="container">
        <div class="page-header">
            <h1>主页
                <small><span>当前用户${user.userName},您之前是<fmt:formatDate value="${user.loginDate}"
                                                                      type="both"/>登录,您今天登陆了${user.loginCount}次</span>
                </small>
            </h1>
        </div>
    </div>
    <!-- 页面头div end -->

    <div class="container" style="height: 100px">
        <div class="row">
            <div class="col-md-2">

                <h2>Hello World!</h2>
            </div>
        </div>
        <br />
        <a href="<%=request.getContextPath()%>/shop/findShopList.action">店铺跳转</a>
        <a href="<%=request.getContextPath()%>/brand/toBrandList.action">品牌跳转</a>
        <a href="<%=basePath%>logs/findLogsList.action">日志跳转</a>
        <a href="<%=basePath%>product/toproductList.action">产品跳转</a>
        <a href="<%=basePath%>dept/todeptList.action">部门跳转</a>

    </div>
    <jsp:include page="/common/script.jsp"></jsp:include>
</body>
</html>
