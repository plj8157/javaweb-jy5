<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <form action="/manage/user/login.do" method="post">
        <input type="text" placeholder="请输入账号" name="username">
        <input type="text" placeholder="请输入密码" name="password">
        <input type="submit" value="登录">
    </form>
</div>
</body>
</html>
