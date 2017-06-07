<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>评论管理</title>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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

        .btn_area input {
            margin: 0 20px;
        }
    </style>
</head>

<body>

<div class="home-masthead">
    <div class="container">
        <nav class="home-nav">
            <a class="home-nav-item" href="/root/${account}/postlist">文章管理 <span class="badge"></span> </a>
            <a class="home-nav-item" href="/root/${account}/category">类别管理 <span class="badge"></span></a>
            <a class="home-nav-item active" href="/root/${account}/comment">评论管理 <span class="badge"></span></a>
            <a class="home-nav-item" href="/root/${account}/postlist/0/draft">草稿箱 <span class="badge"></span></a>
            <a class="home-nav-item" href="/root/${account}/postlist/0/deleted">回收站 <span class="badge"></span></a>
            <a class="home-nav-item navbar-right glyphicon glyphicon-edit"
               href="/root/${account}/postedit">写新文章</a>
        </nav>
    </div>
</div>

<div class="container">


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