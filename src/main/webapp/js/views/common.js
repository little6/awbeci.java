$(function () {
    $.post('/json/getSession.json', function (data) {
        var html = '';
        if (data) {
            $('#navbar-collapse-01').empty();
            if (data.session) {
                //html += '<h1 class="logo"><span class="mega-octicon octicon-mark-github"></span></h1>' +
                html += '<h1 class="logo"></h1>' +
                '<ul class="nav navbar-nav navbar-left">' +
                ' <li><a href="/" class="header-nav-link">首页</a></li>' +
                '  <li><a href="/' + data.session + '" class="header-nav-link">我的主页</a></li>' +
                ' <li><a href="/aboutme/aboutme" class="header-nav-link">关于</a></li>' +
                '  </ul>' +
                '  <ul class="nav navbar-nav navbar-right">' +
                '  <li class="dropdown">' +
                '  <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"' +
                '  aria-expanded="false">' +
                '  zhangwei <span class="caret"></span></a>' +
                '  <ul class="dropdown-menu">' +
                '  <li><a href="#">当前登入账号：' +
                '<br>zhangwei</a></li>' +
                '    <li role="separator" class="divider"></li>' +
                '    <li><a href="/' + data.session + '">个人主页</a></li>' +
                '    <li><a href="#">帮助</a></li>' +
                '    <li role="separator" class="divider"></li>' +
                '    <li><a href="/settings/account">设置</a></li>' +
                '    <li><a href="javascript:void(0)" onclick="quit()">退出</a></li>' +
                '    </ul>' +
                '    </li>' +
                '    </ul>';
                $('#navbar-collapse-01').append(html);
                $("#container-main").css({'margin-top': '50px'});
            }
            else {
                html += ' <!--menu2 start-->' +
                ' <ul class="nav navbar-nav navbar-left">' +
                ' <li><a href="/navigation/navigation" class="header-nav-link">探索发现</a></li>' +
                ' <li><a href="/navigation/navigation" class="header-nav-link">功能特性</a></li>' +
                ' <li><a href="/navigation/navigation" class="header-nav-link">站点博客</a></li>' +
                ' <li><a href="/aboutme/aboutme" class="header-nav-link">关于</a></li>' +
                ' </ul>' +
                ' <ul class="nav navbar-nav navbar-right">' +
                ' <li>' +
                ' <button type="button" class="btn btn-success btn-nav" onclick="region()">注册' +
                ' </button>' +
                ' </li>' +
                ' <li>' +
                ' <button type="button" class="btn btn-default btn-nav" onclick="login()">登录' +
                ' </button>' +
                ' </li>' +
                ' </ul>';
                $('#navbar-collapse-01').append(html);
                $("#container-main").css({'margin-top': '60px'});
            }
        }
    });
});
function region() {
    location.href = '/region';
}

function login() {
    location.href = "/login";
}

function quit() {
    $.post('/json/loginOut.json', function (data) {
        if (data.success) {
            location.href = '/';
        }
    })
}