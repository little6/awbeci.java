/**
 *
 */
$(function () {
    $("#shownav3").dropmenu({
        title: '标题',
        display: 'navigation',
        fontWeight: false,
        showBorder: false,
        showCaret: true,
        position: 'right',
        width: '180px',
        padding:'4px'
    });

    $('#quit').on('click',function(event,data){
        alert(1)
    })
});

function login() {
    location.href = "/login.html";
}