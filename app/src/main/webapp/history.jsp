<%@page import="bean.DonDatHangBean"%>
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
      <div class="container">
      	<div class="row mb-5">
          <form class="col-md-12" action = "GioHangController" method="post">
            <div class="site-blocks-table">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th class="product"> Mã Đơn Hàng </th>
                    <th class="product"> Người nhận </th>
                    <th class="product"> Địa chỉ </th>
                    <th class="product"> Số điện thoại </th>
                    <th class="product"> Tổng tiền </th>
                    <th class="product"> Mã Hoá Đơn </th>
                    <th class="product"> Tình tràng </th>
                    <%
                    	ArrayList<DonDatHangBean> lichSu = (ArrayList<DonDatHangBean>)ss.getAttribute("lichsu");
                    	if (lichSu != null)	
                    	for (DonDatHangBean x: lichSu) {
                    		out.println("<tr>");
                    		out.println("<td>" + x.getMaDonDatHang() + "</td>");
                    		out.println("<td>" + x.getHoVaTen() + "</td>");
                    		out.println("<td>" + x.getDiaChi() + "</td>");
                    		out.println("<td>" + x.getSDT() + "</td>");
                    		out.println("<td>" + x.getTongTien() + "</td>");
                    		out.println("<td>" + x.getMaHoaDon() + "</td>");
                    		if (x.getTinhTrang() == true) {
                    			out.println("<td> Đã xác nhận </td>");
                    		} else 
                    			out.println("<td> Chờ xác nhận </td>");
                    		out.println("</tr>");
                    	}
                    %>
                  </tr>
                </thead>
                <tbody>
        							
                </tbody>
              </table>
            </div>
          </form>
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