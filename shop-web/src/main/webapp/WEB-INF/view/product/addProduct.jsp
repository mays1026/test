<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/common/css.jsp"></jsp:include><!-- 网页标题栏 -->
    <title>Title</title>
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
                <li class="active"><a href="javascript:window.location.reload();">商品管理 <span
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
        <h1>商品添加
            <small>欢迎您, ${user.userName}</small>
        </h1>
    </div>
</div>
<!-- 页面头div end -->

<div class="container">
    <form class="form-horizontal">
        <input type="hidden" name="imagePath" id="imagePath">
        <input type="hidden" name="imgPath" id="imgPath">
        <table class="table table-bordered table-hover">
            <tbody>
            <tr>
                <td>名称</td>
                <td><input name="productName"/></td>
            </tr>
            <tr>
                <td>品牌</td>
                <td>
                    <select id="brandId" name="brandId.id">
                        <option value="-1">==请选择==</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>所属店铺</td>
                <td>
                    <select id="shopId" name="shopId.id">
                        <option value="-1">==请选择==</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>成本价</td>
                <td><input name="costPrice"/></td>
            </tr>
            <tr>
                <td>销售价</td>
                <td><input name="marketPrice"/></td>
            </tr>
            <tr>
                <td>库存</td>
                <td><input name="repertory"/></td>
            </tr>
            <tr>
                <td>是否推荐</td>
                <td>
                    <label><input type="radio" name="recommend" value="0"/>否</label>
                    <label><input type="radio" name="recommend" value="1"/>是</label>
                </td>
            </tr>
            <tr>
                <td>选择主图片</td>
                <td>
                    <input id="uploadfile" type="file" multiple="multiple">

                </td>
            </tr>
            <tr name="data-file">
                <td>选择附图片</td>
                <td>
                    <input id="uploadfileImage" type="file" multiple="multiple">
                </td>
            </tr>
            </tbody>
        </table>
        <div class="panel-heading">
            <div class="container-fluid">
                <div class="col-md-9"></div>
                <div class="btn-group" role="toolbar">
                    <button type="submit" class="btn btn-info dropdown-toggle">
                        <span class="glyphicon glyphicon-plus">添加信息</span></button>
                    <button type="reset" class="btn btn-info dropdown-toggle"
                            data-toggle="dropdown">
                        <span class="glyphicon glyphicon-alert">重置</span></button>
                </div>
            </div>
        </div>
    </form>


</div>

<!-- 引入js文件 -->
<jsp:include page="/common/script.jsp"></jsp:include>
<script type="text/javascript">

    var imagePath = [];
    var imgPath = [];
    $(function () {
        initBrandList(-1);
        //initShopList();
        initFileInput();
        initFileImageInput();
    });

    function initFileInput() {
        $("#uploadfile").fileinput({
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
            //minImageWidth: 50, //图片的最小宽度
            //minImageHeight: 50,//图片的最小高度
            //maxImageWidth: 1000,//图片的最大宽度
            //maxImageHeight: 1000,//图片的最大高度
            //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
            //minFileCount: 0,
            maxFileCount: 10, //表示允许同时上传的最大文件个数
            enctype: 'multipart/form-data',
            validateInitialCount: true,
            previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        })
        //上传成功后的 回调函数
        $('#uploadfile').on('fileuploaded', function(event, data) {
            imagePath.push(data.response.data);
            $("#imagePath").val(imagePath.join(","));
        })

        //上传成功后的 缩略图中删除按钮的回调函数
        $('#uploadfile').on('filesuccessremove', function(event, data) {
            console.log(event)
            console.log(data)
        })


        $('#uploadfile').on('filedeleted', function(event, key) {
            console.log('Key = ' + key);
        });

    }

    function initFileImageInput() {
        $("#uploadfileImage").fileinput({
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
            previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
        })
        //上传成功后的 缩略图中删除按钮的回调函数
        $('#uploadfileImage').on('fileuploaded', function(event, data) {
            imgPath.push(data.response.data);
            $("#imgPath").val(imgPath.join(","));
        });

        //上传成功后的 缩略图中删除按钮的回调函数
        $('#uploadfileImage').on('filesuccessremove', function(event, data) {
            console.log(event);
            console.log(data);
        });


        $('#uploadfileImage').on('filedeleted', function(event, key) {
            console.log('Key = ' + key);
        });

    }

    //删除栏位
    function deleteFences(obj) {
        $(obj).parents("tr").remove();
    }

    //添加栏位
    function addFence() {
        $("tr[name='data-file']").last().after("<tr name='data-file'>" +
            "<td>选择图片</td>" +
            "<td>" +
            "<input type=\'file\' name=\'imgFile\'>" +
            "<input type='button' onclick='deleteFences(this)' value='删除元素'/>" +
            "</td>")
    }


</script>
</body>
</html>