$(function(){
    $('.list-group-item').each(function(){
        $(this).on('click',function(e){
            $('.list-group-item').removeClass('list-group-items');
            $(this).addClass('list-group-items')
        })
    });
    $('.list-group-item:first-child').addClass('list-group-items')
})
function settingProfile(type) {
    switch (type) {
        case 1:
            break;
        case 2:
            break;
        case 3:
            break;
    }
}