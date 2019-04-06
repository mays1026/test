<%--
  Created by IntelliJ IDEA.
  User: MYS
  Date: 2019/03/02
  Time: 16:04
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
    <title>Title</title>
    <jsp:include page="/common/css.jsp"></jsp:include>
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
                <li class="active"><a href="javascript:window.location.reload();">用户管理</a></li>
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

<!-- 页面 -->
<div class="container-fluid">

    <!-- 页面头div strat -->
    <div class="container">
        <div class="page-header">
            <h1>用户管理
                <small>欢迎您, ${user.userName}</small>
            </h1>
        </div>
    </div>
    <!-- 页面头div end -->

    <div class="container">
        <div class="col-md-4">
        <!-- 左侧dept ztree树 div strat -->
        <div class="col-md-12">
            <div class="panel panel-primary">
                <!-- 按钮div start-->
                <div class="panel-heading">
                    <div class="container-fluid">
                        <div class="col-md-4"></div>
                        <div class="btn-group" role="toolbar" aria-label="...">
                            <button type="button" onclick="addDeptDivShow()" class="btn btn-info dropdown-toggle"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                            <span class="glyphicon glyphicon-plus">添加信息</span>
                            <button type="button" onclick="updateDeptData();"
                                    class="btn btn-warning dropdown-toggle show-alert"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                            <span class="glyphicon glyphicon-remove">修改信息</span>
                            <button type="button" onclick="deleteDeptDate();"
                                    class="btn btn-danger dropdown-toggle show-alert"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                            <span class="glyphicon glyphicon-remove">删除信息</span>
                        </div>
                    </div>
                </div>
                <!--批量删除导出excel end-->
                <!-- ztree start-->
                <div class="panel-body">
                    <ul id="tree" class="ztree" style="overflow:auto;"></ul>
                </div>
                <!-- ztree end-->
            </div>

        </div>
        <!-- 左侧dept ztree树 div end -->

        <!-- 左侧area ztree树 div strat -->
        <div class="col-md-12">
            <div class="panel panel-primary">
                <!-- 按钮div start-->
                <div class="panel-heading">
                    <div class="container-fluid">
                        <div class="col-md-4"></div>
                        <div class="btn-group" role="toolbar" aria-label="...">
                            <button type="button" onclick="addAreaDivShow()" class="btn btn-info dropdown-toggle"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                            <span class="glyphicon glyphicon-plus">添加信息</span>
                            <button type="button" onclick="updateAreaData();"
                                    class="btn btn-warning dropdown-toggle show-alert"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                            <span class="glyphicon glyphicon-remove">修改信息</span>
                            <button type="button" onclick="deleteAreaDate();"
                                    class="btn btn-danger dropdown-toggle show-alert"
                                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                            <span class="glyphicon glyphicon-remove">删除信息</span>
                        </div>
                    </div>
                </div>
                <!--批量删除导出excel end-->
                <!-- ztree start-->
                <div class="panel-body">
                    <ul id="areazTree" class="ztree" style="overflow:auto;"></ul>
                </div>
                <!-- ztree end-->
            </div>

        </div>
        <!-- 左侧area ztree树 div end -->
        </div>
        <!-- 右侧表格数据 div strat -->
        <div class="col-md-8">


            <div class="panel panel-primary">
                <!--用户 按钮div -->
                <div class="page-header">
                    <!-- 用户增删改按钮div start-->
                    <div class="panel-heading">
                        <div class="container-fluid">
                            <div class="col-md-7"></div>
                            <div class="btn-group" role="toolbar" aria-label="...">
                                <button type="button" onclick="toShowAddUserDiv()" class="btn btn-info dropdown-toggle"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                                <span class="glyphicon glyphicon-plus">添加用户</span>
                                <button type="button" onclick="updateUserDate()"
                                        class="btn btn-warning dropdown-toggle show-alert"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                                <span class="glyphicon glyphicon-remove">修改用户</span>
                                <button type="button" onclick="deleteAllUserInfo();"
                                        class="btn btn-danger dropdown-toggle show-alert"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                                <span class="glyphicon glyphicon-remove">删除用户</span>
                                <button type="button" onclick="replaceDept();"
                                        class="btn btn-warning dropdown-toggle show-alert"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                                <span class="glyphicon glyphicon-remove">批量更换部门</span>
                                <button type="button" onclick="exportExcelWhereDept();"
                                        class="btn btn-warning dropdown-toggle show-alert"
                                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"/>
                                <span class="glyphicon glyphicon-remove">导出Excel</span>
                            </div>
                        </div>
                    </div>
                    <!--用户增删改按钮div end-->

                </div>

                <!-- jquery datatable表格数据 div strat -->
                <table id="example" class="table table-striped table-bordered table-hover" style="width:100%">

                </table>
                <!-- jquery datatable表格数据 div end -->
            </div>
        </div>
        <!-- 右侧表格数据 div end -->
    </div>
