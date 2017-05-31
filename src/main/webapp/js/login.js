/**
 * Created by gonghf95 on 5/30/17.
 */
$(document).ready(function () {
    $("#signin").click(function () {
        var account = $("#username").val();
        var passwd = $("#password").val();
        $.ajax({
            type: "POST",
            url: "/login",
            data: {account: account, passwd: md5(passwd)},
            datatype: "json",
            beforeSend: function () {

            },
            success: function (data) {
                var res = jQuery.parseJSON(data);
                if (res.state === 1) {
                    var root="/administrator/"+res.message;
                    window.location.href=root;
                }else{
                    var show_err = $("#p_err");
                    show_err.css("visibility","visible");
                    show_err.text(res.message);
                }
            },
            complete: function (XMLHttpRequest, textStatus) {

            },
            error: function () {

            }
        });
    });
});