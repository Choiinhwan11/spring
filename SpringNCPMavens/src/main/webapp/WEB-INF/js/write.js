$(function(){
          // 입력
       $('#writeBtn').click(function() {

        $('#nameDiv').empty();
        $('#idDiv').empty();
        $('#pwdDiv').empty();

        if ($('#name').val() == '')
            $('#nameDiv').text('이름 입력');
        else if ($('#id').val() == '')
            $('#idDiv').text('아이디 입력');
        else if ($('#pwd').val() == '')
            $('#pwdDiv').text('비밀번호 입력');
        else
            $.ajax({
                type: 'post',
                url :'/user/write',
                data : $('#writeForm').serialize(), //변수=값&변수=값 이런식으로 간다
                success : function (data){
                    alert('회원가입 완료');
                    location.href='/user/list';
                },
                error : function (e){
                    console.log(e)
                }

            })
    })

    // 아이디 중복체크
    $('#id').on('focusout',function (){
        $('#idDiv').empty();

        if($('#id').val() == ''){
            $('#idDiv').html('먼저 아이디를 입력하세요')
        }else{
            $.ajax({
                type : 'post',
                url : '/user/isExistId',
                data : 'id=' + $('#id').val(), // 서버로 보내는 데이터
                dataType : 'text', // 서버로 받는 데이터 타입
                success : function(data){
                    if(data == 'exist'){
                        $('#idDiv').html('사용 불가능').css('color','red')
                    }else if(data == 'non_exist'){
                        $('#idDiv').html('사용 가능').css('color','blue')
                        $('#check').val($('id').val())
                    }
                },
                error : function (e){
                  console.log(e)
                }
            })
        }
    })
})