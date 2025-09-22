<%@page import="java.awt.font.ImageGraphicAttribute" %>
	<%@page import="bean.NguoiDungBean" %>
		<%@page import="bean.SanPhamBean" %>
			<%@page import="java.util.ArrayList" %>
				<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

					<!DOCTYPE html>
					<html lang="en">

					<head>
						<title>Shop &mdash; Home</title>
						<meta charset="utf-8">
						<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
						<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700">
						<link rel="stylesheet" href="fonts/icomoon/style.css">
						<link rel="stylesheet" href="css/bootstrap.min.css">
						<link rel="stylesheet" href="css/magnific-popup.css">
						<link rel="stylesheet" href="css/jquery-ui.css">
						<link rel="stylesheet" href="css/owl.carousel.min.css">
						<link rel="stylesheet" href="css/owl.theme.default.min.css">
						<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
						<link rel="stylesheet" href="css/aos.css">
						<link rel="stylesheet" href="css/style.css">
					</head>

					<body>
						<% HttpSession ss=request.getSession(); request.setCharacterEncoding("utf-8");
							response.setCharacterEncoding("utf-8"); %>
							<div class="site-wrap">
								<%@include file="head.jsp" %>
									<div class="container w-25">
										<form action="DangNhapController" method="post">
											<div class="form-outline mb-4">
												<label class="form-label" for="userName">Tên đăng nhập</label>
												<input type="text" id="userName" name="userName" class="form-control"
													placeholder="Nhập tên đăng nhập" required="required" />
											</div>

											<div class="form-outline mb-4">
												<label class="form-label" for="passWord">Mật khẩu</label>
												<input type="password" id="passWord" name="passWord"
													class="form-control" placeholder="Nhập mật khẩu"
													required="required" />
											</div>
											<% if (ss.getAttribute("fail") !=null && (int)ss.getAttribute("fail")> 2) {
												out.println("<img src=\"simpleCaptcha.jpg\">");
												out.println("<input type=\"text\" name=\"captcha\" class=\"form-control\">");
												}
												%>
												<button type="submit" class="btn btn-primary btn-block mb-4"> Đăng nhập
												</button>
										</form>
										<% if (ss.getAttribute("mess") !=null) { out.println("<p class=\"mb-4\">" +
											ss.getAttribute("mess") + "</p>");
											}
											ss.removeAttribute("mess");
											%>
									</div>
									<div class="text-center">
										<p> Chưa có tài khoản ? <a href="DangKiController"> Đăng kí </a></p>
									</div>
							</div>

							<script src="js/jquery-3.3.1.min.js"></script>
							<script src="js/jquery-ui.js"></script>
							<script src="js/popper.min.js"></script>
							<script src="js/bootstrap.min.js"></script>
							<script src="js/owl.carousel.min.js"></script>
							<script src="js/jquery.magnific-popup.min.js"></script>
							<script src="js/aos.js"></script>
							<script src="js/main.js"></script>
					</body>

					</html>