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
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.ckeditor.com/4.7.0/standard-all/ckeditor.js"></script>
    <style type="text/css">

        body {
            font-family: Georgia, "Times New Roman", Times, serif;
            color: #555;
        }

        h1, .h1,
        h2, .h2,
        h3, .h3,
        h4, .h4,
        h5, .h5,
        h6, .h6 {
            margin-top: 0;
            font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
            font-weight: normal;
            color: #333;
        }

        @media (min-width: 1200px) {
            .container {
                width: 960px;
            }
        }

        .home-masthead {
            background-color: #428bca;
            -webkit-box-shadow: inset 0 -2px 5px rgba(0, 0, 0, .1);
            box-shadow: inset 0 -2px 5px rgba(0, 0, 0, .1);
        }

        .home-nav-item {
            position: relative;
            display: inline-block;
            padding: 10px;
            font-weight: 500;
            color: #cdddeb;
        }

        .home-nav-item:hover,
        .home-nav-item:focus {
            color: #fff;
            text-decoration: none;
        }

        .home-nav .active {
            color: #fff;
        }

        .home-nav .active:after {
            position: absolute;
            bottom: 0;
            left: 50%;
            width: 0;
            height: 0;
            margin-left: -5px;
            vertical-align: middle;
            content: " ";
            border-right: 5px solid transparent;
            border-bottom: 5px solid;
            border-left: 5px solid transparent;
        }

        .footer {
            position: relative;
            bottom: 0;
            width: 100%;
            height: 40px;
        }

        .text-muted {
            text-align: center;
        }

        .subtit {
            margin: 8px 0;
            border-bottom-color: #f0f0f0;
        }

        .btn_area {
            text-align: center;
            margin: 0 auto;
            padding: 20px 0 14px 0;
        }

        .btn_area input {
            margin: 0 20px;
        }

        .input_btn {
            width: auto;
            height: 30px;
            padding: 0 15px;
            border: none;
            color: #fff;
            font: bold 12px/30px Arial, Helvetica, sans-serif;
            text-align: center;
            cursor: pointer;
        }

        #editor {
            width: 960px;
            display: block;
            margin: 0 auto;
        }
    </style>
</head>

<body>

<div class="home-masthead">
    <div class="container">
        <nav class="home-nav">
            <a class="home-nav-item glyphicon glyphicon-home" href="/root/${user.account}/main"> 起始页</a>
            <a class="home-nav-item" href="#">文章管理 <span class="badge">${post}</span> </a>
            <a class="home-nav-item" href="#">类别管理 <span class="badge">${post}</span></a>
            <a class="home-nav-item" href="#">评论管理 <span class="badge">${post}</span></a>
            <a class="home-nav-item" href="#">草稿箱 <span class="badge">${post}</span></a>
            <a class="home-nav-item" href="#">回收站 <span class="badge">${post}</span></a>
            <a class="home-nav-item navbar-right glyphicon glyphicon-edit active" href="/root/${user.account}/article/postedit">写新文章</a>
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
               autocomplete="off" id="category">
        （多个分类之间用“,”分隔）
    </div>

    <p style="text-indent:2em;text-align: center;margin-top: 40px;">
        提示：请不要发布任何推广、广告（包括招聘）、政治、低俗等方面的内容，不要把博客当作SEO工具，否则可能会影响到您的使用。</p>
    <div class="btn_area">
        <input type="button" class="btn btn-primary input_btn" value="发表文章" id="publish">
        <!--<input type="button" class="btn btn-primary input_btn" value="立即保存" id="draft"> -->
        <input type="button" class="btn btn-primary input_btn" value="舍弃" id="cancel">
    </div>

    <div style="display: block;height: 70px;" id="content"></div>
    <script>
        $(document).ready(function () {
            /*CKEditor Configuration*/
            CKEDITOR.replace('editor', {
                height: 400,
                language: 'zh-ch',
                extraPlugins: 'codesnippet',
                codeSnippet_theme: 'rainbow',
                filebrowserUploadUrl: '/root/${user.account}/article/upload',
                toolbarCanCollapse: true,
                disableObjectResizing: true
            });
            /*提交按鈕事件响应*/
            $("#publish").click(function () {
                var title = $("#title").val();
                if (title===""){
                    alert("标题不能为空");
                    return false;
                }
                var contents = CKEDITOR.instances.editor.getData();
                if (contents===""){
                    alert("文章内容不能为空");
                    return false;
                }
                var category = $("#category").val();
                if(category===""){
                    alert("类别不能为空");
                    return false;
                }
                $.ajax({
                    type: "POST",
                    url: "/root/${user.account}/article/add",
                    data: {title: title, contents: contents},
                    datatype: "json",
                    success: function (data) {
                        var resp = jQuery.parseJSON(data);
                        if(resp.state===1){
                            var path = "/article/details/"+resp.data;
                            window.location.href=path;
                        }
                    },
                    //调用执行后调用的函数
                    complete: function (XMLHttpRequest, textStatus) {

                    },
                    //调用出错执行的函数
                    error: function () {
                        //请求出错处理
                    }
                });
            });
        });
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