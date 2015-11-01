$(function () {

    $("[data-toggle='tooltip']").tooltip({html: true});
    //$("#showlink ul").dragsort({});
    //$(".we-edit").hide();

    $.getJSON('/json/getCategoryByUid.json', function (data) {
        var html = '<ul>';
        for (var i = 0; i < data.length; i++) {
            html += '<li class="js-expand-btn">';
            html += '<h3>';
            html += '<a href="#">';
            html += '<span class="octicon octicon-triangle-right arrow-btn"></span>';
            html += data[i].name;
            html += '</a>';
            html += '<span class="navedit navediticon octicon octicon-pencil" ></span>';
            html += '<span class="navedit navdelicon octicon octicon-x"></span>';
            html += '</h3>';
            html += '<ul class="js-guides">';
            html += '<li class="list-item"><a href="#">JQuery</a>';
            html += '<span class="navedit navediticon octicon octicon-pencil"></span>';
            html += '<span class="navedit navdelicon octicon octicon-x"></span></li>';
            html += '<li><a href="#">EXTJS</a></li>';
            html += '</ul>';
            html += '</li>';
        }
        html += '</ul>';
        $('.sidebar-module').append($(html));
        $('.linkedit').addClass('hide');
        $('.navedit').addClass('hide');

        setSiteBar();
        editNav();
        editLink();
    });
    addnavSite();
    editNavSite();
});
function addnavSite() {
    $('#addnavsite').on('click', function () {
        $('#navSiteModal').modal({
            keyboard: true
        });
    })
}

//编辑导航
function editNavSite() {
    $("#editnavsite").on('click', function (e) {
        if ($('.linkedit').hasClass('hide')) {
            $('.linkedit').removeClass('hide').addClass('show');
            $('.navedit').removeClass('hide').addClass('show');
        }
        else {
            $('.linkedit').removeClass('show').addClass('hide');
            $('.navedit').removeClass('show').addClass('hide');
        }
        canceleditNav();
        canceleditLink();
    });
}

function editNav() {
    $('.navedit').on('click', function () {
        var positon = $(this).parent().position();
        $("#naveditname").val($.trim($(this).parent().children('a').text()));
        $('.editnavdlg').css({
            left: positon.left,
            top: positon.top
        }).addClass('show');
        event.stopPropagation();
    });

}

/*编辑链接*/
function editLink() {
    $('.linkediticon').on('click', function (event, data) {
        var $positon = $(this).parent().position();
        $("#linkeditname").val($.trim($(this).parent().children('a').text()));
        $("#linkediturl").val($.trim($(this).parent().children('a').attr('href')));
        $('.editlinkdlg').css({
            left: $positon.left + 4,
            top: $positon.top + 4
        }).addClass('show');
    })
}

//取消编辑
function canceleditNav() {
    $('.editnavdlg').removeClass('show');
}

function canceleditLink() {
    $('.editlinkdlg').removeClass('show');
}