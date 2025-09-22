<%@page import="bean.DonDatHangBean"%>
<%@page import="bean.NhaSanXuatBean"%>
<%@page import="bean.SanPhamBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.NguoiDungBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
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
  <%@include file="head.jsp"%>
  <div class="site-section">
		<div class = "container">
			<h3 class = "font-weight-light mb-0"> Danh sách đơn hàng </h3>
			<div class="row mb-5">
            <div class="site-blocks-table">
              <table class="table">
                <thead>
                  <tr>
                    <th> Mã đơn đặt hàng </th>
                    <th> Họ và tên </th>
                    <th> Địa chỉ </th>
                    <th> Số điện thoại </th>
                    <th> Tổng tiền </th>
                    <th> Mã hoá đơn </th>
                    <th> Xem </th>
                  </tr>
                </thead>
            
                <tbody>
                	<% 
                		ArrayList<DonDatHangBean> sp = (ArrayList<DonDatHangBean>)ss.getAttribute("dondathang");
                		if (sp != null)
                		for (DonDatHangBean x: sp) {
                			out.println("<tr>");
                			out.println("<td>" + x.getMaDonDatHang() + "</td>");
                			out.println("<td>" + x.getHoVaTen() + "</td>");
                			out.println("<td>" + x.getDiaChi() + "</td>");
                			out.println("<td>" + x.getSDT() + "</td>");
                			out.println("<td>" + x.getTongTien() + "</td>");
                			out.println("<td>" + x.getMaHoaDon() + "</td>");
                		%>
 										
                			<td> 
                				<form action= "AdminXacNhan" method = "post"> 
                					<button type = "submit" name = "btn_xn" value = <%=x.getMaDonDatHang()%>> Xác nhận </button> 
                				</form> 
                			</td>
                		<% 
                			out.println("</tr>");
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