<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Xác nhận mật khẩu</title>
</head>
<body>
    <div class="card card-outline card-primary">
    <div class="card-header text-center">
      <a href="../../index2.html" class="h1"><b>Lấy lại</b>mật khẩu</a>
    </div>
    <div class="card-body">
      <p class="login-box-msg">Còn một bước nữa thôi sẽ hoàn thành lấy lại mật khẩu</p>
      
      
      <c:url value="/quen-mat-khau/nhap-mat-khau?email=${email}&token=${token }" var="url" />
      <form action="${url}" method="post">
      
  
        <div class="input-group mb-3">
          <input name="matKhau" type="password" class="form-control" placeholder="Mật khẩu">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" class="form-control" placeholder="Nhập lại mật khẩu">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-12">
            <button type="submit" class="btn btn-primary btn-block">Thay đổi mật khẩu</button>
          </div>
          <!-- /.col -->
        </div>
      </form>

      <p class="mt-3 mb-1">
        <a href='<c:url value="/login"  />'>Đăng nhập</a>
      </p>
    </div>
    <!-- /.login-card-body -->
  </div>
</body>
</html>