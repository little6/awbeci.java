var categoryflag = '';
var siteflag = '';

$(function () {
    $("[data-toggle='tooltip']").tooltip({html: true});
    //$("#showlink ul").dragsort({});
    initCategory();
    initSite();
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

function initSite() {
    $.post('/json/getSiteByMostClick.json', function (data) {
//todo:显示网址
    });
}

function initCategory() {
    $('.sidebar-module').empty();
    $.post('/json/getCategoryByUid.json', function (data) {
        var html = '<ul>';
        for (var i = 0; i < data.length; i++) {
            if (data[i].pid == null || data[i].pid == '') {
                html += '<li class="js-expand-btn">';
                html += '<h3>';
                html += '<a id="' + data[i].id + '" href="#" class="categoryParent">';
                html += '<span class="octicon octicon-chevron-right arrow-btn" aria-hidden="true"></span>';
                html += data[i].name;
                html += '</a>';
                html += '<span class="navedit navediticon octicon octicon-pencil" ></span>';
                html += '<span class="navedit navdelicon octicon octicon-x"></span>';
                html += '</h3>';
                html += '<ul class="js-guides">';

                for (var j = 0; j < data.length; j++) {
                    if (data[j].pid == data[i].id) {
                        html += '<li class="list-item">';
                        html += '<a class="categoryChild" href="javascript:void(0)" id="' + data[j].id + '" pid="' + data[j].pid + '">' + data[j].name + '</a>';
                        html += '<span class="navedit navediticon octicon octicon-pencil"></span>';
                        html += '<span class="navedit navdelicon octicon octicon-x"></span>';
                        html += '</li>';
                    }
                }

                html += '</ul>';
                html += '</li>';
            }
        }
        html += '</ul>';
        $('.sidebar-module').append($(html));
        $('.linkedit').addClass('hide');
        $('.navedit').addClass('hide');

        //this funciton in github.js
        setSiteBar();
        editDelCategory();
        editSite();
        categoryChildClick();
    }, 'json');
}

function categoryChildClick() {
    $('.categoryChild').on('click', function () {
        $.post('/json/getSiteByCategoryId.json', {
            categoryId: $(this).attr('id')
        }, function (data) {
//todo:点击分类生成网址
        }, 'json');
    });
}

function bindCategories(id) {
    $('#categoryType').empty();
    $.ajaxSettings.async = false;
    $.post('/json/getCategoryParent.json', function (data) {
        var html = '<option value="">默认</option>';
        for (var i = 0; i < data.length; i++) {
            if (data[i].id != id) {
                html += '<option value="' + data[i].id + '">' + data[i].name + '</option>'
            }
        }
        $('#categoryType').append(html);
        $('#categoryType').selectpicker('refresh');
    }, 'json');
}

function bindSite() {
    $('#siteType').empty();
    $.ajaxSettings.async = false;
    $.post('/json/getCategoryChild.json', function (data) {
        var html = '';
        for (var i = 0; i < data.length; i++) {
            html += '<option value="' + data[i].id + '">' + data[i].name + '</option>'
        }
        $('#siteType').append(html);
        $('#siteType').selectpicker('refresh');
    }, 'json');
}

function addcategory() {
    $('#addcategory').on('click', function () {
        categoryflag = 'add';
        $('.header-title').text('添加');
        var positon = $(this).parent().parent().position();
        $("#categoryName").val('');
        $('#categoryId').val('');
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
    if ($.trim(categoryname).length == 0) {
        return alert('请输入完整');
    }
    //todo:注意：添加的时候不能允许名称重复
    $.post('/json/saveCategory.json', {
        id: $('#categoryId').val(),
        name: categoryname,
        pid: category,
        flag: categoryflag
    }, function (data) {
        if (data != 0) {
            canceleditNav();
            initCategory();
        }
        else {
            alert('添加失败');
        }
    }, 'json');
}

function addSite() {
    $('#addsite').on('click', function (event, data) {
        siteflag = 'add';
        $('.header-title').text('添加');
        var $positon = $(this).position();
        $("#sitename").val('');
        $("#siteurl").val('');
        $('.editlinkdlg').css({
            left: $positon.left - 221,
            top: $positon.top + 25
        }).addClass('show');
        bindSite('');
    })
}

function saveSite() {
    var sitename = $('#sitename').val();
    var siteurl = $('#siteurl').val();
    if ($.trim(sitename).length == 0 ||
        $.trim(siteurl).length == 0) {
        return alert('请输入完整');
    }

    if (!isURL(siteurl)) {
        alert('您输入的URL不合法，请重新输入');
        return;
    }
    var categoryid = $('#siteType').val();
    $.post('/json/saveSite.json', {
        id: $('#categoryId').val(),
        name: sitename,
        url: siteurl,
        categoryId: categoryid,
        flag: siteflag
    }, function (data) {
        if (data != 0) {
            canceleditLink();
            //initCategory();
        }
        else {
            alert('添加失败');
        }
    }, 'json');
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

function editDelCategory() {
    $('.navediticon').on('click', function (event) {
        categoryflag = 'update';
        bindCategories($(this).parent().children('a').attr('id'));
        var positon = $(this).parent().position();
        $('#categoryId').val($(this).parent().children('a').attr('id'));
        $("#categoryName").val($.trim($(this).parent().children('a').text()));
        $('#categoryType').selectpicker('val', $(this).parent().children('a').attr('pid'));
        $('.editnavdlg').css({
            left: positon.left,
            top: positon.top + 35
        }).addClass('show');
        event.stopPropagation();
    });

    $('.navdelicon').on('click', function (event) {
        event.stopPropagation();
        var parents = $(this).parent().parent().find('.list-item');
        var parent = $(this).parent();
        if (parents.length > 0 && !parent.hasClass('list-item')) {
            return alert('该分类下存在子分类，请先删除子分类，再删除此分类');
        }
        var val = confirm("您确定删除此分类？");
        if (val) {
            $.post('/json/deleteCategory.json', {
                id: $(this).parent().children('a').attr('id')
            }, function (data) {
                if (data != 0) {
                    initCategory();
                }
                else {
                    alert('删除失败');
                }
            }, 'json');
        }
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

function isURL(str_url) {
    var strRegex = /^((http|https|ftp):\/\/)?(\w(\:\w)?@)?([0-9a-z_-]+\.)*?([a-z0-9-]+\.[a-z]{2,6}(\.[a-z]{2})?(\:[0-9]{2,6})?)((\/[^?#<>\/\\*":]*)+(\?[^#]*)?(#.*)?)?$/i;
    if (strRegex.test(str_url)) {
        return true;
    } else {
        return false;
    }
}
