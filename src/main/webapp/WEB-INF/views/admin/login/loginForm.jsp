<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
    
     <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <h1><b>ĐĂNG</b> NHẬP</h1>
    </div>
    <div class="card-body">
      <p class="login-box-msg">Nhập thông tin để đăng nhập</p>

      
      <form action="<c:url value='/login' />" method="post">
        <div class="input-group mb-3">
          <input name="email" type="email" class="form-control" placeholder="Email">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input name="password" type="password" class="form-control" placeholder="Mật khẩu">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
            <div class="icheck-primary">
              <input type="checkbox" id="remember">
              <label for="remember">
                Nhớ mật khẩu
              </label>
            </div>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block">Đăng nhập</button>
          </div>
          <!-- /.col -->
        </div>
      </form>


      <p class="mb-1">
        <a href="<c:url value='/quen-mat-khau' />">Quên mật khẩu</a>
      </p>
      <p class="mb-0">
        <a href="<c:url value='/dang-ki' />" class="text-center">Đăng kí tài khoản</a>
      </p>
    </div>
    <!-- /.card-body -->
  </div>
</body>
</html>