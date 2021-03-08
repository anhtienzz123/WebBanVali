<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
</head>
<body>
    <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="../../index2.html" class="h1"><b>Quên</b> Mật Khẩu</a>
    </div>
    <div class="card-body">
      <p class="login-box-msg">Bạn hãy nhập email đăng kí tài khoản</p>
      <form action='<c:url value="/quen-mat-khau" />' method="post">
        <div class="input-group mb-3">
          <input name="email" type="email" class="form-control" placeholder="Email">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <button type="submit" class="btn btn-primary btn-block">Lấy lại mật khẩu</button>
          </div>
          <!-- /.col -->
        </div>
      </form>
      <p class="mt-3 mb-1">
        <a href='<c:url value="/login" />'>Đăng nhập</a>
      </p>
    </div>
    <!-- /.login-card-body -->
  </div>
</body>
</html>