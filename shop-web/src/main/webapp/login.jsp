<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- bootstrap引入要求 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 引入css -->
    <link rel="stylesheet" href="/js/bootstrap-3.3.7-dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/js/DataTables-1.10.15/media/css/dataTables.bootstrap.min.css"/>
    <link rel="stylesheet" href="/js/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css">
    <!-- 网页标题栏 -->
    <title>Insert title here</title>
</head>
<body onload="onkey()">
<div class="container">
    <!-- 页面头div strat -->
    <div class="container">
        <div class="page-header">
            <h1>你好，
                <small>请进行登陆</small>
            </h1>
        </div>
    </div>
    <!-- 页面头div end -->


    <form class="form-horizontal">
        <div class="form-group">
            <label for="userName" class="col-md-2 control-label">用户名：</label>
            <div class="col-md-4">
                <input type="text" class="form-control" id="userName" name="userName"><br/>
            </div>
        </div>
        <div class="form-group">
            <label for="userPassword" class="col-md-2 control-label">密码： </label>
            <div class="col-md-4">
                <input type="password" class="form-control" id="userPassword" name="userPassword"><br/>
            </div>
        </div>
        <div class="form-group">
            <label for="imgCode" class="col-md-2 control-label">验证码： </label>
            <div class="col-md-4">
                <div class="col-md-6" style="margin-left: -15px">
                    <input class="form-control col-md-2" type="text" id="imgCode" name="imgCode">
                </div>
                <span class="col-md-2">
			        <img src="<%=request.getContextPath()%>/imgCode" alt="点击刷新" onclick="resetImgCode()">
		        </span><br/>
            </div>
        </div>
        <div class="form-group">
            <label for="zzz" class="col-md-2 control-label"></label>
            <div id="zzz">
                <input type="button" id="loginButton" class="btn btn-default" value="登录" onclick="userLogin()">
                <input type="reset" class="btn btn-default" value="重置">
                <a href="javaScript:toaddUser();">还没有账户？点击注册</a>
            </div>
        </div>
    </form>

</div>
<!-- 引入js -->
<script src="/js/DataTables-1.10.15/jQuery-3.3.1/jquery-3.3.1.min.js"></script>
<script src="/js/md5.js"></script>
<%--<script src="/js/bootbox/popper.js"></script>--%>
<script src="/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script src="/js/DataTables-1.10.15/media/js/jquery.dataTables.min.js"></script>
<script src="/js/DataTables-1.10.15/media/js/dataTables.bootstrap.min.js"></script>
<script src="/js/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.min.js"></script>
<script src="/js/bootstrap-datetimepicker-master/js/locales/bootstrap-datetimepicker.zh-CN.js"></script>
<script src="/js/bootbox/bootbox.min.js"></script>
<script src="/js/bootbox/bootbox.locales.min.js"></script>
<script src="/js/shop/shop.js"></script>
<script type="text/javascript">


    function onkey() {
        $(document).keypress(function(e) {
            if((e.keyCode || e.which)==13) {
                $("#loginButton").click();  //login_btn登录按钮的id
            }
        });
    }

    function userLogin() {
        $.ajax({
            url: "/user/login.action",
            type: "post",
            data: {
                "userName": $("[name='userName']").val(),
                "userPassword": hex_md5($("[name='userPassword']").val()),
                "imgCode": $("[name='imgCode']").val()
            },
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    location.href = "/product/toproductList.action"
                } else {
                    alert(data.message);
                    resetImgCode();
                }
            }
        })
    }

    function resetImgCode() {
        $("span img").attr("src", "<%=request.getContextPath()%>/imgCode?r=" + new Date());
    }

    function toaddUser() {
        location.href = "<%=request.getContextPath()%>/addUser.jsp"
    }

</script>

</body>
</html>