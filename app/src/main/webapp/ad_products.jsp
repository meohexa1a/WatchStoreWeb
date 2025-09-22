<%@page import="bean.NhaSanXuatBean"%>
<%@page import="bean.SanPhamBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.NguoiDungBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Shoppers &mdash; Colorlib e-Commerce Template</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Mukta:300,400,700"> 
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
		<link rel="stylesheet" href="css/pop_up.css">
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
					            			NguoiDungBean nd = (NguoiDungBean)ss.getAttribute("nguoiDung");
					            			if (ss.getAttribute("nguoiDung") == null) {
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
		<%
		request.setCharacterEncoding("utf-8"); 
		response.setCharacterEncoding("utf-8"); 
		%>
  <div class="site-section">
		<div class = "container">
			<button onclick="document.getElementById('ThemSP').style.display='inline-block'" class = "btn btn-sm btn-primary"> Thêm sản phẩm </button>
			<div id="ThemSP" class="modal">
		        <div class="modal-content">
		        		<div class="modal_header">
									<h5 class="modal-title"> Thêm sản phẩm </h5>		
								</div>
								<form action = "ThemSanPham" method = "post" enctype= "multipart/form-data" accept-charset="UTF-8">
								<div class="modal_body">
		            		<div class = "form-group">
		                	<label for = "TenSanPham" class = "from"> Tên sản phẩm </label>
		                	<input id = "TenSanPham" class = "form-control" name = "TenSanPham" required="required" type = "text">  <br>
		                </div>
		                <div class = "form-group">
			                <label for = "DonGia"> Đơn giá </label>
			                <input id = "DonGia" class = "form-control" type = "number" name = "DonGia" required="required"><br>
		                </div>
		                <div class = "form-group">
			                <label for = "LoaiDongHo"> Loại đồng hồ </label>
			                <select id = "LoaiDongHo" name = "LoaiDongHo" class = "form-control" required="required">
			                	<option value = "Analog"> Analog </option>
			                	<option value = "Digital"> Digital </option>
			                	<option value = "Ana-Digi"> Ana-Digi </option>
			             		</select>
		            		</div>
		                <div class = "form-group">
			                <label for = "DTSuDung"> Đối tưởng sử dung </label>
			                <select id = "DTSuDung" name = "DTSuDung" class = "form-control" required="required">
			                	<option value = "0"> Nam </option>
			                	<option value = "1"> Nữ </option>
			                	<option value = "2"> Unisex </option>
			                	<option value = "3"> Trẻ em </option>
			             		</select>
		            		</div>
		            		<div class = "form-group">
			                <label for = "NSX"> Nhà sản xuất </label>
			                <select id = "NSX" name = "NSX" class = "form-control" required="required">
			                	<%
			                		ArrayList<NhaSanXuatBean> nsx = (ArrayList<NhaSanXuatBean>)ss.getAttribute("NhaSanXuat");
			                		if (nsx != null)
			                		for (NhaSanXuatBean x: nsx) {
			                			out.println("<option value = \"" + x.getMaNSX() + "\">" + x.getTenNSX() + "</option>");
			                		}
			                	%>
			             		</select>
		            		</div>
		            		<div>
										  <label for="formFileLg" class="form-label">Large file input example</label>
										  <input class="form-control form-control-lg" id="formFileLg" type="file" name = "imagefile" required="required">
										</div>
								</div>
								<div class = "modal_footer">
		            		<button type = "submit" class = "btn btn-primary"> Thêm </button>
		            		<button type="button" onclick="document.getElementById('ThemSP').style.display='none'" class="btn btn-secondary"> Đóng </button>		     
		            </div>
		            </form>  
		        </div>
		 	</div>
			<h3 class = "font-weight-light mb-0"> Danh sách sản phẩm </h3>
			<div class="row mb-5">
            <div class="site-blocks-table">
              <table class="table">
                <thead>
                  <tr>
                    <th> Ảnh </th>
                    <th> Tên sản phẩm </th>
                    <th> Đơn giá </th>
                    <th> Loại Đồng Hồ </th>
                    <th> Nhà sản xuất </th>
                    <th> Đối tưởng sử dụng </th>
                    <th> Xoá </th>
                    <th> Sửa </th>
                  </tr>
                </thead>
            
                <tbody>
                	<% 
                		ArrayList<SanPhamBean> sp = (ArrayList<SanPhamBean>)ss.getAttribute("TatCaSanPham");
                		if (sp != null)
                		for (SanPhamBean x: sp) {
                			if (x.isDaXoa() == true) continue;
                			out.println("<tr>");
                			out.println("<td><img class=\"img-fluid\" src = \"images/" + x.getHinhAnh() + "\"></td>");
                			out.println("<td>" + x.getTenSanPham() + "</td>");
                			out.println("<td>" + x.getDonGia() + "</td>");
                			out.println("<td>" + x.getLoaiDongHo() + "</td>");
                			out.println("<td>" + x.getMaNSX() + "</td>");
                			out.println("<td>" + x.getMaDoiTuongSD() + "</td>");
                			out.println("<td><a href = \"XoaSanPhamAdmin?msp=" + x.getMaSanPham() + "\"> X </a></td>");
                			out.println("<td><a type = \"button\" onclick=\"document.getElementById('" + x.getMaSanPham() + "').style.display=\'inline-block'\"> Sửa </a></td>");
                			out.println("</tr>");
         					%>
         							<div id="<%=x.getMaSanPham()%>" class="modal">
										       	<div class = "modal-content">
											       	<div class="modal_header">
											        		 <h5 class="modal-title"> Sửa sản phẩm </h5>		
											        </div>
											        <form action = "ChinhSuaSanPhamAdmin?msp=<%=x.getMaSanPham()%>" method = "post">
											        <div class="modal-body">   
											                <label for = "TenSanPham" class = "from"> Tên sản phẩm </label>
											                <input id = "TenSanPham" value = "<%=x.getTenSanPham()%>" class = "form-control" name = "TenSanPham">  <br>
											                <label for = "DonGia"> Đơn giá </label>
											                <input id = "DonGia" value = "<%=x.getDonGia()%>" class = "form-control" type = "number" name = "DonGia">  <br>
											        </div>
									            <div class="modal-footer">
													       <button type="submit" class="btn btn-primary"> Lưu thay đổi</button> 
														     <button type="button" onclick="document.getElementById('<%=x.getMaSanPham()%>').style.display='none'" class="btn btn-secondary"> Đóng </button>
												     </div>
											       </form>
										       </div>
									  	</div>
                	<%
                		}
                	%>
                </tbody>
              </table>
            </div>
        </div>
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