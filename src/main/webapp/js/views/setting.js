$(function () {
    $('.list-group-item').each(function () {
        $(this).on('click', function (e) {
            $('.list-group-item').removeClass('list-group-items');
            $(this).addClass('list-group-items')
        })
    });
    $('.list-group-item:first-child').addClass('list-group-items');
    var $image = $('#avatorImg');
    var $modal = $('#myModal');
    var cropBoxData;
    var canvasData;

    // Bind events first
    $modal.on('shown.bs.modal', function () {
        $image.cropper({
            movable: true,
            aspectRatio: 1,
            strict: false
        });
    }).on('hidden.bs.modal', function () {
        $image.cropper('destroy');
    });

    $('#inputImage').change(function () {
        var files = this.files;
        var file;

        if (files && files.length) {
            file = files[0];

            if (/^image\/\w+$/.test(file.type)) {
                blobURL = URL.createObjectURL(file);

                $image.one('built.cropper', function () {
                    // Revoke when load complete
                    URL.revokeObjectURL(blobURL);
                });

                $image.attr('src', blobURL);
            } else {
                window.alert('Please choose an image file.');
            }
        }

        // Don't bind events in another event

        $modal.modal('show');
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

function uploadAvator() {
    var $avatar = $("#userAvatar");
    var $image = $('#avatorImg');
    var $modal = $('#myModal');
    $image.cropper('getCroppedCanvas').toBlob(function (blob) {
        var formData = new FormData();
        formData.append('croppedImage', blob);
        formData.append('avatarUrl', $avatar.attr('src'));
        $.ajax('/json/uploadAvatar.json', {
            method: "POST",
            data: formData,
            processData: false,
            contentType: false,
            success: function (data) {
                if (data) {
                    $modal.modal('hide');
                    $avatar.attr('src', data);
                }
            },
            error: function () {
                console.log('Upload error');
            }
        });
    });
    //$avatarForm = $("#avatarForm");
    //var data = new FormData($avatarForm[0]);
    //var _this = this;
    //$.ajax({
    //    url: '/json/uploadAvatar.json',
    //    type: 'post',
    //    data: data,
    //    dataType: 'json',
    //    processData: false,
    //    contentType: false,
    //    success: function (data) {
    //
    //    },
    //
    //});
}

