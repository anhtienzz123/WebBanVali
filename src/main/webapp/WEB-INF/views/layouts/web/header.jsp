<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>

<div class="bg-white border mb-3">

<form action='<c:url value="/san-pham/" />' >
	<div class="header p-3 bg-white">
		<div class="row">
			<div class="col-2 ">
				<a href='<c:url value="/" />'
					style="text-decoration: none; color: black"> <img alt=""
					src='<c:url value="/static/image/logoblue.png" />' width='100%'
					height='95%' />
				</a>
			</div>

			
				<div class="col-5 input-group input-group p-0 ">


					<input type="password" class="form-control " id="inputPassword3"
						name="tenVali" placeholder="Tìm kiếm sản phẩm mong muốn...">

					<div class="input-group-append" style="height: 55%">
						<button class="btn btn-outline-secondary" type="button"
							type="submit">
							<i class="fas fa-search"></i>
						</button>
					</div>



				</div>
			

			<div class="col-5 p-1">

				<div class="ml-5 mr-5 d-inline ">

					<a style="color: black; text-decoration: none;"
						href=' <c:url value="/gio-hang" />'> <img
						src="https://cdn0.fahasa.com/skin/frontend/base/default/images/ico_shopping_cart_orange.svg"
						alt="" class=""> Giỏ hàng <!-- 
					  	<span
						style="color: #f7941e; font-weight: 500">(3)</span>
					   -->
					</a>
				</div>



				<!--  nếu đã đăng nhập -->
				<sec:authorize access="isAuthenticated()">

					<!-- 
						
					<a style="color: black; text-decoration: none;"
						href=' <c:url value="/user/thong-tin" />'> <img
						src="https://cdn0.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_user.svg"
						alt=""> <sec:authentication property="name" />

					</a>
					 -->

					<div class="dropdown" style="display: inline;">
						<a style="color: black; text-decoration: none;"
							href=' <c:url value="/user/thong-tin" />' class="dropdown-toggle"
							role="button" id="dropdownMenuLink" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false"> <img
							src="https://cdn0.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_user.svg"
							alt=""> <sec:authentication property="name" />

						</a>

						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							<a class="dropdown-item" href="<c:url value="/user/thong-tin" />">Thông
								tin</a> <a class="dropdown-item" href="<c:url value="/logout" />">Đăng
								xuất</a>
						</div>
					</div>




					<!--  nếu có quyền admin -->
					<sec:authorize access="hasRole('ADMIN')">
						<a href=' <c:url value="/admin/trang-chu" /> '>|| Quản lí</a>
					</sec:authorize>

				</sec:authorize>


				<!-- chưa đăng nhập -->
				<sec:authorize access="!isAuthenticated()">
					<a style="color: black; text-decoration: none;"
						href=' <c:url value="/login" />'> <img
						src="https://cdn0.fahasa.com/skin/frontend/ma_vanese/fahasa/images/ico_user.svg"
						alt=""> Đăng nhập/ đăng ký
					</a>
				</sec:authorize>



			</div>

		</div>

	</div>
	</form>
</div>

