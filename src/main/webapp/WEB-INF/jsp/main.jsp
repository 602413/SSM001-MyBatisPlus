<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2020/5/21
  Time: 9:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <h1>主界面</h1><br>
    <c:if test="${activeName==null}">
        <a href="/toLogin">请登录</a>
    </c:if>
    <c:if test="${activeName!=null}">
        <a href="#">${activeName}</a>
    </c:if>
</body>
</html>
