$(function (){
    $.ajax({
        type : 'post',
        url : '/user/getUploadImage',
        data : 'seq=' + $('#seq').val(),
        dataType : 'json',
        success : function (data){
            console.log(JSON.stringify(data))

            var result = `<img src="https://kr.object.ncloudstorage.com/bitcamp-6th-bucket-97/storage/${data.imageFileName}" width="70" height="70"/>`

            $('#imageName').val(data.imageName)
            $('#imageContent').val(data.imageContent)
            $('#showImgList').html(result);
        },
        error : function (e){
            console.log(e)
        }
    }) // $.ajax

    // 수정
    $('#uploadUpdateBtn').on('click',function (){
        var formData = new FormData($('#uploadUpdateForm')[0]);
        console.log($('#seq').val())
        $.ajax({
            type: 'post',
            enctype : 'multipart/form-data',
            processData : false,
            contentType : false,
            url : '/user/uploadUpdate',
            data : formData,
            success : function (data){
                alert(data);
                location.href='/user/uploadList'
            },
            error : function (e){
                console.log(e)
            }
        })
    })

})