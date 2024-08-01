$(function (){
    $('#uploadAJaxBtn').click(function (){
        var formData = new formData($('#uploadFormAJax')[0]);
        $.ajax({
            type:'post',
            enctype : 'multipart/form-data',
            processData: false,
            contentType: false,
            url:'/Chapter06_Web/user/upload',
            data: formData,
            success:function (data) {
                alert(data);
                location.href = '/Chapter06_Web/user/uploadList';
            },
            error:function (e){
                console.log(e);
            }
        })
    })
})

/*
* processData
* -기복적값은 true
* - 기복적 커리를 String 로 변환해서 보내진다. ( '변수 = 값 & 변수 =값')
*-  파일 전송시에는 반드시 false 로 해야한다. (formData 를 문자열로 변환하지 않는다.)
*
*
*
*
* */