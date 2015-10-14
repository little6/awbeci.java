<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<html>
<head>
    <title>登录</title>
    <link href="${path}/css/login.css" rel="stylesheet">
    <script type="text/javascript" src="${path}/js/views/login.js"></script>
</head>
<body>
<div class="container" id="logincontainer">
    <div>
        <div class="panel">
            <div class="panel-heading">
                <h3 class="panel-title">登录</h3>
            </div>
            <div class="panel-body">
                <div class="form-group">
                    用户名或者邮箱
                    <input type="email"  class="form-control" id="username" data-toggle="tooltip" data-placement="bottom"
                           title="请输入用户名或者邮箱" >
                </div>
                <div class="form-group">
                    密码
                    <input type="password" class="form-control" id="password" data-toggle="tooltip" data-placement="bottom"
                           title="请输入密码">
                </div>
                <a href="javascript:void(0)" id="submit" class="btn btn-default">登录</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>
