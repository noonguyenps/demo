<%--
  Created by IntelliJ IDEA.
  User: Justin Gnoud
  Date: 10/8/2022
  Time: 10:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach items="${categoryList}" var="cate" varStatus="STT" >
    <tr class="odd gradeX">
        <td>${STT.index+1 }</td>
        <c:url value="/image?fname=${cate.images }" var="imgUrl"></c:url>
        <td><img height="150" width="200" src="${imgUrl}" /></td>
        <td>${cate.cateName }</td>
        <td><a href="<c:url value='/admin/category/edit?id=${cate.cateId }'/>"
               class="center">Sửa</a>
            | <a href="<c:url value='/admin/category/delete?id=${cate.cateId }'/>"
                 class="center">Xóa</a></td>
    </tr>
</c:forEach>
</body>
</html>
