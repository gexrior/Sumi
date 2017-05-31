<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>用户登录</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
    <script src="js/md5.min.js"></script>
    <script src="js/login.js"></script>
</head>

<body>

<div class="container">
    <div class="form-login">
        <h3 class="form-login-heading">用户登录</h3>
        <label for="username" class="sr-only">邮箱</label>
        <input name="username" type="text" id="username" class="form-control" placeholder="用户名" required autofocus>
        <label for="password" class="sr-only">密码</label>
        <input name="passwd" type="password" id="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input id="reme" type="checkbox" value="remember-me">记住我</label>
        </div>
        <p id="p_err"></p>
        <button class="btn btn-lg btn-primary btn-block" id="signin">登录</button>
    </div>
</div>
<footer class="footer">
    <div class="container">
        <p class="text-muted">Copyright &copy; 2003-2017, <a href="http://www.gonghf95.cn">It's me</a>. All rights
            reserved.</p>
    </div>
</footer>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>
