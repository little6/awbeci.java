$(function(){
    $('.list-group-item').each(function(){
        $(this).on('click',function(e){
            $('.list-group-item').removeClass('list-group-items');
            $(this).addClass('list-group-items')
        })
    });
    $('.list-group-item:first-child').addClass('list-group-items')

    $('#inputImage').change(function(){
        var $image = $('#avatorImg');
        var cropBoxData;
        var canvasData;
        var files = this.files;
        var file;

        if (files && files.length) {
            file = files[0];
            var reader=new FileReader();
            reader.onload=function(){
                // 通过 reader.result 来访问生成的 DataURL
                var url=reader.result;
                //setImageURL(url);
            };
            if (/^image\/\w+$/.test(file.type)) {
                blobURL = URL.createObjectURL(file);
                $.post('/json/uploadAvatar.json',{
                    filePath:blobURL
                },function(){

                },'json');
                //$image.one('built.cropper', function () {
                //    // Revoke when load complete
                //    URL.revokeObjectURL(blobURL);
                //}).cropper('reset').cropper('replace', blobURL);

            } else {
                window.alert('Please choose an image file.');
            }
        }
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
        $('#myModal').modal('show');

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