</div>


<!-- 添加dept div strat -->
<div id="addShowDiv" class="container">
    <input type="hidden" id="deptPid"/>
    <form class="form-horizontal" id="whereForm">
        <div class="form-group">
            <label class="col-md-2 control-label">deptName</label>
            <div class="col-md-4 input-group">
                <span class="input-group-addon">--</span>
                <input type="text" class="form-control inputdate" id="deptName"
                       aria-describedby="basic-addon3">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">deptRemark</label>
            <div class="col-md-4 input-group">
                <span class="input-group-addon">--</span>
                <textarea style="resize: none;" class="form-control" id="deptRemark"></textarea>
            </div>
        </div>
    </form>
</div>
<!-- 添加dept div end -->

<!-- 修改dept div strat -->
<div id="edit_showDiv" class="container">
    <input type="hidden" id="edit_deptid" value="0">
    <form class="form-horizontal" id="edit_whereForm">
        <div class="form-group">
            <label class="col-md-2 control-label">edit_deptName</label>
            <div class="col-md-4 input-group">
                <span class="input-group-addon">--</span>
                <input type="text" class="form-control inputdate" id="edit_deptName">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">deptRemark</label>
            <div class="col-md-4 input-group">
                <span class="input-group-addon">--</span>
                <textarea style="resize: none;" class="form-control" id="edit_deptRemark"></textarea>
            </div>
        </div>
    </form>
</div>
<!-- 修改dept div end -->

<!-- 添加user div strat -->
<div id="addUserShowDiv">
    <form class="form-horizontal" id="userWhereForm">
        <input type="hidden" id="userDeptId" name="deptId">
        <div class="form-group">
            <label class="col-md-2 control-label">ztree部门</label>
            <div class="col-md-4 input-group">
                <input type="text" id="user_deptName">
                <button type="button" onclick="initZtreeClone();" class="btn btn-info">
                    <span class="glyphicon glyphicon-th-large"></span>
                </button>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">userName</label>
            <div class="col-md-4 input-group">
                <span class="input-group-addon">--</span>
                <input type="text" class="form-control" id="userName">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">userPassword</label>
            <div class="col-md-4 input-group">
                <span class="input-group-addon">--</span>
                <input type="password" class="form-control" id="userPassword">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">userRealName</label>
            <div class="col-md-4 input-group">
                <span class="input-group-addon">--</span>
                <input id="userRealName" style="resize: none;" class="form-control"></input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">salary</label>
            <div class="col-md-4 input-group">
                <span class="input-group-addon">--</span>
                <input style="resize: none;" class="form-control" id="salary"></input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">birthday</label>
            <div class="col-md-4 input-group">
                <input style="resize: none;" class="form-control inputdate" name="birthday" id="birthday"></input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">headImage</label>
            <div class="col-md-4 input-group">
                <input type="file" class="form-control" name="uploadFile" id="headImage"></input>
                <input type="hidden" class="form-control" name="imagePath" id="imagePath"></input>
                <input type="hidden" class="form-control" name="oldImagePath" id="oldImagePath"></input>
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-2 control-label">sex</label>
            <div class="col-md-4">
                <div class="radio">
                    <label>
                        <input type="radio" name="sex" id="optionsRadios1" value="1">
                        <span class="glyphicon glyphicon-user">男</span>
                    </label>
                </div>
                <div class="radio">
                    <label>
                        <input type="radio" name="sex" id="optionsRadios2" value="0">
                        <span class="glyphicon glyphicon-user">女</span>
                    </label>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- 添加user div end -->

<div id="ztreeDiv" class="ztree" style="overflow:auto;"></div>

<div id="addAreaShowDiv">
    <input id="areaName" type="text">
</div>


