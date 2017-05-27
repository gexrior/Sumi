<%--
  Created by IntelliJ IDEA.
  User: gonghf95
  Date: 5/25/17
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
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
                <td colspan="2"><input type="submit" value="登录"></td>
            </tr>
        </table>
    </center>
</form>
</body>
</html>
