<%--
  Created by IntelliJ IDEA.
  User: Justin Gnoud
  Date: 10/21/2022
  Time: 1:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%--header--%>
<%@include file="header.jsp"%>
<%--end header--%>
<div class="container">
  <div class="row">
    <div class="col">
      <div class="card">
        <div class="card-header bg-primary text-white"><i class="fa fa-envelope"></i> Contact us.
        </div>
        <div class="card-body">
          <form>
            <div class="form-group">
              <label for="name">Name</label>
              <input type="text" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter name" required>
            </div>
            <div class="form-group">
              <label for="email">Email address</label>
              <input type="email" class="form-control" id="email" aria-describedby="emailHelp" placeholder="Enter email" required>
              <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
            </div>
            <div class="form-group">
              <label for="message">Message</label>
              <textarea class="form-control" id="message" rows="6" required></textarea>
            </div>
            <div class="mx-auto">
              <button type="submit" class="btn btn-primary text-right">Submit</button></div>
          </form>
        </div>
      </div>
    </div>
    <div class="col-12 col-sm-4">
      <div class="card bg-light mb-3">
        <div class="card-header bg-success text-white text-uppercase"><i class="fa fa-home"></i> Address</div>
        <div class="card-body">
          <p>3 rue des Champs Elysées</p>
          <p>75008 PARIS</p>
          <p>France</p>
          <p>Email : email@example.com</p>
          <p>Tel. +33 12 56 11 51 84</p>

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
