<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="images/favicon.ico">
    <title>新文章</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/postedit.css" rel="stylesheet">
    <script src="https://cdn.ckeditor.com/4.7.0/standard-all/ckeditor.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <script src="js/postedit.js"></script>
</head>

<body>

<div class="home-masthead">
    <div class="container">
        <nav class="home-nav">
            <a class="home-nav-item glyphicon glyphicon-home" href=""> 起始页</a>
            <a class="home-nav-item" href="#">文章管理 <span class="badge">${post}</span> </a>
            <a class="home-nav-item" href="#">类别管理 <span class="badge">${post}</span></a>
            <a class="home-nav-item" href="#">评论管理 <span class="badge">${post}</span></a>
            <a class="home-nav-item" href="#">草稿箱 <span class="badge">${post}</span></a>
            <a class="home-nav-item" href="#">回收站 <span class="badge">${post}</span></a>
            <a class="home-nav-item navbar-right glyphicon glyphicon-edit active" href="">写新文章</a>
        </nav>
    </div>
</div>

<div class="container">

    <p class="subtit" style="margin-top: 20px">文章标题</p>
    <input type="text" id="title" class="form-control" style="width: 560px;height: 26px;">

    <p class="subtit">文章内容</p>
    <textarea cols="80" id="editor" name="editor" rows="10"></textarea>

    <p class="subtit">文章分类</p>
    <div>
        <input id="txtTag" type="text" class="form-control" style="width:60%;display: inline;height: 26px;"
               maxlength="100"
               autocomplete="off">
        （多个分类之间用“,”分隔）
    </div>

    <p style="text-indent:2em;text-align: center;margin-top: 40px;">
        提示：请不要发布任何推广、广告（包括招聘）、政治、低俗等方面的内容，不要把博客当作SEO工具，否则可能会影响到您的使用。</p>
    <div class="btn_area">
        <input type="button" class="btn btn-primary input_btn" value="发表文章" id="btn-publish">
        <input type="button" class="btn btn-primary input_btn" value="立即保存" id="draftBtn">
        <input type="button" class="btn btn-primary input_btn" value="舍弃" id="cancelBtn">
    </div>

    <div style="display: block;height: 70px;" id="content"></div>
    <script>
    </script>

</div><!-- /.container -->

<div class="footer">
    <div class="container">
        <p class="text-muted">Copyright &copy; 2003-2017, <a href="http://www.gonghf95.cn">It's me</a>. All rights
            reserved.</p>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>