<!-- jquery -->
<script src="/js/DataTables-1.10.15/jQuery-3.3.1/jquery-3.3.1.min.js"></script>
<%--<script src="/js/bootbox/popper.js"></script>--%>
<jsp:include page="/common/script.jsp"></jsp:include>

<script>
    var table;
    //添加用户时初始化上面的ztree弹出框 ztree对象
    var zTreeObject;
    var dialogs;
    $(function () {
        initDate();
        // initFileInput();
        //表格初始化
        initTable();
        initTableClickChangeColor();
        //初始化dept ztree
        initDeptList();
        //initZtree();
        initAreaList();
        $("#addShowDiv").hide();
        $("#edit_showDiv").hide();
        $("#addUserShowDiv").hide();
    });

    //文件上传
    function initFileInput(obj) {
        $("#headImage", obj).fileinput({
            language: 'zh', //设置语言
            uploadUrl: "/product/fileInput.action", //上传的地址
            allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
            //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
            uploadAsync: true, //默认异步上传
            showUpload: true, //是否显示上传按钮
            showRemove: true, //显示移除按钮
            showPreview: true, //是否显示预览
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            dropZoneEnabled: false,//是否显示拖拽区域
            maxFileCount: 10, //表示允许同时上传的最大文件个数
            enctype: 'multipart/form-data',
            validateInitialCount: true,
            previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        })

        //上传成功后的 回调函数
        $('#headImage', obj).on('fileuploaded', function(event, data) {
            var imagePath = [];
            imagePath.push(data.response.data);
            $("#imagePath", obj).val(imagePath.join(","));
        })
    }
    //表格初始化
    function initTable() {
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
                "url": "/user/findUserList.action",
                "type": "POST",
            },
            "type": "POST",
            "lengthMenu": [10, 15, 30],
            "language": {
                "url": "/common/datatable/Chinese.json",
            },
            "searching": false,
            "columns": [
                {
                    "data": "id", "title": "选择",
                    render: function (data, type, row, meta) {
                        return "<input type='checkbox' value='" + data + "'/>";
                    }
                },
                {"data": "id", "title": "编号"},
                {"data": "userName", "title": "用户名称"},
                {"data": "imagePath", "title": "用户名称",
                    render:function(data){
                        if (data != null) {
                            return "<img src='"+data+"' style = 'width: 50px;'/>";
                        }
                        return null;
                    }
                },
                {"data": "industryTitle", "title": "所属部门"},
                {
                    "data": "loginDate",
                    "title": "登陆时间",
                    "render": function (data, type, row, meta) {
                        if (data != null) {
                            var unixTimestamp = new Date(data);
                            commonTime = unixTimestamp.toLocaleString();
                            return commonTime;
                        }
                        return data;
                    }
                },
                {
                    "data": "stauts",
                    "title": "操作",
                    "render": function (data, type, row, meta) {
                        if (data == 0) {
                            return "无需操作";
                        }
                        return "<button class='btn btn-info' onclick=\'unlockUser(" + row.id + ")\';>解锁用户</button>"
                    }
                }
            ]
        });
    }

    //解锁用户
    function unlockUser(id) {
        $.ajax({
            url: "/user/unlockUser.action",
            data: {
                "id": id
            },
            success: function () {
                table.ajax.reload();
            }
        });
    }

    var zTreeObj;
    //ztree初始化配置
    var setting = {
        data: {
            simpleData: {
                enable: true,
                pIdKey: "pId",
            },
            key: {
                name: "name",
            }
        },
        check: {
            enable: true,
            chkboxType: {"Y": "ps", "N": "ps"}
        },
        callback: {
            onClick: zTreeOnClick //ztree点击事件回调函数
        }

    };

    //add dept 添加弹框div
    function addDeptDivShow() {
        var dialog = bootbox.dialog({
            title: 'A custom dialog with buttons and callbacks',
            message: $("#addShowDiv").html(),
            size: 'large',
            buttons: {
                cancel: {
                    label: "取消",
                    className: 'btn-danger',
                    callback: function () {
                    }
                },
                ok: {
                    label: "提交",
                    className: 'btn-info',
                    callback: function () {
                        $.ajax({
                            url: "/dept/addDeptInfo.action",
                            type: "post",
                            data: {
                                "industryTitle": $("#deptName", dialog).val(),
                                "remark": $("#deptRemark", dialog).val(),
                                "pid": $("#deptPid", dialog).val(),
                            },
                            success: function (data) {
                                if (data.code == 200) {
                                    var newNode = {
                                        id: data.data,
                                        name: $("#deptName", dialog).val(),
                                        pId: $("#deptPid", dialog).val(),
                                        remark: $("#deptRemark", dialog).val()
                                    }
                                    var selectedNode = zTreeObj.getSelectedNodes()[0];
                                    zTreeObj.addNodes(selectedNode, newNode);
                                } else {
                                    alert("失败");
                                }
                            }
                        })
                    }
                }
            }
        });
    }

    //添加用户时选择部门
    function initZtreeClone() {
        $.ajax({
            url: "/dept/initDeptList.action",
            type: "post",
            dataType: "json",
            success: function (data) {
                var settings = {
                    data: {
                        simpleData: {
                            enable: true,
                            pIdKey: "pId",
                        },
                        key: {
                            name: "name",
                        }
                    },
                    check: {
                        enable: true,
                        chkboxType: {"Y": "ps", "N": "ps"}
                    },
                    callback: {
                        onClick: zTreeObjectOnClick //ztree点击事件回调函数
                    }

                };
                //初始化ztree
                $("#ztreeDiv").html("<ul id=\"ztreeUl\" class=\"ztree\" style=\"overflow:auto;\"></ul>")
                zTreeObject = $.fn.zTree.init($("#ztreeUl"), settings, data);
                dialogs = bootbox.dialog({
                    title: 'A',
                    message: $("#ztreeUl"),
                    buttons: {
                        cancel: {
                            label: "取消",
                            className: 'btn-danger',
                            callback: function () {
                                // Example.show('Custom cancel clicked');
                                // console.log($("#deptName", dialog).val());
                            }
                        },
                        ok: {
                            label: "提交",
                            className: 'btn-info',
                            callback: function () {
                            }
                        }
                    }
                });
            }
        });
    }

    //添加用户 addUser
    function toShowAddUserDiv() {
        var addUserDiv = $("#addUserShowDiv").clone(true);
        $("#userWhereForm", addUserDiv).get(0).reset();
        addUser_dialog = bootbox.dialog({
            title: 'A custom dialog with buttons and callbacks',
            message: addUserDiv.html(),
            size: 'large',
            buttons: {
                cancel: {
                    label: "取消",
                    className: 'btn-danger',
                    callback: function () {
                    }
                },
                ok: {
                    label: "提交",
                    className: 'btn-info',
                    callback: function () {
                        $.ajax({
                            url: "/user/addUser.action",
                            type: "post",
                            data: {
                                "userName": $("#userName", addUser_dialog).val(),
                                "userRealName": $("#userRealName", addUser_dialog).val(),
                                "birthday": $("#birthday", addUser_dialog).val(),
                                "sex": $("[name='sex']:checked", addUser_dialog).val(),
                                "deptId": $("#userDeptId", addUser_dialog).val(),
                                "salary": $("#salary", addUser_dialog).val(),
                                "imagePath": $("#imagePath", addUser_dialog).val(),
                                "userPassword": hex_md5($("#userPassword", addUser_dialog).val())
                            },
                            dataType: "json",
                            success: function (data) {
                                if (data.code == 200) {
                                    alert("添加成功");
                                    table.ajax.reload();
                                } else {
                                    alert("添加失败")
                                }
                            }
                        })
                    }
                }
            }
        });
        initFileInput(addUser_dialog);
    }

    //修改 dept
    function updateDeptData() {
        // 获取当前选中节点
        var theCurrent = zTreeObj.getSelectedNodes()[0];
        $("#edit_deptName").attr("value", theCurrent.name);
        $("#edit_deptRemark").text(theCurrent.remark);
        var dialog = bootbox.dialog({
            title: 'A custom dialog with buttons and callbacks',
            message: $("#edit_showDiv").html(),
            size: 'large',
            buttons: {
                cancel: {
                    label: "取消",
                    className: 'btn-danger',
                    callback: function () {
                         // Example.show('Custom cancel clicked');
                        // console.log($("#deptName", dialog).val());
                    }
                },
                ok: {
                    label: "提交",
                    className: 'btn-info',
                    callback: function () {
                        $.ajax({
                            url: "/dept/updateDeptInfo.action",
                            type: "post",
                            data: {
                                "id": theCurrent.id,
                                "industryTitle": $("#edit_deptName", dialog).val(),
                                "remark": $("#edit_deptRemark", dialog).val(),
                                "pid": theCurrent.pId,
                            },
                            success: function (data) {
                                if (data.code == 200) {
                                    // var nodeIndex = zTreeObj.getNodeIndex(theCurrent);
                                    theCurrent.name = $("#edit_deptName", dialog).val();
                                    theCurrent.remark = $("#edit_deptRemark", dialog).val();
                                    zTreeObj.updateNode(theCurrent);
                                } else {
                                    alert("失败");
                                }
                            }
                        })
                    }
                }
            }
        });
    }

    //删除节点 dept
    function deleteDeptDate() {
        var theCurrent = zTreeObj.getSelectedNodes();
        /*var ids = theCurrent.id + "," + joinTreeNodeIds(theCurrent, "");*/
        var toArray = zTreeObj.transformToArray(zTreeObj.getSelectedNodes());
        var ids = [];
        for (var i = 0; i < toArray.length; i++) {
            ids.push(toArray[i].id);
        }
        console.log(ids)
        $.ajax({
            url: "/dept/deleteDeptInfo.action",
            type: "post",
            data: {
                "ids": ids
            },
            dataType: "json",
            success: function (data) {
                if (data.code == 200) {
                    alert("删除成功！")
                    for (var i = 0; i < theCurrent.length; i++) {
                        zTreeObj.removeNode(theCurrent[i]);
                    }
                } else {
                    alert(data.message)
                }
            }
        })
    }

    //获取dept数据
    function initDeptList() {
        $.ajax({
            url: "/dept/initDeptList.action",
            type: "post",
            dataType: "json",
            success: function (data) {
                //初始化ztree
                zTreeObj = $.fn.zTree.init($("#tree"), setting, data);
            }
        })
    }

    var deptIds = [];

    //ztree点击事件回调函数
    function zTreeOnClick(event, treeId, treeNode) {
        // 每次初始化deptids数组
        deptIds = [];
        $("#deptPid").val(treeNode.id);
        var toArray = zTreeObj.transformToArray(zTreeObj.getSelectedNodes());
        for (var i = 0; i < toArray.length; i++) {
            deptIds.push(toArray[i].id);
        }
        //查询
        getDate();
    };

    //查询数据库
    function getDate() {
        table.settings()[0].ajax.data = {
            "ids": deptIds
        }
        table.ajax.reload();
    }

    //拼接子节点ids
    function joinTreeNodeIds(theCurrent, treeNodeids) {
        if (theCurrent.isParent) {
            var childrenNodes = theCurrent.children;
            if (childrenNodes) {
                for (var i = 0; i < childrenNodes.length; i++) {
                    treeNodeids += childrenNodes[i].id + ",";
                    treeNodeids = joinTreeNodeIds(childrenNodes[i], treeNodeids);
                }
            }
        }
        return treeNodeids;
    }

    //弹出ztree时点击ztree的回调函数
    function zTreeObjectOnClick(event, treeId, treeNode) {
        // console.log(treeNode.id)
        $("#userDeptId", addUser_dialog).attr("value", treeNode.id);
        $("#user_deptName", addUser_dialog).attr("value", treeNode.name);
    }

    // 删除用户
    function deleteAllUserInfo() {
        if (checkboxStauts.length > 0) {
            $.ajax({
                url: "/user/deleteAllUserInfo.action",
                type: "post",
                data: {
                    "ids": checkboxStauts
                },
                dataType: "json",
                success: function (data) {
                    if (data.code == 200) {
                        table.ajax.reload();
                    } else {
                        alert(data.message);
                    }
                }
            })
        }
    }

    //修改用户
    function updateUserDate() {
        console.log(rowData.id);
        $("#deptPid").attr("value", rowData.id);
        $("#user_deptName").attr("value", rowData.industryTitle);
        $("#userName").attr("value", rowData.userName);
        $("#userRealName").attr("value", rowData.userName);
        $("#birthday").attr("value", rowData.birthday);
        $("[name='sex']").each(function () {
            if ($(this).val() == rowData.sex) {
                $(this).attr("checked", true);
            }
        });
        $("#userDeptId").attr("value", rowData.userDeptId);
        $("#salary").attr("value", rowData.salary);
        $("#imagePath").attr("value", rowData.imagePath);
        $("#oldImagePath").attr("value", rowData.imagePath);
        var addUserDiv = $("#addUserShowDiv").clone(true);
        $("#userWhereForm", addUserDiv)[0].reset();
        addUser_dialog = bootbox.dialog({
            title: 'A custom dialog with buttons and callbacks',
            message: addUserDiv.html(),
            size: 'large',
            buttons: {
                cancel: {
                    label: "取消",
                    className: 'btn-danger',
                    callback: function () {
                    }
                },
                ok: {
                    label: "提交",
                    className: 'btn-info',
                    callback: function () {
                        $.ajax({
                            url: "/user/updateUserInfo.action",
                            type: "post",
                            data: {
                                "id": rowData.id,
                                "deptPid": $("#deptPid").val(),
                                "industryTitle": $("#user_deptName").val(),
                                "userName": $("#userName", addUser_dialog).val(),
                                "userRealName": $("#userRealName", addUser_dialog).val(),
                                "birthday": $("#birthday", addUser_dialog).val(),
                                "sex": $("[name='sex']:checked", addUser_dialog).val(),
                                "deptId": $("#userDeptId", addUser_dialog).val(),
                                "salary": $("#salary", addUser_dialog).val(),
                                "userPassword": hex_md5($("#userPassword", addUser_dialog).val()),
                                "imagePath": $("#imagePath", addUser_dialog).attr("value"),
                                "oldImagePath": $("#oldImagePath", addUser_dialog).attr("value")
                            },
                            dataType: "json",
                            success: function (data) {
                                if (data.code == 200) {
                                    alert("成功");
                                    table.ajax.reload();
                                } else {
                                    alert("失败")
                                }
                            }
                        })
                    }
                }
            }
        });
        initOldFileInput(addUser_dialog);
    }

    function initOldFileInput(obj) {
        $("#headImage", obj).fileinput({
            language: 'zh', //设置语言
            uploadUrl: "/product/fileInput.action", //上传的地址
            allowedFileExtensions: ['jpg', 'gif', 'png'],//接收的文件后缀
            //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
            uploadAsync: true, //默认异步上传
            showUpload: true, //是否显示上传按钮
            showRemove: true, //显示移除按钮
            showPreview: true, //是否显示预览
            showCaption: false,//是否显示标题
            browseClass: "btn btn-primary", //按钮样式
            dropZoneEnabled: false,//是否显示拖拽区域
            maxFileCount: 10, //表示允许同时上传的最大文件个数
            enctype: 'multipart/form-data',
            validateInitialCount: true,
            previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        })

        //上传成功后的 回调函数
        $('#headImage', obj).on('fileuploaded', function(event, data) {
            var imagePath = [];
            imagePath.push(data.response.data);
            $("#imagePath", obj).val(imagePath.join(","));
        })
    }

    //批量更换部门
    function replaceDept() {
        if (checkboxStauts.length > 0) {
            $.ajax({
                url: "/dept/initDeptList.action",
                type: "post",
                dataType: "json",
                success: function (result) {
                    //初始化ztree
                    var settings = {
                        data: {
                            simpleData: {
                                enable: true,
                                pIdKey: "pId",
                            },
                            key: {
                                name: "name",
                            }
                        },
                        check: {
                            enable: true,
                            chkboxType: {"Y": "ps", "N": "ps"}
                        },
                        callback: {
                            onClick: replaceZtreeOnclick //ztree点击事件回调函数
                        }

                    };
                    $("#ztreeDiv").html("<ul id=\"ztreeReplaceZtree\" class=\"ztree\" style=\"overflow:auto;\"></ul>")
                    var replaceZtree = $.fn.zTree.init($("#ztreeReplaceZtree"), settings, result);
                    bootbox.dialog({
                        title: 'A custom dialog with buttons and callbacks',
                        message: $("#ztreeDiv ul"),
                        size: 'large',
                        buttons: {
                            cancel: {
                                label: "取消",
                                className: 'btn-danger',
                                callback: function () {
                                    deptId = "";
                                }
                            },
                            ok: {
                                label: "提交",
                                className: 'btn-info',
                                callback: function () {
                                    $.ajax({
                                        url: "/user/updateUserDept.action",
                                        type: "post",
                                        data: {
                                            "userIds": checkboxStauts,
                                            "deptId": deptId
                                        },
                                        dataType: "json",
                                        success: function (data) {
                                            if (data.code == 200) {
                                                getDate();
                                            } else {
                                                alert(data.message)
                                            }
                                        }
                                    })
                                }
                            }
                        }
                    });
                }
            })
        }
    }

    var deptId;
    //
    function replaceZtreeOnclick(event, treeId, treeNode) {
        deptId = treeNode.id;
    }

    //导出Excel
    function exportExcelWhereDept() {
        location.href="/user/exportExcelWhereDept.action?deptId="+$("#deptPid").val();
    }

    var areazTree;
    // 初始化area ztree树
    function initAreaList() {
        $.ajax({
            url:"/area/initAreaList.action",
            type:"post",
            dataType:"json",
            success:function(data) {
                var settings = {
                    data: {
                        simpleData: {
                            enable: true,
                            pIdKey: "pId",
                        },
                        key: {
                            name: "name",
                        }
                    },
                    check: {
                        enable: true,
                        chkboxType: {"Y": "ps", "N": "ps"}
                    },
                    callback: {
                        onClick: areaZtreeOnClick//ztree点击事件回调函数
                    }
                };
                //初始化ztree
                areazTree = $.fn.zTree.init($("#areazTree"), settings, data.data);
            }
        })
    }

    var areaZtreeId;
    // areaZtree 点击事件
    function areaZtreeOnClick(event, treeId, treeNode) {
        areaZtreeId = treeNode.id;
        console.log(areaZtreeId)
    }

    //弹出添加地区 div
    function addAreaDivShow() {
        var areaDiv = bootbox.dialog({
            title: 'A custom dialog with buttons and callbacks',
            message: $("#addAreaShowDiv").html(),
            size: 'large',
            buttons: {
                cancel: {
                    label: "取消",
                    className: 'btn-danger',
                    callback: function () {
                    }
                },
                ok: {
                    label: "提交",
                    className: 'btn-info',
                    callback: function () {
                        $.ajax({
                            url: "/area/addAreaInfo.action",
                            type: "post",
                            data: {
                                "areaname": $("#areaName", areaDiv).val(),
                                "parentid": areaZtreeId,
                            },
                            success: function (data) {
                                if (data.code == 200) {
                                    var newNode = {
                                        id: data.data,
                                        name: $("#areaName", areaDiv).val(),
                                        pId: areaZtreeId
                                    }
                                    var selectedNode = areazTree.getSelectedNodes()[0];
                                    areazTree.addNodes(selectedNode, newNode);
                                } else {
                                    alert("失败");
                                }
                            }
                        })
                    }
                }
            }
        });
    }

    //删除 area信息
    function deleteAreaDate() {
        $.ajax({
            url:"/area/deleteAreaById.action",
            type:"post",
            dataType:"json",
            data:{
                "id":areaZtreeId
            },
            success:function(data) {
                if (data.code == 200){
                    alert("成功")
                } else {
                    alert(data.message)
                }
            }
        })
    }

    //修改信息
    function updateAreaData() {
        // 获取当前选中节点
        var theCurrent = areazTree.getSelectedNodes()[0];
        $("#areaName").attr("value", theCurrent.name);
        // console.log(theCurrent)
        var userDiv = bootbox.dialog({
            title: '修改信息',
            message: $("#addAreaShowDiv").html(),
            size: 'large',
            buttons: {
                cancel: {
                    label: "取消",
                    className: 'btn-danger',
                    callback: function () {
                    }
                },
                ok: {
                    label: "提交",
                    className: 'btn-info',
                    callback: function () {
                        $.ajax({
                            url: "/area/updateAreaData.action",
                            type: "post",
                            data: {
                                "id": theCurrent.id,
                                "areaname": $("#areaname", userDiv).val()
                            },
                            success: function (data) {
                                if (data.code == 200) {
                                    // var nodeIndex = zTreeObj.getNodeIndex(theCurrent);
                                    theCurrent.name = $("#areaName", userDiv).val();
                                    areazTree.updateNode(theCurrent);
                                } else {
                                    alert("失败");
                                }
                            }
                        })
                    }
                }
            }
        });
    }

</script>
</body>
</html>
