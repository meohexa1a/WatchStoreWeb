<%@page import="bean.NguoiDungBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
  
  <% 
  HttpSession ssh = request.getSession();
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8"); 
  %>
	<header class="site-navbar" role="banner">
			<div class="site-navbar-top">
				<div class="container">
					<div class="row align-items-center">
						<div
							class="col-6 col-md-4 order-2 order-md-1 site-search-icon text-left">
							<form action="ShopController" class="site-block-top-search" method = "get">
								<span class="icon icon-search2"></span> <input type="text"
									class="form-control border-0" placeholder="Search" name = "search">
							</form>
						</div>

						<div
							class="col-12 mb-3 mb-md-0 col-md-4 order-1 order-md-2 text-center">
							<div class="site-logo">
								<a href="IndexController" class="js-logo-clone">Shoppers</a>
							</div>
						</div>

						<div class="col-6 col-md-4 order-3 order-md-3 text-right">
							<div class="navbar navbar-expand-sm navbar-light bg-light" id = "mauNen">
								<nav class="navbar navbar-expand-sm bg-light navbar-light" id = "mauNen">
					         <!-- Toggler/collapsibe Button -->
					         <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
					            <span class="navbar-toggler-icon"></span>
					         </button>
					
					         <!-- Navbar links -->
					         <div class="collapse navbar-collapse" id="collapsibleNavbar">
					            <ul class="navbar-nav">
					            		<%
					            			NguoiDungBean nd = (NguoiDungBean)ssh.getAttribute("nguoiDung");
					            			if (ssh.getAttribute("nguoiDung") == null) {
					            				out.println("<li class=\"nav-item\"> <a class=\"nav-link\" href=\"DangNhapController\">Đăng Nhập</a></li>");
															out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"DangKiController\">Đăng kí</a></li>");
					            			} else {
					            				out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"\"> Xin chào " + nd.getTenNguoiDung() + "</a></li>");
					            				out.println("<li class=\"nav-item\"><a class=\"nav-link\" href=\"DangXuatController\"> Đăng Xuất </a></li>");
					            			}
					            		%>
					            </ul>
					         </div>
					      </nav>
							</div>
						</div>
					</div>
				</div>
			</div>
			<nav class="site-navigation text-right text-md-center"
				role="navigation">
				<div class="container">
					<ul class="site-menu js-clone-nav d-none d-md-block">
						<li><a href="IndexController">Trang chủ</a></li>
						<li><a href="ShopController">Cửa hàng</a></li>
						<%
							out.println("<li><a href=\"GioHangController\">GioHang</a></li>");
							out.println("<li><a href=\"LichSuMuaHangController\">LichSuMuaHang</a></li>");
							if (nd != null && nd.getQuyen() != null && nd.getQuyen() == true) { 
								out.println("<li><a href=\"HienThiSanPhamAdmin\">Trang Quản Lý</a></li>");
								out.println("<li><a href=\"AdminXacNhan\">Xác nhân đơn đặt hàng</a></li>");
							}
						%>
					</ul>
				</div>
			</nav>
		</header>
</body>
</html>