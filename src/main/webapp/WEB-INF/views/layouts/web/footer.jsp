<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<footer class="text-center text-lg-start bg-white text-muted">
	<section
		class="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
	</section>
	<!-- Section: Links  -->
	<section class="">
		<div class="container text-center text-md-start mt-5">
			<!-- Grid row -->
			<div class="row mt-3">
				<!-- Grid column công ty -->
				<div class="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
					<h6 class="text-uppercase fw-bold mb-4">
						<i class="fas fa-gem me-3"></i> Tiên Huỳnh Company
					</h6>
					<p>Tiên Huỳnh Company luôn luôn nổ lực hết mình để mang lại
						những sản phẩm chất lượng cho người dùng</p>
					<span>Liên hệ chúng tôi qua:</span>
					<div>
						<a target="_blank" href="https://www.facebook.com/tienhuynhzz123"
							class="me-4 text-reset"> <i class="fab fa-facebook-f"></i>
						</a> <a target="_blank" href="https://www.instagram.com/vawnkhair/"
							class="me-4 text-reset"> <i class="fab fa-instagram"></i>
						</a> <a target="_blank" href="" class="me-4 text-reset"> <i class="fab fa-github"></i>
						</a>
					</div>
				</div>

				<div class="col-md-2 col-lg-2 col-xl-2 mx-auto mb-8">

					<h6 class="text-uppercase fw-bold mb-4">Liên Kết</h6>
					<p>
						<a href='<c:url value="/" />' class="text-reset">Trang Chủ</a>
					</p>
					<p>
						<a href='<c:url value="/user/thong-tin" />' class="text-reset">Quản
							Lý Tài Khoản</a>
					</p>
					<p>
						<a href='<c:url value="/user/don-hang" />' class="text-reset">Đơn
							Hàng Của Tôi</a>
					</p>
				</div>


				<!-- Grid column m tả -->
				<div class="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">

					<h6 class="text-uppercase fw-bold mb-4">Contact</h6>
					<p>
						<i class="fas fa-home me-3"></i> IUH-Đại Học Công Nghiệp TP.Hồ Chí
						Minh
					</p>
					<p>
						<i class="fas fa-envelope me-3"></i> tienhuynh@gmail.com
					</p>
					<p>
						<i class="fas fa-phone me-3"></i> 0123456789
					</p>
				</div>

			</div>

		</div>
	</section>
	<!-- Section: Links  -->
</footer>
