// Init sidebar
$(function () {

});

function setSiteBar(){
    //默认子节点全部隐藏
    $('.js-guides').each(function () {
        $(this).children().hide()
    });

    $(' .js-expand-btn > h3 > a').click(function () {
        var parent = $(this).parent().parent();
        var topicGuides = parent.find('.js-guides li')

        if ($(this).hasClass('collapsed')) {
            parent.find('h3 a span')
                .removeClass('octicon octicon-chevron-down')
                .addClass('octicon octicon-chevron-right')
        }
        else {
            parent.find('h3 a span')
                .removeClass('octicon octicon-chevron-right')
                .addClass('octicon octicon-chevron-down')
        }
        $(this).toggleClass('collapsed')
        topicGuides.slideToggle(100)

        return false
    });

    //阻止子节点点击发生冒泡
    $(' .js-guides li a').click(function (event) {
        $('.js-guides li').removeClass('activeli');
        $(this).parent().addClass('activeli');
        event.stopPropagation();
    })
}