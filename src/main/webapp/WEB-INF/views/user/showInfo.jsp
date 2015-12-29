<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>账户设置</title>
    <link href="/css/setting.css" rel="stylesheet">
    <script src="/js/views/setting.js"></script>
</head>
<body>
<div class="container" id="container-main">
    <div class="row">
        <div class="row-left">
            <div class="person-info-content">
                <div class="person-info-header">
                    用户设置
                </div>
            </div>
            <div class="person-info-setlist">
                <div class="list-group">
                    <a href="#" class="list-group-item" onclick="settingProfile(1)">
                        个人资料
                        <span class="octicon octicon-chevron-right"></span>
                    </a>
                    <a href="#" class="list-group-item" onclick="settingProfile(2)">账户设置
                        <span class="octicon octicon-chevron-right"></span>
                    </a>
                    <a href="#" class="list-group-item" onclick="settingProfile(3)">其它
                        <span class="octicon octicon-chevron-right"></span>
                    </a>
                </div>
            </div>
        </div>
        <div class="row-right">
            <div class="setting-content">
                <div class="setting-header">
                    <h4>个人资料</h4>
                    <p>修改你的基本账号</p>
                </div>
                <div class="setting-detail">
                    <dl>
                        <dt><label>头像图片</label></dt>
                        <dd>
                            <img class="left" src="" alt="" width="70" height="70">
                            <div class="user-avatar-info">
                                <a href="#" class="btn btn-default">上传新头像</a>
                                <p>上传后你可以通过拖动新头像来设置</p>
                            </div>
                        </dd>
                    </dl>
                    <dl class="form-group clearboth margintop">
                        <dt><label>用户名</label></dt>
                        <dd>
                            <input type="text" class="form-control form-control-width">
                        </dd>
                    </dl>
                    <dl class="form-group clearboth">
                        <dt><label>昵称</label></dt>
                        <dd>
                            <input type="text" class="form-control form-control-width">
                        </dd>
                    </dl>
                    <dl class="form-group clearboth">
                        <dt><label>邮箱</label></dt>
                        <dd>
                            <input type="text" class="form-control form-control-width">
                        </dd>
                    </dl>
                    <dl class="form-group clearboth">
                        <dt><label>URL</label></dt>
                        <dd>
                            <input type="text" class="form-control form-control-width">
                        </dd>
                    </dl>
                    <p><button class="btn btn-success">更新资料</button></p>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>