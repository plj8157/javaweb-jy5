<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/6
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.itdr.pojo.Users" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>欢迎${user.uname}</div>

<ul>
    <li>
        <a href="/manage/user/list.do">用户列表</a>
    </li>
    <li>
        <a href="">商品列表</a>
    </li>
    <li>
        
    </li>
</ul>
</body>
</html>
