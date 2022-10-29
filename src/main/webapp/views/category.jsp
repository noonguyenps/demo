<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- Site meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Free Bootstrap 4 Ecommerce Template</title>
    <!-- CSS -->
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="//fonts.googleapis.com/css?family=Open+Sans:400,300,600" rel="stylesheet" type="text/css">
    <link href="<c:url value="/WEB-INF/templates/css/style.css"/>" rel="stylesheet" type="text/css">
</head>
<body>
<%--header--%>
<%@include file="header.jsp"%>
<%--end header--%>
<div class="container">
    <div class="row">
        <div class="col-12 col-sm-3">
            <div class="card bg-light mb-3">
                <div class="card-header bg-primary text-white text-uppercase"><i class="fa fa-list"></i> Categories</div>
                <ul class="list-group category_block">
                    <c:forEach items="${categoryList}" var="cate" varStatus="STT" >
                        <li class="list-group-item"><a href="/category?id=${cate.cateId}">${cate.cateName}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <div class="card bg-light mb-3">
                <div class="card-header bg-success text-white text-uppercase">Last product</div>
                <div class="card-body">
                    <img class="img-fluid" src="${lastProduct.imageLink}" />
                    <h5 class="card-title">${lastProduct.productName}</h5>
                    <p class="card-text">${lastProduct.productDescription}</p>
                    <p class="bloc_left_price">${lastProduct.price} VND</p>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="row">
                <c:forEach items="${productList}" var="product" varStatus="STT" >
                    <div class="col-12 col-md-6 col-lg-4">
                        <div class="card">
                            <img class="card-img-top" src="${product.imageLink}" alt="Card image cap">
                            <div class="card-body">
                                <h4 class="card-title"><a href="/product?productID=${product.productID}" title="View Product">${product.productName}</a></h4>
                                <p class="card-text">${product.productDescription}</p>
                                <div class="row">
                                    <div class="col">
                                        <p class="btn btn-danger btn-block">${product.price} VND</p>
                                    </div>
                                    <div class="col">
                                        <a href="#" class="btn btn-success btn-block">Add to cart</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-12">
                    <nav aria-label="...">
                        <ul class="pagination">
                            <li class="page-item disabled">
                                <a class="page-link" href="#" tabindex="-1">Previous</a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">1</a></li>
                            <li class="page-item active">
                                <a class="page-link" href="#">2 <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="page-item"><a class="page-link" href="#">3</a></li>
                            <li class="page-item">
                                <a class="page-link" href="#">Next</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>

    </div>
</div>
<%--footer--%>
<%@include file="footer.jsp"%>
<%---end footer--%>
<!-- JS -->
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js" type="text/javascript"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" type="text/javascript"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" type="text/javascript"></script>

</body>
</html>
