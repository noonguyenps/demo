<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:url value="/admin/category/edit" var="edit"></c:url>
<form role="form" action="${edit}" method="post"
      enctype="multipart/form-data">
    <input name="id" value="${category.cateId }" hidden="">
    <div class="form-group">
        <label>Tên danh mục:</label> <input type="text" class="form-control"
                                             value="${category.cateName }" name="name" />
    </div>
    <div class="form-group">
        <c:url value="/image?fname=${category.images }" var="imgUrl"></c:url>
        <img class="img-responsive" width="100px" src="${imgUrl}"
             alt="">
        <label>Ảnh đại diện</label> <input type="file" name="image"
                                           value="${category.images }" />
        <label>Trạng thái</label> <input type="text" name="status"
                                           value="${category.status }" />
    </div>
    <button type="submit" class="btn btn-default">Edit</button>
    <button type="reset" class="btn btn-primary">Reset</button>
</form>
</body>
</html>
