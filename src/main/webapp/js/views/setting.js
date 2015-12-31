$(function(){
    $('.list-group-item').each(function(){
        $(this).on('click',function(e){
            $('.list-group-item').removeClass('list-group-items');
            $(this).addClass('list-group-items')
        })
    });
    $('.list-group-item:first-child').addClass('list-group-items')

    $('#inputImage').change(function(){
        var $image = $('#image');
        $('#myModal').modal();
        $('#myModal').on('shown.bs.modal', function () {
            $image.cropper({
                autoCropArea: 0.5,
                built: function () {
                    $image.cropper('setCanvasData', canvasData);
                    $image.cropper('setCropBoxData', cropBoxData);
                }
            });
        }).on('hidden.bs.modal', function () {
            cropBoxData = $image.cropper('getCropBoxData');
            canvasData = $image.cropper('getCanvasData');
            $image.cropper('destroy');
        });
    });
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

function uploadAvator(){

}

