<%--
  Created by IntelliJ IDEA.
  User: Justin Gnoud
  Date: 10/8/2022
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form role="form" action="add" method="post"
      enctype="multipart/form-data">
  <div class="form-group">
    <label>Tên danh mục:</label> <input class="form-control"
                                        placeholder="Tên danh mục" name="name" />
  </div>
  <div class="form-group">
    <label>Trạng thái:</label> <input class="form-control"
                                        placeholder="Trạng thái" name="status" />
  </div>
  <div class="form-group">
    <label>Ảnh đại diện</label> <input type="file" name="icon" />
  </div>
  <button type="submit" class="btn btn-default">Thêm</button>
  <button type="reset" class="btn btn-primary">Hủy</button>
</form>

</body>
</html>
