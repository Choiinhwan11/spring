<%--
  Created by IntelliJ IDEA.
  User: bitcamp
  Date: 2024-03-22
  Time: 오후 3:38
  To change this template use File | Settings | File Templates.
--%>
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
    <form method="post" enctype="multipart/form-data" action="/user/upload">
        <table border="1">
            <tr>
                <th>상품명</th>
                <td>
                    <input type="text" name="imageName" size="35">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <textarea name="imageContent" rows="10" cols="50"></textarea>
                </td>
            </tr>
            <%-- 다중 업로드 할때는 name 속성의 이름이 같아야 한다. name ="img" --%>
         <%--   <tr>
                <td colspan="2">
                    <input type="file" name="img">
                </td>
            </tr>--%>
        <%--    <tr>
                <td colspan="2">
                    <input type="file" name="img">
                </td>
            </tr>--%>

             <%--한번에 1개 선택 또는 여러 개 선택--%>
            <tr>
                <td colspan="2">
                    <input type="file" name="img[]" multiple="multiple">
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="이미지 업로드"/>
                    <input type="reset" value="취소"/>

                </td>
            </tr>
        </table>
    </form>
</body>
</html>
