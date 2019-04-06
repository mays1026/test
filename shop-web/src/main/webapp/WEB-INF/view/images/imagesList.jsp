<%--
  Created by IntelliJ IDEA.
  User: MYS
  Date: 2019/02/17
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <input type="hidden" id="ids" name="ids">
    <input type="hidden" id="imgPath" name="imgPath">
    <div class="row">
        <c:forEach items="${list}" var="imagesInfo">
            <div class="col-sm-6 col-md-4" imgId="${imagesInfo.id}">
                <div class="thumbnail">
                    <img src="${imagesInfo.imgPath}">
                    <div class="caption">
                        <p><a href="javaScript:deleteImages(${imagesInfo.id});" class="btn btn-primary"
                              role="button">删除</a>
                                <%--<a href="#" class="btn btn-default" role="button">Button</a></p>--%>
                    </div>
                </div>
            </div>
            <%--<img src="${imagesInfo.imgPath}" alt="${imagesInfo.imgPath}">--%>
        </c:forEach>
    </div>
</div>
<!-- 引入js -->
<script src="/js/DataTables-1.10.15/jQuery-3.3.1/jquery-3.3.1.min.js"></script>
<script src="/js/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<script>
    var ids = [];
    var imgPath = [];

    //删除图片
    function deleteImages(id) {
        if (confirm("你确认删除这张图片么？？")) {
            /*$.ajax({
                url:"/images/deleteImages.action",
                data:{
                    "ids":id,
                    "paths":path
                },
                type:"post",
                dataType:"json",
                success:function(data){
                    if (data.code == 200){
                        alert("删除成功！");
                    }
                }
            });*/
            ids.push($("[imgId='" + id + "']").attr("imgId"));
            imgPath.push($("[imgId='" + id + "']").attr("imgPath"));
            $("#ids").val(ids.join(","));
            $("#paths").val(imgPath.join(","));
            $("[imgId='" + id + "']").remove();
            // alert($("#ids").val()+":"+$("#paths").val());
        }
    }
</script>
</body>
</html>
