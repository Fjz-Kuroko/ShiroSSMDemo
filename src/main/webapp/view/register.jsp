<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/14
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="/index/doRegister" method="POST">
    <table>
        <tr>
            <td class="tdx">用户名：</td>
            <td><input type="text" name="uname" /></td>
        </tr>
        <tr>
            <td class="tdx">密&nbsp;&nbsp; 码：</td>
            <td><input type="password" name="upwd" /></td>
        </tr>

        <tr>
            <td colspan="2" style="text-align:center">
                <input type="submit" value="注册"/>&nbsp;&nbsp;&nbsp;<a href="login.jsp">去登录</a>
            </td>
        </tr>
        <tr><td colspan="2" style="color:red;text-align:center;font-height:bold;">
            ${message}</td></tr>
    </table>
</form>
</body>
</html>
