<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>写新文章</title>
    <link href="css/postedit.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet">
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.ckeditor.com/4.7.0/full-all/ckeditor.js"></script>
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
</head>

<body>

<div class="home-masthead navbar-fixed-top">
    <div class="container">
        <nav class="home-nav">
            <a class="home-nav-item glyphicon glyphicon-home" href=""> 起始页</a>
            <a class="home-nav-item" href="#">文章管理 <span class="badge">43</span> </a>
            <a class="home-nav-item" href="#">类别管理</a>
            <a class="home-nav-item" href="#">评论管理</a>
            <a class="home-nav-item" href="#">草稿箱</a>
            <a class="home-nav-item" href="#">回收站</a>
            <a class="home-nav-item navbar-right glyphicon glyphicon-edit active" href="">写新文章</a>
        </nav>
    </div>
</div>

<div class="container">
    <p class="subtit">文章标题</p>
    <div class="input-group">
        <div class="input-group-btn">
            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true"
                    aria-expanded="false">请选择 <span class="caret"></span></button>
            <ul class="dropdown-menu">
                <li><a href="#">C++</a></li>
                <li><a href="#">C</a></li>
                <li><a href="#">Java</a></li>
            </ul>
        </div><!-- /btn-group -->
        <input type="text" class="form-control" style="max-width: 560px;">
    </div>
    <p class="subtit">文章内容</p>
    <textarea cols="80" id="editor" name="editor" rows="10"></textarea>

    <fieldset style="margin-top: 10px; padding:4px 10px 10px 10px;">
        <legend>上传图片</legend>
        <table border="0" cellpadding="0" cellspacing="0" style="width: 100%;">
            <tr>
                <td valign="top">
                    <ol></ol>
                    <p></p>
                </td>
                <td rowspan="2" valign="top" style="width:240px;">
                    <div style="border: solid 1px #999;background-color: #f0f0f0;font-size: 11px;padding-left: 10px;">
                        <br>
                        <p>
                            1.图片大小不能超过<b>2M</b>
                        </p>
                        <p>
                            2.支持格式:.jpg&nbsp;.git&nbsp;.png&nbsp;.bmp
                        </p>
                    </div>
                </td>
            </tr>
            <tr>
                <td valign="bottom">
                    <input type="file" class="file" style="display: inline;">
                    <input type="button" class="btn btn-default" value="上传">
                </td>
            </tr>
        </table>
    </fieldset>
    <p class="subtit"></p>
    <p style="text-indent:2em;text-align: center;">提示：请不要发布任何推广、广告（包括招聘）、政治、低俗等方面的内容，不要把博客当作SEO工具，否则可能会影响到您的使用。</p>
    <div class="btn_area">
        <input type="button" class="btn btn-primary input_btn" value="发表文章">
        <input type="button" class="btn btn-primary input_btn" value="立即保存">
        <input type="button" class="btn btn-primary input_btn" value="舍弃">
    </div>

    <div style="display: block;min-height: 70px;" id="content"></div>

    <script>
        CKEDITOR.replace('editor', {
            height: 400
        });
        $("#button").click(function () {
            if (CKEDITOR.instances.editor.getData() === "") {
                alert("内容不能为空！");
                return false;
            } else {
                var res = CKEDITOR.instances.editor.getData();
                $("#content").html(res);
                document.write($("#content").html());
            }
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