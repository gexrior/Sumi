<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="icon" href="images/favicon.ico">
    <title>用户登录</title>
</head>
<body>
<form action="/login" method="post">
    <center>
        <table>
            <tr>
                <td colspan="2"><center>Login</center></td>
            </tr>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="account"></td>
            </tr>
            <tr>
                <td>密&nbsp;码</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2"><center><input type="submit" value="登录"></center></td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>
