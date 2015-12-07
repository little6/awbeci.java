<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><sitemesh:write property="title"/></title>
    <!-- Loading Bootstrap -->
    <link href="/js/Bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/js/Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="/css/social-buttons.css" rel="stylesheet">
    <link href="/css/template.css" rel="stylesheet">
    <link href="/js/awbeci/themes/default/dropmenu.css" rel="stylesheet">
    <link href="/js/font-awesome/font-awesome.min.css" rel="stylesheet">
    <link href="/js/octicons/octicons.css" rel="stylesheet">

    <link href="http://static.bootcss.com/www/assets/ico/favicon.png" rel="shortcut icon">
    <link href="/css/common.css" rel="stylesheet">
    <script src="/js/jquery/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="/js/Bootstrap/js/bootstrap.min.js"></script>
    <script src="/js/views/common.js"></script>
    <sitemesh:write property="head"/>
    <%if (request.getSession().getAttribute("user") != null) {%>
    <style type="text/css">
        .navbar-nav > li > a {
            padding-top: 10px;
            padding-bottom: 10px;
        }

        .navbar-header {
            display: none
        }
    </style>
    <% }%>
</head>
<body>
<nav class="navbar navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand nav-logo" href="/">Awbeci</a>
        </div>

        <div class="collapse navbar-collapse" id="navbar-collapse-01">
            <% if (request.getSession().getAttribute("user") != null) { %>
            <h1 class="logo"><span class="mega-octicon octicon-mark-github"></span></h1>
            <ul class="nav navbar-nav navbar-left">
                <li><a href="/main/main.html" class="header-nav-link">首页</a></li>
                <li><a href="/navigation/navigation.html" class="header-nav-link">我的主页</a></li>
                <li><a href="/aboutme/aboutme.html" class="header-nav-link">关于</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        zhangwei <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">当前登入账号：
                            <br>zhangwei</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">个人主页</a></li>
                        <li><a href="#">帮助</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">设置</a></li>
                        <li><a href="javascript:void(0)" onclick="quit()">退出</a></li>
                    </ul>
                </li>
            </ul>
            <% } else {%>
            <ul class="nav navbar-nav navbar-left">
                <li><a href="/navigation/navigation.html" class="header-nav-link">探索发现</a></li>
                <li><a href="/navigation/navigation.html" class="header-nav-link">功能特性</a></li>
                <li><a href="/navigation/navigation.html" class="header-nav-link">站点博客</a></li>
                <li><a href="/aboutme/aboutme.html" class="header-nav-link">关于</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <button type="button" class="btn btn-success btn-nav">注册
                    </button>
                </li>
                <li>
                    <button type="button" class="btn btn-default btn-nav" onclick="login()">登录
                    </button>
                </li>
            </ul>

            <%}%>

        </div>
    </div>
    <!-- /.navbar-collapse --> </nav>
<!-- /navbar -->

<sitemesh:write property="body"/>
<footer>
    <div class="myclearfix">
        <span>©2015 hellozw <a href="http://www.miitbeian.gov.cn/">皖ICP备14011269号-1</a></span>
    </div>
</footer>
<!-- /menu -->
</body>
</html>