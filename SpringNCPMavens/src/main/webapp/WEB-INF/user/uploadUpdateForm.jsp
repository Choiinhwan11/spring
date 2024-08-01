<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border-collapse: collapse;
        }
        th,td{
            padding: 5px;
        }
    </style>
</head>
<body>
<a href="/"><img src="../image/딸기탕후루.jpg" width="50"></a>
<br><br>

<form id="uploadUpdateForm" enctype="multipart/form-data" >
    <input type="hidden" name="seq" id="seq" value="${seq}"/>
    <table border="1">
        <tr>
            <th>상품명</th>
            <td>
                <input type="text" name="imageName" id="imageName" size="35">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <textarea name="imageContent" id="imageContent" rows="10" cols="50"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <span id="showImgList">이미지가 보이는 영역</span>
                <img src="../image/camera.jpg" id="camera" alt="카메라" width="50" height="50"/>
                <input type="file" name="img" id="img"  style="visibility: hidden">
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="button" value="목록" onclick="location.href='/user/uploadList'"/>
                <input type="button" value="수정" id="uploadUpdateBtn"/>
                <input type="reset" value="취소" onclick="location.reload()"/>
            </td>
        </tr>
    </table>
</form>
<script src="http://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script src="/js/uploadUpdate.js"></script>
<%--<script src="/js/imageDelete.js"></script>--%>
<script>
    $('#camera').on('click',function(){
        // 강제 이벤트 발생 , 클릭은 카ㅔㄹ
        $('#img').trigger('click');
    })

    // 여러개의 이미지 미리보기
    $('#img').on('change',function (){
        $('#showImgList').empty();

        for(var i=0; i<this.files.length ; i++){
            readURL(this.files[i])
        }
    })

    function readURL(file){
        var reader = new FileReader();

        var show;
        reader.onload = function (e){
            var img = document.createElement('img');
            img.src = e.target.result;
            img.width = 70;
            img.height = 70;
            $('#showImgList').append(img);
        }

        reader.readAsDataURL(file);
    }
</script>
</body>
</html>
