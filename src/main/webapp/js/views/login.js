$(function () {
    $('#submit').on('click', function (e) {
        var username = $("#username").val();
        var password = $("#password").val();
        if (username.length <= 0) {
            return $("#username").tooltip('show');
        }
        if (password.length < 7) {
            return $("#password").tooltip('show');
        }
        $.post('/json/loginIn.json', {
            name: username,
            password: password
        }, function (val) {
            if (val.success) {
                location.href = "/";
            }
            else {
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
//注册
function quickRegion() {
    var username = $("#name").val();
    var email = $("#email").val();
    var password = $("#password").val();
    if (username.length <= 0) {
        return $("#name").tooltip('show');
    }
    if (email.length <= 0) {
        return $("#email").tooltip('show');
    }
    if (password.length < 7) {
        return $("#password").tooltip('show');
    }
    $('#myform').submit();
}