$(function(){
    $.ajax({
        type: 'post'
        , url: '/Chapter06_Web/user/getUploadList'
        , dataType: 'json'
        , success: function(data){
            console.log(JSON.stringify(data));
            $.each(data, function (index, items){
                $('<tr/>').append($('<td/>', {
                            align: 'center'
                            , text: items.seq
                            })).append($('<td/>', {
                            align: 'center'
                            , text: items.image1
                                }).append($('<img/>', {
                                    src: '../storage/' + items.image1       // 가상 폴더의 위치를 잡아준다.
                                    , style: 'width: 50px; height: 50px;'
                                })))
                            .append($('<td/>', {
                            align: 'center'
                            , text: items.imageName
                })).appendTo($('#uploadListTable'));
            })
        }
        , error: function(e){
            console.log(e);
        }
    });
})