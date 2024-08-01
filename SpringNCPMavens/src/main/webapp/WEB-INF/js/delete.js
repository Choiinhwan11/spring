$('#deleteBtn').on('click',function (){
    if(confirm('삭제하시겠습니까?')){
        $.ajax({
            type : 'post',
            url : '/user/delete',
            data : 'id=' + $('#id1').val(),
            success : function (){
                alert('회원정보 삭제 완료');
                location.href = '/user/list'
            },
            error : function (e){
                console.log(e)
            }
        })
    }// if
})