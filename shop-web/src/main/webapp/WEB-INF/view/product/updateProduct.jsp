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
    <jsp:include page="/common/css.jsp"></jsp:include>
</head>
<body>
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

    <form class="form-horizontal" action="<%=basePath%>product/updateProduct.action" method="post"
          enctype="multipart/form-data">
        <input type="hidden" name="id" value="${productInfo.id}"/>
        <input type="hidden" name="imagePath" id="imagePath" value="${productInfo.imagePath}"/>
        <input type="hidden" name="oldImagePath" id="oldImagePath" value="${productInfo.imagePath}"/>
        <input type="hidden" name="imgPath" id="imgPath">
        <table class="table table-bordered table-hover">
            <tbody>
            <tr>
                <td>名称</td>
                <td><input name="productName" value="${productInfo.productName}"/></td>
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
                <td><input name="costPrice" value="${productInfo.costPrice}"/></td>
            </tr>
            <tr>
                <td>销售价</td>
                <td><input name="marketPrice" value="${productInfo.marketPrice}"/></td>
            </tr>
            <tr>
                <td>库存</td>
                <td><input name="repertory" value="${productInfo.repertory}"/></td>
            </tr>
            <tr>
                <td>是否推荐</td>
                <td>
                    <label><input type="radio" ${productInfo.recommend==0?"checked":""} name="recommend"
                                  value="0"/>否</label>
                    <label><input type="radio" ${productInfo.recommend==1?"checked":""} name="recommend"
                                  value="1"/>是</label>
                </td>
            </tr>
            <tr>
                <td>商品图片</td>
                <td>
                    <input id="uploadfile" type="file" multiple="multiple">
                </td>
            </tr>

            <tr>
                <td>附件图片</td>
                <td>
                    <jsp:include page="/product/findImagesList.action?id=${productInfo.id}"></jsp:include>
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
        <input type="submit" value="提交">
    </form>
</div>


<jsp:include page="/common/script.jsp"></jsp:include>
<script>
    var imagePath = [];
    var imgPaths = [];
    $(function () {
        initBrandList("${productInfo.brandId.id}");
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
            maxFileCount: 10, //表示允许同时上传的最大文件个数
            enctype: 'multipart/form-data',
            validateInitialCount: true,
            previewFileIcon: "<iclass='glyphicon glyphicon-king'></i>",
            msgFilesTooMany: "3",
            msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
            initialPreview: [
                "<img width='180' src='${productInfo.imagePath}' />",
            ],
        })
        //上传成功后的 缩略图中删除按钮的回调函数
        $('#uploadfile').on('fileuploaded', function (event, data) {
            imagePath.push(data.response.data);
            $("#oldImagePath").attr("value","");
            $("#imagePath").val(imagePath.join(","));
        })

        //上传成功后的 缩略图中删除按钮的回调函数
        $('#uploadfile').on('filesuccessremove', function (event, data) {
            console.log(event)
            console.log(data)
        })


        $('#uploadfile').on('filedeleted', function (event, key) {
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
            imgPaths.push(data.response.data);
            $("#imgPath").val(imgPaths.join(","));
        });

    }

</script>
</body>
</html>