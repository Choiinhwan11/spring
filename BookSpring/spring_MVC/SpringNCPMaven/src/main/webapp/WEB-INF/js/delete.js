$(function (){
    // 삭제 버튼
    $('#deleteBtn').click(function (){
        // div영역 초기화

        if(confirm("삭제 하시겠습니까?"))
        $.post({
            url: '/Chapter06_Web/user/update'
            , data: 'id=' + $('#id')
            , success: function (){
                alert('회원정보 삭제 완료');
                location.href='/Chapter06_Web/user/list'
            }
            , error: function (e){
                console.log(e);
            }
        })
    })
})