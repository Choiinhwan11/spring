$(function (){
    $.ajax({
        type : 'post',
        url : '/user/getUploadImage',
        data : 'seq=' + $('#seq').val(),
        dataType : 'json',
        success : function (data){
            console.log(JSON.stringify(data))

            var result = `<img src="https://kr.object.ncloudstorage.com/bitcamp-6th-bucket-97/storage/
                                        ${data.imageFileName}" width="250" height="250"/>`
            $('#imageSpan').html(result)
            $('#imageNameSpan').html(data.imageName)
            $('#imageOriginalNameSpan').html(data.imageOriginalName)
            $('#imageContentSpan').text(data.imageContent)

        },
        error : function (e){
            console.log(e)
        }
    }) // $.ajax
})

/*
$('#updateBtn').on('click',function(){
    $('#imageNameDiv').empty()
    $('#imageContentDiv').empty()

    if($('#imageName').val() == ''){
        $('#imageNameDiv').text('상품명을 입력하세요')
    }else if($('#imageContent').val() == ''){
        $('#imageContentDiv').text('내용을 입력하세요')
    }else{
        var formData  = new FormData($('#imageUpdateForm')[0]);

        $.ajax({
            type: 'post',
            url : '/user/imageUpdate',
            data : formData,
            enctype : 'multipart/form-data',
            contentType : false,
            processData : false,
            success : function (){
                alert('회원정보 수정 완료')
                location.href = '/user/uploadList'
            },
            error : function (e){
                console.log(e)
            }
        })
    }
})*/
