<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <jsp:include page="/common/css.jsp"></jsp:include>
    <title>Insert title here</title>
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
            <a class="navbar-brand" href="/index.jsp">主页</a>
        </div>
        <!-- 主页div strat -->
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/product/toproductList.action">商品管理 <span
                        class="sr-only">(current)</span></a></li>
                <li><a href="/brand/toBrandList.action">品牌管理</a></li>
                <li><a href="/user/touserMangerPage.action">用户管理</a></li>
                <li class="active"><a href="javascript:window.location.reload();">日志查看</a></li>
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
        <h1>日志管理
            <small>欢迎您, ${user.userName}</small>
        </h1>
    </div>
</div>
<!-- 页面头div end -->

<div class="container">
    <form class="form-horizontal">
        <table class="table table-hover">
            <tr>
                <td>状态</td>
                <td>
                    <div class="col-md-1">
                        <label for="z" class="radio">
                            <input type="radio" id="z" name="status" value="-1"/><span>不限</span>
                        </label>
                    </div>
                    <div class="col-md-1">
                        <label for="x" class="radio">
                            <input type="radio" id="x" class="radio" name="status" value="1"/>成功
                        </label>
                    </div>
                    <div class="col-md-1">
                        <label for="c" class="radio">
                            <input type="radio" id="c" class="radio" name="status" value="0"/>失败
                        </label>
                    </div>
                </td>
            </tr>
            <tr>
                <td>操作时间</td>
                <td>
                    <div class="col-md-4 input-group">
                        <input type="text" id="minCreateTime" class="form_datetime form-control col-md-4"/>
                        <span class="input-group-addon">--</span>
                        <input id="maxCreateTime" class="form_datetime form-control col-md-4"/>
                    </div>




                </td>
            </tr>

        </table>
        <div class="btn-group">
            <input type="button" class="btn btn-default" value="查询" onclick="getData(1)">
            <input type="reset" class="btn btn-default" value="重置">
        </div>
    </form>

    <div id="dataPage">
        <table id="example" class="table table-striped table-bordered table-hover" style="width:100%">
            <tfoot>
            <tr>
                <th>编号</th>
                <th>用户名称</th>
                <th>操作信息</th>
                <th>状态</th>
                <th>耗时</th>
                <th>操作信息</th>
            </tr>
            </tfoot>
        </table>

    </div>
</div>
<jsp:include page="/common/script.jsp"></jsp:include>
<script type="text/javascript">
    $(function () {
        //getData();
        initTableLogs();
        //日期input框初始化
        initTime();
    })


    //日期input框初始化
    function initTime() {
        $(".form_datetime").datetimepicker({
            format: "yyyy-mm-dd hh:mm",
            autoclose: true,
            todayBtn: true,
            minuteStep: 10,
            todayBtn: 1,//显示‘今日’按钮
            language: 'zh-CN',
            weekStart: 1,
            todayHighlight: 1,
        });
    }


    //jquery datatable初始化
    var table;

    //jquery datatable表格函数初始化
    function initTableLogs() {
        //表格初始化
        table = $('#example').DataTable({
            "processing": true,
            "serverSide": true,
            //默认排序
            "order": [],
            "aoColumnDefs": [
                {
                    "bSortable": false,
                    "aTargets": []
                }],
            "ajax": {
                "url": "/logs/findLogsList.action",
                "type": "POST",
            },
            "type": "POST",
            "lengthMenu": [10, 15, 30],
            "language": {
                "url": "/common/datatable/Chinese.json",
            },
            "searching": false,
            "columns": [
                {"data": "id", "title": "编号"},
                {"data": "userName", "title": "用户名称"},
                {"data": "info", "title": "操作信息"},
                {"data": "status", "title": "状态"},
                {"data": "useTime", "title": "耗时"},
                {"data": "infoStr", "title": "操作信息"},
                {
                    "data": "createTime",
                    "title": "创建时间",
                    render: function (data, type, row, meta) {
                        if (data != null) {
                            var unixTimestamp = new Date(data);
                            commonTime = unixTimestamp.toLocaleString();
                            return commonTime;
                            11
                        }
                        return data;
                    }
                }
            ],
            /*"createdRow": function (row, data, dataIndex) {
                for (var i = 0; i < checkboxStauts.length; i++) {
                    if (data.id == checkboxStauts[i]) {
                        $(row).css("background-color", "#ccc");
                        var checkedNode = $(row).children(':first').children(':first').get(0);
                        checkedNode.checked = true;
                    }
                }
            }*/
        });
        /*点击事件*/
        /*$("#example tbody").on("click", "tr", function () {
            var checkedNode = $(this).children(':first').children(':first').get(0);
            if (!checkedNode.checked) {
                checkboxStauts.push(checkedNode.value);
                checkedNode.checked = true;
                $(this).css("background-color", "#ccc");
            } else {
                for (var i = 0; i < checkboxStauts.length; i++) {
                    if (checkboxStauts[i] == checkedNode.value) {
                        checkboxStauts.splice(i, 1);
                    }
                }
                $(this).css("background-color", "");
                checkedNode.checked = false;
            }
        });*/

        /*鼠标移上事件*/
        /*$("#example tbody").on("mouseover", "tr", function () {
            var checkedNode = $(this).children(':first').children(':first').get(0);
            if (!checkedNode.checked) {
                $(this).css("background-color", "#ddd");
            }
        });*/

        /*鼠标移除事件*/
        /*$("#example tbody").on("mouseout", "tr", function () {
            var checkedNode = $(this).children(':first').children(':first').get(0);
            if (!checkedNode.checked) {
                $(this).css("background-color", "");
            }
        });*/
    }


    //查询
    function getData(cpage) {
        table.settings()[0].ajax.data = {
            "pageIndex": cpage,
            "status": $("[name='status']:checked").val(),
            "minCreateTime": $("#minCreateTime").val(),
            "maxCreateTime": $("#maxCreateTime").val(),
            "minUpdateTime": $("#minUpdateTime").val(),
            "maxUpdateTime": $("#maxUpdateTime").val()
        }
        table.ajax.reload();
    }

</script>

</body>
</html>