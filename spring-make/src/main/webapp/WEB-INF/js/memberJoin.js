
$(document).ready(function() {
    // 가입 버튼 클릭 이벤트
    $('#signupButton').click(function(e) {
        e.preventDefault(); // 폼 기본 제출 막기

        // 폼 데이터 수집
        var formData = {
            // 예시: userId: $('#userId').val(),
            // 폼에서 입력받은 데이터를 key-value 형태로 추가
        };

        // AJAX 요청
        $.ajax({
            url: '/memberJoin',
            type: 'POST',
            data: formData,
            success: function (response) {
                alert('가입이 완료되었습니다.');
            },
            error: function (xhr, status, error) {
                alert('가입 중 오류가 발생했습니다.');
                console.error('오류:', error);
            }
        });
    });
});
