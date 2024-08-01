$(function (){
    $.ajax({
        type : 'post',
        url : '/user/getUploadList',
        dataType : 'json',
        success : function (data){
            console.log(JSON.stringify(data));

            $.each(data, function(index, items){
            /*    $('<tr>').append($('<td>',{
                     align : 'center',
                     text : items.seq
                })).append($('<td>',{
                    align : 'center',
                }).append($('<img>',{
                    src : '../storage/' + items.image1, // 가상폴더 주소를 써야한다.
                    style : 'width : 100%;'
                }))).append($('<td>',{
                    align : 'center',
                    text : items.imageName
                })).appendTo($('#uploadListTable'))*/

                /*var result = `
                    <tr>
                        <td align="center">${items.seq}</td>
                        <td align="center">
                            <img src="../storage/${items.imageOriginalName}" width="100%"/>
                        </td>
                        <td align="center">${items.imageName}</td>
                    </tr>
                `
                $('#uploadListTable').append(result);*/

                // 이미지는 NCP Object Storage에서 가져온다
                var result = `
                    <tr>
                        <td align="center">
                            <input type="checkbox" name="check" id="check" value="${items.seq}"/>${items.seq}
                        </td>
                        <td align="center">
                            <img src="https://kr.object.ncloudstorage.com/bitcamp-6th-bucket-97/storage/${items.imageFileName}" width="100%" class="imgBtn"/>
                        </td>
                        <td align="center">${items.imageName}</td>
                    </tr>
                `
                $('#uploadListTable').append(result);
            }) // $.each

            // 전체선택 / 전체 해제
            $('#all').on('click',function (){
                if($(this).prop('checked')){
                    $('input[name="check"]').prop('checked',true)
                }else{
                    $('input[name="check"]').prop('checked',false)
                }
            })

            // 전체 선택한 후 <input type="checkbox" name="check" >가 한개라도 해제되면
            // all은 자동으로 해제가 된다.
            $('input[name="check"]').on('click',function (){
                $('#all').prop('checked', $('input[name="check"]:checked').length == $('input[name="check"]').length);
            })


            $('.imgBtn').on('click', function(){
                console.log('hi')
                location.href = '/user/uploadView?seq=' + $(this).parent().prev().text()
            })

        },
        error : function (e){
            console.log(e);
        }
    }) // $.ajax


})

