$(function () {
    $('#submit').on('click', function (e) {
        var username = $("#username").val();
        var password = $("#password").val();
        if (username.length <= 0) {
            return $("#username").tooltip('show');
        }
        if (password.length <= 0) {
            return $("#password").tooltip('show');
        }
        $.post('/json/loginIn.json', {
            name: username,
            password: password
        }, function (val) {
            if(val.success){
                location.href="/main/main.html";
            }
            else{
                alert('登录失败');
            }
        })
    });

    $("#username").on('change', function (e) {
        var useorname = $("#username").val();
        if (username.length > 0) {
            $("#username").tooltip('destroy');
        }
        else {
            return $("#username").tooltip('show');
        }
    })

    $("#password").on('change', function (e) {
        var password = $("#password").val();
        if (password.length > 0) {
            $("#password").tooltip('destroy');
        }
        else {
            return $("#password").tooltip('show');
        }
    });
});