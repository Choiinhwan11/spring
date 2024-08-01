$(function (){
    // 폼 제출 시 실행되는 함수
    $('form').submit(function(event) {
        // 기본 제출 동작을 막음
        event.preventDefault();
        // AJAX 요청 보내기
        $.ajax({
            url: '/idCheck',
            type: 'POST',
            data: formData,
            dataType: 'text',
            success: function(result) {
                if (result === 'true') {
                    $("#userid").html('사용 가능한 아이디입니다.');
                } else {
                    $("#userid").html('이미 사용중인 아이디입니다.');
                }
            },
            error: function(xhr, status, error) {
                alert('사용 불가능한 아이디입니다.');
                console.error('오류:', error);
            }
        });
    });
});
