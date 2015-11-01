// Init sidebar
$(function () {

});

function setSiteBar(){
    //默认子节点全部隐藏
    $('.js-guides').each(function () {
        $(this).children().hide()
    });

    $(' .js-expand-btn').click(function () {
        var topicGuides = $(this).find('.js-guides li')

        if ($(this).hasClass('collapsed')) {
            $(this).find('h3 a span')
                .removeClass('octicon-triangle-down')
                .addClass('octicon-triangle-right')
        }
        else {
            $(this).find('h3 a span')
                .removeClass('octicon-triangle-right')
                .addClass('octicon-triangle-down')
        }
        $(this).toggleClass('collapsed')
        topicGuides.slideToggle(100)

        return false
    });

    //阻止子节点点击发生冒泡
    $(' .js-guides li').click(function (event) {
        $(' .js-guides li a').removeClass('activeli').css('padding-left', '31px');
        $(this).find('a').addClass('activeli').css('padding-left', '29px');
        event.stopPropagation();
    })
}