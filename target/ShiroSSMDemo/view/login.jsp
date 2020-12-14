<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2020/12/13
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/index/doLogin" method="POST">
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
                <input type="submit" value="登录"/>&nbsp;&nbsp;&nbsp;<a href="register.jsp">去注册</a>
            </td>
        </tr>
        <tr><td colspan="2" style="color:red;text-align:center;font-height:bold;">
            ${message}</td></tr>
    </table>
</form>
</body>
</html>
