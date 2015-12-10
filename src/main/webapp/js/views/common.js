/**
 *
 */
$(function () {

    $('#quit').on('click', function (event, data) {
        alert(1)
    })
});

function region() {
    location.href = '/region.html';
}

function login() {
    location.href = "/login.html";
}

function quit() {
    $.post('/json/loginOut.json', function (data) {
        if (data.success) {
            location.href = '/';
        }
    })
}