/**
 * Created by gonghf95 on 5/29/17.
 */
$(document).ready(function () {

    /*
     * CKEditor Configure
     * */
    CKEDITOR.replace('editor', {
        height: 400,
        language:'zh-ch',
        extraPlugins: 'codesnippet',
        codeSnippet_theme: 'rainbow',
        filebrowserUploadUrl:'/article/upload',
        toolbarCanCollapse:true,
        disableObjectResizing:true
    });

    /*发表按钮*/
    $("#btn-publish").click(function () {
        var title = $("#title").val();
        if (title === "") {
            alert("标题不能为空");
            return false;
        }

        var contents = CKEDITOR.instances.editor.getData();
        if (contents === "") {
            alert("内容不能为空");
            return false;
        }

        $.ajax({
            type: "POST",
            url: "/article/add",
            data: {title: title, contents: contents},
            datatype: "json",//"xml", "html", "script", "json", "jsonp", "text".
            beforeSend: function () {

            },
            success: function (data) {
                $("#msg").html(data);
            },
            //调用执行后调用的函数
            complete: function (XMLHttpRequest, textStatus) {
                alert(XMLHttpRequest.responseText);
                alert(textStatus);
            },
            //调用出错执行的函数
            error: function () {
                //请求出错处理
            }
        });
    });

    var path = "";
    /*
     * 上载按钮点击事件
     * 1.上载成功在列表中添加该文件，返回图片地址，
     * 2.上载失败不在列表显示内容
     * */
    $("#upload").click(function () {
        if (imgcheck()) {
            //下面模拟成功后操作
            /*<li><span>http://img.blog.csdn.net/20170529213238340?watermark/2/text/aHR0cDovL2Jsb2cuY3Nkbi5uZXQvaWFtXzEzMg==/font/5a6L5L2T/fontsize/400/fill/I0JBQkFCMA==/dissolve/70/gravity/Center</span><a
             href="#" onclick="javascript:insertImage2(this);return false;">[插入]</a></li>*/
            $("ol").append("<li><span>").append(path).append("</span><a href='#' onclick='insert'></a>");
        }
    });

    function insertImage2(obj){

    }

    /**
     *上传图片
     * 1.文件类型校验
     * 2.文件大小校验
     * 3.上传成功添加到上传列表中，不成功更新当前文件为未选择
     **/
    function imgcheck() {
        var filepath = $("#select").val();
        path = filepath;
        var extStart = filepath.lastIndexOf(".");
        var ext = filepath.substring(extStart, filepath.length).toUpperCase();
        if (ext !== ".BMP" && ext !== ".PNG" && ext !== ".GIF" && ext !== ".JPG") {
            resetFileInput($("#select"));
            alert("图片限于bmp,png,gif,jpeg,jpg格式");
            return false;
        }

        var file_size = 0;
        if ($.support) {
            var img = new Image();
            img.src = filepath;
            while (true) {
                if (img.fileSize > 0) {
                    if (img.fileSize > 3 * 1024 * 1024) {
                        alert("图片不大于100MB。");
                    }
                }
                break;
            }
        } else {
            file_size = this.files[0].size;
            var size = file_size / 1024;
            if (size > 10240) {
                alert("上传的图片大小不能超过10M！");
                return false;
            }
        }
        return true;
    }

    /*
     * 重置文件输入
     * */
    function resetFileInput(file) {
        file.after(file.clone().val(""));
        file.remove();
    }

});