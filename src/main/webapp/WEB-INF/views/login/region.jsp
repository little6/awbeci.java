<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
    <style>
        .content {
            margin: 80px auto 0 auto;
            width: 800px;
            min-height: 600px;
        }

        .regionContent {
            width: 450px;
            margin-top: 30px;
        }

        .text-muted {
            min-height: 17px;
            margin: 4px 0 2px;
            font-size: 12px;
            color: #767676;
        }

        .form-group {
            margin-top: 15px;
            margin-bottom: 0;
        }

        .text-note {
            min-height: 17px;
            margin: 15px 0;
            font-size: 12px;
            color: #333;
            padding: 15px;
            border-top: 1px solid #ddd;
            border-bottom: 1px solid #ddd;
        }

        .regionBtn {
            margin: 10px 0;
            width: 100px;
            float: right;
        }
    </style>
</head>
<body>
<div class="content">
    <h1>加入Awbeci</h1>

    <p>让您在工作和娱乐的同时享受到awbeci带来的便利和快乐。</p>

    <div class="regionContent">
        <form>
            <h4>创建个人账号</h4>

            <div class="form-group">
                <label>用户名</label>
                <input type="text" id="name" name="name" class="form-control" placeholder="用户名"
                       required></div>
            <p class="text-muted">这里输入的是您的用户名，完成注册后您也可以在设置中更改它。</p>
            <div class="form-group">
                <label>邮箱地址</label>
                <input type="email" id="email" name="email" class="form-control" placeholder="邮箱"
                       required></div>
            <p class="text-muted">你的邮箱将会收到一封来自awbeci的确认邮件，我们保证不会向任何人公开你的邮箱。</p>

            <div class="form-group">
                <label>密码</label>
                <input type="password" id="password" name="password" class="form-control"
                       placeholder="密码" required></div>
            <p class="text-muted">至少使用一个小写字母，一个数字和七个字符。</p>

            <p class="text-note">当你点击创建账户，默认你同意我们的<a href="#">服务条款</a>和隐私保护的条款.我们将发送一封电子邮件到你注册的邮箱.</p>

            <div class="regionBtn">
                <a href="javascript:void(0)" class="btn btn-success btn-block" id="region" onclick="quickRegion()"><b>创建账户</b></a>
            </div>

        </form>
    </div>
</div>
</body>
</html>