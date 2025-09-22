<%@page import="bean.NguoiDungBean"%>
<%@page import="bean.SanPhamBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%
		HttpSession ss = request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	%>
  <div class="site-wrap">
    <%@include file="head.jsp"%>
    
		<div class = "container w-25">
			<form action = "DangKiController" method = "post">
				<div class="form-outline mb-4">
			    <label class="form-label" for="Name">Tên người dùng</label>
			    <input type="text" id="Name" name = "tenNguoiDung" pattern="[\p{L}\p{N}\s]{3,20}" class="form-control" placeholder = "Nhập tên người dùng" required  minlength = "5" maxlength = "20"/>
			  </div>
			  <div class="form-outline mb-4">
			    <label class="form-label" for="userName">Tên đăng nhập</label>
			    <input type="text" id="userName" name = "tenDangNhap" pattern="^[A-Za-z0-9]+$" class="form-control" placeholder = "Nhập tên đăng nhập" required  minlength = "5" maxlength = "20"/>
			  </div>
			  <div class="form-outline mb-4">
			    <label class="form-label" for="passWord">Mật khẩu</label>
			    <input type="password" id="passWord" name = "matKhau" class="form-control" pattern="^[A-Za-z0-9@]+$" placeholder = "Nhập mật khẩu" required minlength = "5" maxlength = "20"/>
			  </div>
			  <button type="submit" class="btn btn-primary btn-block mb-4"> Đăng kí </button>		
			</form>
		  <div class="text-center">
		    <p> Đã có tài khoản ? <a href="DangNhapController"> Đăng nhập </a></p>
		  </div>
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