$(function (){
    $('#uploadDeleteBtn').on('click',function (){
        $.ajax({
            type : 'post',
            url : '/user/uploadDelete',
            data : $('#uploadListForm').serialize(),
            success : function (){
                alert("이미지 삭제 완료");
                location.href = '/user/uploadList'
            },
            error : function (e){
                console.log(e)
            }
        })
    })
})