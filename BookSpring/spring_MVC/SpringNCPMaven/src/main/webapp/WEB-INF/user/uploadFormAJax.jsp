<%--
  Created by IntelliJ IDEA.
  User: choiinhwan
  Date: 2024/03/25
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        td, th{
            padding: 5px;
        }
        div{
            color: red;
            font-size: small;
        }
    </style>
</head>
<body>

    <form id="uploadFormAJax">
        <table border="1" >
            <tr>
                <th>상품명</th>
                <td>
                    <input type="text" name="imageName" size="35">

                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea name="imageContent" id="imageContent" cols="50" rows="10"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <span id="showImgList">이미지가 보이는 영역 </span>
                    <input type="file" name="img[]" multiple="multiple" id="img" style="visibility: hidden">
                    <input type="../image/ca.png" id="camera" alt="카메라" width="50" height="50">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="button" value="이미지 업로드"id="uploadAJaxBtn">
                    <input type="reset" value="취소">
                </td>
            </tr>

        </table>
    </form>
    <script src="https://code.jQuery.com/jquery-3.7.1.min.js"></script>
<script type="text/javascript">

    $('#camera').click(function (){
        //강제로 이벤트를 발생했을때 .
        $('#img').trigger('click');
    });


    //여러개의 이미지 미리보기
    $('#img').change(function (){
        $('#showImgList').empty();
        for(var i = 0 ; this.file.length; i++){
            readURL(this.files[i])
        }
    });

    function readURL(file) {
        var reader = new FileReader();

        reader.onload = function (e) {
            var img = document.createElement('img');

            img.src = e.target.result; // Corrected the assignment operator from "-" to "="
            img.width = 70;
            img.height = 70;
            $('#showImgList').append(img);
        };

        reader.readAsDataURL(file);
    }

</script>
<script type="text/javascript" src="../js/uploadList.js">

</script>

</body>
</html>









