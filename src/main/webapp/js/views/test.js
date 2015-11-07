$(function () {
    $("[data-toggle='tooltip']").tooltip({html: true});
    //$("#showlink ul").dragsort({});

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
        editCategory();
        editSite();
    });
    editCategorySite();
    addcategory();
    addSite();
    $('#categoryClose').on('click', function () {
        canceleditNav();
    });

    $('#siteClose').on('click', function () {
        canceleditLink();
    });
});

function bindCategories(){
    $('#categoryType').empty();
    $.getJSON('/json/getCategoryByUid.json', function (data) {
        var html = '<option value="">默认</option>';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i].id + '">' + data[i].name + '</option>'
        }
        $('#categoryType').append(html);
        $('#categoryType').selectpicker('refresh');
    });
}

function addcategory() {
    $('#addcategory').on('click', function () {
        $('.header-title').text('添加');
        var positon = $(this).parent().parent().position();
        $("#naveditname").val('');
        $('.editnavdlg').css({
            left: '1px',
            top: positon.top + 29
        }).addClass('show');
        bindCategories();
    });
}

function saveCategory() {
    var categoryname = $('#categoryName').val();
    var category = $('#categoryType').val();
    if ($.trim(categoryname).length == 0 || $.trim(category).length == 0) {
        return alert('请输入完整');
    }
    $.getJSON('/json/saveCategory.json', {
        'name': categoryname,
        'pid': category
    }, function (data) {

    });
}

function addSite() {
    $('#addsite').on('click', function (event, data) {
        $('.header-title').text('添加');
        var $positon = $(this).position();
        $("#linkeditname").val('');
        $("#linkediturl").val('');
        $('.editlinkdlg').css({
            left: $positon.left - 221,
            top: $positon.top+25
        }).addClass('show');
    })
}

//编辑导航
function editCategorySite() {
    $("#editcategory").on('click', function (e) {
        $('.header-title').text('编辑');
        if ($('.navedit').hasClass('hide')) {
            $('.navedit').removeClass('hide').addClass('show');
        }
        else {
            $('.navedit').removeClass('show').addClass('hide');
        }
        canceleditNav();
    });

    $("#editsite").on('click', function (e) {
        if ($('.linkedit').hasClass('hide')) {
            $('.linkedit').removeClass('hide').addClass('show');
        }
        else {
            $('.linkedit').removeClass('show').addClass('hide');
        }
        canceleditLink();
    });
}

function editCategory() {
    $('.navedit').on('click', function () {
        var positon = $(this).parent().position();
        $("#naveditname").val($.trim($(this).parent().children('a').text()));
        $('.editnavdlg').css({
            left: positon.left,
            top: positon.top + 35
        }).addClass('show');
        event.stopPropagation();
    });

}

/*编辑链接*/
function editSite() {
    $('.linkediticon').on('click', function (event, data) {
        $('.header-title').text('编辑');
        var $positon = $(this).parent().position();
        $("#linkeditname").val($.trim($(this).parent().children('a').text()));
        $("#linkediturl").val($.trim($(this).parent().children('a').attr('href')));
        $('.editlinkdlg').css({
            left: $positon.left + 6,
            top: $positon.top + 39
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
